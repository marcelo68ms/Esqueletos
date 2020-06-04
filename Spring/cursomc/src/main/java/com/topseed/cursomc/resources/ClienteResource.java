package com.topseed.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.topseed.cursomc.domain.Cliente;
import com.topseed.cursomc.dto.ClienteDTO;
import com.topseed.cursomc.dto.ClienteNewDTO;
import com.topseed.cursomc.services.ClienteService;

/**
 * Classe responsável pelo controle de Serviço do Cliente
 * 
 * @author marcelo
 *
 */
@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	/**
	 * Método responsável pela busca de um cliente específico
	 * 
	 * @param id
	 * @return mensagem de HTTP de retorno
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * Método que efetiva a gravação de Cliente no banco baseado no DTO preenchido
	 * 
	 * @param objDTO 
	 * @return mensagem de HTTP de retorno
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDTO) {
		Cliente obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	/**
	 * Método que efetiva a alteração de informações da Cliente específica
	 * @param objDTO
	 * @param id
	 * @return mensagem de HTTP de retorno
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id) {
		Cliente obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Método responsável por apagar uma Cliente específica 
	 *
	 * @param id
	 * @return mensagem de HTTP de retorno
	 */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}
	
	/**
	 * Efetua a listagem de todas as Clientes
	 * 
	 * @return uma lista de Clientes
	 */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> listObj = service.findAll();
		List<ClienteDTO> listDTO = listObj.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}

	/**
	 * Lista todas as Clientes de forma paginada 
	 * 
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Cliente> listObj = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> listDTO = listObj.map(obj -> new ClienteDTO(obj));
		
		return ResponseEntity.ok().body(listDTO);
	}
}

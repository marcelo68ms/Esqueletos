package com.topseed.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topseed.cursomc.domain.Cidade;
import com.topseed.cursomc.domain.Cliente;
import com.topseed.cursomc.domain.Endereco;
import com.topseed.cursomc.domain.enums.TipoCliente;
import com.topseed.cursomc.dto.ClienteDTO;
import com.topseed.cursomc.dto.ClienteNewDTO;
import com.topseed.cursomc.repositories.ClienteRepository;
import com.topseed.cursomc.repositories.EnderecoRepository;
import com.topseed.cursomc.services.exceptions.DataIntegrityException;
import com.topseed.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * Classe responsável pelas regras de negócio para os Clientes
 * 
 * @author marcelo
 *
 */
@Service
public class ClienteService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClienteRepository rep;
	
	@Autowired
	private EnderecoRepository endRep;
	
	/**
	 * Efetua a busca de Cliente por um id
	 * 
	 * @param id
	 * @return
	 */
	public Cliente find(Integer id) {
		Optional<Cliente> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Nome: " + Cliente.class.getName()));
 	}
	
	
	/**
	 * Insere uma Cliente no banco de dados
	 * 
	 * @param obj
	 * @return
	 */
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		rep.save(obj);
		endRep.saveAll(obj.getEnderecos());		
		return obj;
	}
		
	/**
	 * Atualiza um Cliente no banco de dados
	 * 
	 * @param obj
	 * @return
	 */
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}
	
	/**
	 * Apaga um Cliente de uma ID específica
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		find(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Cliente porque possui entidades relacionadas.");
		}
	}
	
	/**
	 * Efetua a busca de Clientes, retornando tudo numa lista geral
	 * 
	 * @return
	 */
	public List<Cliente> findAll(){
		return rep.findAll();
	}
	
	/**
	 * Efetua uma busca de Clientes paginadas   
	 *
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return rep.findAll(pageRequest);
	}
	
	/**
	 * Transforma o DTO em Cliente
	 * 
	 * @param obj
	 * @return
	 */
	public Cliente fromDTO(ClienteDTO obj) {
		return new Cliente(obj.getId(), obj.getNome(), obj.getEmail(), null, null, null);
	}

	/**
	 * Transforma o DTO em Cliente
	 * 
	 * @param obj
	 * @return
	 */
	public Cliente fromDTO(ClienteNewDTO obj) {
		Cliente cli = new Cliente(null, obj.getNome(), obj.getEmail(), obj.getCpfOuCnpj(), TipoCliente.toEnum(obj.getTipo()), pe.encode(obj.getSenha()) );
		Cidade cid = new Cidade(obj.getCidadeId(), null, null);
		Endereco end = new Endereco(null, obj.getLogradouro(), obj.getNumero(), obj.getComplemento(), obj.getBairro(), obj.getCep(), cli, cid);		
		cli.getEnderecos().add(end);
		cli.getTelefones().add(obj.getTelefone1());
		if (obj.getTelefone2() != null) {
			cli.getTelefones().add(obj.getTelefone2());			
		}
		if (obj.getTelefone3() != null) {
			cli.getTelefones().add(obj.getTelefone3());			
		}		
		return cli;
	}
	
	/**
	 * updateData - Utilizado para a atualização de um Cliente 
	 *
	 * @param newObj
	 * @param obj
	 */
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}

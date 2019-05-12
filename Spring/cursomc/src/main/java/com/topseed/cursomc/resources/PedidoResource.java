package com.topseed.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.topseed.cursomc.domain.Pedido;
import com.topseed.cursomc.services.PedidoService;

/**
 * Classe responsável pelo controle do serviço de Pedidos
 * 
 * @author marcelo
 *
 */
@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService service;
	
	/**
	 * Busca de pedidos por um ID específico
	 * 
	 * @param id
	 * @return mensagem de HTTP de retorno
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}

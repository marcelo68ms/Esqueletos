package com.topseed.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.Pedido;
import com.topseed.cursomc.repositories.PedidoRepository;
import com.topseed.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * Classe responsável pelas regras de negócio para os Pedidos
 * 
 * @author marcelo
 *
 */
@Service
public class PedidoService {

	@Autowired
	private PedidoRepository rep;
	
	/**
	 * Busca de um único Pedido, baseado no seu ID
	 * 
	 * @param id
	 * @return
	 */
	public Pedido find(Integer id) {
		Optional<Pedido> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Pedido: " + Pedido.class.getName()));
 	}
}

package com.topseed.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.Cliente;
import com.topseed.cursomc.repositories.ClienteRepository;
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
	private ClienteRepository rep;
	
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
}

package com.topseed.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.Categoria;
import com.topseed.cursomc.domain.Produto;
import com.topseed.cursomc.repositories.CategoriaRepository;
import com.topseed.cursomc.repositories.ProdutoRepository;
import com.topseed.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * ProdutoService
 * Classe de Serviço de Produtos
 * 
 * @author marcelo
 *
 */
@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;
	
	@Autowired
	private CategoriaRepository repCat;
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		List<Categoria> categorias = repCat.findAllById(ids);
		
		return rep.search(nome, categorias, pageRequest);
	}
	
	/**
	 * Busca de um único Produto, baseado no seu ID
	 * 
	 * @param id
	 * @return
	 */
	public Produto find(Integer id) {
		Optional<Produto> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Produto: " + Produto.class.getName()));
 	}
}

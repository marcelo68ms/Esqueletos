package com.topseed.cursomc.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.Produto;

/**
 * ProdutoService
 * Classe de Serviço de Produtos
 * 
 * @author marcelo
 *
 */
@Service
public class ProdutoService {

	public Page<Produto> search(String nome, List<Integer> ids) {
		
		return null;
	}
}

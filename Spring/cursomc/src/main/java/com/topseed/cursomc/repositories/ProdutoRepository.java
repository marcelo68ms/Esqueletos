package com.topseed.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topseed.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}

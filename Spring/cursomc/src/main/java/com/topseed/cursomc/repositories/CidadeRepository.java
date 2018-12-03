package com.topseed.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topseed.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}

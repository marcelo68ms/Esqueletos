package com.topseed.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.Categoria;
import com.topseed.cursomc.dto.CategoriaDTO;
import com.topseed.cursomc.repositories.CategoriaRepository;
import com.topseed.cursomc.services.exceptions.DataIntegrityException;
import com.topseed.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * Classe responsável pelas regras de negócio para as Categorias
 * 
 * @author marcelo
 *
 */
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rep;
	
	/**
	 * Efetua a busca de uma categoria
	 * 
	 * @param id
	 * @return objeto Categoria
	 */
	public Categoria find(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
 	}
	
	/**
	 * Insere uma Categoria no banco de dados
	 * 
	 * @param obj
	 * @return
	 */
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	/**
	 * Atualiza uma Categoria no banco de dados
	 * 
	 * @param obj
	 * @return
	 */
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}
	
	/**
	 * Apaga uma Categoria de uma ID específica
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		find(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	/**
	 * Efetua a busca de Categorias, retornando tudo numa lista geral
	 * 
	 * @return
	 */
	public List<Categoria> findAll(){
		return rep.findAll();
	}
	
	/**
	 * Efetua uma busca de Categorias paginadas   
	 *
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return rep.findAll(pageRequest);
	}
	
	/**
	 * Transforma o DTO em Categoria
	 * 
	 * @param obj
	 * @return
	 */
	public Categoria fromDTO(CategoriaDTO obj) {
		return new Categoria(obj.getId(), obj.getNome());
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
}

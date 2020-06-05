package com.topseed.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.topseed.cursomc.security.UserSS;

/**
 * Classe responsável por tratar o usuário logado
 * 
 * @author marcelo
 *
 */
public class UserService {

	/**
	 * Esse método retorna o usuário autenticado
	 * 
	 * @return
	 */
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}

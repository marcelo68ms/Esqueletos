package com.topseed.cursomc.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Classe responsável pela autorização do Usuário na aplicação
 * 
 * @author marcelo
 *
 */

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private JWTUtil jwtUtil;
	private UserDetailsService userDatailsService;
	
	/**
	 * Construtor da classe 
	 *
	 * @param authenticationManager
	 * @param jwtUtil
	 * @param userDatailsService
	 */
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDatailsService) {
		super(authenticationManager);
		
		this.jwtUtil = jwtUtil;
		this.userDatailsService = userDatailsService;
	}

	/**
	 * Reescrita do método que faz a checagem do Token para saber quem é o usuário
	 * e qual é a sua autorização
	 * 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Busca o header do serviço JSON com a Authorization
		String header = request.getHeader("Authorization");
		
		if (header != null && header.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));
			if (auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		chain.doFilter(request, response);		
	}

	/**
	 * Método que retorna o usuário e seus perfils
	 * 
	 * @param token
	 * @return
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(String token) {
		if (jwtUtil.tokenValido(token) ) {
			String username = jwtUtil.getUsername(token);
			UserDetails user = userDatailsService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(user, user.getAuthorities());
		}
		return null;
	}
}

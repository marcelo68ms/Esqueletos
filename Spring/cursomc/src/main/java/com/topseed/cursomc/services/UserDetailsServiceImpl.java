package com.topseed.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.topseed.cursomc.domain.Cliente;
import com.topseed.cursomc.repositories.ClienteRepository;
import com.topseed.cursomc.security.UserSS;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository rep;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cli = rep.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}

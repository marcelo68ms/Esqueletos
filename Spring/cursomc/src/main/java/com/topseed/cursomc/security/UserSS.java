package com.topseed.cursomc.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.topseed.cursomc.domain.enums.Perfil;

public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	// Incluir as informações de Usuários
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {

	}

	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Lista da linha 14
		return authorities;
	}

	@Override
	public String getPassword() {
		// linha 13
		return senha;
	}

	@Override
	public String getUsername() {
		// linha 12
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// A conta não está expirada ?
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// A conta não está bloqueada ?
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// As credenciais não estão expiradas ?
		return true;
	}

	@Override
	public boolean isEnabled() {
		// O usuário está ativo ?
		return true;
	}

}

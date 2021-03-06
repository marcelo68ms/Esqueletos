package com.topseed.cursomc.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.topseed.cursomc.domain.enums.Perfil;

/**
 * Classe obrigatória, para a implemetação do UserDetails do Security 
 * 
 * @author marcelo
 *
 */
public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	// Incluir as informações de Usuários
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	/**
	 * Construtor vazio
	 */
	public UserSS() {

	}

	/**
	 * Construtor com a carga inicial dos atributos
	 * 
	 * @param id
	 * @param email
	 * @param senha
	 * @param perfis
	 */
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
		// Lista da linha 26
		return authorities;
	}

	@Override
	public String getPassword() {
		// linha 25
		return senha;
	}

	@Override
	public String getUsername() {
		// linha 24
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
	
	/**
	 * Método que retorna se o perfil é pertencente ao usuário logado.
	 * @param perfil
	 * @return
	 */
	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}
}

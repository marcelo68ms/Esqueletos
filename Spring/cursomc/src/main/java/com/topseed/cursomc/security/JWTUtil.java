package com.topseed.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Classe utilitária para o uso com o JWT
 * 
 * @author marcelo
 *
 */
@Component
public class JWTUtil {

	@Value("${jwt.sercret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private String expiration;
	
	/**
	 * Método responsável por gerar o Token 
	 *
	 * @param username
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String generateToken(String username) {	
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis()+ expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	/**
	 * Método que retorna se o Token é válido (true/false)
	 * 
	 * @param token
	 * @return
	 */
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que retorna o nome do usuário
	 * 
	 * @param token
	 * @return
	 */
	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}
	
	/**
	 * Método que captura as informações do security relativos
	 * ao login
	 * 
	 * @param token
	 * @return
	 */
	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}
}

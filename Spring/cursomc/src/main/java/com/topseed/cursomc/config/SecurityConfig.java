package com.topseed.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.topseed.cursomc.security.JWTAuthenticationFilter;
import com.topseed.cursomc.security.JWTAuthorizationFilter;
import com.topseed.cursomc.security.JWTUtil;

/**
 * Classe responsável por configurações de Segurança da Aplicação.
 * 
 * @author marcelo
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/* Por default o security bloqueia todas as URLs da aplicação */
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JWTUtil jwtUtil;

	// lista de urls que serão liberadas
	private static final String[] PUBLIC_MATCHERS = { "/h2-console/**" };

	// lista de urls que serão liberadas com o GET apenas
	private static final String[] PUBLIC_MATCHERS_GET = { "/produtos/**", "/categorias/**" };
	
	// lista de urls que serão liberadas com o POST
	private static final String[] PUBLIC_MATCHERS_POST = { "/clientes/**", "/auth/forgot/**" };
	

	/**
	 * Método que libera as urls de serviço da aplicação
	 * Inclusive determinando as URLs que são apenas para GET
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Libera a url do H2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.cors().and().csrf().disable(); // Permitir o Cors 
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_POST).permitAll() // Libera as urls de POST
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll() // Libera as urls de GET
			.antMatchers(PUBLIC_MATCHERS).permitAll() // Libera o restante de urls
			.anyRequest().authenticated();
		
		// Registro de Autenticação
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));

		// Registro da Autorização
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		
		// Registro da política da Sessão.
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	/**
	 * Método de configuração de captura dos detalhes de usuário e 
	 * da encriptação da senha
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	/**
	 * Liberação do cors
	 * 
	 * @return
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

	/**
	 * Método responsável pela incriptação da senha.
	 * 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

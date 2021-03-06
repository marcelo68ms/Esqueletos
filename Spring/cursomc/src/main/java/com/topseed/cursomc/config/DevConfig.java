package com.topseed.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.topseed.cursomc.services.DBService;
import com.topseed.cursomc.services.EmailService;
import com.topseed.cursomc.services.SmtpEmailService;

/**
 * Classe Responsável pela configuração da aplicação no ambiente de Desenvolvimento
 * 
 * @author marcelo
 *
 */
@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("{spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean intantiateDatabase() throws ParseException {
		if (strategy.equalsIgnoreCase("create")) {
			dbService.instantiateTestDatabase();
		}
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}

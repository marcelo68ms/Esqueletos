package com.topseed.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.Cliente;
import com.topseed.cursomc.repositories.ClienteRepository;
import com.topseed.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * Classe responsável por ações de autenticação e autorização
 * 
 * @author marcelo
 *
 */
@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRep;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	/**
	 * Método responsável pela mudança de senha.
	 * 
	 * @param email
	 */
	public void sendNewPassword(String email) {
	
		Cliente cliente = clienteRep.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado !");
		}
		
		String newPass = newPassword();
		cliente.setSenha(bCrypt.encode(newPass));
		
		clienteRep.save(cliente);
		
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	/**
	 * Método responsável para gerar uma nova senha com 10 caracteres aleatórios
	 * 
	 * @return
	 */
	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	/**
	 * Método que gera o caractere individualmente aleatório
	 * 
	 * @return
	 */
	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { //gera um dígito
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) { //gera letra maiúscula
			return (char) (rand.nextInt(26) + 65);			
		} else { //gera letra minúscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}

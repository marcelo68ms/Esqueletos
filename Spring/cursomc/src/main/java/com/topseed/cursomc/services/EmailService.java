package com.topseed.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.topseed.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}

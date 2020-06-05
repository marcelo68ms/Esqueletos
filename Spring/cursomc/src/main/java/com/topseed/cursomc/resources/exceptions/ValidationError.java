package com.topseed.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelos erros de validação
 * 
 * @author marcelo
 *
 */
public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	/**
	 * Construtor da classe 
	 * @param status
	 * @param msg
	 * @param timeStamp
	 */
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);		
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}	
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}

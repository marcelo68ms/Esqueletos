package com.topseed.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.topseed.cursomc.domain.Cliente;
import com.topseed.cursomc.domain.enums.TipoCliente;
import com.topseed.cursomc.dto.ClienteNewDTO;
import com.topseed.cursomc.repositories.ClienteRepository;
import com.topseed.cursomc.resources.exceptions.FieldMessage;
import com.topseed.cursomc.services.validation.util.BR;

/**
 * Classe que faz o tratamento de validações do Cliente na sua inserção.
 * 
 * @author marcelo
 *
 */
public class ClientInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repo;
	
	/**
	 * Inicializador da classe passando a interface como parâmetro
	 */
	@Override
	public void initialize(ClienteInsert ann) {
	}

	/**
	 * Retorna se as validações do Cliente são válidas ou não
	 */
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		// inclua os testes de validade do Cliente aqui, inserindo erros na lista
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
				
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

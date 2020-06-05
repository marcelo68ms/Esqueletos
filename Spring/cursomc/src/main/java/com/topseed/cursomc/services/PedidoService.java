package com.topseed.cursomc.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.Cliente;
import com.topseed.cursomc.domain.ItemPedido;
import com.topseed.cursomc.domain.PagamentoComBoleto;
import com.topseed.cursomc.domain.Pedido;
import com.topseed.cursomc.domain.enums.EstadoPagamento;
import com.topseed.cursomc.repositories.ItemPedidoRepository;
import com.topseed.cursomc.repositories.PagamentoRepository;
import com.topseed.cursomc.repositories.PedidoRepository;
import com.topseed.cursomc.security.UserSS;
import com.topseed.cursomc.services.exceptions.AuthorizationException;
import com.topseed.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * Classe responsável pelas regras de negócio para os Pedidos
 * 
 * @author marcelo
 *
 */
@Service
public class PedidoService {

	@Autowired
	private PedidoRepository rep;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagto;
	
	@Autowired
	private ProdutoService prod;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmailService emailService;
	
	/**
	 * Busca de um único Pedido, baseado no seu ID
	 * 
	 * @param id
	 * @return
	 */
	public Pedido find(Integer id) {
		Optional<Pedido> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Pedido: " + Pedido.class.getName()));
 	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());	
		}
		obj = rep.save(obj);
		pagto.save(obj.getPagamento());
		
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(prod.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		
		//		emailService.sendOrderConfirmationEmail(obj);
		emailService.sendOrderConfirmationHtmlEmail(obj);
		
		return obj;
	}
	
	/**
	 * Efetua uma busca de Pedidos paginadas   
	 *
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		// Busca o usuário autenticado
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso Negado");
		}
				
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Cliente cliente = clienteService.find(user.getId());
		
		return rep.findByCliente(cliente, pageRequest);
	}

}

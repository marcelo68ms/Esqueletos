package com.topseed.cursomc.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topseed.cursomc.domain.ItemPedido;
import com.topseed.cursomc.domain.PagamentoComBoleto;
import com.topseed.cursomc.domain.Pedido;
import com.topseed.cursomc.domain.enums.EstadoPagamento;
import com.topseed.cursomc.repositories.ItemPedidoRepository;
import com.topseed.cursomc.repositories.PagamentoRepository;
import com.topseed.cursomc.repositories.PedidoRepository;
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
	private ClienteService cliente;
	
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
		obj.setCliente(cliente.find(obj.getCliente().getId()));
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
		
		emailService.sendOrderConfirmationEmail(obj);
		
		return obj;
	}
}

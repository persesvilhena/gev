package br.com.projeto.bean;

import java.util.Date;
import java.util.List;

public class VendaBean {
	private int Codigo;
	private ClienteBean Cliente;
	private double acrescimo;
	private double desconto;
	private double total;
	private Date datavenda;
	private List<ItemVendaBean> venItens;
	
	public List<ItemVendaBean> getVenItens() {
		return venItens;
	}

	public void setVenItens(List<ItemVendaBean> venItens) {
		this.venItens = venItens;
	}
	
	public Date getDatavenda() {
		return datavenda;
	}
	public void setDatavenda(Date datavenda) {
		this.datavenda = datavenda;
	}
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public ClienteBean getCliente() {
		return Cliente;
	}
	public void setCliente(ClienteBean cliente) {
		Cliente = cliente;
	}
	public double getAcrescimo() {
		return acrescimo;
	}
	public void setAcrescimo(double acrescimo) {
		this.acrescimo = acrescimo;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}

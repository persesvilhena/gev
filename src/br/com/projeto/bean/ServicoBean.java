package br.com.projeto.bean;

import java.util.Date;

public class ServicoBean {
	private int codser;
	private ClienteBean codcli;
	private String desser;
	private double totser;
	private Date datser;
	public ServicoBean(int codser, ClienteBean codcli, String desser,
			double totser, Date datser) {
		super();
		this.codser = codser;
		this.codcli = codcli;
		this.desser = desser;
		this.totser = totser;
		this.datser = datser;
	}
	public ServicoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodser() {
		return codser;
	}
	public void setCodser(int codser) {
		this.codser = codser;
	}
	public ClienteBean getCodcli() {
		return codcli;
	}
	public void setCodcli(ClienteBean codcli) {
		this.codcli = codcli;
	}
	public String getDesser() {
		return desser;
	}
	public void setDesser(String desser) {
		this.desser = desser;
	}
	public double getTotser() {
		return totser;
	}
	public void setTotser(double totser) {
		this.totser = totser;
	}
	public Date getDatser() {
		return datser;
	}
	public void setDatser(Date datser) {
		this.datser = datser;
	}
	

}

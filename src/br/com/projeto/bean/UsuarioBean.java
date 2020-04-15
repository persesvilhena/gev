package br.com.projeto.bean;

import java.util.Date;


public class UsuarioBean {
	private int codUsu;
	private String nomeUsu;
	private String loginUsu;
	private String senha;
	private String tipoAcesso;
	private CidadeBean cidadeUsu;
	private Date data;
	private String cpf;
	
	
	
	public UsuarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UsuarioBean(int codUsu, String nomeUsu, String loginUsu,
			String senha, String tipoAcesso, CidadeBean cidadeUsu, Date data,
			String cpf) {
		super();
		this.codUsu = codUsu;
		this.nomeUsu = nomeUsu;
		this.loginUsu = loginUsu;
		this.senha = senha;
		this.tipoAcesso = tipoAcesso;
		this.cidadeUsu = cidadeUsu;
		this.data = data;
		this.cpf = cpf;
	}



	public int getCodUsu() {
		return codUsu;
	}



	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}



	public String getNomeUsu() {
		return nomeUsu;
	}



	public void setNomeUsu(String nomeUsu) {
		this.nomeUsu = nomeUsu;
	}



	public String getLoginUsu() {
		return loginUsu;
	}



	public void setLoginUsu(String loginUsu) {
		this.loginUsu = loginUsu;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getTipoAcesso() {
		return tipoAcesso;
	}



	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}



	public CidadeBean getCidadeUsu() {
		return cidadeUsu;
	}



	public void setCidadeUsu(CidadeBean cidadeUsu) {
		this.cidadeUsu = cidadeUsu;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	


}

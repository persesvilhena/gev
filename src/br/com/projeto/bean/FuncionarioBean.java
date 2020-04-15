package br.com.projeto.bean;

import java.util.Date;

public class FuncionarioBean {
	
	private int codigo;
	private String nome;
	private String endereco ;
	private String numero ;
	private String bairro ;
	private String cep ;
	private CidadeBean cidade ;
	private String estado ;
	private String telefone ;
	private String email ;
	private String cpf ;
	private String rg ;
	private Date nascimento ;
	
	public FuncionarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FuncionarioBean(int codigo, String nome, String endereco, String numero, String bairro, String cep,
			CidadeBean cidade, String estado, String telefone, String email, String cpf, String rg, Date nascimento) 
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.nascimento = nascimento;
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public CidadeBean getCidade() {
		return cidade;
	}
	public void setCidade(CidadeBean cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	

}

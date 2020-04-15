package br.com.projeto.bean;

public class FornecedorBean {
	
	private int codigo;
	private String nome;
	private String endereco ;
	private String email ;
	private String telefone ;
	private String cnpj ;
	private String obs ;
	public FornecedorBean(int codigo, String nome, String endereco,
			String email, String telefone, String cnpj, String obs) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.obs = obs;
	}
	public FornecedorBean() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	

}

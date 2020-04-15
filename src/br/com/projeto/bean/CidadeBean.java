package br.com.projeto.bean;

public class CidadeBean {
	private int CodCid;
	private String NomCid;
	private String UfCid;
	
	
	
	public CidadeBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CidadeBean(int codCid, String nomCid, String ufCid) {
		super();
		CodCid = codCid;
		NomCid = nomCid;
		UfCid = ufCid;
	}



	public int getCodCid() {
		return CodCid;
	}



	public void setCodCid(int codCid) {
		CodCid = codCid;
	}



	public String getNomCid() {
		return NomCid;
	}



	public void setNomCid(String nomCid) {
		NomCid = nomCid;
	}



	public String getUfCid() {
		return UfCid;
	}



	public void setUfCid(String ufCid) {
		UfCid = ufCid;
	}
	
	

}

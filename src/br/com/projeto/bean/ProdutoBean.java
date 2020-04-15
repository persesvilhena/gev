package br.com.projeto.bean;

public class ProdutoBean {
	private int CodPro;
	private String NomPro;
	private String DesPro;
	private double CusPro;
	private double VenPro;
	private int EstPro;
	public ProdutoBean(int codPro, String nomPro, String desPro, double cusPro,
			double venPro, int estPro) {
		super();
		CodPro = codPro;
		NomPro = nomPro;
		DesPro = desPro;
		CusPro = cusPro;
		VenPro = venPro;
		EstPro = estPro;
	}
	public ProdutoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodPro() {
		return CodPro;
	}
	public void setCodPro(int codPro) {
		CodPro = codPro;
	}
	public String getNomPro() {
		return NomPro;
	}
	public void setNomPro(String nomPro) {
		NomPro = nomPro;
	}
	public String getDesPro() {
		return DesPro;
	}
	public void setDesPro(String desPro) {
		DesPro = desPro;
	}
	public double getCusPro() {
		return CusPro;
	}
	public void setCusPro(double cusPro) {
		CusPro = cusPro;
	}
	public double getVenPro() {
		return VenPro;
	}
	public void setVenPro(double venPro) {
		VenPro = venPro;
	}
	public int getEstPro() {
		return EstPro;
	}
	public void setEstPro(int estPro) {
		EstPro = estPro;
	}
	
	public String toString() {
		
		return getNomPro();
	}

	

}

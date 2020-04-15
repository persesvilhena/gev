package br.com.projeto.bean;

public class ItemVendaBean {

	private int CodItem;
	private int CodVenda;
	private ProdutoBean produto;
	private int quant;
	
	public int getCodItem() {
		return CodItem;
	}
	public void setCodItem(int codItem) {
		CodItem = codItem;
	}
	public int getCodVenda() {
		return CodVenda;
	}
	public void setCodVenda(int codVenda) {
		CodVenda = codVenda;
	}
	public ProdutoBean getProduto() {
		return produto;
	}
	public void setProduto(ProdutoBean produto) {
		this.produto = produto;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}

	
}

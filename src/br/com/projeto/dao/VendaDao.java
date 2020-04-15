package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.projeto.bean.ItemVendaBean;
import br.com.projeto.bean.VendaBean;
import br.com.projeto.conexao.Conexao;

public class VendaDao {
	
	//private ItemVendaDao objItemVendaDao;

	public void cadastrarVenda(VendaBean Venda) throws SQLException, ClassNotFoundException {
		List<ItemVendaBean> listaItens = Venda.getVenItens();
		
		// inclui venda
		inserirVenda(Venda);
		int venCod = retornaultimocodigo();
		
		// incluir itens e baixar estoque
		for (ItemVendaBean objItem : listaItens) {
			objItem.setCodVenda(venCod);
			ItemVendaDao itens = new ItemVendaDao();
			itens.cadastrarItemVenda(objItem);
			ProdutoDao baixar = new ProdutoDao();
			baixar.baixarestoque(objItem);
		}
	}
	
	public VendaBean inserirVenda(VendaBean objVenda) throws SQLException, ClassNotFoundException{
		String sql = "INSERT INTO vendas (CliVen, DatVen, DesVen, AcrVen, TotVen) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, objVenda.getCliente().getCodigo());
		comandoSql.setDate(2, new java.sql.Date(objVenda.getDatavenda().getTime()));
		comandoSql.setDouble(3, objVenda.getDesconto());
		comandoSql.setDouble(4, objVenda.getAcrescimo());
		comandoSql.setDouble(5, objVenda.getTotal());
		comandoSql.execute(); 
		Conexao.getInstance().commit();
		return objVenda;
	}
	

	private int retornaultimocodigo() throws SQLException, ClassNotFoundException
	{          
		String sql = "SELECT MAX(CodVen) FROM vendas";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		ResultSet rs = comandoSql.executeQuery();
		int codigo=0;
		if (rs.next()) {
			//VendaBean venda = new VendaBean();
			codigo = rs.getInt(1);
		}		
		return codigo;
	}
}

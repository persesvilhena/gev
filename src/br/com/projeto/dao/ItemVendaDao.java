package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.bean.ItemVendaBean;
import br.com.projeto.bean.ProdutoBean;
import br.com.projeto.conexao.Conexao;

public class ItemVendaDao {

	public void cadastrarItemVenda(ItemVendaBean objItemVenda) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO itensvenda (CodVen, CodPro,  QtdPro, ValPro) VALUES (?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, objItemVenda.getCodVenda());
		ProdutoBean objProduto = objItemVenda.getProduto();
		if (objProduto != null) {
			comandoSql.setInt(2, objProduto.getCodPro());
		} else {
			comandoSql.setInt(2, 0);
		}
		System.out.println("oioioi");
		comandoSql.setInt(3, objItemVenda.getQuant());
		comandoSql.setDouble(4, objProduto.getVenPro());
		comandoSql.execute(); 
		Conexao.getInstance().commit();
	}
	
	public void alterarItemVenda(ItemVendaBean objItemVenda) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE ItemVenda SET CodVen = ?, CodPro = ?, QtdPro = ?, ValPro = ? WHERE CodIte = ?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, objItemVenda.getCodVenda());
		comandoSql.setInt(2, objItemVenda.getProduto().getCodPro());
		comandoSql.setInt(3, objItemVenda.getQuant());
		comandoSql.setDouble(4, objItemVenda.getProduto().getVenPro());
		comandoSql.setInt(5, objItemVenda.getCodItem());
		comandoSql.execute(); 
		Conexao.getInstance().commit();
	}
	

	public void excluirItemVenda(int codItemVenda) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM ItemVenda WHERE CodIte = ?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, codItemVenda);

		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public List<ItemVendaBean> consultarItemVenda(String codigo) throws SQLException, ClassNotFoundException{
		List<ItemVendaBean> listaItemVenda = null;

		// implementar inner join
		String sql = "SELECT * FROM ItemVenda WHERE CodIte LIKE ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + codigo + "%");
		ResultSet rs = comandoSql.executeQuery();

		listaItemVenda = new ArrayList<ItemVendaBean>();
		while (rs.next()) {
			ItemVendaBean objItemVenda = new ItemVendaBean();
			objItemVenda.setCodItem(rs.getInt("CodIte"));
			objItemVenda.setQuant(rs.getInt("QtdIte"));
			ProdutoBean objProd = new ProdutoBean();
			objProd.setCodPro(rs.getInt("CodPro"));
			objItemVenda.setProduto(objProd);
			objItemVenda.setCodVenda(rs.getInt("CodVen"));
			listaItemVenda.add(objItemVenda);
		}
		return listaItemVenda;
	}
	
}

package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.projeto.bean.ItemVendaBean;
import br.com.projeto.bean.ProdutoBean;
import br.com.projeto.conexao.Conexao;

public class ProdutoDao {


	List<ProdutoBean> listaproduto = null;
	
	public ProdutoBean consultarProdutoTodos(String nome) throws SQLException,
	ClassNotFoundException {
		ProdutoBean produtoBean = null;
		String sql = "SELECT * FROM produtos";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			produtoBean = new ProdutoBean();
			produtoBean.setCodPro(rs.getInt("CodPro"));
			produtoBean.setNomPro(rs.getString("NomPro"));
			produtoBean.setDesPro(rs.getString("DesPro"));
			produtoBean.setCusPro(rs.getDouble("CusPro"));			
			produtoBean.setVenPro(rs.getDouble("VenPro"));
			produtoBean.setEstPro(rs.getInt("EstPro"));
			
		}		
		return produtoBean;
	}
	public List<ProdutoBean> consultarProduto(String nome) throws SQLException,ClassNotFoundException {
		String sql = "SELECT * FROM produtos WHERE NomPro LIKE ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		
		ResultSet rs = comandoSql.executeQuery();
		
		listaproduto = new ArrayList<ProdutoBean>();
		
		while (rs.next()) {
			
			ProdutoBean produto = new ProdutoBean();;
			produto.setCodPro(rs.getInt("CodPro"));
			produto.setNomPro(rs.getString("NomPro"));
			produto.setDesPro(rs.getString("DesPro"));
			produto.setCusPro(rs.getDouble("CusPro"));			
			produto.setVenPro(rs.getDouble("VenPro"));
			produto.setEstPro(rs.getInt("EstPro"));
			listaproduto.add(produto);
			
		}		
		return listaproduto;
	}
	public void cadastrarProduto(ProdutoBean produto) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO produtos (NomPro, DesPro, CusPro, VenPro, EstPro) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, produto.getNomPro());
		comandoSql.setString(2, produto.getDesPro());
		comandoSql.setDouble(3, produto.getCusPro());
		comandoSql.setDouble(4, produto.getVenPro());
		comandoSql.setInt(5, produto.getEstPro());
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	
	public void alterarProduto(ProdutoBean produto) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE produtos SET NomPro = ?, DesPro = ?, CusPro = ?, VenPro = ?, EstPro = ?  WHERE CodPro = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, produto.getNomPro());
		comandoSql.setString(2, produto.getDesPro());
		comandoSql.setDouble(3, produto.getCusPro());
		comandoSql.setDouble(4, produto.getVenPro());
		comandoSql.setInt(5, produto.getEstPro());
		comandoSql.setInt(6, produto.getCodPro());
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	public void excluirProduto(int codigo) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM produtos WHERE CodPro = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, codigo);
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	public void baixarestoque(ItemVendaBean objItemVenda) throws SQLException, ClassNotFoundException{
		String sql = "SELECT EstPro FROM produtos WHERE CodPro=?"; 
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql); 
		comandoSql.setInt(1, objItemVenda.getProduto().getCodPro()); 
		ResultSet rs = comandoSql.executeQuery(); 
		int quantidade = 0;
		while (rs.next()){
			quantidade = rs.getInt(1);
		}
		quantidade = quantidade - objItemVenda.getQuant();
		
		sql = "UPDATE produtos SET EstPro = ? WHERE CodPro = ?"; 
		comandoSql = Conexao.getInstance().prepareStatement(sql); 
		comandoSql.setInt(1, quantidade); 
		comandoSql.setInt(2, objItemVenda.getProduto().getCodPro());
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
		System.out.println("Estoque atualizado com sucesso! ");
	}
	

	
}

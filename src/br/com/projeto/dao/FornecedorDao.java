package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.projeto.bean.FornecedorBean;
import br.com.projeto.conexao.Conexao;



public class FornecedorDao {

	List<FornecedorBean> listafornecedor = null;
	
	public FornecedorBean consultarFornecedorTodos(String nome) throws SQLException,
	ClassNotFoundException {
		FornecedorBean fornecedorBean = null;
		String sql = "SELECT * FROM fornecedores";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			fornecedorBean = new FornecedorBean();
			fornecedorBean.setCodigo(rs.getInt("codfornecedor"));
			fornecedorBean.setNome(rs.getString("nome"));
			fornecedorBean.setEndereco(rs.getString("endereco"));
			fornecedorBean.setEmail(rs.getString("email"));			
			fornecedorBean.setTelefone(rs.getString("telefone"));	
			fornecedorBean.setCnpj(rs.getString("cnpj"));
			fornecedorBean.setObs(rs.getString("obs"));	
		}		
		return fornecedorBean;
	}
	public List<FornecedorBean> consultarFornecedor(String nome) throws SQLException,ClassNotFoundException {
		String sql = "SELECT * FROM fornecedores WHERE nome LIKE ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		
		ResultSet rs = comandoSql.executeQuery();
		
		listafornecedor = new ArrayList<FornecedorBean>();
		
		while (rs.next()) {
			
			FornecedorBean fornecedor = new FornecedorBean();;
			fornecedor.setCodigo(rs.getInt("codfornecedor"));
			fornecedor.setNome(rs.getString("nome"));
			fornecedor.setEndereco(rs.getString("endereco"));
			fornecedor.setEmail(rs.getString("email"));			
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setObs(rs.getString("obs"));
			listafornecedor.add(fornecedor);
			
		}		
		return listafornecedor;
	}

	public void cadastrarFornecedor(FornecedorBean fornecedor) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO fornecedores (nome, endereco, email, telefone, cnpj, obs) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, fornecedor.getNome());
		comandoSql.setString(2, fornecedor.getEndereco());
		comandoSql.setString(3, fornecedor.getEmail());
		comandoSql.setString(4, fornecedor.getTelefone());
		comandoSql.setString(5, fornecedor.getCnpj());
		comandoSql.setString(6, fornecedor.getObs());
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	
	public void alterarFornecedor(FornecedorBean fornecedor) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE fornecedores SET nome = ?, endereco = ?, email = ?, telefone = ?, cnpj = ?, obs = ?  WHERE codfornecedor = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, fornecedor.getNome());
		comandoSql.setString(2, fornecedor.getEndereco());
		comandoSql.setString(3, fornecedor.getEmail());
		comandoSql.setString(4, fornecedor.getTelefone());
		comandoSql.setString(5, fornecedor.getCnpj());
		comandoSql.setString(6, fornecedor.getObs());
		comandoSql.setInt(7, fornecedor.getCodigo());	
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
		public void excluirFornecedor(int codigo) throws SQLException, ClassNotFoundException {
			String sql = "DELETE FROM fornecedores WHERE codfornecedor = ?";
			PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
			comandoSql.setInt(1, codigo);
			comandoSql.execute();
			Conexao.getInstance().commit();
		}


	}
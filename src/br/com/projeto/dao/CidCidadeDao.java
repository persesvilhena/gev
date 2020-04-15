package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;


import br.com.projeto.bean.CidCidadeBean;
import br.com.projeto.conexao.Conexao;



public class CidCidadeDao {

	List<CidCidadeBean> listacidade = null;
	
	public CidCidadeBean consultarCidadeTodos(String nome) throws SQLException,
	ClassNotFoundException {
		CidCidadeBean cidadeBean = null;
		String sql = "SELECT * FROM cidade";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			cidadeBean = new CidCidadeBean();
			cidadeBean.setCodCid(rs.getInt("CodCid"));
			cidadeBean.setNomCid(rs.getString("NomCid"));
			cidadeBean.setUfCid(rs.getString("UfCid"));
			
		}		
		return cidadeBean;
	}
	public List<CidCidadeBean> consultarCidade(String nome) throws SQLException,ClassNotFoundException {
		String sql = "SELECT * FROM cidade WHERE NomCid LIKE ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		
		ResultSet rs = comandoSql.executeQuery();
		
		listacidade = new ArrayList<CidCidadeBean>();
		
		while (rs.next()) {
			
			CidCidadeBean cidade = new CidCidadeBean();;
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));
			listacidade.add(cidade);
			
		}		
		return listacidade;
	}

	public void cadastrarCidade(CidCidadeBean cidade) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO cidade (NomCid, UfCid) VALUES (?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cidade.getNomCid());
		comandoSql.setString(2, cidade.getUfCid());
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	
	public void alterarCidade(CidCidadeBean cidade) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE cidade SET NomCid = ?, UfCid = ?  WHERE CodCid = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cidade.getNomCid());
		comandoSql.setString(2, cidade.getUfCid());
		comandoSql.setInt(3, cidade.getCodCid());	
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
		public void excluirCidade(int codigo) throws SQLException, ClassNotFoundException {
			String sql = "DELETE FROM cidade WHERE CodCid = ?";
			PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
			comandoSql.setInt(1, codigo);
			comandoSql.execute();
			Conexao.getInstance().commit();
		}
		public List<CidCidadeBean> consultarCidades() throws SQLException, ClassNotFoundException {
			List<CidCidadeBean> listacidade = null;
			String sql = "SELECT * FROM cidade ORDER BY NomCid";

			PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
			
			ResultSet rs = comandoSQL.executeQuery();

			listacidade = new ArrayList<CidCidadeBean>();
			while (rs.next()) {
				CidCidadeBean cidade = new CidCidadeBean();
				cidade.setCodCid(rs.getInt("CodCid"));
				cidade.setNomCid(rs.getString("NomCid"));

				listacidade.add(cidade);
			}

			return listacidade;
		}


	}
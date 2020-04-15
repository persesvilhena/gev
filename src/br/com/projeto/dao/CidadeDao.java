package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.projeto.bean.CidadeBean;
import br.com.projeto.conexao.Conexao;

public class CidadeDao {
	List<CidadeBean> listacidade = null;
	
	/**
	 * O metodo busca uma cidade pelo codigo
	 * @param cidCod
	 * @return cidade
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public CidadeBean consultarCidadePorCod(int CodCid) throws SQLException, ClassNotFoundException {
		CidadeBean cidade = null;
		String sql = "SELECT * FROM cidade WHERE CodCid = ?";

		PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		comandoSQL.setInt(1, CodCid);
		ResultSet rs = comandoSQL.executeQuery();

		while (rs.next()) {
			cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));
		}
		
		return cidade;
	}
	
	/**
	 * O metodo busca o codigo de uma cidade pelo nome 
	 * @param cidNome
	 * @return codigo
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public int consultarCidadePorNome(String NomCid) throws SQLException, ClassNotFoundException {
		int codigo = -1;
		String sql = "SELECT * FROM cidade WHERE NomCid = ?";

		PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		comandoSQL.setString(1, NomCid);
		ResultSet rs = comandoSQL.executeQuery();

		if (rs.next()) {
			codigo = rs.getInt("CodCid");
		}

		return codigo;
	}

	/**
	 * O metodo busca as cidades de um estado
	 * @param cidUf
	 * @return listaCidades
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<CidadeBean> consultarCidadePorUf(String cidUf) throws SQLException, ClassNotFoundException {
		List<CidadeBean> listaCidades = null;
		String sql = "SELECT * FROM cidade WHERE UfCid = ?";

		PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		comandoSQL.setString(1, cidUf);
		// ResultSet contem o resultado do sql
		ResultSet rs = comandoSQL.executeQuery();

		listaCidades = new ArrayList<CidadeBean>();
		while (rs.next()) {
			CidadeBean cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));

			listaCidades.add(cidade);
		}

		return listaCidades;
	}
	
	/**
	 * O metodo busca todas as cidades
	 * @param 
	 * @return listaCidades
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<CidadeBean> consultarCidades() throws SQLException, ClassNotFoundException {
		List<CidadeBean> listaCidades = null;
		String sql = "SELECT * FROM cidade ORDER BY NomCid";

		PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSQL.executeQuery();

		listaCidades = new ArrayList<CidadeBean>();
		while (rs.next()) {
			CidadeBean cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));

			listaCidades.add(cidade);
		}

		return listaCidades;
	}
	public void cadastrarCidade(CidadeBean cidade) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO cidade (CodCid, NomCid, UfCid) VALUES (?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, cidade.getCodCid());
		comandoSql.setString(2, cidade.getNomCid());
		comandoSql.setString(3, cidade.getUfCid());
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	
	public void alterarCidade(CidadeBean cidade) throws SQLException, ClassNotFoundException {
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
	public CidadeBean conconsultarCidadeTodos(String nome) throws SQLException,
	ClassNotFoundException {
		CidadeBean cidadeBean = null;
		String sql = "SELECT * FROM cidade";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			cidadeBean = new CidadeBean();
			cidadeBean.setCodCid(rs.getInt("CodCid"));
			cidadeBean.setNomCid(rs.getString("NomCid"));
			cidadeBean.setUfCid(rs.getString("UfCid"));
			
		}		
		return cidadeBean;
	}
	public List<CidadeBean> conconsultarCidade(String nome) throws SQLException,ClassNotFoundException {
		String sql = "SELECT * FROM cidade WHERE NomCid like ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		
		ResultSet rs = comandoSql.executeQuery();
		
		listacidade = new ArrayList<CidadeBean>();
		
		while (rs.next()) {
			
			CidadeBean cidade = new CidadeBean();;
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));
			listacidade.add(cidade);
			
		}		
		return listacidade;
	}

}

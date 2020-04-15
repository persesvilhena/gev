package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.com.projeto.bean.ServicoBean;
import br.com.projeto.bean.ClienteBean;
import br.com.projeto.conexao.Conexao;



public class ServicoDao {

	List<ServicoBean> listaservico = null;
	
	public ServicoBean consultarServicoTodos(String descricao) throws SQLException,
	ClassNotFoundException {
		ServicoBean servicoBean = null;
		String sql = "SELECT * FROM servicos";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + descricao + "%");
		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			servicoBean = new ServicoBean();
			servicoBean.setCodser(rs.getInt("CodCli"));
			ClienteBean cliente = new ClienteBean();
			cliente.setCodigo(rs.getInt("CodCli"));
			cliente.setNome(rs.getString("NomCli"));
			servicoBean.setDesser(rs.getString("DesSer"));
			servicoBean.setTotser(rs.getDouble("TotSer"));
			Date dataNasc = new java.util.Date(rs.getDate("DatSer").getTime());
			servicoBean.setDatser(dataNasc);
			servicoBean.setCodcli(cliente);
			
		}		
		return servicoBean;
	}
	public List<ServicoBean> consultarServico(String descricao) throws SQLException,ClassNotFoundException {
		String sql = "SELECT * FROM servicos INNER JOIN clientes ON clientes.CodCli = servicos.CodCli WHERE DesSer LIKE ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + descricao + "%");
		
		ResultSet rs = comandoSql.executeQuery();
		
		listaservico = new ArrayList<ServicoBean>();
		
		while (rs.next()) {
			
			ServicoBean servico = new ServicoBean();;
			servico.setCodser(rs.getInt("CodSer"));
			ClienteBean cliente = new ClienteBean();
			cliente.setCodigo(rs.getInt("CodCli"));
			cliente.setNome(rs.getString("NomCli"));
			servico.setDesser(rs.getString("DesSer"));
			servico.setTotser(rs.getDouble("TotSer"));
			Date dataNasc = new java.util.Date(rs.getDate("DatSer").getTime());
			servico.setDatser(dataNasc);
			servico.setCodcli(cliente);
			listaservico.add(servico);
			
		}		
		return listaservico;
	}

	public void cadastrarServico(ServicoBean servico) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO servicos (CodCli, DesSer, TotSer, DatSer) VALUES (?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, servico.getCodcli().getCodigo());
		comandoSql.setString(2, servico.getDesser());
		comandoSql.setDouble(3, servico.getTotser());
		comandoSql.setDate(4, new java.sql.Date(servico.getDatser().getTime()));
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	
	public void alterarServico(ServicoBean servico) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE servicos SET CodCli = ?, DesSer = ?, TotSer = ?, DatSer = ? WHERE CodSer = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, servico.getCodcli().getCodigo());
		comandoSql.setString(2, servico.getDesser());
		comandoSql.setDouble(3, servico.getTotser());
		comandoSql.setDate(4, new java.sql.Date(servico.getDatser().getTime()));
		comandoSql.setInt(5, servico.getCodser());	
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
		public void excluirServico(int codigo) throws SQLException, ClassNotFoundException {
			String sql = "DELETE FROM servicos WHERE CodSer = ?";
			PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
			comandoSql.setInt(1, codigo);
			comandoSql.execute();
			Conexao.getInstance().commit();
		}


	}
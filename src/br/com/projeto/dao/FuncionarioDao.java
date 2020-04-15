package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.com.projeto.bean.CidadeBean;
import br.com.projeto.bean.FuncionarioBean;
import br.com.projeto.conexao.Conexao;



public class FuncionarioDao {

	List<FuncionarioBean> listafuncionario = null;
	
	public FuncionarioBean consultarFuncionarioTodos(String nome) throws SQLException,
	ClassNotFoundException {
		FuncionarioBean funcionarioBean = null;
		String sql = "SELECT * FROM funcionarios";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			funcionarioBean = new FuncionarioBean();
			funcionarioBean.setCodigo(rs.getInt("CodCli"));
			funcionarioBean.setNome(rs.getString("NomCli"));
			funcionarioBean.setEndereco(rs.getString("EndCli"));
			funcionarioBean.setNumero(rs.getString("NumCli"));			
			funcionarioBean.setBairro(rs.getString("BaiCli"));
			funcionarioBean.setCep(rs.getString("CepCli"));
			CidadeBean cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));
			funcionarioBean.setEstado(rs.getString("EstCli"));
			funcionarioBean.setTelefone(rs.getString("TelCli"));
			funcionarioBean.setEmail(rs.getString("EmaCli"));
			funcionarioBean.setCpf(rs.getString("CpfCli"));
			funcionarioBean.setRg(rs.getString("RgCli"));
			Date dataNasc = new java.util.Date(rs.getDate("DatUsu").getTime());
			funcionarioBean.setNascimento(dataNasc);
			funcionarioBean.setCidade(cidade);
			
		}		
		return funcionarioBean;
	}
	public List<FuncionarioBean> consultarFuncionario(String nome) throws SQLException,ClassNotFoundException {
		String sql = "SELECT * FROM funcionarios INNER JOIN cidade ON funcionarios.CidFun = cidade.CodCid WHERE NomFun LIKE ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		
		ResultSet rs = comandoSql.executeQuery();
		
		listafuncionario = new ArrayList<FuncionarioBean>();
		
		while (rs.next()) {
			
			FuncionarioBean funcionario = new FuncionarioBean();;
			funcionario.setCodigo(rs.getInt("CodFun"));
			funcionario.setNome(rs.getString("NomFun"));
			funcionario.setEndereco(rs.getString("EndFun"));
			funcionario.setNumero(rs.getString("NumFun"));			
			funcionario.setBairro(rs.getString("BaiFun"));
			funcionario.setCep(rs.getString("CepFun"));
			CidadeBean cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));
			funcionario.setEstado(rs.getString("EstFun"));
			funcionario.setTelefone(rs.getString("TelFun"));
			funcionario.setEmail(rs.getString("EmaFun"));
			funcionario.setCpf(rs.getString("CpfFun"));
			funcionario.setRg(rs.getString("RgFun"));
			Date dataNasc = new java.util.Date(rs.getDate("NasFun").getTime());
			funcionario.setNascimento(dataNasc);
			funcionario.setCidade(cidade);
			listafuncionario.add(funcionario);
			
		}		
		return listafuncionario;
	}

	public void cadastrarFuncionario(FuncionarioBean funcionario) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO funcionarios (NomFun, EndFun, NumFun, BaiFun, CepFun, CidFun, EstFun, TelFun, EmaFun, CpfFun, RgFun, NasFun) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, funcionario.getNome());
		comandoSql.setString(2, funcionario.getEndereco());
		comandoSql.setString(3, funcionario.getNumero());
		comandoSql.setString(4, funcionario.getBairro());
		comandoSql.setString(5, funcionario.getCep());
		comandoSql.setInt(6, funcionario.getCidade().getCodCid());
		comandoSql.setString(7, funcionario.getEstado());
		comandoSql.setString(8, funcionario.getTelefone());
		comandoSql.setString(9, funcionario.getEmail());
		comandoSql.setString(10, funcionario.getCpf());
		comandoSql.setString(11, funcionario.getRg());
		comandoSql.setDate(12, new java.sql.Date(funcionario.getNascimento().getTime()));
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	
	public void alterarFuncionario(FuncionarioBean funcionario) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE funcionarios SET NomFun = ?, EndFun = ?, NumFun = ?, BaiFun = ?, CepFun = ?, CidFun = ?,EstFun = ?, TelFun = ?, EmaFun = ?, CpfFun = ?, RgFun = ?, NasFun = ?  WHERE CodFun = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, funcionario.getNome());
		comandoSql.setString(2, funcionario.getEndereco());
		comandoSql.setString(3, funcionario.getNumero());
		comandoSql.setString(4, funcionario.getBairro());
		comandoSql.setString(5, funcionario.getCep());
		comandoSql.setInt(6, funcionario.getCidade().getCodCid());
		comandoSql.setString(7, funcionario.getEstado());
		comandoSql.setString(8, funcionario.getTelefone());
		comandoSql.setString(9, funcionario.getEmail());
		comandoSql.setString(10, funcionario.getCpf());
		comandoSql.setString(11, funcionario.getRg());
		comandoSql.setDate(12, new java.sql.Date(funcionario.getNascimento().getTime()));
		comandoSql.setInt(13, funcionario.getCodigo());	
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
		public void excluirFuncionario(int codigo) throws SQLException, ClassNotFoundException {
			String sql = "DELETE FROM funcionarios WHERE CodFun = ?";
			PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
			comandoSql.setInt(1, codigo);
			comandoSql.execute();
			Conexao.getInstance().commit();
		}


	}
package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.com.projeto.bean.CidadeBean;
import br.com.projeto.bean.ClienteBean;
import br.com.projeto.conexao.Conexao;



public class ClienteDao {

	List<ClienteBean> listacliente = null;
	
	public ClienteBean consultarUsuarioTodos(String nome) throws SQLException,
	ClassNotFoundException {
		ClienteBean clienteBean = null;
		String sql = "SELECT * FROM clientes";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			clienteBean = new ClienteBean();
			clienteBean.setCodigo(rs.getInt("CodCli"));
			clienteBean.setNome(rs.getString("NomCli"));
			clienteBean.setEndereco(rs.getString("EndCli"));
			clienteBean.setNumero(rs.getString("NumCli"));			
			clienteBean.setBairro(rs.getString("BaiCli"));
			clienteBean.setCep(rs.getString("CepCli"));
			CidadeBean cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));
			clienteBean.setEstado(rs.getString("EstCli"));
			clienteBean.setTelefone(rs.getString("TelCli"));
			clienteBean.setEmail(rs.getString("EmaCli"));
			clienteBean.setCpf(rs.getString("CpfCli"));
			clienteBean.setRg(rs.getString("RgCli"));
			Date dataNasc = new java.util.Date(rs.getDate("DatUsu").getTime());
			clienteBean.setNascimento(dataNasc);
			clienteBean.setCidade(cidade);
			
		}		
		return clienteBean;
	}
	public List<ClienteBean> consultarCliente(String nome) throws SQLException,ClassNotFoundException {
		String sql = "SELECT * FROM clientes INNER JOIN cidade ON clientes.CidCli = cidade.CodCid WHERE NomCli LIKE ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%");
		
		ResultSet rs = comandoSql.executeQuery();
		
		listacliente = new ArrayList<ClienteBean>();
		
		while (rs.next()) {
			
			ClienteBean cliente = new ClienteBean();;
			cliente.setCodigo(rs.getInt("CodCli"));
			cliente.setNome(rs.getString("NomCli"));
			cliente.setEndereco(rs.getString("EndCli"));
			cliente.setNumero(rs.getString("NumCli"));			
			cliente.setBairro(rs.getString("BaiCli"));
			cliente.setCep(rs.getString("CepCli"));
			CidadeBean cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CodCid"));
			cidade.setNomCid(rs.getString("NomCid"));
			cidade.setUfCid(rs.getString("UfCid"));
			cliente.setEstado(rs.getString("EstCli"));
			cliente.setTelefone(rs.getString("TelCli"));
			cliente.setEmail(rs.getString("EmaCli"));
			cliente.setCpf(rs.getString("CpfCli"));
			cliente.setRg(rs.getString("RgCli"));
			Date dataNasc = new java.util.Date(rs.getDate("NasCli").getTime());
			cliente.setNascimento(dataNasc);
			cliente.setCidade(cidade);
			listacliente.add(cliente);
			
		}		
		return listacliente;
	}

	public void cadastrarCliente(ClienteBean cliente) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO clientes (NomCli, EndCli, NumCli, BaiCli, CepCli, CidCli, EstCli, TelCli, EmaCli, CpfCli, RgCli, NasCli) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cliente.getNome());
		comandoSql.setString(2, cliente.getEndereco());
		comandoSql.setString(3, cliente.getNumero());
		comandoSql.setString(4, cliente.getBairro());
		comandoSql.setString(5, cliente.getCep());
		comandoSql.setInt(6, cliente.getCidade().getCodCid());
		comandoSql.setString(7, cliente.getEstado());
		comandoSql.setString(8, cliente.getTelefone());
		comandoSql.setString(9, cliente.getEmail());
		comandoSql.setString(10, cliente.getCpf());
		comandoSql.setString(11, cliente.getRg());
		comandoSql.setDate(12, new java.sql.Date(cliente.getNascimento().getTime()));
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
	
	public void alterarCliente(ClienteBean cliente) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE clientes SET NomCli = ?, EndCli = ?, NumCli = ?, BaiCli = ?, CepCli = ?, CidCli = ?,EstCli = ?, TelCli = ?, EmaCli = ?, CpfCli = ?, RgCli = ?, NasCli = ?  WHERE CodCli = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cliente.getNome());
		comandoSql.setString(2, cliente.getEndereco());
		comandoSql.setString(3, cliente.getNumero());
		comandoSql.setString(4, cliente.getBairro());
		comandoSql.setString(5, cliente.getCep());
		comandoSql.setInt(6, cliente.getCidade().getCodCid());
		comandoSql.setString(7, cliente.getEstado());
		comandoSql.setString(8, cliente.getTelefone());
		comandoSql.setString(9, cliente.getEmail());
		comandoSql.setString(10, cliente.getCpf());
		comandoSql.setString(11, cliente.getRg());
		comandoSql.setDate(12, new java.sql.Date(cliente.getNascimento().getTime()));
		comandoSql.setInt(13, cliente.getCodigo());	
		comandoSql.execute(); 
		Conexao.getInstance().commit(); 
	}
		public void excluirCliente(int codigo) throws SQLException, ClassNotFoundException {
			String sql = "DELETE FROM clientes WHERE CodCli = ?";
			PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
			comandoSql.setInt(1, codigo);
			comandoSql.execute();
			Conexao.getInstance().commit();
		}
		public List<ClienteBean> consultarClientes() throws SQLException, ClassNotFoundException {
			List<ClienteBean> listaClientes = null;
			String sql = "SELECT * FROM clientes ORDER BY NomCli";

			PreparedStatement comandoSQL = Conexao.getInstance().prepareStatement(sql);
			
			ResultSet rs = comandoSQL.executeQuery();

			listaClientes = new ArrayList<ClienteBean>();
			while (rs.next()) {
				ClienteBean cliente = new ClienteBean();
				cliente.setCodigo(rs.getInt("CodCli"));
				cliente.setNome(rs.getString("NomCli"));

				listaClientes.add(cliente);
			}

			return listaClientes;
		}


	}
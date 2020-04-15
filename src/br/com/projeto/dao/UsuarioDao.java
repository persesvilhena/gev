package br.com.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.projeto.bean.CidadeBean;
import br.com.projeto.bean.UsuarioBean;
import br.com.projeto.conexao.Conexao;


public class UsuarioDao {
	
	List<UsuarioBean> listausuario=null;

	
	public UsuarioBean consultarUsuarioPorLogin(String LogUsu, String SenUsu, String TipUsu) 
	throws SQLException, ClassNotFoundException{
		UsuarioBean usuarioBean = null;
		String sql="SELECT * FROM usuarios WHERE LogUsu = ? and SenUsu=? and TipUsu=?";
		PreparedStatement comandoSql = Conexao.getInstance() .prepareStatement (sql);
		comandoSql.setString(1, LogUsu);
		comandoSql.setString(2, SenUsu);
		comandoSql.setString(3, TipUsu);
		
		ResultSet rs=comandoSql.executeQuery();
		if(rs.next()){
			usuarioBean = new UsuarioBean();
			usuarioBean.setCodUsu(rs.getInt("CodUsu"));
			usuarioBean.setNomeUsu(rs.getString("NomUsu"));
			usuarioBean.setLoginUsu(rs.getString("LogUsu"));
			usuarioBean.setSenha(rs.getString("SenUsu"));
			usuarioBean.setTipoAcesso(rs.getString("TipUsu"));
			CidadeBean cidade = new CidadeBean();
			cidade.setCodCid(rs.getInt("CidUsu"));
			Date dataNasc = new java.util.Date(rs.getDate("DatUsu").getTime());
			usuarioBean.setData(dataNasc);
			usuarioBean.setCpf(rs.getString("CpfUsu"));
			usuarioBean.setCidadeUsu(cidade);
		}
		return usuarioBean;
}
	
		
	public List<UsuarioBean> consultarUsuarios(String nome)
	throws SQLException, ClassNotFoundException{
	UsuarioBean usuarioBean = null;
	String sql="SELECT * FROM usuarios INNER JOIN cidade ON usuarios.CidUsu = cidade.CodCid WHERE NomUsu LIKE ?";
	PreparedStatement comandoSql = Conexao.getInstance() .prepareStatement (sql);
	comandoSql.setString(1,"%" + nome + "%");
	
	
	ResultSet rs=comandoSql.executeQuery();
	
	listausuario = new ArrayList<UsuarioBean>();
	while(rs.next()){
		usuarioBean = new UsuarioBean();
		usuarioBean.setCodUsu(rs.getInt("CodUsu"));
		usuarioBean.setNomeUsu(rs.getString("NomUsu"));
		usuarioBean.setLoginUsu(rs.getString("LogUsu"));
		usuarioBean.setSenha(rs.getString("SenUsu"));
		usuarioBean.setTipoAcesso(rs.getString("TipUsu"));
		CidadeBean cidade = new CidadeBean();
		cidade.setCodCid(rs.getInt("CidUsu"));
		cidade.setNomCid (rs.getString("NomCid"));
		cidade.setUfCid(rs.getString("UfCid"));
		usuarioBean.setCidadeUsu(cidade);
		Date dataNasc = new java.util.Date(rs.getDate("DatUsu").getTime());
		usuarioBean.setData(dataNasc);
		usuarioBean.setCpf(rs.getString("CpfUsu"));
		listausuario.add(usuarioBean);
	}
	return listausuario;
}

	public void cadastrarUsuario(UsuarioBean usuario) throws SQLException, ClassNotFoundException{
		String sql = "INSERT INTO usuarios (NomUsu, LogUsu, SenUsu, TipUsu, CidUsu, DatUsu, CpfUsu) VALUES (?,?,?,?,?,?,?)";
	
	PreparedStatement comandoSql = Conexao.getInstance() .prepareStatement (sql);
	comandoSql.setString(1, usuario.getNomeUsu());
	comandoSql.setString(2, usuario.getLoginUsu());
	comandoSql.setString(3, usuario.getSenha());
	comandoSql.setString(4, usuario.getTipoAcesso());
	comandoSql.setInt(5, usuario.getCidadeUsu().getCodCid());
	comandoSql.setDate(6, new java.sql.Date(usuario.getData().getTime()));
	comandoSql.setString(7,usuario.getCpf());
	comandoSql.execute();
	Conexao.getInstance() .commit();
	
	
}
	
	public void alterarUsuario(UsuarioBean usuario) throws SQLException, ClassNotFoundException{
		String sql = "UPDATE usuarios SET NomUsu=?, LogUsu=?, SenUsu=?, TipUsu=?, CidUsu=?, DatUsu=?, CpfUsu=? WHERE CodUsu = ?";
	
		PreparedStatement comandoSql = Conexao.getInstance() .prepareStatement (sql);
		comandoSql.setString(1, usuario.getNomeUsu());
		comandoSql.setString(2, usuario.getLoginUsu());
		comandoSql.setString(3, usuario.getSenha());
		comandoSql.setString(4, usuario.getTipoAcesso());
		comandoSql.setInt(5, usuario.getCidadeUsu().getCodCid());
		comandoSql.setDate(6, new java.sql.Date(usuario.getData().getTime()));
		comandoSql.setString(7,usuario.getCpf());
		comandoSql.setInt(8, usuario.getCodUsu());
		comandoSql.execute();
		Conexao.getInstance() .commit();
	
}	
	
	public void excluirUsuario(int CodUsu) throws SQLException, ClassNotFoundException{
		String sql = "DELETE FROM usuario WHERE CodUsu = ?";
		
		
		PreparedStatement comandoSql = Conexao.getInstance() .prepareStatement (sql);
		comandoSql.setInt(1, CodUsu);
		comandoSql.execute();
		Conexao.getInstance().commit();
}	
	
}		
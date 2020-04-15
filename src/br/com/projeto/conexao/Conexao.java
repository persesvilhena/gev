package br.com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	//Variável que armazena a conexão
	private static Connection conexao = null;
	private String bancoDados = "projetoinfo";
	
	public Conexao() throws ClassNotFoundException, SQLException{
		//carregar o drive de conexão
		
		
		Class.forName("com.mysql.jdbc.Driver");
			//estabele a conexão
		    //servidor, porta, bando de dados, usuario, senha
		conexao = DriverManager.getConnection
		("jdbc:mysql://localhost:3306/"+this.bancoDados,"root","369875");
		conexao.setAutoCommit(false);
		System.out.println("Conexão realizada com sucesso.");
		
	}	
	//Obtem a conexão
	public static Connection getInstance() throws ClassNotFoundException, SQLException{
		if (conexao == null){
		new Conexao();
		
	}
	return conexao;
 } 
}
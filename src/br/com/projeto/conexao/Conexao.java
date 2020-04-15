package br.com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	//Vari�vel que armazena a conex�o
	private static Connection conexao = null;
	private String bancoDados = "projetoinfo";
	
	public Conexao() throws ClassNotFoundException, SQLException{
		//carregar o drive de conex�o
		
		
		Class.forName("com.mysql.jdbc.Driver");
			//estabele a conex�o
		    //servidor, porta, bando de dados, usuario, senha
		conexao = DriverManager.getConnection
		("jdbc:mysql://localhost:3306/"+this.bancoDados,"root","369875");
		conexao.setAutoCommit(false);
		System.out.println("Conex�o realizada com sucesso.");
		
	}	
	//Obtem a conex�o
	public static Connection getInstance() throws ClassNotFoundException, SQLException{
		if (conexao == null){
		new Conexao();
		
	}
	return conexao;
 } 
}
package com.moon.DAO;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {
	
	public Connection getConnection() {
		String url = "jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_6766a389e373090";
		String user = "b85d6ad646dfbd";
		String password = "1651462d";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		}catch(Exception error) {
			throw new RuntimeException("Erro na conexão com banco de dados: "+error);
		}
	}

}

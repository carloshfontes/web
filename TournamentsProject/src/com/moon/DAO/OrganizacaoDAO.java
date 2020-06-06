package com.moon.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.moon.BEAN.OrganizacaoBean;
import com.moon.DAO.ConnectionFactory;

public class OrganizacaoDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public OrganizacaoDAO() {
		conn = new ConnectionFactory().getConnection();
	}

	
	public void cadastrarOrganizacao(OrganizacaoBean organizacaoBean) {
		System.out.println("Preguiçaaa");
		
		String sql = "INSERT INTO organizacao (nome,usuario, senha) values (?,?,?)";
		System.out.println("Preguiçaaa2");

		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, organizacaoBean.getNome());
			ps.setString(2, organizacaoBean.getUsuario());
			ps.setString(3, organizacaoBean.getSenha());
			ps.execute();
			ps.close();
			
			
		}catch (Exception error) {
			System.out.println("false: "+error);
			
		}
	}
	
	
	
}

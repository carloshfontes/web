package com.moon.DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

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
		
		String sql = "INSERT INTO organizacao (nome, usuario, senha) values (?,?,?)";


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
	
	public ArrayList<OrganizacaoBean> buscarOrganizacoes() {
		
		String sql = "SELECT * FROM organizacao";
		ArrayList<OrganizacaoBean> lista = new ArrayList<OrganizacaoBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				OrganizacaoBean organizacao = new OrganizacaoBean(rs.getString("nome"), rs.getInt("id"), rs.getString("usuario"), rs.getString("Senha"));
				lista.add(organizacao);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de organizacoes: " + e);
		}
		
		return lista;
	}
}

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
			
			st.close();
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de organizacoes: " + e);
		}
		
		return lista;
	}
	
	public OrganizacaoBean buscaoOrganizacao(String usuario, String senha) {
		String sql = "SELECT * FROM organizacao WHERE usuario='"+usuario+"' and senha='"+senha+"'";

		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if(rs.next()) {
				System.out.println("usuario: "+rs.getString("usuario"));
				System.out.println("Senha: "+rs.getString("senha"));
				OrganizacaoBean organizacaoBean = new OrganizacaoBean(rs.getString("nome"), rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"));
				return organizacaoBean;
			}
			
			st.close();
			rs.close();
		}catch (Exception error) {
			return null;
		}
		return null;
	}
}

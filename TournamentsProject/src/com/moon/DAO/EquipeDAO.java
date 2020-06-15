package com.moon.DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.EquipeBean;
import com.moon.DAO.ConnectionFactory;

import jdk.nashorn.internal.runtime.ListAdapter;

public class EquipeDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public EquipeDAO() {
		conn = new ConnectionFactory().getConnection();
	}

	
	public void cadastrarEquipe(EquipeBean equipeBean) {
		
		String sql = "INSERT INTO equipe (nome, usuario, senha) values (?,?,?)";

		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, equipeBean.getNome());
			ps.setString(2, equipeBean.getUsuario());
			ps.setString(3, equipeBean.getSenha());
			ps.execute();
			ps.close();
			
			
		}catch (Exception error) {
			System.out.println("false: "+error);
			
		}
	}
	
	public ArrayList<EquipeBean> buscarEquipes() {
		
		String sql = "SELECT * FROM equipe";
		ArrayList<EquipeBean> lista = new ArrayList<EquipeBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				EquipeBean equipe = new EquipeBean(rs.getString("nome"), rs.getInt("id"), rs.getString("usuario"), rs.getString("Senha"));
				lista.add(equipe);
			}
			
			st.close();
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de Equipes: " + e);
		}
		
		return lista;
	}
	
	public EquipeBean buscaoEquipe(String usuario, String senha) {
		String sql = "SELECT * FROM equipe WHERE usuario='"+usuario+"' and senha='"+senha+"'";

		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {

				EquipeBean equipeBean = new EquipeBean(rs.getString("nome"), rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"));
				return equipeBean;
			}
			 
			st.close();
			rs.close();
		}catch (Exception error) {
			return null;
		}
		return null;
	}
	
	public EquipeBean buscaoEquipeID(int id) {
		String sql = "SELECT * FROM equipe WHERE id="+id;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EquipeBean equipeBean = new EquipeBean(rs.getString("nome"), rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"));
				return equipeBean;	
			}
			 
			st.close();
			rs.close();
		}catch (Exception error) {
			return null;
		}
		return null;
	}
	
	public ArrayList<Integer> buscarCampeonatos(EquipeBean equipe) {
		
		ArrayList<Integer> campeonatos = new ArrayList<Integer>();
		System.out.println("equipe: "+equipe.getId());		
		String sql = "SELECT * FROM campeonato_equipe WHERE id_equipe="+equipe.getId();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				campeonatos.add(rs.getInt("id_campeonato"));
			}
			
			st.close();
			rs.close();
			System.out.println(campeonatos.size());
			return campeonatos;
		}catch (Exception error) {
			return campeonatos;
		}
	}
	
	public CampeonatoBean buscarCampeonato(int id, EquipeBean equipe) {
	
		String sql = "SELECT * FROM campeonato_equipe WHERE id_campeonato="+id+ "and id_equipe="+equipe.getId();
		CampeonatoBean campeonatoBean = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if(rs.next()) {
				campeonatoBean = new CampeonatoBean(rs.getInt("id_campeonato"));
			}
			
			st.close();
			rs.close();
			
			
			return campeonatoBean;
		}catch (Exception error) {
			return null;
		}
	}
}

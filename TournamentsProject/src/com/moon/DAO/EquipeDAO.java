package com.moon.DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.EquipeBean;
import com.moon.BO.CampeonatoBO;
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

			if(rs.next()) {
				System.out.println("usuario: "+rs.getString("usuario"));
				System.out.println("Senha: "+rs.getString("senha"));
				EquipeBean equipeBean = new EquipeBean(rs.getString("nome"), rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"));
				return equipeBean;
			}
			 
		}catch (Exception error) {
			return null;
		}
		return null;
	}
	
	public ArrayList<CampeonatoBean> buscarCampeonatos(EquipeBean equipe) {
		
		ArrayList<Integer> idCampeonatos = new ArrayList<Integer>();
				
		String sql = "SELECT * FROM campeonato_equipe WHERE id_equipe='"+equipe.getId()+"'";
		
		
		CampeonatoBO campeonatoBO = new CampeonatoBO();
		ArrayList<CampeonatoBean> campeonatos = campeonatoBO.listarCampeonatos();
		ArrayList<CampeonatoBean> resultado = new ArrayList<CampeonatoBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if(rs.next()) {
				idCampeonatos.add(rs.getInt("id_campeonato"));
			}
			
			for(int i = 0; i < idCampeonatos.size(); i++) {
				for(int j = 0; j < campeonatos.size(); j++) {
					if(idCampeonatos.get(i) == campeonatos.get(j).getId()){
						resultado.add(campeonatos.get(j));
					}
				}
			}
			
			return resultado;
		}catch (Exception error) {
			return resultado;
		}
	}
}

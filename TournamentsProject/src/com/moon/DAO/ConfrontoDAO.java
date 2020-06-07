package com.moon.DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import com.moon.BEAN.ConfrontoBean;
import com.moon.DAO.ConnectionFactory;

public class ConfrontoDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public ConfrontoDAO() {
		conn = new ConnectionFactory().getConnection();
	}

	
	public void cadastrarConfronto(ConfrontoBean confrontoBean) {
		
		String sql = "INSERT INTO confronto (numero_confronto, id_rodada, id_equipe1, id_equipe2, id_campeao, id_campeonato) values (?,?,?,?,?,?)";

		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, confrontoBean.getNumero_confronto());
			ps.setInt(2, confrontoBean.getId_rodada());
			ps.setInt(3, confrontoBean.getId_equipe1());
			ps.setInt(4, confrontoBean.getId_equipe2());
			ps.setInt(5, confrontoBean.getId_campeao());
			ps.setInt(6, confrontoBean.getId_campeonato());
			ps.execute();
			ps.close();
			
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
	}
	
	public ArrayList<ConfrontoBean> buscarConfrontos() {
		
		String sql = "SELECT * FROM confronto";
		ArrayList<ConfrontoBean> lista = new ArrayList<ConfrontoBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ConfrontoBean campeonato = new ConfrontoBean(rs.getInt("numero_confronto"), rs.getInt("id"), rs.getInt("id_rodada"), rs.getInt("id_equipe1"), rs.getInt("id_equipe2"), rs.getInt("id_campeao"), rs.getInt("id_campeonato"));
				lista.add(campeonato);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de confrontos: " + e);
		}
		
		return lista;
	}
}

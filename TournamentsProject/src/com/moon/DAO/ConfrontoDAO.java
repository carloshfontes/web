package com.moon.DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.ConfrontoBean;
import com.moon.BEAN.EquipeBean;
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
				ConfrontoBean confronto = new ConfrontoBean(rs.getInt("numero_confronto"), rs.getInt("id"), rs.getInt("id_rodada"), rs.getInt("id_equipe1"), rs.getInt("id_equipe2"), rs.getInt("id_campeao"), rs.getInt("id_campeonato"));
				lista.add(confronto);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de confrontos: " + e);
		}
		
		return lista;
	}
	
	public ArrayList<ConfrontoBean> buscaoConfrontos(CampeonatoBean campeonato) {
		
		String sql = "SELECT * FROM confornto WHERE id_campeonato='"+campeonato.getId()+"'";
		ArrayList<ConfrontoBean> lista = new ArrayList<ConfrontoBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ConfrontoBean confronto = new ConfrontoBean(rs.getInt("numero_confronto"), rs.getInt("id"), rs.getInt("id_rodada"), rs.getInt("id_equipe1"), rs.getInt("id_equipe2"), rs.getInt("id_campeao"), rs.getInt("id_campeonato"));
				lista.add(confronto);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de confrontos: " + e);
		}
		
		return lista;
	}
	
	private void adicionarEquipeConfronto(ConfrontoBean confronto, EquipeBean equipe) {
		
		String sql = "UPDATE confronto SET id_equipe2 = '"+equipe.getId()+"' WHERE id = '"+confronto.getId()+"'";

		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
	}

	public void cadastraEquipeConfronto(CampeonatoBean campeonato, EquipeBean equipe) {
		
		ArrayList<ConfrontoBean> lista = buscarConfrontos();
		ConfrontoBean confrontoVago = null;
		
		for(int i = 0; i > lista.size(); i++) {
			System.out.println("TA CHEGANDO  = " + lista.get(i).getId_equipe2());
			
			if(lista.get(i).getId_equipe2() == 0) {
				confrontoVago = lista.get(i);
			}
		}
		
		if(lista.size() == 4 && confrontoVago == null) {
			System.out.println("Campeonato Cheio");
			return;
		}
		
		if(confrontoVago == null) {
			ConfrontoBean confrontoBean = new ConfrontoBean(lista.size() + 1, 1, 1, equipe.getId(), campeonato.getId());
			cadastrarConfronto(confrontoBean);
		}else {
			adicionarEquipeConfronto(confrontoVago, equipe);
		}
	}
	
	public void passarRodada(CampeonatoBean campeonato, ConfrontoBean confronto, EquipeBean equipe) {
		
		int numeroConfronto = 0;
		ConfrontoBean confrontoVago = null;
		
		if(confronto.getNumero_confronto() == 1 || confronto.getNumero_confronto() == 2) {
			numeroConfronto = 1;
		}else {
			numeroConfronto = 2;
		}
	
		ArrayList<ConfrontoBean> confrontos = buscaoConfrontos(campeonato);
		
		for(int i = 0; i > confrontos.size(); i++) {
			if(confrontos.get(i).getNumero_confronto() == numeroConfronto && confronto.getId_rodada() == (confronto.getId_rodada() + 1)) {
				confrontoVago = confrontos.get(i);
			}
		}
		
		if(confrontoVago == null) {
			ConfrontoBean confrontoBean = new ConfrontoBean(numeroConfronto, 1, confronto.getId_rodada() + 1 , equipe.getId(), campeonato.getId());
			cadastrarConfronto(confrontoBean);
		}else {
			adicionarEquipeConfronto(confrontoVago, equipe);
		}
	}
}

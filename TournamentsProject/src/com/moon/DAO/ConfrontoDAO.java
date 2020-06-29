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
import com.moon.BO.CampeonatoBO;
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
		System.out.println("boi JOJO");
		String sql = "INSERT INTO confronto (numero_confronto, id_rodada, id_equipe1, id_equipe2, id_campeao, id_campeonato) values (?,?,?,?,?,?)";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, confrontoBean.getNumero_confronto());
			ps.setInt(2, confrontoBean.getId_rodada());
			ps.setInt(3, confrontoBean.getId_equipe1());
			
			if(confrontoBean.getId_equipe2() != 0) {
				ps.setInt(4, confrontoBean.getId_equipe2());
			}else {
				ps.setNull(4, java.sql.Types.INTEGER);
			}
			
			if(confrontoBean.getId_campeao() != 0) {
				ps.setInt(5, confrontoBean.getId_campeao());
			}else {
				ps.setNull(5, java.sql.Types.INTEGER);
			}
	
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
			st.close();
			rs.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de confrontos: " + e);
		}
		
		return lista;
	}
	
	
	public ArrayList<ConfrontoBean> buscarCf(CampeonatoBean campeonato) {
		System.out.println(campeonato);
		String sql = "SELECT * FROM confronto WHERE id_campeonato='"+campeonato.getId()+"'";
		ArrayList<ConfrontoBean> lista = new ArrayList<ConfrontoBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ConfrontoBean confronto = new ConfrontoBean(rs.getInt("numero_confronto"), rs.getInt("id"), rs.getInt("id_rodada"), rs.getInt("id_equipe1"), rs.getInt("id_equipe2"), rs.getInt("id_campeao"), rs.getInt("id_campeonato"));
				lista.add(confronto);
			}
			
			st.close();
			rs.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de confrontos: " + e);
		}
		
		return lista;
	}
	
	
	public ArrayList<ConfrontoBean> buscaoConfrontos(CampeonatoBean campeonato) {
		System.out.println(campeonato);
		String sql = "SELECT c.numero_confronto, c.id, c.id_equipe1, c.id_equipe2, c.id_campeao, c.id_campeonato, c.id_rodada, e.nome, e2.nome AS 'nome2' from confronto c, equipe e, equipe e2 where c.id_campeonato ="+campeonato.getId()+" and  e.id = c.id_equipe1 and e2.id = c.id_equipe2 group by e.nome, e2.nome";
		ArrayList<ConfrontoBean> lista = new ArrayList<ConfrontoBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
//				ConfrontoBean confronto = new ConfrontoBean(rs.getInt("numero_confronto"), rs.getInt("id"), rs.getInt("id_rodada"), rs.getInt("id_equipe1"), rs.getInt("id_equipe2"), rs.getInt("id_campeao"), rs.getInt("id_campeonato"));
				ConfrontoBean confronto = new ConfrontoBean(rs.getInt("numero_confronto"), rs.getInt("id"), rs.getInt("id_rodada"), rs.getInt("id_equipe1"), rs.getInt("id_equipe2"), rs.getInt("id_campeao"), rs.getInt("id_campeonato"), rs.getString("nome"), rs.getString("nome2"));
				lista.add(confronto);
			}
			
			st.close();
			rs.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de confrontos: " + e);
		}
		
		return lista;
	}
	
	public ConfrontoBean buscarConfrontoRodada(CampeonatoBean campeonato, int rodada, int confronto) {
		
		String sql = "SELECT * FROM confornto WHERE id_campeonato="+campeonato.getId()+" and id_rodada ="+rodada+" and numero_confronto = "+confronto;
		ConfrontoBean confrontoBean = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			confrontoBean = new ConfrontoBean(rs.getInt("numero_confronto"), rs.getInt("id"), rs.getInt("id_rodada"), rs.getInt("id_equipe1"), rs.getInt("id_equipe2"), rs.getInt("id_campeao"), rs.getInt("id_campeonato"));
			
			st.close();
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de confrontos: " + e);
		}
		
		return confrontoBean;
	}
	
	private void adicionarEquipeConfronto(ConfrontoBean confronto, EquipeBean equipe) {
		
		String sql = "UPDATE confronto SET id_equipe2 = "+equipe.getId()+" WHERE id = "+confronto.getId();

		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
	}

	public void cadastraEquipeConfronto(CampeonatoBean campeonato, EquipeBean equipe) {
		System.out.println(equipe.getId());
		ArrayList<ConfrontoBean> lista = buscarCf(campeonato);
		System.out.println(lista);
		ConfrontoBean confrontoVago = null;
		

		for(int i = 0; i < lista.size(); i++) {
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
			System.out.println(confrontoVago);
		}
	}
	
	private void adicionarCampeaoConfronto(ConfrontoBean confronto, EquipeBean equipe, CampeonatoBean campeonato) {
		
		String sql = "UPDATE confronto SET id_campeao = "+equipe.getId()+" WHERE id = "+confronto.getId();

		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
		
		if(confronto.getId_rodada() == 3) {
			CampeonatoBO campeonatoBO = new CampeonatoBO();
			
			campeonatoBO.inserirCampeao(campeonato, equipe.getNome());
		}
	}
	
	public void passarRodada(CampeonatoBean campeonato, ConfrontoBean confronto, EquipeBean equipe) {
		
		int numeroConfronto = 0;
		ConfrontoBean confrontoVago = null;
		
		adicionarCampeaoConfronto(confronto, equipe, campeonato);
		
		if(confronto.getId_rodada() == 3) {
			return;
		}
		
		if(confronto.getNumero_confronto() == 1 || confronto.getNumero_confronto() == 2) {
			numeroConfronto = 1;
		}else {
			numeroConfronto = 2;
		}
	
		ArrayList<ConfrontoBean> confrontos = buscarCf(campeonato);
		
		for(int i = 0; i < confrontos.size(); i++) {
			if(confrontos.get(i).getNumero_confronto() == numeroConfronto && confrontos.get(i).getId_rodada() == (confronto.getId_rodada() + 1)) {
				confrontoVago = confrontos.get(i);
			}
		}
		
		if(confrontoVago == null) {
			System.out.println(confronto.getId_rodada());
			ConfrontoBean confrontoBean = new ConfrontoBean(numeroConfronto, 1, confronto.getId_rodada() + 1 , equipe.getId(), campeonato.getId());
			cadastrarConfronto(confrontoBean);
		}else {
			adicionarEquipeConfronto(confrontoVago, equipe);
		}
	}
}

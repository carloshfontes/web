package com.moon.DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.EquipeBean;
import com.moon.BEAN.OrganizacaoBean;
import com.moon.BEAN.CampeonatoBean;
import com.moon.DAO.ConnectionFactory;

public class CampeonatoDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public CampeonatoDAO() {
		conn = new ConnectionFactory().getConnection();
	}

	
	public void cadastrarCampeonato(CampeonatoBean campeonatoBean) {
		
		String sql = "INSERT INTO campeonato (nome, jogo, descricao, data, max_equipes, id_organizacao, campeao) values (?,?,?,?,?,?,?)";

		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, campeonatoBean.getNome());
			ps.setString(2, campeonatoBean.getJogo());
			ps.setString(3, campeonatoBean.getDescricao());
			ps.setDate(4, (Date) campeonatoBean.getData());
			ps.setInt(5, 8);
			ps.setInt(6, campeonatoBean.getIdOrganizacao());
			ps.setString(7, campeonatoBean.getCampeao());

			ps.execute();
			ps.close();
			
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
	}
	
	public ArrayList<CampeonatoBean> buscarCampeonatos() {
		
		String sql = "SELECT * FROM campeonato";
		ArrayList<CampeonatoBean> lista = new ArrayList<CampeonatoBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				CampeonatoBean campeonato = new CampeonatoBean(rs.getString("nome"), rs.getInt("id"), rs.getString("jogo"), rs.getString("descricao"), rs.getDate("data"), rs.getInt("max_equipes"), rs.getString("campeao"));
				lista.add(campeonato);
			}
			
			st.close();
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de campeonatos: " + e);
		}
		
		return lista;
	}
	
	public void adicionarEquipe(EquipeBean equipe, CampeonatoBean campeonato) {
		
		ConfrontoDAO confrontoDAO = new ConfrontoDAO();	
		String sql = "INSERT INTO campeonato_equipe (id_equipe, id_campeonato) values (?,?)";

		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, equipe.getId());
			ps.setInt(2, campeonato.getId());

			ps.execute();
			ps.close();
			
			confrontoDAO.cadastraEquipeConfronto(campeonato, equipe);
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
	}

	public CampeonatoBean buscaoCampeonatos(int id) {
        String sql = "SELECT * FROM campeonato WHERE id="+id;


        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            if(rs.next()) {
            	return new CampeonatoBean(rs.getString("nome"), rs.getInt("id"), rs.getString("jogo"), rs.getString("descricao"), rs.getDate("data"), rs.getInt("max_equipes"), rs.getString("campeao"));
            }

            st.close();
			rs.close();
        }catch (Exception error) {
            return null;
        }
        return null;
    }
	
	public ArrayList<CampeonatoBean> buscarCampeonatoOrganizacao(OrganizacaoBean organizacaoBean) {
		
		String sql = "SELECT * FROM campeonato WHERE id_organizacao="+organizacaoBean.getId();
		ArrayList<CampeonatoBean> lista = new ArrayList<CampeonatoBean>();
		
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()) {
            	CampeonatoBean campeonatoBean = new CampeonatoBean(rs.getString("nome"), rs.getInt("id"), rs.getString("jogo"), rs.getString("descricao"), rs.getDate("data"), rs.getInt("max_equipes"), rs.getString("campeao"));
            	lista.add(campeonatoBean);
            }

            st.close();
			rs.close();
			
			return lista;
        }catch (Exception error) {
            return null;
        }
	}
	
	public void inserirCampeao(CampeonatoBean campeonato, String campeao) {
		System.out.println("nome: "+campeao);
		String sql = "UPDATE campeonato SET campeao = '" + campeao + "' WHERE id = " + campeonato.getId();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
	}
}

package com.moon.DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import com.moon.BEAN.RodadaBean;
import com.moon.DAO.ConnectionFactory;

public class RodadaDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public RodadaDAO() {
		conn = new ConnectionFactory().getConnection();
	}

	
	public void cadastrarRodada(RodadaBean rodadaBean) {
		
		String sql = "INSERT INTO rodada (numero, data) values (?,?)";

		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rodadaBean.getNumero());
			ps.setDate(2, (Date) rodadaBean.getData());
			ps.execute();
			ps.close();
			
			
		}catch (Exception error) {
			System.out.println("false: "+error);
		}
	}
	
	public ArrayList<RodadaBean> buscarRodadas() {
		
		String sql = "SELECT * FROM rodada";
		ArrayList<RodadaBean> lista = new ArrayList<RodadaBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				RodadaBean rodada = new RodadaBean(rs.getInt("numero"), rs.getInt("id"), rs.getDate("data"));
				lista.add(rodada);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na busca de rodadas: " + e);
		}
		
		return lista;
	}
}

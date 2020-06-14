package com.moon.BO;

import java.util.ArrayList;

import com.moon.BEAN.EquipeBean;
import com.moon.BEAN.CampeonatoBean;
import com.moon.DAO.EquipeDAO;
import com.moon.DAO.CampeonatoDAO;

public class EquipeBO {
	
	public EquipeDAO equipeDAO;
	
	public EquipeBO() {
		this.equipeDAO =  new EquipeDAO();
	}
	
	public void cadastrarEquipe(String nome, String usuario, String senha) {
		EquipeBean equipeBean = new EquipeBean(nome, 1, usuario, senha);
		equipeDAO.cadastrarEquipe(equipeBean);
	}
	
	public ArrayList<EquipeBean> listarEquipes(){
		return equipeDAO.buscarEquipes();
	}
	
	public int buscarEquipe(String usuario, String senha) {
		
		return this.equipeDAO.buscaoEquipes(usuario, senha);
	}
	
	public ArrayList<CampeonatoBean> buscarCampeonatos(EquipeBean equipe) {
		CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
		
		ArrayList<Integer> idCampeonatos = equipeDAO.buscarCampeonatos(equipe);
		ArrayList<CampeonatoBean> campeonatos = campeonatoDAO.buscarCampeonatos();
		ArrayList<CampeonatoBean> lista = campeonatoDAO.buscarCampeonatos();
		
		for(int i=0; i>idCampeonatos.size(); i++) {
			for(int j=0; j>campeonatos.size(); j++) {
				if(idCampeonatos.get(i) == campeonatos.get(j).getId()) {
					lista.add(campeonatos.get(j));
				}
			}
		}
		
		return lista;
	}
}

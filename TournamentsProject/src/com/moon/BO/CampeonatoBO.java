package com.moon.BO;

import java.util.ArrayList;
import java.util.Date;

import com.moon.BEAN.CampeonatoBean;
import com.moon.DAO.CampeonatoDAO;

public class CampeonatoBO {
	
	public CampeonatoDAO campeonatoDAO;
	
	public CampeonatoBO() {
		this.campeonatoDAO =  new CampeonatoDAO();
	}
	
	public void cadastrarCampeonato(String nome, String jogo, String descricao, Date data, int max_equipes, int idOrganizacao) {
		CampeonatoBean campeonatoBean = new CampeonatoBean(nome, 1, jogo, descricao, data, max_equipes, idOrganizacao);
		campeonatoDAO.cadastrarCampeonato(campeonatoBean);
	}
	
	public ArrayList<CampeonatoBean> listarCampeonatos(){
		return campeonatoDAO.buscarCampeonatos();
	}
	public CampeonatoBean buscarCampeonato(int id) {
        return this.campeonatoDAO.buscaoCampeonatos(id);
    }
	
}

package com.moon.BO;

import java.util.ArrayList;
import java.util.Date;

import com.moon.DAO.CampeonatoDAO;
import com.moon.BEAN.EquipeBean;
import com.moon.BEAN.OrganizacaoBean;
import com.moon.BEAN.CampeonatoBean;

public class CampeonatoBO {
	
	public CampeonatoDAO campeonatoDAO;
	
	public CampeonatoBO() {
		this.campeonatoDAO =  new CampeonatoDAO();
	}
	
	public void cadastrarCampeonato(String nome, String jogo, String descricao, Date data, int max_equipes, int idOrganizacao) {
		CampeonatoBean campeonatoBean = new CampeonatoBean(nome, 1, jogo, descricao, data, max_equipes, idOrganizacao, null);
		campeonatoDAO.cadastrarCampeonato(campeonatoBean);
	}
	
	public ArrayList<CampeonatoBean> listarCampeonatos(){
		return campeonatoDAO.buscarCampeonatos();
	}
	
	public void adicionarEquipe(EquipeBean equipe, CampeonatoBean campeonato) {
		campeonatoDAO.adicionarEquipe(equipe, campeonato);
	}

	public CampeonatoBean buscarCampeonato(int id) {
        return this.campeonatoDAO.buscaoCampeonatos(id);
    }
	
	public ArrayList<CampeonatoBean> buscarCampeonatoOrganizacao(OrganizacaoBean organizacaoBean) {
		return this.campeonatoDAO.buscarCampeonatoOrganizacao(organizacaoBean);
	}
	
	public void inserirCampeao(CampeonatoBean campeonato, String campeao) {
		this.campeonatoDAO.inserirCampeao(campeonato, campeao);
	}
}

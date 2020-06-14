package com.moon.BO;

import java.util.ArrayList;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.ConfrontoBean;
import com.moon.BEAN.EquipeBean;
import com.moon.DAO.ConfrontoDAO;

public class ConfrontoBO {
	
	public ConfrontoDAO confrontoDAO;
	
	public ConfrontoBO() {
		this.confrontoDAO =  new ConfrontoDAO();
	}
	
	public void cadastrarConfronto(int numero_confronto, int id_rodada, int id_equipe1, int id_equipe2, int id_campeao, int id_campeonato) {
		ConfrontoBean confrontoBean = new ConfrontoBean(numero_confronto, 1, id_rodada, id_equipe1, id_equipe2, id_campeao, id_campeonato);
		confrontoDAO.cadastrarConfronto(confrontoBean);
	}
	
	public ArrayList<ConfrontoBean> listarConfrontos(){
		return confrontoDAO.buscarConfrontos();
	}

	public void cadastraEquipeConfronto(CampeonatoBean campeonato, EquipeBean equipe) {
		confrontoDAO.cadastraEquipeConfronto(campeonato, equipe);
	}
	
	public void passarRodada(CampeonatoBean campeonato, ConfrontoBean confronto, EquipeBean equipe) {
		confrontoDAO.passarRodada(campeonato, confronto, equipe);
	}
	
	public ConfrontoBean buscarConfrontoRodada(CampeonatoBean campeonato, int rodada, int confronto) {
		return confrontoDAO.buscarConfrontoRodada(campeonato, rodada, confronto);
	}
}

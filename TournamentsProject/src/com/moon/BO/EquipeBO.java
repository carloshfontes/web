package com.moon.BO;

import java.util.ArrayList;

import com.moon.BEAN.EquipeBean;
import com.moon.DAO.EquipeDAO;

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

}

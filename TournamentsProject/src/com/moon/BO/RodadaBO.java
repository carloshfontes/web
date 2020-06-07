package com.moon.BO;

import java.util.ArrayList;
import java.util.Date;

import com.moon.BEAN.RodadaBean;
import com.moon.DAO.RodadaDAO;

public class RodadaBO {
	
	public RodadaDAO rodadaDAO;
	
	public RodadaBO() {
		this.rodadaDAO =  new RodadaDAO();
	}
	
	public void cadastrarRodada(int numero, Date data) {
		RodadaBean rodadaBean = new RodadaBean(numero, 1, data);
		rodadaDAO.cadastrarRodada(rodadaBean);
	}
	
	public ArrayList<RodadaBean> listarRodadas(){
		return rodadaDAO.buscarRodadas();
	}

}

package com.moon.BO;

import java.util.ArrayList;

import com.moon.BEAN.OrganizacaoBean;
import com.moon.DAO.OrganizacaoDAO;

public class OrganizacaoBO {
	
	public OrganizacaoDAO organizacaoDAO;
	
	public OrganizacaoBO() {
		this.organizacaoDAO =  new OrganizacaoDAO();
	}
	
	public void cadastrarOrganizacao(String nome, String usuario, String senha) {
		OrganizacaoBean organizacaoBean = new OrganizacaoBean(nome, 1, usuario, senha);
		organizacaoDAO.cadastrarOrganizacao(organizacaoBean);
	}
	
	public ArrayList<OrganizacaoBean> listarOrganizacoes(){
		return organizacaoDAO.buscarOrganizacoes();
	}

	public OrganizacaoBean buscarOrganiacao(String usuario, String senha) {
		
		return this.organizacaoDAO.buscaoOrganizacao(usuario, senha);
	}
}

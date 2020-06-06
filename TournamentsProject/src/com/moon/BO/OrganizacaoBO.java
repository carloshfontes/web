package com.moon.BO;

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

}

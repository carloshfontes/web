package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.BO.EquipeBO;
import com.moon.BO.OrganizacaoBO;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastroServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String tipo = request.getParameter("tipo");
		String redirect = "cadastrar.jsp";
		
		
		switch (tipo) {
		case "Organizacao":
			OrganizacaoBO organizacaoBO = new OrganizacaoBO();
			organizacaoBO.cadastrarOrganizacao(nome, usuario, senha);
			redirect = "login.jsp";
			break;
			
		case "Equipe":
			EquipeBO equipeBO = new EquipeBO();
			equipeBO.cadastrarEquipe(nome, usuario, senha);
			redirect = "login.jsp";
			break;

		default:
			break;
		}


	
		request.getRequestDispatcher(redirect).forward(request, response);
	}

}

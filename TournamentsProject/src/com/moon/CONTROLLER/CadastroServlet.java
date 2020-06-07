package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		switch (tipo) {
		case "Organizacao":
			OrganizacaoBO organizacaoBO = new OrganizacaoBO();
			organizacaoBO.cadastrarOrganizacao(nome, usuario, senha);
			break;
			
		case "Equipe":
			System.out.println("equipe");
			break;

		default:
			break;
		}


	
//		request.getRequestDispatcher("cadastrarCarro.htm").forward(request, response);
	}

}

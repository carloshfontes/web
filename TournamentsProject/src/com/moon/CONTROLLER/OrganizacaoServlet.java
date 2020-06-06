package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.BO.OrganizacaoBO;

@WebServlet("/OrganizacaoServlet")
public class OrganizacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrganizacaoServlet() {
        super();
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		OrganizacaoBO organizacaoBO = new OrganizacaoBO();
		organizacaoBO.cadastrarOrganizacao(nome, usuario, senha);
		
		request.getRequestDispatcher("cadastrarCarro.htm").forward(request, response);
	}

}

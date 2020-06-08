package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moon.BO.OrganizacaoBO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String tipo = request.getParameter("tipo");

		switch (tipo) {
		case "Organizacao":
			OrganizacaoBO organizacaoBO = new OrganizacaoBO();
			int resultadoBusca = organizacaoBO.buscarOrganiacao(usuario, senha);
			System.out.println(resultadoBusca);
			if( resultadoBusca != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("organizacao", resultadoBusca);
				System.out.println("aqqq");

			}
			break;
			
		case "Equipe":
			System.out.println("equipe");
			break;

		default:
			break;
		}
		
		request.getRequestDispatcher("dashboardOrganizacao.jsp").forward(request, response);
	}

}

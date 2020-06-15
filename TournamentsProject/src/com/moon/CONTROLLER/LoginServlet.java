package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moon.BEAN.EquipeBean;
import com.moon.BEAN.OrganizacaoBean;
import com.moon.BO.EquipeBO;
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
		String redirect = "index.jsp";

		switch (tipo) {
		case "Organizacao":
			OrganizacaoBO organizacaoBO = new OrganizacaoBO();
			OrganizacaoBean resultadoBusca = organizacaoBO.buscarOrganiacao(usuario, senha);
			if( resultadoBusca != null) {
				HttpSession session = request.getSession();
				session.setAttribute("organizacao", resultadoBusca);
				redirect = "dashboardOrganizacao.jsp";
			}
			break;
			
		case "Equipe":
			System.out.println("aq");
			EquipeBO equipeBO = new EquipeBO();
			EquipeBean equipeBean = equipeBO.buscarEquipe(usuario, senha);
			if (equipeBean != null) {
				HttpSession session = request.getSession();
				session.setAttribute("equipe", equipeBean);
				redirect = "equipe.jsp";
			}
			break;

		default:
			break;
		}
		
		request.getRequestDispatcher(redirect).forward(request, response);
	}

}

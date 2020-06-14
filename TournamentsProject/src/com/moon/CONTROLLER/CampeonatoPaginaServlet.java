package com.moon.CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.ConfrontoBean;
import com.moon.BO.CampeonatoBO;
import com.moon.BO.ConfrontoBO;

@WebServlet("/CampeonatoPaginaServlet")
public class CampeonatoPaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CampeonatoPaginaServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCampeonato = Integer.parseInt(request.getParameter("id"));
		CampeonatoBO campeonatoBO = new CampeonatoBO();
		String redirect = "index.jsp";

		CampeonatoBean campeonatoBean = campeonatoBO.buscarCampeonato(idCampeonato);
		if (campeonatoBean != null) {
			redirect = "campeonato.jsp";
			request.setAttribute("campeonato", campeonatoBean);
			ConfrontoBO confrontoBO = new ConfrontoBO();			

			request.setAttribute("confrontos", confrontoBO.buscarConfrontos(campeonatoBean));
			
			
		}

		request.getRequestDispatcher(redirect).forward(request, response);
	}

}

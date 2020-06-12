package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BO.CampeonatoBO;

@WebServlet("/CampeonatoPaginaServlet")
public class CampeonatoPaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CampeonatoPaginaServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCampeonato = Integer.parseInt(request.getParameter("id"));
		CampeonatoBO campeonatoBO = new CampeonatoBO();
		CampeonatoBean campeonatoBean = campeonatoBO.buscarCampeonato(idCampeonato);
//		System.out.println(request.getParameter("id"));
	}

}

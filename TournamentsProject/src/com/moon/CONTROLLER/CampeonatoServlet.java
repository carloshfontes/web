package com.moon.CONTROLLER;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.BO.CampeonatoBO;


@WebServlet("/CampeonatoServlet")
public class CampeonatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CampeonatoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String jogo = request.getParameter("jogo");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		int idOrganizacao = Integer.parseInt(request.getParameter("organizacao"));

		String descricao = "Campeonato de "+jogo;
		Date date = new Date(0);
		
		CampeonatoBO campeonatoBO = new CampeonatoBO();
		campeonatoBO.cadastrarCampeonato(nome, jogo, descricao, date, quantidade,idOrganizacao);
		response.sendRedirect("dashboardOrganizacao.jsp");

	}

}

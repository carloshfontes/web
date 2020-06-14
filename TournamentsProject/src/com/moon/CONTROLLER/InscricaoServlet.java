package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.EquipeBean;
import com.moon.BO.CampeonatoBO;

@WebServlet("/InscricaoServlet")
public class InscricaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InscricaoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("campeonato"));
		int idCampeonato = Integer.parseInt(request.getParameter("campeonato"));
		int idEquipe = Integer.parseInt(request.getParameter("equipe"));
		
		System.out.println("c: "+idCampeonato+" e: "+idEquipe);
		CampeonatoBean campeonatoBean = new CampeonatoBean(idCampeonato);
		EquipeBean equipeBean = new EquipeBean(idEquipe);
		
		CampeonatoBO campeonatoBO = new CampeonatoBO();
		campeonatoBO.adicionarEquipe(equipeBean, campeonatoBean);
		
	}
	
}



package com.moon.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.BEAN.CampeonatoBean;
import com.moon.BEAN.ConfrontoBean;
import com.moon.BEAN.EquipeBean;
import com.moon.BO.ConfrontoBO;

@WebServlet("/PassarRodadaServlet")
public class PassarRodadaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PassarRodadaServlet() {
        super();
    }
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCampeao = Integer.parseInt(req.getParameter("campeao"));
		int idRodada = Integer.parseInt(req.getParameter("rodada"));
		int idConfronto = Integer.parseInt(req.getParameter("confronto"));
		int idCampeonato = Integer.parseInt(req.getParameter("campeonato"));
		int numConfronto = Integer.parseInt(req.getParameter("numConfronto"));
		String nome = req.getParameter("nomeEquipe");

		
		CampeonatoBean campeonatoBean = new CampeonatoBean(idCampeonato);
		ConfrontoBean confrontoBean = new ConfrontoBean(idConfronto, idRodada, numConfronto);
		EquipeBean equipeBean = new EquipeBean(idCampeao, nome);
		
		ConfrontoBO confrontoBO = new ConfrontoBO();
		confrontoBO.passarRodada(campeonatoBean, confrontoBean, equipeBean);
		
		resp.sendRedirect("http://localhost:8080/TournamentsProject/CampeonatoPaginaServlet?id="+idCampeonato);
		
	}


}

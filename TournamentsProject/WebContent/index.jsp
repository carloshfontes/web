<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BO.CampeonatoBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.moon.BEAN.EquipeBean"%>
<%@ page import="com.moon.BEAN.OrganizacaoBean"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Moon</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">


<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">
</head>

<body class="bg">

	<%
CampeonatoBO campeonatoBO = new CampeonatoBO();
ArrayList<CampeonatoBean> campeonatos = new ArrayList<CampeonatoBean>();
campeonatos = campeonatoBO.listarCampeonatos();

HttpSession s = request.getSession();
EquipeBean equipe = (EquipeBean) s.getAttribute("equipe");



%>

	<nav class="navbar">
		<a class="navbar-brand navbar-nav mr-auto" href="/"> <img
			src="<c:url value="/resources/imagens/08.png"/>" width="150"
			class="d-inline-block align-top">
		</a>

		<div class="navbar-nav">
			<% if (equipe != null ) {%>
				
				<p class="text-light"><%=equipe.getNome() %></p> 
			<% } else { %>
				<a href="login.jsp"><button type="button"
					class="btn cor1 text-light mr-2" style="border-radius: 20px;">Entrar</button></a>
			<% } %>
		</div>

	</nav>



	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="row">
					<% for(int i = 0; i < campeonatos.size(); i++) { %>
					<div class="col-12 col-md-4 mb-3">
						<a href="/TournamentsProject/CampeonatoPaginaServlet?id=<%=campeonatos.get(i).getId()%>">
							<div class="card card-body cor3">
								<div class="row mt-2">
									<div class="col-12">
										<h3 class="text-light"><%=campeonatos.get(i).getNome()%></h3>
									</div>
								</div>

								<div class="row mt-2">
									<div class="col-12">
										<h3 class="text-light"><%=campeonatos.get(i).getJogo()%></h3>
									</div>
								</div>

								<div class="row mt-2">
									<div class="col-12">
										<h3 class="text-light"><%=campeonatos.get(i).getMax_equipes()%></h3>
									</div>
								</div>

							</div>
						</a>
					</div>
					<% } %>
				</div> 
			</div>
		</div>
	</div>



</body>

</html>
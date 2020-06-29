<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BEAN.OrganizacaoBean"%>
<%@ page import="com.moon.BO.EquipeBO"%>
<%@ page import="com.moon.BEAN.EquipeBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Painel Equipe</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	
<script src="https://kit.fontawesome.com/7af8d015de.js"></script>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">

</head>
<body>

	<%
		HttpSession s = request.getSession();
	EquipeBean equipe = (EquipeBean) s.getAttribute("equipe");
	EquipeBO equipeBO = new EquipeBO();
	ArrayList<CampeonatoBean> campeonatos = equipeBO.buscarCampeonatos(equipe);
	
	%>
	
<div class="container">
		<div class="row">
			<div class="col-12">
				<nav class="mb-1 navbar navbar-expand-lg navbar-dark default-color">
					<a class="navbar-brand navbar-nav mr-auto" href="/TournamentsProject"> <img
						src="<c:url value="/resources/imagens/08.png"/>" width="150"
						class="d-inline-block align-top">
					</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent-333"
						aria-controls="navbarSupportedContent-333" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent-4">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="#">
									<i class="fab fa-facebook-f"></i> Facebook <span
									class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link text-light" href="#"> <i
									class="fab fa-instagram"></i> Instagram 
							</a></li>

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle text-light" id="navbarDropdownMenuLink-4"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="fas fa-user"></i> <%=equipe.getNome()%>
							</a>
								<div class="dropdown-menu dropdown-menu-right dropdown-info"
									aria-labelledby="navbarDropdownMenuLink-4">
									 <a
										class="dropdown-item" href="/TournamentsProject/Logout">Sair</a>
								</div>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</div>
	
	

<%-- 	<div class="container">

		<% for(int i = 0; i < campeonatos.size(); i++) { %>
		<div class="row mt-3">
			<div class="col-12 text-center">
				<div class="card bg-white rounded p-3">
					<a href="http://localhost:8080/TournamentsProject/CampeonatoPaginaServlet?id=<%=campeonatos.get(i).getId()%>"><h6><%=campeonatos.get(i).getNome() %></h6></a>
				</div>
			</div>
		</div>
		<% } %>
	</div> --%>
	
	<div class="container mt-5">

		
		<div class="row mt-3">
		<% for(int i = 0; i < campeonatos.size(); i++) { %>
			<div class="col-4 text-center mb-4">
			<%
								switch(campeonatos.get(i).getJogo()){
								
								case "Valorant":
									%>
									<img class="card-img-top" src="<c:url value="/resources/imagens/Valorant.jpg"/>" alt="Card image cap">
									<%
									break;
									
								case "Counter-Strike":
									%>
									<img class="card-img-top" src="<c:url value="/resources/imagens/Counter-Strike.jpg"/>" alt="Card image cap">
									<%
									break;
									
								case "Fifa":
									%>
									<img class="card-img-top" src="<c:url value="/resources/imagens/Fifa.jpg"/>" alt="Card image cap">
									<%
									break;
								case "Fortnite":
									%>
									<img class="card-img-top" src="<c:url value="/resources/imagens/Fortnite.jpg"/>" alt="Card image cap">
									<%
									break;
								case "League of Legends":
									%>
									<img class="card-img-top" src="<c:url value="/resources/imagens/League of Legends.jpg"/>" alt="Card image cap">
									<%
									break;
								}
							%>
				<div class="card cor3 rounded p-3">
					<a
						href="http://localhost:8080/TournamentsProject/CampeonatoPaginaServlet?id=<%=campeonatos.get(i).getId()%>"><h6 class="text-light text-uppercase"><%=campeonatos.get(i).getNome()%></h6></a>
				</div>
			</div>
		<% } %>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
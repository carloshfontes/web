<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="paginaDeErro.jsp" %>
	

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BO.CampeonatoBO"%>
<%@ page import="com.moon.BO.EquipeBO"%>
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

<script src="https://kit.fontawesome.com/7af8d015de.js"></script>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">

</head>

<body class="bg">
	<%
		HttpSession s = request.getSession();
	EquipeBean equipe = (EquipeBean) s.getAttribute("equipe");
	OrganizacaoBean organizacao = (OrganizacaoBean) s.getAttribute("organizacao");
	
	CampeonatoBean campeonatoBean = (CampeonatoBean) request.getAttribute("campeonato");
	EquipeBO equipeBO = new EquipeBO();
	
		
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

							<%
								if (equipe == null && organizacao == null) {
							%>
							<li><a href="login.jsp"><button type="button"
										class="btn cor1 text-light mr-2" style="border-radius: 20px;">Entrar</button></a>
							</li>

							<%
								} else if (equipe != null) {
							%>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle text-light" id="navbarDropdownMenuLink-4"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="fas fa-user"></i> <%=equipe.getNome()%>
							</a>
								<div class="dropdown-menu dropdown-menu-right dropdown-info"
									aria-labelledby="navbarDropdownMenuLink-4">
									<a class="dropdown-item" href="/TournamentsProject/equipe.jsp">Minha conta</a> <a
										class="dropdown-item" href="/TournamentsProject/Logout">Sair</a>
								</div></li>
							<%
								} else if (organizacao != null) {
							%>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle text-light" id="navbarDropdownMenuLink-4"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="fas fa-user"></i> <%=organizacao.getNome()%>
							</a>
								<div class="dropdown-menu dropdown-menu-right dropdown-info"
									aria-labelledby="navbarDropdownMenuLink-4">
									<a class="dropdown-item" href="/TournamentsProject/dashboardOrganizacao.jsp">Minha conta</a> <a
										class="dropdown-item" href="/TournamentsProject/Logout">Sair</a>
								</div></li>
							<%
								}
							%>

						</ul>
					</div>
				</nav>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="card cor3 p-3">
					<div class="row">
						<div class="col-8">
							<h1 class="text-light"><%=campeonatoBean.getNome()%></h1>
						</div>

						<%
							if (equipe != null) {
						%>
						<div class="col-4">
							<form method="POST" action="InscricaoServlet">
								<div class="form-row d-none">
									<div class="col-12">
										<input type="text" class="form-control"
											value="<%=campeonatoBean.getId()%>" name="campeonato"
											id="campeonato">
									</div>
								</div>

								<div class="form-row d-none">
									<div class="col-12">
										<input type="text" class="form-control"
											value="<%=equipe.getId()%>" name="equipe" id="equipe">
									</div>
								</div>
								
								
								<div class="form-row">
									<div class="col-12 text-right">
										<button type="submit" class="btn btn-primary">Me
											inscrever</button>
									</div>
								</div>
								
							</form>

						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-2">
				<div class="card bg-light p-2 mt-5 text-left">
					<h3>Rodada 1</h3>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<c:forEach var="confronto" items="${confrontos}">
				<c:if test="${confronto.getId_rodada() == 1}">
					<div class="col-3">
						<div class="card rounded p-3 bg-light">
							<div class="row">
								<div class="col-12">
									${confronto.getEquipe1()}
								</div>
							</div>

							<div class="row">
								<div class="col-12">
								${confronto.getEquipe2()}
								</div>
							</div>
					
						<% if (organizacao != null) { %>
							<div class="row">
								<div class="col-6">
									<a
										href="/TournamentsProject/PassarRodadaServlet?rodada=${confronto.getId_rodada()}&confronto=${confronto.getId()}&campeao=${confronto.getId_equipe1()}&campeonato=<%=campeonatoBean.getId()%>&numConfronto=${confronto.getNumero_confronto()}"><button
											class="btn btn-primary btn-sm">${confronto.getEquipe1()}</button></a>
								</div>

								<div class="col-6">
									<a
										href="/TournamentsProject/PassarRodadaServlet?rodada=${confronto.getId_rodada()}&confronto=${confronto.getId()}&campeao=${confronto.getId_equipe1()}&campeonato=<%=campeonatoBean.getId()%>&numConfronto=${confronto.getNumero_confronto()}"><button
											class="btn btn-primary btn-sm">${confronto.getEquipe2()}</button></a>
								</div>
							</div>
						<% } %>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-2">
				<div class="card bg-light p-2 mt-5 text-left">
					<h3>Rodada 2</h3>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<c:forEach var="confronto" items="${confrontos}">
				<c:if test="${confronto.getId_rodada() == 2}">
					<div class="col-3">
						<div class="card rounded p-3 bg-light">
							<div class="row">
								<div class="col-12">
									${confronto.getEquipe1()}
								</div>
							</div>

							<div class="row">
								<div class="col-12">
								${confronto.getEquipe2()}
								</div>
							</div>

						<% if (organizacao != null) { %>
							<div class="row">
								<div class="col-6">
									<a
										href="/TournamentsProject/PassarRodadaServlet?rodada=${confronto.getId_rodada()}&confronto=${confronto.getId()}&campeao=${confronto.getId_equipe1()}&campeonato=<%=campeonatoBean.getId()%>&numConfronto=${confronto.getNumero_confronto()}"><button
											class="btn btn-primary btn-sm">${confronto.getEquipe1()}</button></a>
								</div>

								<div class="col-6">
									<a
										href="/TournamentsProject/PassarRodadaServlet?rodada=${confronto.getId_rodada()}&confronto=${confronto.getId()}&campeao=${confronto.getId_equipe1()}&campeonato=<%=campeonatoBean.getId()%>&numConfronto=${confronto.getNumero_confronto()}"><button
											class="btn btn-primary btn-sm">${confronto.getEquipe2()}</button></a>
								</div>
							</div>
						<% } %>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-2">
				<div class="card bg-light p-2 mt-5 text-left">
					<h3>Rodada 3</h3>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<c:forEach var="confronto" items="${confrontos}">
				<c:if test="${confronto.getId_rodada() == 3}">
					<div class="col-3">
						<div class="card rounded p-3 bg-light">
							<div class="row">
								<div class="col-12">
									${confronto.getEquipe1()}
								</div>
							</div>

							<div class="row">
								<div class="col-12">
								${confronto.getEquipe2()}
								</div>
							</div>

						<% if (organizacao != null) { %>
							<div class="row">
								<div class="col-6">
									<a
										href="/TournamentsProject/PassarRodadaServlet?rodada=${confronto.getId_rodada()}&confronto=${confronto.getId()}&campeao=${confronto.getId_equipe1()}&campeonato=<%=campeonatoBean.getId()%>&numConfronto=${confronto.getNumero_confronto()}"><button
											class="btn btn-primary btn-sm">${confronto.getEquipe1()}</button></a>
								</div>

								<div class="col-6">
									<a
										href="/TournamentsProject/PassarRodadaServlet?rodada=${confronto.getId_rodada()}&confronto=${confronto.getId()}&campeao=${confronto.getId_equipe1()}&campeonato=<%=campeonatoBean.getId()%>&numConfronto=${confronto.getNumero_confronto()}"><button
											class="btn btn-primary btn-sm">${confronto.getEquipe2()}</button></a>
								</div>
							</div>
						<% } %>

						</div>
					</div>
				</c:if>
			</c:forEach>
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
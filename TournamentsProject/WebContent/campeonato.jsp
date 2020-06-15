<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BO.CampeonatoBO"%>
<%@ page import="com.moon.BO.EquipeBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.moon.BEAN.EquipeBean"%>


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

	CampeonatoBean campeonatoBean = (CampeonatoBean) request.getAttribute("campeonato");
	%>

	<nav class="navbar">
		<a class="navbar-brand navbar-nav mr-auto" href="#"> <img
			src="<c:url value="/resources/imagens/08.png"/>" width="150"
			class="d-inline-block align-top">
		</a>

		<div class="navbar-nav">
			<a href="login.jsp"><button type="button"
					class="btn cor1 text-light mr-2" style="border-radius: 20px;">Entrar</button></a>
		</div>

	</nav>

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
									<div class="col-12">
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

						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>


	<!-- <script> 

var ajax = new XMLHttpRequest();

ajax.open("GET", "http://localhost:8080/TournamentsProject/PassarRodadaServlet?rodada=101name=Henry&lastname=Ford", true);

//Envia a requisição
ajax.send();

//Cria um evento para receber o retorno.
ajax.onreadystatechange = function() {
// Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
	if (ajax.readyState == 4 && ajax.status == 200) {
		var data = ajax.responseText;
 // Retorno do Ajax
		console.log(data);
	}
}

</script> -->
</body>

</html>
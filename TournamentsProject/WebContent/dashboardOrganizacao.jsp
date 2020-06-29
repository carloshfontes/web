<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BO.CampeonatoBO"%>
<%@page import="java.util.ArrayList"%>
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
OrganizacaoBean organizacao = (OrganizacaoBean) s.getAttribute("organizacao");

CampeonatoBO campeonatoBO = new CampeonatoBO();
ArrayList<CampeonatoBean> campeonatos = new ArrayList<CampeonatoBean>();


campeonatos = campeonatoBO.buscarCampeonatoOrganizacao(organizacao);

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
								aria-expanded="false"> <i class="fas fa-user"></i> <%=organizacao.getNome()%>
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
	
	<div class="container mt-2">

		<div class="row justify-content-center">
			<div class="col-12 text-center">
				<button type="button" class="btn cor1 text-light mr-2"
					data-toggle="modal" data-target="#exampleModal"
					style="border-radius: 20px;">Adicionar campeonato</button>
			</div>
		</div>

		<div class="row mt-2">
			<div class="col-12"></div>
		</div>
	</div>


	<div class="container mt-5">

		
		<div class="row mt-3">
		<% for(int i = 0; i < campeonatos.size(); i++) { %>
			<div class="col-4 text-center mb-4">
				<img class="card-img-top" src="<c:url value="https://i.imgur.com/six4i12.jpg"/>" alt="Card image cap">
				<div class="card bg-white rounded p-3">
					<a
						href="http://localhost:8080/TournamentsProject/CampeonatoPaginaServlet?id=<%=campeonatos.get(i).getId()%>"><h6><%=campeonatos.get(i).getNome() %></h6></a>
				</div>
			</div>
		<% } %>
		</div>
	</div>




	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Adicionar
						campeonato</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="mt-3" action="CampeonatoServlet" method="POST">
						<div class="form-group">
							<label for="nome" class="">Nome do campeonato</label> <input
								type="text" class="form-control" id="nome" name="nome">
						</div>
						<div class="form-group">
							<label for="jogo" class="">Jogo</label> 
							<select class="selectpicker" id="jogo" name="jogo">
							  <option value="Counter-Strike">Counter-Strike</option>
							  <option value="Valorant">Valorant</option>
							  <option value="Fortnite">Fortnite</option>
							  <option value="League of Legends">League of Legends</option>
							  <option value="Fifa">Fifa</option>
							</select>
						</div>
						<div class="form-group">
							<label for="quantidade" class="">Quantidade de equipes</label> <input
								type="number" class="form-control" id="quantidade"
								name="quantidade">
						</div>

						<div class="form-group d-none">
							<label for="quantidade" class="">Quantidade de equipes</label> <input
								type="number" class="form-control" id="organizacao"
								name="organizacao" value="<%=organizacao.getId()%>">
						</div>

						<button type="submit"
							class="btn cor1 font-weight-bold text-uppercase"
							style="border-radius: 20px;">Cadastrar</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>

</html>
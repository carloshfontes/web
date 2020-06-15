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
	
	<nav class="navbar">
		<a class="navbar-brand navbar-nav mr-auto" href="/TournamentsProject/"> <img
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

		<% for(int i = 0; i < campeonatos.size(); i++) { %>
		<div class="row mt-3">
			<div class="col-12 text-center">
				<div class="card bg-white rounded p-3">
					<a href="http://localhost:8080/TournamentsProject/CampeonatoPaginaServlet?id=<%=campeonatos.get(i).getId()%>"><h6><%=campeonatos.get(i).getNome() %></h6></a>
				</div>
			</div>
		</div>
		<% } %>
	</div>


</body>
</html>
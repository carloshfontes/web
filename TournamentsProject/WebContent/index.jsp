<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean" %>
<%@ page import="com.moon.BO.CampeonatoBO" %>
<%@page import="java.util.ArrayList"%>

    
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
<%
CampeonatoBO campeonatoBO = new CampeonatoBO();
ArrayList<CampeonatoBean> campeonatos = new ArrayList<CampeonatoBean>();
campeonatos = campeonatoBO.listarCampeonatos();

%>


	<div class="container">
		<div class="row">
		<div class="col-12">
			<div class="row">
				 <% for(int i = 0; i < campeonatos.size(); i++) { %>
				<div class="col-12 col-md-4 mb-3">
					<div class="card card-body">
						<div class="row mt-2">
							<div class="col-12">
								<h3 class="text-dark"><%=campeonatos.get(i).getNome()%></h3>
							</div>
						</div>
						
						<div class="row mt-2">
							<div class="col-12">
								<h3 class="text-dark"><%=campeonatos.get(i).getJogo()%></h3>
							</div>
						</div>
						
						<div class="row mt-2">
							<div class="col-12">
								<h3 class="text-dark"><%=campeonatos.get(i).getMax_equipes()%></h3>
							</div>
						</div>
						
						
					</div>
				</div>
				<% } %>
			</div>
		</div>
	</div>
	</div>



</body>

</html>
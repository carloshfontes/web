<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BO.EquipeBO"%>
<%@ page import="com.moon.BEAN.EquipeBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Painel Equipe</title>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">

</head>
<body class>

	<%
		HttpSession s = request.getSession();
	EquipeBean equipe = (EquipeBean) s.getAttribute("equipe");
	EquipeBO equipeBO = new EquipeBO();
	ArrayList<CampeonatoBean> campeonatos = equipeBO.buscarCampeonatos(equipe);
	%>
	<h1><%=equipe.getNome()%></h1>

	<div class="container">
		<% for(int i = 0; i < campeonatos.size(); i++) { %>
		<div class="row">
			<div class="col-12 bg-white">
				<h6><%=campeonatos.get(i).getNome() %></h6>
			</div>
		</div>
		<% } %>
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BO.CampeonatoBO"%>
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
%>
<h1><%=equipe.getNome()%></h1>


</body>
</html>
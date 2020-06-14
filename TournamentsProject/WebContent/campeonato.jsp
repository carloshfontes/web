<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.moon.BEAN.CampeonatoBean"%>
<%@ page import="com.moon.BO.CampeonatoBO"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moon</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <script src="https://kit.fontawesome.com/7af8d015de.js"></script>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">

</head>

<body class="bg">

    <nav class="navbar">
        <a class="navbar-brand navbar-nav mr-auto" href="#">
           <img
			src="<c:url value="/resources/imagens/08.png"/>" width="150"
			class="d-inline-block align-top">
        </a>

        <div class="navbar-nav">
            <a href="login.htm"><button type="button" class="btn cor1 text-light mr-2"
                    style="border-radius: 20px;">Entrar</button></a>
        </div>

    </nav>
    
    <div class="container">
		<div class="row">
            <div class="col-12">
                <div class="card cor3 p-3">
                    <div class="row">
                        <div class="col-12">
                            <h1 class="text-light">Brasileirão de Point Blank</h1>
                        </div>
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
            <div class="col-3">
                <div class="card rounded p-3 bg-light">
                    <div class="row">
                        <div class="col-12">
                            <h6>Pain Gamimg</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <h6>INTZ eSports Club</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary btn-sm">Pontuar</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="card rounded p-3 bg-light">
                    <div class="row">
                        <div class="col-12">
                            <h6>Pain Gamimg</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <h6>INTZ eSports Club</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary btn-sm">Pontuar</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="card rounded p-3 bg-light">
                    <div class="row">
                        <div class="col-12">
                            <h6>Pain Gamimg</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <h6>INTZ eSports Club</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary btn-sm">Pontuar</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="card rounded p-3 bg-light">
                    <div class="row">
                        <div class="col-12">
                            <h6>Pain Gamimg</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <h6>INTZ eSports Club</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary btn-sm">Pontuar</button>
                        </div>
                    </div>
                </div>
            </div>
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
            <div class="col-3">
                <div class="card rounded p-3 bg-light">
                    <div class="row">
                        <div class="col-12">
                            <h6>Pain Gamimg</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <h6>INTZ eSports Club</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary btn-sm">Pontuar</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="card rounded p-3 bg-light">
                    <div class="row">
                        <div class="col-12">
                            <h6>Pain Gamimg</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <h6>INTZ eSports Club</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary btn-sm">Pontuar</button>
                        </div>
                    </div>
                </div>
            </div>
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
            <div class="col-3">
                <div class="card rounded p-3 bg-light">
                    <div class="row">
                        <div class="col-12">
                            <h6>Pain Gamimg</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <h6>INTZ eSports Club</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary btn-sm">Pontuar</button>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>

</body>

</html>
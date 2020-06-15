<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moon</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">
</head>

<body class="bg">

<%


HttpSession s = request.getSession();
int organizacao = (int) s.getAttribute("organizacao");
%>

    <nav class="navbar">
        <a class="navbar-brand navbar-nav mr-auto" href="#">
            <img src="<c:url value="/resources/imagens/08.png"/>" width="150" class="d-inline-block align-top">
        </a>

        <div class="navbar-nav">
            <p class="text-light mr-2 d-inline-block">Seja bem vindo, <span
                    class="text-uppercase font-weight-bold">NLB</span></p>
        </div>

    </nav>
    <div class="container mt-2">

        <div class="row justify-content-center">
            <div class="col-12 text-center">
                <button type="button" class="btn cor1 text-light mr-2" data-toggle="modal" data-target="#exampleModal"
                    style="border-radius: 20px;">Adicionar campeonato</button>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-12">

            </div>
        </div>
    </div>
    

    

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Adicionar campeonato</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="mt-3" action="CampeonatoServlet" method="POST">
                        <div class="form-group">
                            <label for="nome" class="">Nome do campeonato</label>
                            <input type="text" class="form-control" id="nome" name="nome">
                        </div>
                        <div class="form-group">
                            <label for="jogo" class="">Jogo</label>
                            <input type="text" class="form-control" id="jogo" name="jogo">
                        </div>
                        <div class="form-group">
                            <label for="quantidade" class="">Quantidade de equipes</label>
                            <input type="number" class="form-control" id="quantidade" name="quantidade">
                        </div>
                        
                         <div class="form-group d-none">
                            <label for="quantidade" class="">Quantidade de equipes</label>
                            <input type="number" class="form-control" id="organizacao" name="organizacao" value="<%=organizacao%>">
                        </div>

                        <button type="submit" class="btn cor1 font-weight-bold text-uppercase"
                            style="border-radius: 20px;">Cadastrar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Moon</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
    
    
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">
</head>
<body class="bg">

    <div class="vertical-center" id="conteudo">
        <div class="container" >
			<div class="row justify-content-center">
                <div class="col-12 col-md-6">
                    <div class="card cor2 rounded p-4">
                        <div class="row">
                            <div class="col-12 text-left">
                                <h1 class="text-light font-weight-bold text-uppercase">Login</h1>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12 text-left">
                                <h6 class="text-light">Para realizar o login, basta preencher os campos abaixo</h6>
                            </div>
                        </div>

                        <form class="mt-3" action="LoginServlet" method="POST">
                            <div class="form-group">
                                <label for="usuario" class="text-light">Usuário</label>
                                <input type="text" class="form-control" id="usuario" name="usuario">
                              </div>
                            <div class="form-group">
                              <label for="senha" class="text-light">Senha</label>
                              <input type="password" class="form-control" id="senha" name="senha">
                            </div>

                            <div class="form-check mb-2">
                                <input class="form-check-input opt" type="radio" name="tipo" id="organizacao" value="Organizacao" checked>
                                <label class="form-check-label" for="exampleRadios1">
                                  Organizacao
                                </label>
                              </div>

                              <div class="form-check mb-3">
                                <input class="form-check-input" type="radio" name="tipo" id="equipe" value="Equipe">
                                <label class="form-check-label" for="exampleRadios2">
                                  Equipe
                                </label>
                              </div>
                           
                            <button type="submit" class="btn cor1 font-weight-bold text-uppercase" style="border-radius: 20px;">Entrar</button>
                          </form>
                          
                          <div class="row mt-2">
                            <div class="col-12 text-left">
                                <a href="/TournamentsProject/cadastrar.jsp"><h6 class="text-light">Clique aqui para cadastrar</h6></a>
                            </div>
                        </div>
                    </div>
                </div>
			</div>
		</div>
    </div>
 
</body>
</html>
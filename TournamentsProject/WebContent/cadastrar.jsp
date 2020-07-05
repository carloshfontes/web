<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro | Moon</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">

<script src="https://kit.fontawesome.com/7af8d015de.js"
	crossorigin="anonymous"></script>
    
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/center.css"/>" rel="stylesheet">
</head>
<body class="bg">

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

						</ul>
					</div>
				</nav>
			</div>
		</div>
	</div>

        <div class="container" >
			<div class="row justify-content-center">
                <div class="col-12 col-md-6">
                    <div class="card cor2 rounded p-4">
                        <div class="row">
                            <div class="col-12 text-left">
                                <h1 class="text-light font-weight-bold text-uppercase">Cadastro</h1>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12 text-left">
                                <h6 class="text-light">Preencha todos os campos abaixo para realizar o cadastro.</h6>
                            </div>
                        </div>

                        <form class="mt-3" action="CadastroServlet" method="POST">
                            <div class="form-group">
                              <label for="nome" class="text-light">Nome</label>
                              <input type="text" class="form-control" id="nome" name="nome" pattern="(.){2,20}" maxlength="20" required >
                            </div>

                            <div class="form-group">
                                <label for="usuario" class="text-light">Usuário</label>
                                <input type="text" class="form-control" id="usuario" name="usuario" pattern="(.){2,20}" maxlength="20" required>
                              </div>
                            <div class="form-group">
                              <label for="senha" class="text-light">Senha</label>
                              <input type="password" class="form-control" id="senha" name="senha" pattern="(.){2,20}" maxlength="20" required>
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
                           
                            <button type="submit" class="btn cor1 font-weight-bold text-uppercase" style="border-radius: 20px;">Cadastrar</button>
                          </form>
                    </div>
                </div>
			</div>
		</div>
 
</body>
</html>
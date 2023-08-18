<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link>
<title>Cadastro</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">

		<h1>Seja Bem-Vindo(a)!</h1>
		<br>
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">Home</a> <a
					class="navbar-brand me-auto mb-0 mb-lg-0" href="Cadastro.jsp">Cadastrar-me</a>
				<a class="navbar-brand" href="login.jsp">Login</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</nav>
		<br>

		<form action="ServletUsuario" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Nome</label> <input
					type="text" class="form-control" name="nome" id="nome"
					aria-describedby="emailHelp">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">E-mail</label> <input
						type="text" class="form-control" name="email"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Senha</label>
					<input type="password" class="form-control" name="senha"
						id="exampleInputPassword1">
				</div>
				<button type="submit" data-bs-toggle="modal"
					data-bs-target="#errorModal" class="btn btn-primary">Cadastrar</button>
		</form>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
		<br>
		<h4>${mensagem}</h4>
		<h4>${erro2}</h4>
		<h4>${erro1}</h4>

</body>

</html>
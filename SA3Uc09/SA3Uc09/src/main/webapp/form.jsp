<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<%
		// 		String email = request.getParameter("email");
		// 		out.print(email + "<br><br>");
		String usuario = request.getParameter("usuario");
		out.print(usuario + "<br><br>");
		String senha = request.getParameter("senha");
		out.print(senha + "<br><br>");
		%>
		<a href="index.jsp">Voltar</a>
</body>
</html>
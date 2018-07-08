<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GERENCIADOR DE EMPRESAS</title>
</head>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
		<c:if test="${not empty usuarioLogado }">
			<span>
				Logado com ${usuarioLogado.email }			
			</span>
		</c:if>
	<p />
	<form action="novaEmpresa" method="POST">
		<label>Nome:</label> <input type="text" name="nome"> <input
			type="submit" value="Enviar">
	</form>
	<p />
	<form action="login" method="POST">
		<table>
			<tr><td><label>Email:</label><input type="email" name="login"></td></tr>
			<tr><td><label>Senha:</label><input type="password" name="senha"> </td></tr>
			<tr><td><input type="submit" value="Logar"></td></tr>
		</table>
	</form>
	<p />
	<form action="fazTudo" method="POST">
	<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Logout">
	</form>
</body>
</html>
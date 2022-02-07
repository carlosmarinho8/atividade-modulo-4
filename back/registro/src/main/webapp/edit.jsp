<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registro de Contatos</title>
<link rel="icon" href="imagens/phonefavicon.png">
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="Bordar">
		<h1>Editar contato</h1>
		<form name="frmContato" action="update">
			<table>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
						name="idcon" id="caixa2" readonly value="<%out.print(request.getAttribute("idcon"));%>"></td>
				</tr>
				<tr>
					<td>Nome&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
						name="nome" class="Caixa" value="<%out.print(request.getAttribute("nome"));%>"></td>
				</tr>
				<tr>
					<td>Idade &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
						name="idade" class="Caixa" value="<%out.print(request.getAttribute("idade"));%>"></td>
				</tr>
				<tr>
					<td>Gênero&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
						name="genero" class="Caixa" value="<%out.print(request.getAttribute("genero"));%>"></td>
				</tr>
				<tr>
					<td>Telefone&nbsp;&nbsp;<input type="text" name="telefone"
						class="Caixa" value="<%out.print(request.getAttribute("telefone"));%>"></td>
				</tr>
				<tr>
					<td>E-mail&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
						name="email" class="Caixa" value="<%out.print(request.getAttribute("email"));%>"></td>
				</tr>
				<tr>
					<td>CPF&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input
						type="text" name="cpf" class="Caixa" value="<%out.print(request.getAttribute("cpf"));%>"></td>
				</tr>
			</table>
			<input type="button" value="Salvar" class="Botao" 
				onclick="validar()">
		</form>
	</div>
	<script src="scripts/validador.js"></script>
</body>

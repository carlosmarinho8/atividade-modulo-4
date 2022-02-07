<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

// Teste
/*
for (int i = 0; i < lista.size(); i++) {
	out.println(lista.get(i).getIdcon());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getIdade());
	out.println(lista.get(i).getGenero());
	out.println(lista.get(i).getTelefone());
	out.println(lista.get(i).getEmail());
	out.println(lista.get(i).getCpf());
	
}
*/
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Registro</title>
<link rel="icon" href="imagens/phonefavicon.png">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

</head>
<body>
	<div id="Titulo">
		<h1>Registro</h1>
		<a href="new.html" class="Botao">Novo Contato</a>
	</div>
	<table class="table" id="tabela">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nome</th>
				<th scope="col">Idade</th>
				<th scope="col">Genero</th>
				<th scope="col">Telefone</th>
				<th scope="col">E-mail</th>
				<th scope="col">CPF</th>
				<th scope="col">Opçôes</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td scope="row"><%=lista.get(i).getIdcon()%></td>
				<td scope="row"><%=lista.get(i).getNome()%></td>
				<td scope="row"><%=lista.get(i).getIdade()%></td>
				<td scope="row"><%=lista.get(i).getGenero()%></td>
				<td scope="row"><%=lista.get(i).getTelefone()%></td>
				<td scope="row"><%=lista.get(i).getEmail()%></td>
				<td scope="row"><%=lista.get(i).getCpf()%></td>
				<td scope="row"><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="Botao">Editar</a>
				<a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>)" class="Botao2">Deletar</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
<script src="scripts/confirmador.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*, br.edu.insper.mvc.controller.*, br.edu.insper.mvc.model.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabela de Tarefas</title>
</head>
<body>


<form action="Lista">
<input type="hidden" name ="importancia" value="desc">
<input type="submit" value="ordenar por importância decrescente">
</form>
<table border="1">
<tr><td>ID</td><td>Título</td><td>Descrição</td><td>Importância</td></tr>

<c:forEach var="tarefa" items="${tarefas}">
<tr>
<td>${tarefa.id}</td>
<td>${tarefa.titulo}</td>
<td>${tarefa.descricao}</td>	
<td>${tarefa.importancia}</td>
<td>
<form action="remove" method="post">
<input type="hidden" name="id" value="${tarefa.id}">
<input type="submit" value="remover">
</form>

<form action="atualiza" method="get">
<input type="hidden" name="Titulo" value="${tarefa.titulo}">
<input type="hidden" name="Descricao" value="${tarefa.descricao}">
<input type="hidden" name="Importancia" value="${tarefa.importancia}">
<input type="hidden" name="id" value="${tarefa.id}">
<input type="submit" value="atualizar">
</form>

</tr>
</c:forEach>
</table>

<form action="http://localhost:8080/OrganizadorDeTarefas/Adicionador">
    <input type="submit" value="Adicionar Tarefa" />
</form>


</body>
</html>
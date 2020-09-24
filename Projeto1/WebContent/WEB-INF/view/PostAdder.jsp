<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, br.edu.insper.mvc.controller.*, br.edu.insper.mvc.model.*, javax.servlet.http.HttpServletResponse,java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sucesso na Adição</title>
</head>
<body>
<% try{ 
DAO dao = new DAO();

Tarefa tarefa = new Tarefa();
tarefa.setTitulo(request.getParameter("Titulo"));
tarefa.setDescricao(request.getParameter("Descricao"));
tarefa.setImportancia(Integer.parseInt(request.getParameter("Importancia")));

dao.adiciona(tarefa);%>

<body><h1>Tarefa adicionada com sucesso!</h1></body><br>

<%
dao.close();
} 
	catch (ClassNotFoundException e) {

e.printStackTrace();
} catch (SQLException e) {

e.printStackTrace();
} %>
<form action="http://localhost:8080/OrganizadorDeTarefas/Lista">
    <input type="submit" value="Ver Tarefas" />
</form>
</body>
</html>
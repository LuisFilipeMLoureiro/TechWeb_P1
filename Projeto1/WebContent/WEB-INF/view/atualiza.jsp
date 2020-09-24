<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizando</title>
</head>
<body>
<form action="atualiza" method="post">
Título: <input type='text' name='Titulo' value='${tarefa.titulo}'><br>
Descrição: <input style='width: 500px;' type='text' name='Descricao' value='${tarefa.descricao}'><br>
Importância: <input  type='number' name='Importancia' value='${tarefa.importancia}'><br>
<input type="hidden" name="id" value='${tarefa.id}'>
<input type='submit' value='atualizar'>

</form>
<form action="http://localhost:8080/OrganizadorDeTarefas/Lista">
    <input type="submit" value="Retornar às Tarefas" />
</form>

</body>
</html>
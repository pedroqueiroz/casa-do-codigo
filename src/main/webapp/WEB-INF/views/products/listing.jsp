<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8>
    <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
</head>
<body>
<h1>Lista de Produtos</h1>
<div>${successMessage}</div>
<table>
    <tr>
        <td>Título</td>
        <td>Descrição</td>
        <td>Páginas</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.title}</td>
            <td>${product.description}</td>
            <td>${product.pages}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
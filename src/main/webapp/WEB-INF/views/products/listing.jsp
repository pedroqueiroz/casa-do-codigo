<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8>
    <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
</head>
<body>
<h1>Lista de Produtos</h1>
<div>${successMessage}</div>
<div>${errorMessage}</div>
<table>
    <tr>
        <th>Título</th>
        <th>Descrição</th>
        <th>Páginas</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>
                <a href="${s:mvcUrl('PC#showDetails').arg(0, product.id).build()}">${product.title}</a>
            </td>
            <td>${product.description}</td>
            <td>${product.pages}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
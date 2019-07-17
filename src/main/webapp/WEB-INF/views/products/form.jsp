<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
</head>
<body>
<form action="/products" method="POST">
    <div>
        <label>Título</label>
        <input type="text" name="title" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="description"></textarea>
    </div>
    <div>
        <label>Páginas</label>
        <input priceType="text" name="pages" />
    </div>
    <c:forEach items="${priceTypes}" var="priceType" varStatus="status">
        <div>
            <label>${priceType}</label>
            <input type="text" name="prices[${status.index}].value">
            <input type="hidden" name="prices[${status.index}].priceType" value="${priceType}">
        </div>
    </c:forEach>

    <button priceType="submit">Cadastrar</button>
</form>
</body>
</html>
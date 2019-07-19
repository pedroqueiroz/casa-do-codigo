<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
</head>
<body>

<form:form action="${s:mvcUrl('PC#add').build()}" method="POST" modelAttribute="product">
    <div>
        <label>Título</label>
        <form:input path="title" />
        <form:errors path="title" />
    </div>
    <div>
        <label>Descrição</label>
        <form:textarea rows="10" cols="20" path="description" />
        <form:errors path="description" />
    </div>
    <div>
        <label>Páginas</label>
        <form:input path="pages" />
        <form:errors path="pages" />
    </div>
    <div>
        <label>Data de Lançamento</label>
        <form:input path="releaseDate" />
        <form:errors path="releaseDate" />
    </div>
    <c:forEach items="${priceTypes}" var="priceType" varStatus="status">
        <div>
            <label>${priceType}</label>
            <form:input path="prices[${status.index}].value" />
            <form:hidden path="prices[${status.index}].priceType" value="${priceType}" />
        </div>
    </c:forEach>

    <button priceType="submit">Cadastrar</button>
</form:form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:url value="/resources/css" var="cssPath" />

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
    <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${s:mvcUrl('HC#serveHome').build()}">
                Casa do Código
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${s:mvcUrl('PC#listProducts').build()}">
                        Lista de Produtos
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${s:mvcUrl('PC#getProductForm').build()}">
                        Cadastro de Produtos
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1>Cadastro de Produtos</h1>

    <form:form action="${s:mvcUrl('PC#add').build()}" method="POST" modelAttribute="product" enctype="multipart/form-data">
        <div class="form-group">
            <label>Título</label>
            <form:input cssClass="form-control" path="title" />
            <form:errors path="title" />
        </div>
        <div class="form-group">
            <label>Descrição</label>
            <form:textarea cssClass="form-control" path="description" />
            <form:errors path="description" />
        </div>
        <div class="form-group">
            <label>Páginas</label>
            <form:input cssClass="form-control" path="pages" />
            <form:errors path="pages" />
        </div>
        <div class="form-group">
            <label>Data de Lançamento</label>
            <form:input cssClass="form-control" path="releaseDate" />
            <form:errors path="releaseDate" />
        </div>
        <c:forEach items="${priceTypes}" var="priceType" varStatus="status">
            <div class="form-group">
                <label>${priceType}</label>
                <form:input cssClass="form-control" path="prices[${status.index}].value" />
                <form:hidden path="prices[${status.index}].priceType" value="${priceType}" />
            </div>
        </c:forEach>
        <div class="form-group">
            <label>Sumário</label>
            <input class="form-control-file" name="summary" type="file" />
        </div>

        <button class="btn btn-primary" type="submit">Cadastrar</button>
    </form:form>
</div>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

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
                <li class="nav-item active">
                    <a class="nav-link" href="${s:mvcUrl('PC#listProducts').build()}">
                        Lista de Produtos
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${s:mvcUrl('PC#getProductForm').build()}">
                        Cadastro de Produtos
                    </a>
                </li>
            </ul>
            <span class="navbar-text">
                <security:authentication property="principal" var="user" />
                Usuário: ${user.username}
            </span>
        </div>
    </div>
</nav>
<div class="container">
    <h1>Lista de Produtos</h1>

    <c:if test="${not empty successMessage}">
        <div class="alert alert-success" role="alert">${successMessage}</div>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">${errorMessage}</div>
    </c:if>

    <table class="table table-bordered table-striped table-hover">
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
</div>
</body>
</html>
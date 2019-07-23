<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="container">
    <h1>Login da Casa do Código</h1>

    <form:form servletRelativeAction="/login" method="POST">
        <div class="form-group">
            <label>E-mail</label>
            <input class="form-control" name="userName" type="text" />
        </div>
        <div class="form-group">
            <label>Senha</label>
            <input class="form-control" name="password" type="password" />
        </div>

        <button class="btn btn-primary" type="submit">Fazer login</button>
    </form:form>
</div>
</body>
</html>
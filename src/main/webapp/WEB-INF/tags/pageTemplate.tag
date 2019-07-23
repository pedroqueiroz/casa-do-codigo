<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="bodyClass" required="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="icon" href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979" type="image/ico" />
<link href="https://plus.googlecom/108540024862647200608" rel="publisher" />

<title>${title} - Casa do Código</title>

<c:url value="/" var="contextPath" />
<link href="${contextPath}resources/css/cssbase-min.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' />
<link href="${contextPath}resources/css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-ie7.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-embedded.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/layout-colors.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/responsive-style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/guia-do-programador-style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/products.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/book-collection.css" rel="stylesheet" type="text/css" media="all" />

<link rel="canonical" href="http://www.casadocodigo.com.br/" />
</head>

<body class="${bodyClass}">

<%@ include file="/WEB-INF/views/header.jsp" %>

<jsp:doBody />

<%@ include file="/WEB-INF/views/footer.jsp" %>

</body>
</html>

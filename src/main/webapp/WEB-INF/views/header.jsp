<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<header id="layout-header">
    <div class="clearfix container">
        <a href="/" id="logo"> </a>
        <div id="header-content">
            <nav id="main-nav">
                <ul class="clearfix">
                    <security:authorize access="isAuthenticated()">
                        <li>
                            <a href="${s:mvcUrl('PC#listProducts').build()}">
                                <fmt:message key="menu.product_list" />
                            </a>
                        </li>
                        <li>
                            <a href="${s:mvcUrl('PC#getProductForm').build()}">
                                <fmt:message key="menu.add_product" />
                            </a>
                        </li>
                    </security:authorize>

                    <li>
                        <a href="${s:mvcUrl('SCC#showItems').build()}" rel="nofollow">
                            <s:message code="menu.cart" arguments="${shoppingCart.quantity}" />
                        </a>
                    </li>
                    <li>
                        <a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">
                            <fmt:message key="menu.about_us" />
                        </a>
                    </li>

                    <li>
                        <a href="?locale=pt" rel="nofollow">
                            <fmt:message key="menu.pt"/>
                        </a>
                    </li>

                    <li>
                        <a href="?locale=en_US" rel="nofollow">
                            <fmt:message key="menu.en"/>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<nav class="categories-nav">
    <ul class="container">
        <li class="category">
            <a href="http://www.casadocodigo.com.br">
                <fmt:message key="navigation.category.home" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-agile">
                <fmt:message key="navigation.category.agile" />
            </a>
        </li>
        <li class="category">
            a href="/collections/livros-de-front-end">
                <fmt:message key="navigation.category.front_end" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-games">
                <fmt:message key="navigation.category.games" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-java">
                <fmt:message key="navigation.category.java" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-mobile">
                <fmt:message key="navigation.category.mobile" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-desenvolvimento-web">
                <fmt:message key="navigation.category.web" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/outros">
                <fmt:message key="navigation.category.other" />
            </a>
        </li>
    </ul>
</nav>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" var="user"/>
<nav class="container container--70">
    <sec:authorize access="!isAuthenticated()">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj ${activeUser.firstName}
                <ul class="dropdown">
                    <li><a href="/editUser">Profil</a></li>
                    <li><a href="/showDonations">Moje zbiórki</a></li>
                    <li><a href="/logout">Wyloguj</a></li>
                </ul>
            </li>
        </ul>
    </sec:authorize>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <sec:authorize access="isAuthenticated()">
            <li><a href="/addDonation" class="btn btn--without-border">Przekaż dary</a></li>
        </sec:authorize>
        <li><a href="${pageContext.request.contextPath}#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>



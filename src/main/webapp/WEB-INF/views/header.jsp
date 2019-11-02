<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 23-Oct-19
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<nav class="container container--70">
    <c:choose>
        <c:when test="${empty sessionScope.user}">
            <ul class="nav--actions">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul class="nav--actions">
                <li class="logged-user">
                    Witaj ${sessionScope.user.firstName}
                    <ul class="dropdown">
                        <li><a href="#">Profil</a></li>
                        <li><a href="#">Moje zbiórki</a></li>
                        <li><a href="/logout">Wyloguj</a></li>
                    </ul>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <c:if test="${not empty sessionScope.user}">
            <li><a href="/addDonation" class="btn btn--without-border">Przekaż dary</a></li>
        </c:if>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>



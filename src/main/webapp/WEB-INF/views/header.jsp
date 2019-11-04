<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                        <li><a href="/showDonations">Moje zbiórki</a></li>
                        <li><a href="/logout">Wyloguj</a></li>
                    </ul>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <c:if test="${not empty sessionScope.user}">
            <li><a href="/addDonation" class="btn btn--without-border">Przekaż dary</a></li>
        </c:if>
        <li><a href="${pageContext.request.contextPath}#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>



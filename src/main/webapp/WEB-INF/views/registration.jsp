<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="data" method="post">
        <div class="form-group">
            <form:input path="firstName" type="text" placeholder="Imie"/>
            <span class="error"><form:errors path="firstName"/></span>
        </div>
        <div class="form-group">
            <form:input path="lastName" type="text" placeholder="Nazwisko"/>
            <span class="error"><form:errors path="lastName"/></span>
        </div>
        <div class="form-group">
            <form:input path="email" type="email" placeholder="Email"/>
            <span class="error"><form:errors path="email"/></span>
        </div>
        <div class="form-group">
            <form:input path="password" type="password" placeholder="Hasło"/>
            <span class="error"><form:errors path="password"/></span>
        </div>
        <div class="form-group">
            <form:input path="rePassword" type="password" placeholder="Powtórz hasło"/>
            <span class="error"><form:errors path="rePassword"/></span>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
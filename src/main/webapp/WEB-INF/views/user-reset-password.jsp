<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" var="user"/>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<section class="login-page">
    <h2>Dane użytkownika</h2>
    <form:form modelAttribute="data" method="post">
        <div class="form-group form-group--inline">
            <label>Aktualne hasło:<form:input path="actualPassword" type="password"/></label>
            <span class="error"><form:errors path="actualPassword"/></span>
        </div>
        <div class="form-group form-group--inline">
            <label>Nowe hasło: <form:input path="newPassword" type="password"/></label>
            <span class="error"><form:errors path="newPassword"/></span>
        </div>
        <div class="form-group form-group--inline">
            <label>Powtórz hasło: <form:input path="reNewPassword" type="password"/></label>
            <span class="error"><form:errors path="reNewPassword"/></span>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/" class="btn btn--without-border">Powrót</a>
            <button class="btn" type="submit">Zapisz zmiany</button>
        </div>
    </form:form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
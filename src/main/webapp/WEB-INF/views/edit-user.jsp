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
        <form:hidden path="id"/>
        <div class="form-group form-group--inline">
            <label>Imie:<form:input path="firstName" type="text"/></label>
            <span class="error"><form:errors path="firstName"/></span>
        </div>
        <div class="form-group form-group--inline">
            <label>Nazwisko: <form:input path="lastName" type="text"/></label>
            <span class="error"><form:errors path="lastName"/></span>
        </div>
        <div class="form-group form-group--buttons">
            <a href="<c:url value="/editUser/resetPassword"/>" class="btn btn--without-border">Zmień hasło</a>
            <button class="btn" type="submit">Zapisz zmiany</button>
        </div>
    </form:form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
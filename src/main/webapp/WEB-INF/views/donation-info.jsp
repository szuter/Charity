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

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<section class="login-page">

    <div class="summary" style="font-size: large">
        <h2>Szczegoły daru</h2>
        <div class="form-section">
            <h4>Oddajesz:</h4>
            <ul>
                <li>
                    <span class="summary--text">Instytucja: ${data.institution.name}</span>
                </li>
                <li>
                    <span class="summary--text">Ilość worków: ${data.quantity}</span>
                </li>
                <li>
                    <span class="summary--text">Kategorie darów: <c:forEach var="item"
                                                                            items="${data.categories}">${item.name} </c:forEach> </span>
                </li>
            </ul>
        </div>

        <div class="form-section form-section--columns">
            <div class="form-section--column">
                <h4>Adres odbioru:</h4>
                <ul>
                    <li>${data.street}</li>
                    <li>${data.city}</li>
                    <li>${data.zipCode}</li>
                    <li>${data.phone}</li>
                </ul>
            </div>

            <div class="form-section--column">
                <h4>Termin odbioru:</h4>
                <ul>
                    <li>Planowany odbior: ${data.pickUpDate} ${data.pickUpTime}</li>
                    <li>Data utworzenia: ${data.created}</li>
                    <li>Status: ${data.status}</li>
                    <c:if test="${data.status.equals('Odebrano')}">
                        <li>Data odebrania: ${data.delivered}</li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
    <a href="<c:url value="/showDonations"/>" class="btn">Powrót</a>
</section>

<jsp:include page="footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
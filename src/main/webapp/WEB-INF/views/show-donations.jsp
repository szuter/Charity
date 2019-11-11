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

    <section class="login-page">
        <h2>Twoje dary</h2>
        <table class="table" style="font-size: 20px">
            <thead>
            <tr>
                <th scope="col">Utowrzono</th>
                <th scope="col">Instytucja</th>
                <th scope="col">Liczba worków</th>
                <th scope="col">Status</th>
                <th scope="col">Data odebrania</th>
                <th scope="col">Akcje</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="donation" items="${userDonations}">
                <tr>
                    <th>${donation.created}</th>
                    <th>${donation.institution.name}</th>
                    <th>${donation.quantity}</th>
                    <th>${donation.status}</th>
                    <th>
                        <c:choose>
                            <c:when test="${donation.status.equals('Nieodebrane')}">
                                <a href="/showDonations/changeStatus?id=${donation.id}" class="btn">Odebrano</a>
                            </c:when>
                            <c:otherwise>
                                ${donation.delivered}
                            </c:otherwise>
                        </c:choose>
                    </th>
                    <th>
                        <a href="/showDonations/info?id=${donation.id}" class="btn">Szczegóły</a>

                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</header>
<jsp:include page="footer.jsp"/>
</body>
</html>
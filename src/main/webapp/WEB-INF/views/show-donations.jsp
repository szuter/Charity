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
    <h2>Twoje dary</h2>
    <table>
        <c:forEach var="donation" items="${userDonations}">
            <tr class="table-row">
                <td>
                    Data utworzenia
                </td>
                <td>
                        ${donation.institution.name}
                </td>
                <td>
                        ${donation.quantity}
                </td>
                <td>
                    Action
                </td>

            </tr>
        </c:forEach>

    </table>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
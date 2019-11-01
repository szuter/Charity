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
<header class="header--form-page">
    <jsp:include page="header.jsp"/>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br/>
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form modelAttribute="data" method="post">
        <!-- STEP 1: class .active is switching steps -->
        <div data-step="1" class="active">
            <h3>Zaznacz co chcesz oddać:</h3>
            <c:forEach var="category" items="${categoryList}">
                <div class="form-group form-group--checkbox" id="category">
                    <label>
                        <form:checkbox path="categories" value="${category.id}"
                        data-name="${category.name}"/>
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
            </c:forEach>
            <span class="error"></span>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 2 -->
        <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

            <div class="form-group form-group--inline" id="quantity">
                <label>
                    Liczba 60l worków:
                    <form:input path="quantity" type="number" step="1" min="1"/>
                </label>
                <span class="error"></span>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>


        <!-- STEP 3 -->
        <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>
            <c:forEach var="institutions" items="${institutionList}">
                <div class="form-group form-group--checkbox" id="institution">
                    <label>
                        <form:radiobutton path="institution" value="${institutions.id}"
                                          data-name="${institutions.name}"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                                        <div class="title">${institutions.name}</div>
                                        <div class="subtitle">${institutions.description}</div>
                                    </span>

                    </label>
                </div>
            </c:forEach>
            <form:errors path="institution"/>
            <span class="error"></span>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 4 -->
        <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru</h4>
                    <div class="form-group form-group--inline" id="street">
                        <label> Ulica <form:input path="street"/> </label>
                    </div>
                    <span class="error"></span>
                    <div class="form-group form-group--inline" id="city">
                        <label> Miasto <form:input path="city"/> </label>
                    </div>
                    <span class="error"></span>
                    <div class="form-group form-group--inline" id="zipCode">
                        <label>
                            Kod pocztowy <form:input path="zipCode"/>
                        </label>
                    </div>
                    <span class="error"></span>
                    <div class="form-group form-group--inline" id="phone">
                        <label>
                            Numer telefonu <form:input path="phone"/>
                        </label>
                    </div>
                    <span class="error"></span>
                </div>

                <div class="form-section--column">
                    <h4>Termin odbioru</h4>
                    <div class="form-group form-group--inline" id="pickUpDate">
                        <label> Data <form:input path="pickUpDate" type="date"/> </label>
                    </div>
                    <span class="error"></span>
                    <div class="form-group form-group--inline" id="pickUpTime">
                        <label> Godzina <form:input path="pickUpTime" type="time"/></label>
                    </div>
                    <span class="error"></span>
                    <div class="form-group form-group--inline" id="comment">
                        <label>
                            Uwagi dla kuriera
                            <form:input path="pickUpComment" type="textarea" row="5" defoult="Brak uwag"/>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>
        <!-- STEP 5 -->
        <div data-step="5">
            <h3>Podsumowanie Twojej darowizny</h3>

            <div class="summary">
                <div class="form-section">
                    <h4>Oddajesz:</h4>
                    <ul>
                        <li>
                            <span class="icon icon-bag"></span>
                            <span class="summary--text" id="summaryQuantityAndCategory"></span
                            >
                        </li>

                        <li>
                            <span class="icon icon-hand"></span>
                            <span class="summary--text"
                                  id="summaryInstitution">Dla fundacji "Mam marzenie" w Warszawie</span
                            >
                        </li>
                    </ul>
                </div>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru:</h4>
                        <ul>
                            <li id="summaryStreet"></li>
                            <li id="summaryCity"></li>
                            <li id="summaryZipCode"></li>
                            <li id="summaryPhone"></li>
                        </ul>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru:</h4>
                        <ul>
                            <li id="summaryPickUpDate"></li>
                            <li id="summaryPickUpTime"></li>
                            <li id="summaryComment"></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <input type="submit" class="btn" value="Potwierdzam"/>
            </div>
            </form:form>
        </div>


</section>

<jsp:include page="footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
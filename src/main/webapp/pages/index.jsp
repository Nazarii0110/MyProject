<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="tmp/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<form action="/login">--%>
<%--<input type="submit" value="Login page" />--%>
<%--</form>--%>


<a href="/login">
    <button>login page</button>
</a>
<hr>

<a href="<c:url value="/logout" />">
    <button>Logout</button>
</a>

<sec:authorize access="hasRole('ADMIN')">

    <form action="/admin/toAdminPage">
        <input type="submit" value="Go to AdminPage"/>
    </form>

</sec:authorize>


<hr>


<%--<h1>Registration as user</h1>--%>
<%--<form action="/saveUser" method="post">--%>
<%--<input  placeholder="name">--%>
<%--<input type="text" name="password" placeholder="password">--%>
<%--<input type="email" name="email" placeholder="@">--%>
<%--<input type="text" name="phonenumber" placeholder="phonenumber">--%>
<%--<input type="submit" name="">--%>
<%--<input type="hidden"--%>
<%--name="${_csrf.parameterName}"--%>
<%--value="${_csrf.token}"/>--%>
<%--</form>--%>
<h1>registration as user</h1>
<sf:form method="post" action="/saveUser" modelAttribute="emptyUser">

    <sf:input path="username" placeholder="username"/>

    <sf:input path="password" placeholder="password"/>
    <sf:input path="email" placeholder="email"/>
    <sf:errors path="email"/>
    <sf:input path="phonenumber" placeholder ="phonenumber"/>

    <input type="submit">

</sf:form>


<hr>
<h1>Registraton as user with REST</h1>
<input type="text" id="name">
<input type="text" id="pass">
<input type="text" id="mail">
<input type="text" id="numb">
<button id="save" value="REGISTR">Registration</button>

<hr>

<form action="/seeAllCat">
    <input type="submit" value="All Categories"/>
</form>


<h2>${category.catname}</h2>
<p>${category.description}</p>
<c:forEach items="${category.products}" var="products">
    <p>
            ${products.prodname} </a>
            ${products.proddescription}</a>
            ${products.prodptice}</a>
        <img src="${products.prodpicture}" alt="">

    </p>
</c:forEach>
<hr>


<hr>
<h3>Find all prod</h3>
<button id="AllProd">Find all prod</button>

<div id="convert"></div>


<hr>


<script src="/js/main.js"></script>

</body>
</html>

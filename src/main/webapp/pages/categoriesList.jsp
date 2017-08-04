<%@include file="tmp/header.jsp"%>

<h1>All Categories</h1>

<hr>

<c:forEach items="${categories}" var="cat">
    <h3>
            ${cat.id}
            ${cat.catname}
    </h3>

    <%--<img src="${cat.picture}" alt="">--%>
    ${cat.description}

    <a href="seeAllCatWithProd-${cat.id}">detalies</a>
</c:forEach>


</body>
</html>

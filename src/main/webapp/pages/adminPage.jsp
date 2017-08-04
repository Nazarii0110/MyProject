<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="tmp/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>This is adminPage</h1>

<hr>

<h1>Form for saving category</h1>

<form action="/admin/saveCategory" method="post" enctype="multipart/form-data">
    <input type="text" name="catname" placeholder="category name">
    <textarea name="description" placeholder="description"></textarea>
    </textarea>
    <%--<input type="file" name="picture">--%>

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input type="submit">
</form>

<hr>


<form action="/admin/usersList">
    <input type="submit" id="show" value="All users" />
</form>

<div class="qw">
<c:forEach items="${users}" var="us">
    <h3>
            ${us.id}
            ${us.username}
                    ${us.email}
                    ${us.phonenumber}

    </h3>
    <%--<img src="${blog.picture}" alt="">--%>

    <%--<a href="blog-${cat.id}">detalies</a>--%>
</c:forEach>
</div>

<hr>
<sf:form method="post" action="/admin/saveProduct" modelAttribute="emptyProduct" enctype="multipart/form-data">

    <sf:input path="prodname" placeholder = "name"/>
    <sf:errors path="prodname" />
    <sf:input path="proddescription" placeholder = "description"/>
    <sf:input path="prodprice" placeholder = "price  "/>
    <sf:input type="file" path="prodpicture" />
    <sf:select path="category">
        <c:forEach items="${categories}" var="cat">
            <sf:option value="${cat.id}">
                ${cat.catname}
            </sf:option>
        </c:forEach>
    </sf:select>
    <input type="submit" >

</sf:form>


<hr>
<h1>Delete category</h1>
<form action="/admin/deleteCategory" method="get">
    <input type="text" name="catname" placeholder="Category name">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input type="submit">

</form>

<hr>

<h1>Send email</h1>
<form action="/sendEmail" method="post" >
    <input type="email" name="email">
    <input type="submit">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

</body>
</html>

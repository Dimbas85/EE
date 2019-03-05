<%--
  Created by IntelliJ IDEA.
  User: Nemtsov
  Date: 04.03.2019
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Collection.*"%>
<%@page import="ru.nemtsov.entity.Product"%>
<%@page import="ru.nemtsov.entity.ProductRepository"%>

<html>
<head>
    <title>Catalog</title>
</head>
<body>

    <jsp:include page="MainMenu.jsp" />

    <h1>Catalog</h1>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
        </tr>

        <c:forEach items="${requestScope.products}" var="product">
        <%--<c:forEach var="product" items="${requestScope.products}">--%>

            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>

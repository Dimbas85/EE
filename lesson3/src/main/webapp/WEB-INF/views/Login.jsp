<%--
  Created by IntelliJ IDEA.
  User: Nemtsov
  Date: 05.03.2019
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login_servlet" method="post">
    <label for="login">Login</label>
    <input id="login" type="text" name="login">
    <label for="password">Password</label>
    <input id="password" type="password" name="password">
    <input type="submit">
</form>
</body>
</html>

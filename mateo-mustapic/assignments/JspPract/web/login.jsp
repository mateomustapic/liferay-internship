<%--
  Created by IntelliJ IDEA.
  User: Mateo
  Date: 3/17/2017
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="css/style2.css" />
</head>
<body>
    <div id="loginContainer">
    <h1> LOGIN </h1>
    <form action="login" method="post" id="loginForm">
        USER ID: <input type="text" data-toggle="tooltip" title="Available user names: marko, kreso, matea & mateo" name="userId" />
        PASSWORD: <input type="password" name="password" />
        <input type="submit" id="loginButton" value="SUBMIT" name="submit" />
    </form>
    </div>
</body>
</html>

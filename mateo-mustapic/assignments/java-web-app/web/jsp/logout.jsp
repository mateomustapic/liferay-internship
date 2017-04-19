<%--
  Created by IntelliJ IDEA.
  User: Mateo
  Date: 3/21/2017
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    session.setAttribute("userId", null);
    session.invalidate();
    response.sendRedirect("../index.html");
%>
</body>
</html>

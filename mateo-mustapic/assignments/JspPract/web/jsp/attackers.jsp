<%--
  Created by IntelliJ IDEA.
  User: Mateo
  Date: 3/15/2017
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attackers</title>
    <link rel="stylesheet" href="../css/style4.css" />
</head>
<body>

<div id="container">
    <h2>CHOOSE YOUR FAVORITE ATTACKERS:</h2>
    <form method="get">
        <input type="checkbox" name="player" value="Torres"> Fernando Torres
        <br>
        <input type="checkbox" name="player" value="Hazard"> Eden Hazard
        <br>
        <input type="checkbox" name="player" value="Dybala"> Paulo Dybala
        <br>
        <input type="checkbox" name="player" value="Costa"> Diego Costa
        <br>
        <input type="checkbox" name="player" value="Vardy"> Jamie Vardy
        <br>
        <input type="checkbox" name="player" value="Higuain"> Gonzalo Higuain
        <br>
        <input type="submit" value="SELECT">
        <a href="<%= request.getRequestURI() %>"
           class="button">RESET</a>
    </form>
    <%
        String[] players = request.getParameterValues("player");
        if (players != null) {
    %>
    <h2>YOU HAVE SELECTED FOLLOWING PLAYERS:</h2>
    <ul>
        <%
            for (int i = 0; i< players.length; ++i) {
        %>
        <li><%= players[i] %></li>
        <%
            }
        %>
        <br>
    </ul>

    <%
        }
    %>
    <div id="homeButton">
        <a href="index.jsp" class="button">BACK TO HOMEPAGE</a>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>

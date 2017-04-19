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
    <title>CHECKBOX</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="../js/menu.js"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="../css/style2.css" />
</head>
<body>
<%@ include file="header.jsp"%>
<h1>CHOOSE YOUR FAVORITE ATTACKERS</h1>
    <form method="post" id="checkbox">

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
        <input type="checkbox" name="player" value="Kane"> Harry Kane
        <br><br>
        <input type="submit" id="submitButton" value="SELECT">
            <a href="<%= request.getRequestURI() %>"
               id="resetButton" class="button">RESET</a>
    </form>
<%
    String[] players = request.getParameterValues("player");
    if (players != null) {
%>
<br><br><br>
<div id="favoritesResult">
    Favorites
    <%
        for (int i = 0; i< players.length; ++i) {
    %>
    <li><%= players[i] %></li>
    <%
        }
    %>
    <br>
    <%
        }
    %>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>

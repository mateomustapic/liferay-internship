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
    <div id="favoritesForm">
        <form method="post" id="checkbox">
            <input type="checkbox" name="player" value="TORRES"> FERNANDO TORRES
            <br>
            <input type="checkbox" name="player" value="HAZARD"> EDEN HAZARD
            <br>
            <input type="checkbox" name="player" value="DYBALA"> PAULO DYBALA
            <br>
            <input type="checkbox" name="player" value="COSTA"> DIEGO COSTA
            <br>
            <input type="checkbox" name="player" value="VARDY"> JAMIE VARDY
            <br>
            <input type="checkbox" name="player" value="HIGUAIN"> GONZALO HIGUAIN
            <br>
            <input type="checkbox" name="player" value="KANE"> HARRY KANE
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
        <b><u>FAVORITES</u></b>
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
    </div>
<%@ include file="footer.jsp"%>
</body>
</html>

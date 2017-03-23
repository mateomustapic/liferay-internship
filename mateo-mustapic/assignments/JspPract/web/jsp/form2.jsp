<%--
  Created by IntelliJ IDEA.
  User: Mateo
  Date: 3/23/2017
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FORM 2</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="../js/menu.js"></script>

    <link rel="stylesheet" href="../css/style3.css" />
</head>
<body>
<%@ include file="header.jsp"%>

    <div id="container">
    <h1>ADD PLAYER</h1>
    <form name="loginForm" method="post" action="/newPlayer">
        <b>ID:</b> <input type="text" id="id" name="id"/>
        <b>FULL NAME:</b> <input type="text" id="name" name="name"/>
        <b>POSITION:</b><input type="text" id="position" name="position"/>
        <input type="submit" id="bttn" class="button" value="ADD" />
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Position</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>01</td>
            <td>Mesut Ozil</td>
            <td>Central Midfielder</td>
        </tr>
        <tr>
            <td>02</td>
            <td>Harry Kane</td>
            <td>Central Forward</td>
        </tr>
        <tr>
            <td>03</td>
            <td>Philip Lahm</td>
            <td>Right Back</td>
        </tr>
        <tr>
            <td>04</td>
            <td>Fernando Torres</td>
            <td>Central Forward</td>
        </tr>
        <tr>
            <td>05</td>
            <td>Eden Hazard</td>
            <td>Left Wing</td>
        </tr>
        <tr>
            <td>06</td>
            <td>Paulo Dybala</td>
            <td>Central Forward</td>
        </tr>
        <tr>
            <td><%
                request.setCharacterEncoding("UTF-8");
                String playerId = request.getParameter("id");
                if (playerId != null && !playerId.isEmpty()) {
                    out.println(playerId);
                }
            %>
            </td>
            <td>
                <%
                    request.setCharacterEncoding("UTF-8");
                    String playerName = request.getParameter("name");
                    if (playerName != null && !playerName.isEmpty()) {
                        out.println(playerName);
                    }
                %>
            </td>
            <td>
                <%
                    request.setCharacterEncoding("UTF-8");
                    String playerPosition = request.getParameter("position");
                    if (playerPosition != null && !playerPosition.isEmpty()) {
                        out.println(playerPosition);
                %>
            </td>
        </tr>
        </tbody>
    </table>
    <h3>
    <%
            out.println("NEW PLAYER HAS BEEN ADDED");
    }
    %>
    </h3>
    </div>
    <%@ include file="footer.jsp"%>
</body>
</html>

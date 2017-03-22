<%--
  Created by IntelliJ IDEA.
  User: Mateo
  Date: 3/20/2017
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Getting data from external JSON</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="../js/menu.js"></script>
    <script src="../js/script2.js"></script>
    <link rel="stylesheet" href="../css/style3.css" />
</head>
<body>
<%@ include file="header.jsp"%>
<div id="container">
    <h1>PLAYERS LIST</h1>
    <h2>
        <div id="result">
        </div>
    </h2>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Position</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <a href="index.jsp" class="button">BACK TO HOMEPAGE</a>
</div>
<%@ include file="footer.jsp"%>

</body>
</html>

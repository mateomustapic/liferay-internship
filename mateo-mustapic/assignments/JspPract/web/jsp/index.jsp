<%--
  Created by IntelliJ IDEA.
  User: Mateo
  Date: 3/15/2017
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="login.Users" %>
<html>
<head>
    <title>JSP Home</title>
    <script src="../js/menu.js"></script>
    <link rel="stylesheet" href="../css/style2.css" />
</head>
<body>
<%@ include file="header.jsp"%>

<div id="main">
    <h1> INDEX PAGE </h1>
    <br>
    <h2> JSP/SERVLETS PRACTICE</h2>
    <%
        Users user = (Users) session.getAttribute("user");
        if(user.getUserName()!=null){
            %><h2>WELCOME <%
            out.println(user.getUserName());
        }
        else {
            out.println("NOT LOGGED IN");
        %>
        <br><br>
        <a href="../login.jsp" class="button">LOG IN</a>
        <%
            }
        %>
    </h2>
</div>

<%@ include file="footer.jsp"%>


<script type="text/javascript">
    var alerted = localStorage.getItem('alerted') || '';
    if (alerted != 'yes') {
        alert("Login successful");
        localStorage.setItem('alerted','yes');
    }
</script>

</body>
</html>

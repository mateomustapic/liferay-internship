<%--
  Created by IntelliJ IDEA.
  User: Mateo
  Date: 3/15/2017
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.football.Users" %>
<html>
<head>
    <title>JSP Home</title>
    <link rel="stylesheet" href="../css/style2.css" />
</head>
<body>
<h1> INDEX PAGE </h1>
<br>
<h2> JSP/SERVLETS PRACTICE</h2>
<%
    Users user = (Users) session.getAttribute("user");
%>
<h2>WELCOME <%
    if(user.getUserName()!=null){
        out.println(user.getUserName());
    }
    else {
        out.println(user.getUserName());
    }
    %>
</h2>
    <a href="form.jsp" class="button">FORM</a>
    <a href="attackers.jsp" class="button">CHECKBOX</a>
    <a href="/servlets/FirstServlet" class="button">TEST SERVLET</a>
    <a href="user.jsp" class="button">USER</a>
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

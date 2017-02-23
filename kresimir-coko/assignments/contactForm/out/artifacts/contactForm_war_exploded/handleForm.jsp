<%--
  Created by IntelliJ IDEA.
  User: kresimircoko
  Date: 23/02/2017
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Form Handled. Go Away.</title>
	<link rel="stylesheet" href="styles.css">
</head>
<body>

	<%
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
	%>

	<div id="response">
		<h3>Form has been handled. Go away.</h3>

		<span class="static">Yer name is:</span>
		<span class="dynamic"> <%= name %> </span>

		<span class="static">Yer email is:</span>
		<span class="dynamic"> <%= email %> </span>

		<span class="static">Yer message is:</span>
		<p class="dynamic"> <%= message %> </p>

		<a href="index.jsp">I wanna go away</a>
	</div>
</body>
</html>

<%@ page import="static javax.swing.text.html.CSS.getAttribute" %>
<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 21/02/2017
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <script
            src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
            crossorigin="anonymous"></script>
    <script src="app-ajax.js" type="text/javascript"></script>
</head>
<body>

<P>Hy,${param.username}</P>

<p>Your music choice is: </p>

<% String[] musica = request.getParameterValues("music");
    if (musica != null) {
        for(int i=0; i<musica.length; i++) { %>
<%= musica[i]%><br><br>
<% }
} %>
<br>
<fieldset>
    <legend> Article1: </legend>
</fieldset>
<br>

<fieldset>
    <legend> Article2: </legend>
</fieldset>
<br>

<form method="post" id="requestForm">
    <fieldset>
        <legend> Bend searching: </legend><br>
        <p>
            <label for="bend">Bend:</label>
            <input id="bend" type="text" name="bendName" />
        </p>
        <p>
            <input id="btn" type="submit" value="Submit" />
        </p>
    </fieldset>
</form>
<div id="result">
    <fieldset>
        <legend> Result </legend>
        <div id="response"></div>
    </fieldset>
</div>
<p>Contact me on: ${initParam.contact}</p>
</body>
</html>

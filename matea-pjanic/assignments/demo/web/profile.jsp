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
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<P>Hy, ${param.username}
</P>

<%  String[] musica = request.getParameterValues("music");
    if (musica != null) {
        for(int i=1; i<=musica.length; i++) { %>
        <fieldset class="article<%=i%>">
            <legend> Article<%=i%>: </legend>
            <div><%= musica[i-1]%></div>
        </fieldset>
        <br>
<% }} %>

<form method="post" id="searchMusicForm">
    <fieldset>
        <legend> Bend searching: </legend><br>

        <p>
            <label for="bend">Bend:</label>
            <input id="bend" type="text" name="bendName" autocomplete="off"/>
        </p>
        <p>
            <input id="btn2" type="submit" value="Submit" />
        </p>

    </fieldset>
</form>
<div id="resultDiv">
    <fieldset>
        <legend> Result </legend>
        <div id="result"></div>
    </fieldset>
</div>
<p>Contact me on: ${initParam.contact}
</p>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 21/02/2017
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registration</title>
  <script
          src="https://code.jquery.com/jquery-3.1.1.js"
          integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
          crossorigin="anonymous"></script>
  <script src="app-ajax.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form method="post" id="selectMusicForm" action="RegistrationPath">
  <fieldset>
    <legend> Registration </legend>
    </br>
    Username: <input type="text" name="username" autocomplete="off"/><br><br>
    Password: <input type="password" name="password"/><br>
  </fieldset>
  <br>
  <fieldset>
    <legend> Choose you favorite music </legend>

    <input type="checkbox" name="music" value="rock"> Rock <br>
    <input type="checkbox" name="music" value="country"> Country <br>
    <input type="checkbox" name="music" value="classic"> Classic <br>
    <input type="checkbox" name="music" value="blues"> Blues <br>
    <input type="checkbox" name="music" value="folk"> Folk <br>
    <input type="checkbox" name="music" value="punk"> Punk <br>
    <input type="checkbox" name="music" value="reggae"> Reggae <br>
    <input type="checkbox" name="music" value="hiphop"> Hip hop <br>
    <input type="checkbox" name="music" value="jazz"> Jazz <br>

  </fieldset>
  <br>
  <input id="btn1" type="submit" value="Submit">
</form>
</body>
</html>


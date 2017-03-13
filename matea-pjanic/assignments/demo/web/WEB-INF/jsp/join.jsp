<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 27/02/2017
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="../../js/jquery.easy-autocomplete.js" type="text/javascript"></script>
    <script src="../../js/jquery.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/easy-autocomplete.css">
    <link rel="stylesheet" type="text/css" href="../../css/easy-autocomplete.themes.css">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container" id="joinContent">
    <form class="form-horizontal" method="post" action="RegistrationPath">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <br>
        <div class="container" id="musicChoice">
            <fieldset>
                <legend>Choose you music preferences</legend><br>
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
        </div>
        <br>
        <br>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Join</button>
            </div>
        </div>
    </form>
</div>
<div class="container resultContainer">
</div>
<%@ include file="footer.jsp"%>
</body>
</html>

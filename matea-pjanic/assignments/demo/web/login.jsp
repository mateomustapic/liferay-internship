<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 27/02/2017
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/jquery.easy-autocomplete.js" type="text/javascript"></script>
    <script src="js/ajax.js" type="text/javascript"></script>
    <script src="js/bla.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/easy-autocomplete.css">
    <link rel="stylesheet" type="text/css" href="css/easy-autocomplete.themes.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<jsp:include page="header.jsp" >
    <jsp:param name="info" value="<a class='headLink' href='#info'>Info</a>" />
    <jsp:param name="artists" value="<a class='headLink' href='index.jsp#artists'>Top artists</a>" />
    <jsp:param name="tracks" value="<a class='headLink' href='index.jsp#tracks'>Top tracks</a>" />
    <jsp:param name="join" value="<a class='headLink' href='join.jsp'>Join</a>" />
    <jsp:param name="events" value="<a class='headLink' href='index.jsp#events'>Events</a>" />
    <jsp:param name="home" value="<a class='headLink' href='index.jsp'>Home</a>" />
</jsp:include>
<div class="container" id="loginContent">
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
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
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

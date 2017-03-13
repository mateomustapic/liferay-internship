<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 03/03/2017
  Time: 12:54
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
<div class="container" id="content">
    <div class="container" id="news"></div>
    <div class="container" id="music"></div>
    <div class="container" id="tracks"></div>
</div>
<div class="container" id="profileContent">
    <h2>Your tracks</h2>
    <table class="table table-hover">
        <tbody>
        <tr>
            <td>
                <div class="song">
                    <button class="playBtn" title="Play"><i class="fa fa-play"></i></button>
                    &nbsp;&nbsp;<p>Ed Sheeran: Shape Of You</p>
                    <audio class="audioPlayHide" controls>
                        <source src = "../mp3/EdSheeran-ShapeOfYou.mp3" type = "audio/mp3">
                    </audio>
                    <button class="removeBtn" title="Remove from playlist"><i class="fa fa-trash-o"></i></button>
                </div>
            </td>

        </tr>
        <tr>
            <td>
                <div class="song">
                    <button class="playBtn" title="Play"><i class="fa fa-play"></i></button>
                    &nbsp;&nbsp;<p>The Weeknd: I Feel It Coming</p>
                    <audio class="audioPlayHide" controls>
                        <source src = "../mp3/TheWeeknd-IFeelItComing.mp3" type = "audio/mp3">
                    </audio>
                    <button class="removeBtn" title="Remove from playlist"><i class="fa fa-trash-o"></i></button>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container resultContainer" id="result">
</div>
<%@ include file="footer.jsp"%>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 21/02/2017
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sending form directly to jsp, not servlet</title>
    <script
            src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
            crossorigin="anonymous"></script>
    <script src="app-ajax.js" type="text/javascript"></script>
</head>
<body>

<div id="result">
    <fieldset>
        <legend> Result </legend>
        <div id="response">
            you wrote: ${param.bendName}<br><br>
            but for now all I have is :<br><br>
            Bend:${azra.bendName}<br>
            Album: ${azra.album.albumName}<br>
            Pjesme: ${azra.album.songs[0].songName}<br>
            ${azra.album.songs[1].songName}<br>
            ${azra.album.songs[2].songName}<br>
        </div>
    </fieldset>
</div>
<%--in scriptlets this would be:--%>
    <%--<%= ((com.company.Bend) request.getAttribute("azra")).getBendName()%><br>--%>
    <%--<%= ((com.company.Bend) request.getAttribute("azra")).getAlbum().getAlbumName()%><br>--%>
    <%--<%= ((com.company.Bend) request.getAttribute("azra")).getAlbum().getSongs()[0].getSongName()%><br>--%>
</body>
</html>

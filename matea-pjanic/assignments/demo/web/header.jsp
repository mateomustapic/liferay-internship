<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 27/02/2017
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <form method="post" id="searchMusicForm">
        <input id="search" type="text" name="bendName" autocomplete="off" placeholder="Search music"/>
        <button id="searchBtn" type="submit"><i class="fa fa-search"></i></button>
    </form>
    <nav id="site-nav">
        ${param.login}
        ${param.join}
        ${param.artists}
        ${param.tracks}
        ${param.info}
        ${param.home}
        ${param.events}
    </nav>
</header>

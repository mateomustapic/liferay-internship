<%--
  Created by IntelliJ IDEA.
  User: kresimircoko
  Date: 23/02/2017
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="styles.css">
  </head>
  <body>
    <form action="handleForm.jsp" method="POST">
      <h3>Awesome Contact Form Using An Old Technology</h3>

      <label for="name">Name</label>
      <input name="name" placeholder="First Name" type="text">

      <label for="email">Email</label>
      <input name="email" placeholder="example@email.com" type="email">

      <label for="message">Message</label>
      <textarea name="message" placeholder="Send us a message..."></textarea>

      <input type="submit" value="Submit">

    </form>
  </body>
</html>

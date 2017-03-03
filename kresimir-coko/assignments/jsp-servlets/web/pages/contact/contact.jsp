<%--
  Created by IntelliJ IDEA.
  User: kresimircoko
  Date: 24/02/2017
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Contact</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../styles.css">
	</head>
	<body id="body-contact">

		<jsp:include page="/components/header/header.jsp" />

		<main>
			<div class="container">
				<h3>Contact us</h3>
				<p>Give us 24 hours and we will get back to you via email :)</p>
			</div>

			<form action="/handleForm" id="contact-form" method="POST">
				<div class="container">
					<label for="name">Name</label>
					<input name="name" placeholder="First Name" required type="text">

					<label for="email">Email</label>
					<input name="email" placeholder="example@contact.info" required type="email">

					<label for="message">Message</label>
					<textarea name="message" placeholder="Send us your feedback..." required></textarea>

					<input type="submit" value="Send">
					<%
						request.setCharacterEncoding("UTF-8");
						String name = request.getParameter("name");

						if (name != null) {
							out.println("<span class='form-success'> Thank you for contacting us " + name + ".</span>");
						}
					%>
				</div>
			</form>
		</main>

		<jsp:include page="/components/footer/footer.jsp" />

		<script type="text/javascript" src="../../scripts.js"></script>
	</body>
</html>

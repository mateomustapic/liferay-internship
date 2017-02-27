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
		<title>Products</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="styles.css">
	</head>
	<body id="products">

		<jsp:include page="header.jsp" />

		<main>
			<div class="container">
				<h3>Products</h3>
				<p>This page will serve to showcase the CRUD functionality of JSPs and Servlets</p>

			</div>
			<section id="crud">
				<div class="container">
					<a href="create.jsp" id="createProduct">Create a product</a>
					<a href="read.jsp" id="readProduct">Read a product</a>
					<a href="update.jsp" id="updateProduct">Update a product</a>
					<a href="delete.jsp" id="deleteProduct">Delete a product</a>
				</div>
			</section>
		</main>

		<jsp:include page="footer.jsp" />

		<script type="text/javascript" src="scripts.js"></script>
	</body>
</html>

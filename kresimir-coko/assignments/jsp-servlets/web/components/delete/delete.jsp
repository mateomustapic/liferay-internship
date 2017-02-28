<%--
  Created by IntelliJ IDEA.
  User: kresimircoko
  Date: 27/02/2017
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Delete a product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../styles.css">
		<link rel="stylesheet" href="delete.css">
	</head>
	<body>

	<jsp:include page="../header/header.jsp" />

		<main>
			<div class="container">
				<h3>Delete a product</h3>
				<p>This form lets you delete existing products.</p>
			</div>
			<form action="handleDelete" class="product-form" id="formDelete" method="POST">
				<div class="container">
					<label for="deleteProduct">Select a product</label>
					<select name="deleteProduct">
						<option value="product1">Product #1</option>
						<option value="product2">Product #2</option>
						<option value="product3">Product #3</option>
						<option value="product4">Product #4</option>
						<option value="product5">Product #5</option>
					</select>

					<input type="submit" value="Delete This Product">
				</div>
			</form>
			<a class="backlink" href="../../pages/products/products.jsp">
				<svg xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
						 height="24" viewBox="0 0 24 24" width="24">
					<path d="M0 0h24v24H0z" fill="none"/>
					<path d="M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z"/>
				</svg>
				Back to Products
			</a>
		</main>

	<jsp:include page="../footer/footer.jsp" />

		<script type="text/javascript" src="../../scripts.js"></script>
	</body>
</html>

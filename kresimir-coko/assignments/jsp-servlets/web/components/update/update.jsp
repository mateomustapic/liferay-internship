<%--
  Created by IntelliJ IDEA.
  User: kresimircoko
  Date: 27/02/2017
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Update a product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../styles.css">
		<link rel="stylesheet" href="update.css">
	</head>
	<body id="body-update">

	<jsp:include page="../header/header.jsp" />

		<main>
			<div class="container">
				<h3>Update a product</h3>
				<p>This form lets you update existing products.</p>

				<form action="/handleUpdate" class="product-form" id="formUpdate" method="POST">
					<div class="container">
						<label for="selectProduct">Select a product</label>
						<select name="selectProduct">
							<option value="product1">Product #1</option>
							<option value="product2">Product #2</option>
							<option value="product3">Product #3</option>
							<option value="product4">Product #4</option>
							<option value="product5">Product #5</option>
						</select>

						<label for="updateProduct">Update the product Name</label>
						<input name="updateProduct" placeholder="New Product Name" type="text">

						<input type="submit" value="Update This Product">
					</div>
				</form>
			</div>

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

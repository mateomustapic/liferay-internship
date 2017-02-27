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
		<title>Create a product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>

		<jsp:include page="header.jsp" />

		<main>
			<div class="container">
				<h3>Create a product</h3>
				<p>This form lets you create a new product.</p>
			</div>
			<form action="handleCreate" class="product-form" id="formCreate" method="POST">
				<div class="container">
					<label for="productName">Product Name</label>
					<input name="productName" placeholder="Product Name" type="text">

					<label for="productType">Product type</label>
					<input name="productType" placeholder="Product Type" type="text">

					<input type="submit" value="Add a Product">
				</div>
			</form>
			<div class="container">
				<a class="backlink" href="products.jsp">Back to Products</a>
			</div>
		</main>

		<jsp:include page="footer.jsp" />

		<script type="text/javascript" src="scripts.js"></script>
	</body>
</html>

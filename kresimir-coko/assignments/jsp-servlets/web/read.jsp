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
		<title>Read a product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>

		<jsp:include page="header.jsp" />

		<main>
			<div class="container">
				<h3>Read a product</h3>
				<p>This form lets you read products.</p>
			</div>
			<form action="handleRead" class="product-form" id="formRead" method="POST">
				<div class="container">
					<p>Select inputs to read existing products</p>
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

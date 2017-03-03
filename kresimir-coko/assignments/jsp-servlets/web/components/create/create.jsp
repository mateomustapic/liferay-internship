<%@ page import="java.util.ArrayList" %><%--
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
		<title>Create a product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../styles.css">
	</head>
	<body id="body-create">

		<jsp:include page="../header/header.jsp" />

		<main>
			<div class="container">
				<h3>Create a product</h3>
				<p>This form lets you create a new product.</p>
			</div>

			<form action="/handleCreate" class="product-form" id="formCreate" method="post">
				<div class="container">
					<label for="productName">Product Name</label>
					<input name="productName" placeholder="Product Name" required type="text">

					<%--<label for="productType">Product type</label>--%>
					<%--<input name="productType" placeholder="Product Type" type="text">--%>

					<input type="submit" value="Add a Product">

					<%
						request.setCharacterEncoding("UTF-8");

						String productName = request.getParameter("productName");

						if (productName != null && !productName.isEmpty()) {
							out.println("<span class='form-success'>" + productName + " has been added</span>");
						}

					%>
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

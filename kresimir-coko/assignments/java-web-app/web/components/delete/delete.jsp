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
		<title>Delete a product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../styles.css">
	</head>
	<body id="body-delete">

	<jsp:include page="/components/header/header.jsp" />

		<main>
			<div class="container">
				<h3>Delete a product</h3>
				<p>This form lets you delete existing products.</p>
			</div>

			<form action="/handleDelete" class="product-form" id="formDelete" method="POST">
				<div class="container">

					<%
						request.setCharacterEncoding("UTF-8");

						ArrayList<String> products;
						products = (ArrayList<String>) session.getAttribute("products");

						if (products == null) {
							out.println("<span class='warning'> Create some products before you can delete them </span>");
						}
					%>

					<label for="deleteProduct">Select a product</label>
					<select placeholder="test" name="deleteProduct">
						<option selected disabled style="display:none">Select a product</option>
						<%
							if (products != null) {
								for (String product : products) {
									out.println("<option value='" + product + "'>" + product + "</option>");
								}
							}
						%>
					</select>

					<input type="submit" value="Delete This Product">

					<%
						String deletedProduct = request.getParameter("deleteProduct");

						if (deletedProduct != null) {
							out.println("<span class='form-success'>" + deletedProduct + " deleted</span>");
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

	<jsp:include page="/components/footer/footer.jsp" />

		<script type="text/javascript" src="../../scripts.js"></script>
	</body>
</html>

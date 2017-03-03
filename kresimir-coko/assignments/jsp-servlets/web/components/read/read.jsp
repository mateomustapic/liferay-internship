<%--
  Created by IntelliJ IDEA.
  User: kresimircoko
  Date: 27/02/2017
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.ArrayList" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Read a product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../styles.css">
	</head>
	<body id="body-read">

	<jsp:include page="/components/header/header.jsp" />

		<main>
			<div class="container">
				<h3>Product List</h3>
				<p>Here you can see a list of all the products</p>
			</div>

			<form class="product-form" id="formRead" method="GET">
				<div class="container">
					<ul>
						<%
							request.setCharacterEncoding("UTF-8");

							ArrayList<String> products = (ArrayList<String>) session.getAttribute("products");

							if (products != null) {
								for(String product : products) {
									out.println("<li>" + product + "</li>");
								}
							} else {
								out.println("<span> Create some products before you can view them here </span>");
							}
						%>
					</ul>
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

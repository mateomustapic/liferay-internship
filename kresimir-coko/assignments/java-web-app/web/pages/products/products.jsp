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
		<link rel="stylesheet" href="../../styles.css">
		<link rel="stylesheet" href="products.css">
	</head>
	<body id="products">

		<jsp:include page="/components/header/header.jsp" />

		<main>
			<div class="container">
				<h3>Products</h3>
				<p>This page will serve to showcase the CRUD functionality of JSPs and Servlets</p>

			</div>
			<section id="crud">
				<div class="container">
					<a href="../../components/create/create.jsp" id="createProduct">
						<svg xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
								 height="24" viewBox="0 0 24 24" width="24">
							<path d="M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"/>
							<path d="M0 0h24v24H0z" fill="none"/>
						</svg> Create a product
					</a>
					<a href="../../components/read/read.jsp" id="readProduct">
						<svg xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
								 height="24" viewBox="0 0 24 24" width="24">
							<path d="M4 14h4v-4H4v4zm0 5h4v-4H4v4zM4 9h4V5H4v4zm5 5h12v-4H9v4zm0 5h12v-4H9v4zM9 5v4h12V5H9z"/>
							<path d="M0 0h24v24H0z" fill="none"/>
						</svg> List products
					</a>
					<a href="../../components/update/update.jsp" id="updateProduct">
						<svg xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
								 height="24" viewBox="0 0 24 24" width="24">
							<path d="M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z"/>
							<path d="M0 0h24v24H0z" fill="none"/>
						</svg> Update a product
					</a>
					<a href="../../components/delete/delete.jsp" id="deleteProduct">
						<svg xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF"
								 height="24" viewBox="0 0 24 24" width="24">
							<path d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z"/>
							<path d="M0 0h24v24H0z" fill="none"/>
						</svg>Delete a product
					</a>
				</div>
			</section>
		</main>

		<jsp:include page="/components/footer/footer.jsp" />

		<script type="text/javascript" src="../../scripts.js"></script>
	</body>
</html>

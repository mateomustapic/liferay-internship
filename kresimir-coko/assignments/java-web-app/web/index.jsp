<%--
  Created by IntelliJ IDEA.
  User: kresimircoko
  Date: 24/02/2017
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html >
  <head>
    <title>Awesome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles.css">
  </head>
  <body>

  	<jsp:include page="components/header/header.jsp" />

    <main>

			<div id="hero">
				<h1>
					Awesome CRUD App made without JavaScript*
					<small>
						* It saddens me too
					</small>
				</h1>

				<a href="./pages/products/products.jsp">I wanna CRUD</a>
			</div>

      <div class="container">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci cupiditate deserunt fuga molestiae nesciunt odit quas rem reprehenderit voluptate. Illo ipsa ratione rem repellendus unde vel? Neque numquam odio vel.</p>
      </div>
    </main>

  	<jsp:include page="components/footer/footer.jsp" />

  	<script type="text/javascript" src="scripts.js"></script>
  </body>
</html>
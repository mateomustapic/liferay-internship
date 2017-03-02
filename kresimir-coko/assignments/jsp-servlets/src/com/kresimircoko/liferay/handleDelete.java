package com.kresimircoko.liferay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kresimircoko on 02/03/2017.
 */
@WebServlet(name = "handleDelete", urlPatterns = "/handleDelete")
public class handleDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatch = request.getRequestDispatcher("/components/delete/delete.jsp");
		dispatch.include(request, response);

		HttpSession session = request.getSession();

		// Retrieve the selected product
		String deletedProduct;
		ArrayList<String> products;

		deletedProduct = request.getParameter("deleteProduct");
		products = (ArrayList<String>) session.getAttribute("products");

		// Store the selected product
		session.setAttribute("deletedProduct", deletedProduct);

		// Index of the product we want to update
		int index = products.indexOf(deletedProduct);

		products.remove(index);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

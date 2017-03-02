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
@WebServlet(name = "handleUpdate", urlPatterns = "/handleUpdate")
public class handleUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatch = request.getRequestDispatcher("/components/update/update.jsp");
		dispatch.include(request, response);

		HttpSession session = request.getSession();

		// Retrieve the selected product & new product name
		String selectedProduct;
		String newProductName;
		ArrayList<String> products;

		selectedProduct = request.getParameter("selectProduct");
		newProductName = request.getParameter("updateProduct");
		products = (ArrayList<String>) session.getAttribute("products");


		// Store the selected product
		session.setAttribute("selectedProduct", selectedProduct);
		session.setAttribute("newProductName", newProductName);

		// Index of the product we want to update
		int index = products.indexOf(selectedProduct);

		// Replace the selected product name with the updated one
		products.set(index, newProductName);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

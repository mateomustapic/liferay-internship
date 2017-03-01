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
 * Created by kresimircoko on 28/02/2017.
 */
@WebServlet(name = "handleCreate", urlPatterns = "/handleCreate")
public class handleCreate extends HttpServlet {
	private ArrayList<String> products = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatch = request.getRequestDispatcher("/components/create/create.jsp");
		dispatch.include(request, response);

		HttpSession session = request.getSession();

		// Retrieve the value from the input
		String productName = request.getParameter("productName");

		// Store the input value into HttpSession
		session.setAttribute("productName", productName);

		// Variable containing productName currently in session
		String storedProductName = (String)session.getAttribute("productName");

		// Add productName to our products ArrayList
		products.add(storedProductName);

		// Store products ArrayList into session
		session.setAttribute("products", products);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

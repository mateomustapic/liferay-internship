package com.kresimircoko.liferay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kresimircoko on 28/02/2017.
 */
@WebServlet(name = "handleCreate", urlPatterns = "/handleCreate")
public class handleCreate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatch = request.getRequestDispatcher("/components/create/create.jsp");
		dispatch.include(request, response);

		String productName = request.getParameter("productName");
//		String productType = request.getParameter("productType");

		HttpSession session = request.getSession();

		session.setAttribute("productName", productName);
//		session.setAttribute("productType", productType);


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

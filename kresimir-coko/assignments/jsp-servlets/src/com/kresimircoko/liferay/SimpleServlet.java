package com.kresimircoko.liferay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kresimircoko on 24/02/2017.
 */
@WebServlet(name = "SimpleServlet", description = "IDK", urlPatterns = {"/SimpleServlet"})
public class SimpleServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter data = response.getWriter();
		data.println("<h3> Hello Response </h3>");
	}
}

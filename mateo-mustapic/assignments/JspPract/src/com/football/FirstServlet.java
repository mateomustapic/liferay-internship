package com.football;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mateo on 3/13/2017.
 */
@WebServlet(name = "FirstServlet", urlPatterns = {"/servlets/firstServlet" })
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>This is TEST servlet output</h1>" +
                "<a href=\"/../jsp/index.jsp\" class=\"button\">BACK TO HOMEPAGE</a>\n");
        out.flush();
    }
}

package com.football;

/**
 * Created by Mateo on 3/16/2017.
 */

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
@WebServlet(name = "User", urlPatterns = {"/servlets/User"})
public class User extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("userName");
        String fullName = request.getParameter("fullName");
        String club = request.getParameter("club");
        String country = request.getParameter("country");

        out.println("Hello " + username + "!" + " Your favorite player is:" + fullName + " Current club: " + club + " Nationality: " + country);
        out.println("\n");
        out.println("<a href=\"/../jsp/index.jsp\" class=\"button\">BACK TO HOMEPAGE</a>");
    }
}

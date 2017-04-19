package com.company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Matea Pjanic on 21/02/2017.
 */
public class Registration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
        view.forward(request,response);
    }
}


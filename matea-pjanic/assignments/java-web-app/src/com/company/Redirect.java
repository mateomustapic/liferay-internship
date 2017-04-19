package com.company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Matea Pjanic on 27/02/2017.
 */
public class Redirect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
        view.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        String url = request.getRequestURL().toString();
        if(url.contains("login")) {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            view.forward(request,response);
        }

        else if(url.contains("join")) {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/join.jsp");
            view.forward(request,response);
        }

        else if(url.contains("home")) {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            view.forward(request,response);
        }

        else {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
            view.forward(request,response);
        }
    }
}

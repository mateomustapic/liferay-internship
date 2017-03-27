package com.football;

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
 * Created by Mateo on 3/22/2017.
 */
@WebServlet(name = "newPlayerServlet", urlPatterns = "/newPlayer")
public class newPlayerServlet extends HttpServlet {
    private ArrayList<String>  playerIds = new ArrayList<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/form2.jsp");
        dispatch.include(request, response);
        // read form fields
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String position = request.getParameter("position");
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("name", name);
        session.setAttribute("position", position);
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("position: " + position);
        // Variable containing playerId currently in session
        String storedPlayerId = (String)session.getAttribute("id");
        String storedPlayerName = (String)session.getAttribute("name");
        String storedPlayerPosition = (String)session.getAttribute("position");
        // Add player ID to our player Ids ArrayList
        playerIds.add(storedPlayerId);
        // Store ids ArrayList into session
        session.setAttribute("id", id);
        session.setAttribute("name", name);
        session.setAttribute("position", position);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

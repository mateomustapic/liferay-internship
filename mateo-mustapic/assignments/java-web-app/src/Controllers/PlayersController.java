package Controllers;

import Model.PlayersModel;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Mateo on 3/20/2017.
 */
@WebServlet(name = "PlayersController", urlPatterns = "/players")
public class PlayersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        PlayersModel playersModel = new PlayersModel();
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("list")) {
            out.print(gson.toJson(playersModel.findAll()));
            out.flush();
            out.close();
        }
    }
}

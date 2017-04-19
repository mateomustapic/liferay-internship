package login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateo on 3/17/2017.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login" })
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId, password;
        userId = request.getParameter("userId");
        password = request.getParameter("password");

        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(userId, password);
        if (result) {
            Users user = loginService.getUserDetails(userId);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/index");
            return;
        }
        else {
            response.sendRedirect("/login");
            return;
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatch = request.getRequestDispatcher("/login.jsp");
        dispatch.forward(request, response);
    }
}

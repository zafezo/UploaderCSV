package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by swen on 6/17/16.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses = request.getSession();

        String password = request.getParameter("password");
        if(password.compareTo( "admin") == 0){
            ses.setAttribute("login", true);
            getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
            return;
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ses.setAttribute("login", null);
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }
}

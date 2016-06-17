package servlets;

import data.Statistic;
import data.User;
import database.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Khomenko_D on 27.05.2016.
 */
@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("login") == null) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            List<User> users = null;
        try {
            users = HibernateUtil.findAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errors", e.getMessage());
        }


        request.setAttribute("users", users);
        request.setAttribute("count", users.size());


        List<Statistic> statistics = HibernateUtil.getStatistics();

        request.setAttribute("statistics", statistics);

        //send response
        getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
    }
    }
}

package servlets;

import data.ParserCSV;
import data.User;
import database.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swen on 5/22/16.
 */
@WebServlet(name = "GetAllServlet",urlPatterns = "/show")
public class GetAllServlet extends HttpServlet {
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<User> users = null;
        try {
           users = HibernateUtil.findAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errors", e.getMessage());
        }
        request.setAttribute("users", users);
          request.setAttribute("count",users.size());

        //send response
        getServletContext().getRequestDispatcher("/show.jsp").forward(request, response);
    }
}

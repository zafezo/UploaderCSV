package servlets;

import data.User;
import data.UserASM;
import database.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Khomenko_D on 28.05.2016.
 */

@WebServlet("/admincontr")
public class AdminControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        if(req.getParameter("userid")!=null){
        int userId= Integer.parseInt(req.getParameter("userid"));
        HibernateUtil.deleteUserById(userId);
        }

        if(req.getParameter("updateid")!=null)
        {

            int updateid= Integer.parseInt(req.getParameter("updateid"));

            String firstname=req.getParameter("firstname") ;
            String lastname= req.getParameter("lastname") ;
            String email=    req.getParameter("email");
            String gender=   req.getParameter("gender")  ;

            User updateUser= UserASM.user.crateUser(firstname,lastname,email,gender);
            updateUser.setId(updateid);
            HibernateUtil.updateUserById(updateUser);

        }
        else
        {
            if(req.getParameter("firstname")!=null)
            {
                String firstname=req.getParameter("firstname") ;
                String lastname= req.getParameter("lastname") ;
                String email=    req.getParameter("email");
                String gender=   req.getParameter("gender")  ;

                User updateUser= UserASM.user.crateUser(firstname,lastname,email,gender);
                HibernateUtil.addUser(updateUser);
            }
        }
    }
}

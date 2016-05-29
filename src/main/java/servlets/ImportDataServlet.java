/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data.ParserCSV;
import data.Statistic;
import data.User;
import database.HibernateUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nazar
 */
@MultipartConfig
public class ImportDataServlet extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //Get file
               Part file = request.getPart("file");
               
             //Get arrayList of users object from file
               ArrayList<User> users = ParserCSV.parseAll(file.getInputStream());

                try {
                    HibernateUtil.addUsers(users);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("errors", e.getMessage());
                }
                request.setAttribute("count", users.size());

                Date date=new Date();
                String useragent=request.getHeader("User-Agent");

                Statistic statistic=new Statistic();
                statistic.setDate(date);
                statistic.setInfo(useragent);
                statistic.setQuantity(users.size());
                HibernateUtil.addStatistic(statistic);

               
               //send response
               getServletContext().getRequestDispatcher("/done.jsp").forward(request, response);
               
    };
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    };
    

}

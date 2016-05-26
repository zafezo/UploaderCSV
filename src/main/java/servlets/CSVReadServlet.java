/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import data.ParserCSV;
import java.io.IOException;
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
public class CSVReadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Get file
        Part file = request.getPart("table");
        
        //Parse to JsonArray and add as "users" object 
        JsonArray users = ParserCSV.parse(file.getInputStream());
        JsonObject jo = new JsonObject();
        jo.add("users", users);
        
        //send response
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(new Gson().toJson(jo));
    }
}

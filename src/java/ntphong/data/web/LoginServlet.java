/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ntphong.data.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ntphong.data.dao.Database;
import ntphong.data.models.User;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Login Page");
        request.getRequestDispatcher("./views/login.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailphone = request.getParameter("emailphone");
        String password = request.getParameter("password");
        User user = Database.getUserDao().findUser(emailphone, password);
//        System.out.println("check user: " + user.getEmail());
//        System.out.println("check user: " + user.getPassword());
        if (user == null) {
            request.getSession().setAttribute("error_login", "You information is incorrect");
            response.sendRedirect("login");
        } else {
            // auth = 1 - n => shop
            //auth = 0 => client
            if (user.getAuthentication() != 0) {
                request.getSession().setAttribute("user", user);
                request.getSession().removeAttribute("error_login");
                response.sendRedirect("admin");
            } else {
                request.getSession().setAttribute("user", user);
                request.getSession().removeAttribute("error_login");
                response.sendRedirect("home");
            }
        }
        
    }

   

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ntphong.data.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import ntphong.data.dao.Database;
import ntphong.data.models.Order;
import ntphong.data.models.User;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get shop Id
        User user = (User) request.getSession().getAttribute("user");
        int shop_id = user.getAuthentication();
        
        List<Order> listOrder = Database.getOrderDao().findOrderByShop(shop_id);
        request.setAttribute("listOrder", listOrder);
        
        request.setAttribute("title", "Admin Page");
        request.getRequestDispatcher("./views/admin_home.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
}

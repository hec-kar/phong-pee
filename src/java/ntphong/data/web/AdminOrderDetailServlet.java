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
import java.util.List;
import ntphong.data.dao.Database;
import ntphong.data.models.Order;
import ntphong.data.models.Product;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "AdminOrderDetailServlet", urlPatterns = {"/admin-chitietdonhang"})
public class AdminOrderDetailServlet extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        
        Order order = Database.getOrderDao().findOrder(order_id);
        request.setAttribute("order", order);
        List<Product> listProduct = Database.getProductDao().findByOrder(order_id);
        request.setAttribute("listProduct", listProduct);
        
        request.setAttribute("title", "Order Detail");
        request.getRequestDispatcher("/views/admin_order_detail.jsp").include(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        
        Database.getOrderDao().update(order_id);
        
        response.sendRedirect("admin");
    }

    

}

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
import java.util.ArrayList;
import ntphong.data.dao.Database;
import ntphong.data.models.Product;
import ntphong.data.models.User;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        insertNewOrder(request);
        response.sendRedirect("shopping-cart");
    }
    
    void insertNewOrder(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        int user_id = user.getUser_id();
        String note = request.getParameter("note");
        
        int newOrderId = Database.getOrderDao().insert(user_id, note);
        //get cart
        ArrayList<Product> cart = (ArrayList<Product>) request.getSession().getAttribute("cart");
        
        for (Product pro: cart) {
            Database.getOrderDetailDao().insert(newOrderId, pro.getId(), pro.getQuantity());
        }
        
        if (newOrderId != -1) {
            request.getSession().setAttribute("payment", true);
        }
        request.getSession().removeAttribute("cart");
    }
    
}

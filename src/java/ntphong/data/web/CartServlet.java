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
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import ntphong.data.models.Product;
import ntphong.data.models.User;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/shopping-cart"})
public class CartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("./login");
            return;
        }
        if (request.getParameter("clear" ) !=null) {
            request.getSession().setAttribute("cart", new ArrayList<>());
        }
        request.setAttribute("title", "Shopping Cart Page");
        request.getRequestDispatcher("./views/cart.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateDelete(request, response);
    }
    
    void updateDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        switch (action) {
            case "update":
                doUpdate(request, id_product);
                break;
            case "delete":
                doDelete(request, id_product);
                break;
            default:
                throw new AssertionError();
        }
        
        request.getRequestDispatcher("./views/cart.jsp").include(request, response);
    }
    
    void doUpdate(HttpServletRequest request, int id_product) {
        List<Product> cart = (List<Product>) request.getSession().getAttribute("cart");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        for (Product pro: cart) {
            if (pro.getId() == id_product && quantity > 0) {
                pro.setQuantity(quantity); break;
            }
        }        
        request.getSession().setAttribute("cart", cart);
    }
    
    void doDelete(HttpServletRequest request, int id_product) {
        List<Product> cart = (List<Product>) request.getSession().getAttribute("cart");
        for (Product pro: cart) {
            if (pro.getId() == id_product) {
               cart.remove(pro); break;
            }
        }        
        request.getSession().setAttribute("cart", cart);
    }

}

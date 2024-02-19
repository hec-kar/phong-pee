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
import java.util.ArrayList;
import java.util.List;
import ntphong.data.dao.Database;
import ntphong.data.models.Shop;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Shop> listShop = Database.getShopDao().findAll();
        request.setAttribute("listShop", listShop);

        findShop(request, response);
        
        
        request.setAttribute("title", "Home Page");
        request.getRequestDispatcher("./views/home.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        findShop(request, response);
        
        response.sendRedirect("home");
    }
    
    void findShop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = request.getParameter("query");
        if (query == null) return;
        List<Shop> listShopByQuery = Database.getShopDao().findShopByQuery(query);

        
        if (listShopByQuery == null) {
            request.setAttribute("listShop", new ArrayList<>());
        } else {
            if (listShopByQuery.size() == 1) {
                for (Shop shop : listShopByQuery) {
                    response.sendRedirect("quanan?shop_id=" + shop.getShop_id());
                }
            } else {
                request.setAttribute("listShop", listShopByQuery);
            }
        }

    }
   
}

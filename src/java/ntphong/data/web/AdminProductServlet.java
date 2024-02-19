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
import ntphong.data.models.Product;
import ntphong.data.models.Shop;
import ntphong.data.models.User;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "AdminProductServlet", urlPatterns = {"/admin-quanlymon"})
public class AdminProductServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("./login");
            return;
        }

        updateDelete(request,response);
        getProductOfShop(request);
        
        request.setAttribute("title", "Product Adminstrator");
        request.getRequestDispatcher("/views/admin_product.jsp").include(request, response);
    }
    
    
    private void getProductOfShop(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        int shop_id = user.getAuthentication();
        
        List<Product> listProduct = Database.getProductDao().findByShop(shop_id);
        request.setAttribute("listProduct", listProduct);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        insertNewProduct(request);
        response.sendRedirect("admin-quanlymon");
    }
    
    void insertNewProduct(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        int shop_id = user.getAuthentication();
        String productName = request.getParameter("name");
        String productDesc = request.getParameter("description");
        int productQuantity = Integer.parseInt(request.getParameter("quantity")) ;
        int productType = Integer.parseInt(request.getParameter("type")) ;
        double price = Double.parseDouble(request.getParameter("price")) ;
        Database.getProductDao().insert(productDesc, productName, shop_id, productQuantity, productType, price);
    }
    
    void updateDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            return;
        }
        int id_product = Integer.parseInt(request.getParameter("id"));
        switch (action) {
            case "update":
//                doUpdate(request, id_product);
                break;
            case "delete":
                doDelete(request, id_product);
                response.sendRedirect("admin-quanlymon");
                break;
            
        }
        
    }
    
    void doDelete(HttpServletRequest request, int id_product) {
        Database.getProductDao().delete(id_product);
    }
    
}

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
import ntphong.data.models.User;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "AdminUpdateProductServlet", urlPatterns = {"/admin-quanlymon-update"})
public class AdminUpdateProductServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("./login");
            return;
        }
        getProductOfShop(request);
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("title", "Product Update");
        request.getRequestDispatcher("/views/admin_update_product.jsp").include(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParameter = (String) request.getParameter("product_id");
        System.out.println("check id" + idParameter);
        if (idParameter != null && !idParameter.isEmpty()) {
            int id_product = Integer.parseInt(idParameter);
            doUpdate(request, id_product);
        }
        response.sendRedirect("admin-quanlymon");
    }

    void getProductOfShop(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        int shop_id = user.getAuthentication();
        List<Product> listProduct = Database.getProductDao().findByShop(shop_id);
        request.setAttribute("listProduct", listProduct);
    }
    
    void doUpdate(HttpServletRequest request, int id_product) {
        String productName = request.getParameter("name");
        String productDesc = request.getParameter("description");
        int productQuantity = Integer.parseInt(request.getParameter("quantity")) ;
        int productType = Integer.parseInt(request.getParameter("type")) ;
        double price = Double.parseDouble(request.getParameter("price")) ;
        Database.getProductDao().update(id_product, productName, productDesc, productQuantity, productType, price);
        System.out.println("check infor::" + productName);
    }

}

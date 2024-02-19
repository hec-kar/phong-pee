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
import java.util.List;
import ntphong.data.dao.Database;
import ntphong.data.models.Product;
import ntphong.data.models.Shop;
import ntphong.data.models.User;

/**
 *
 * @author ngoti
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/quanan"})
public class ProductServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getShopDetail(request, response);
        getProductOfShop(request, response);
        addProductToCart(request);
//        request.getRequestDispatcher("./views/product_page.jsp").include(request, response);
        request.getRequestDispatcher("./views/product_page.jsp").include(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void getShopDetail(HttpServletRequest request, HttpServletResponse response) {
        int shop_id = Integer.parseInt(request.getParameter("shop_id"));
        Shop shop = Database.getShopDao().find(shop_id);
        request.setAttribute("shop", shop);
    }
    
    private void getProductOfShop(HttpServletRequest request, HttpServletResponse response) {
        int shop_id = Integer.parseInt(request.getParameter("shop_id"));
        List<Product> listProduct = Database.getProductDao().findByShop(shop_id);
        request.setAttribute("listProduct", listProduct);
    }
    
    void addProductToCart(HttpServletRequest request) {
        int id_product;
        try {
            id_product = Integer.parseInt(request.getParameter("id_product"));
        } catch (Exception e) {
            id_product = 0;
        }
        System.out.println("check id product::" + id_product );
        List<Product> cart = (List<Product>)request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        if (id_product > 0) {
            Product product = Database.getProductDao().findProduct(id_product);
            
            boolean isProductInCart = false;
            for (Product pro: cart) {
                if (pro.getId() == id_product) {
                    pro.setQuantity(pro.getQuantity() + 1);
                    isProductInCart = true;
                }
            }
            if (!isProductInCart) {
                cart.add(product);
            }
        }
        request.getSession().setAttribute("cart", cart);
    }
}

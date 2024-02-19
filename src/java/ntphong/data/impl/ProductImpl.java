/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ntphong.data.dao.ProductDao;
import ntphong.data.driver.MySQLDriver;
import ntphong.data.models.Product;
import ntphong.data.models.Shop;

/**
 *
 * @author ngoti
 */
public class ProductImpl implements ProductDao{
    Connection con = MySQLDriver.getConnection();

    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> findByShop(int shop_id) {
        try {
            List<Product> listProduct = new ArrayList<>();
            String sql = "select * from products where shop_id = " + shop_id;
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("name");
                String description = rs.getString("decription");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int type = rs.getInt("type");
                String image = rs.getString("image");
                Product product = new Product(id, name, description, shop_id, quantity, price, type, image);
                listProduct.add(product);
            }
            return listProduct;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public boolean insert(String name, String description,int shop_id ,int quantity, int type, double price) {
        try {
            String sql = "insert into products(name, decription, shop_id, quantity, price, type) values (?,?,?,?,?,?)";
            PreparedStatement sttm = con.prepareStatement(sql);
            //set arguments
            sttm.setString(1, name);
            sttm.setString(2, description);
            sttm.setInt(3, shop_id);
            sttm.setInt(4, quantity);
            sttm.setDouble(5, price);
            sttm.setInt(6, type);
            int rowsAffected = sttm.executeUpdate();

            // Check if any rows were affected
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(int product_id,String name, String description, int quantity, int type, double price) {
        try {
            String sql = "Update products set name = ?, decription=?, quantity=?, type=?, price=? where product_id =? ";
            PreparedStatement sttm = con.prepareStatement(sql);
            //set arguments
            sttm.setString(1, name);
            sttm.setString(2, description);
            sttm.setInt(3, quantity);
            sttm.setInt(4, type);
            sttm.setDouble(5, price);
            sttm.setInt(6, product_id);
            int rowsAffected = sttm.executeUpdate();

            // Check if any rows were affected
            System.out.println("check rows::" + rowsAffected );
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM products WHERE product_id = ?";
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, id);
            int rowsAffected = sttm.executeUpdate();
            // Check if any rows were affected
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product findProduct(int id) {
        String sql = "select * from products where product_id = ?";
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) return new Product(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findByOrder(int order_id) {
        
        try {
            List<Product> listProduct = new ArrayList<>();
            String sql = "CALL GetProductDetails(?)";
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, order_id);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String name = rs.getString("name");
                String description = rs.getString("decription");
                int shop_id = rs.getInt("shop_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int type = rs.getInt("type");
                String image = rs.getString("image");
                Product product = new Product(product_id, name, description, shop_id, quantity, price, type, image);
                listProduct.add(product);
            }
            return listProduct;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

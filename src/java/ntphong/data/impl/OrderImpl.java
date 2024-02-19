/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ntphong.data.dao.OrderDao;
import ntphong.data.driver.MySQLDriver;
import ntphong.data.models.Order;

/**
 *
 * @author ngoti
 */
public class OrderImpl implements OrderDao{
    Connection con = MySQLDriver.getConnection();
    @Override
    public List<Order> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(int user_id, String note) {
        String sql = "insert into orders(user_id, note, date, due_time) values(?,?,?,?)";
        try {
            //date now sql
            LocalDate curDate = LocalDate.now();
            Date sqlDate = Date.valueOf(curDate);
            // set sttm
            PreparedStatement sttm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sttm.setInt(1, user_id);
            sttm.setString(2, note);
            sttm.setDate(3, sqlDate);
            sttm.setInt(4, 30);
            
            int affectedRows = sttm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }
            
            try (ResultSet generatedKey = sttm.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    int orderId = generatedKey.getInt(1);
                    return orderId;
                } else {
                    throw new SQLException("Crating order failed");
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean update(int order_id) {
        try {
            String sql = "update orders set status = 1 where order_id = ?";
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, order_id);
            sttm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int order_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Order findOrder(int order_id) {
        String sql = "SELECT * FROM orders where order_id = ?";
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, order_id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                Order order = new Order(rs);
                return order;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public List<Order> findOrderByShop(int shop_id) {
        String sql = "CALL GetOrdersByShopId(?)";
        try {
            List<Order> listOrder = new ArrayList<>();
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, shop_id);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs);
                listOrder.add(order);
            }
            return listOrder;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}

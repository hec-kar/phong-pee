/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import ntphong.data.dao.OrderDetailDao;
import ntphong.data.driver.MySQLDriver;
import ntphong.data.models.OrderDetail;

/**
 *
 * @author ngoti
 */
public class OrderDetailImpl implements OrderDetailDao{
    Connection con = MySQLDriver.getConnection();
    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public int insert(int order_id, int product_id, int quantity) {
        String sql = "insert into orders_detail(orders_id, product_id, quantity) values(?,?,?)";
        try {
            // set sttm
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setInt(1, order_id);
            sttm.setInt(2, product_id);
            sttm.setInt(3, quantity);
            
            int affectedRows = sttm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order detail failed, no rows affected.");
            }
            return 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(int order_id) {
        return false;
    }

    @Override
    public OrderDetail findOrder(int order_id) {
        return null;
    }

    @Override
    public List<OrderDetail> findOrderDetail() {
        
        return null;
        
    }
    
}

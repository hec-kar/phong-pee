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
import ntphong.data.dao.ShopDao;
import ntphong.data.driver.MySQLDriver;
import ntphong.data.models.Shop;

/**
 *
 * @author ngoti
 */
public class ShopImpl implements ShopDao{
    Connection con = MySQLDriver.getConnection();
    @Override
    public List<Shop> findAll() {
        try {
            List<Shop> listShop = new ArrayList<>();
            String sql = "select * from shops";
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                Shop shop = new Shop(rs);
                listShop.add(shop);
            }
            return listShop;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(Shop shop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Shop shop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Shop find(int id) {
         try {
            String sql = "select * from shops where shop_id = " + id;
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                Shop shop = new Shop(rs);
                return shop;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Shop> findShopByQuery(String input) {
        try {
            List<Shop> listShop = new ArrayList<>();
            String sql = "SELECT * FROM shops WHERE shops.name LIKE ?";
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setString(1, "%" + input + "%");
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                Shop shop = new Shop(rs);
                listShop.add(shop);
            }
            return listShop;
        } catch (SQLException ex) {
            Logger.getLogger(ShopImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

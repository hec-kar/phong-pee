/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ntphong.data.dao.UserDao;
import ntphong.data.driver.MySQLDriver;
import ntphong.data.models.User;
import ntphong.utils.API;

/**
 *
 * @author ngoti
 */
public class UserImpl implements UserDao{
    Connection con = MySQLDriver.getConnection();
    @Override
    public User findUser(String emailphone, String password) {
        String sql;
        if (emailphone.contains("@")) {
            sql = "SELECT * FROM users WHERE email = '" + emailphone + "' and password = '" + API.getMd5(password) + "'";
        } else {
            sql = "SELECT * FROM users WHERE phone = '" + emailphone + "' and password = '" + API.getMd5(password) + "'";
        }
        PreparedStatement sttm;
        try {
            sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) return new User(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }

    @Override
    public User findUser(String emailphone) {
        String sql;
        if (emailphone.contains("@")) {
            sql = "SELECT * FROM users WHERE email = '" + emailphone+ "'" ;
        } else {
            sql = "SELECT * FROM users WHERE phone = '" + emailphone+ "'";
        }
        PreparedStatement sttm;
        try {
            sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) return new User(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }

    @Override
    public void insertUser(String name, String email, String phone, String password) {
        String sql  = "insert into users(name, email, phone, password, authentication) "
                + "values ('"+ name+"','"+email+"','"+phone+"','"+password+"',0)";
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

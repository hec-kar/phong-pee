/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.models;

import java.sql.ResultSet;
import java.sql.SQLException;


public class User {
    private int user_id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private int authentication;
   

    public User() {
    }

    public User(int user_id, String name ,String email, String phone, String password, int authentication) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.authentication = authentication;
    }
   
    public User(ResultSet rs) throws SQLException {
        this.user_id = rs.getInt("user_id");
        this.name = rs.getString("name");
        this.email = rs.getString("email");
        this.phone = rs.getString("phone");
        this.password = rs.getString("password");
        this.authentication = rs.getInt("authentication");
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthentication() {
        return authentication;
    }

    public void setAuthentication(int authentication) {
        this.authentication = authentication;
    }

    
}

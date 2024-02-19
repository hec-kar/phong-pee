/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ngoti
 */
public class Shop {
    private int shop_id;
    private String name;
    private String address;
    private String image;

    public Shop() {
    }

    public Shop(int shop_id, String name, String address, String image) {
        this.shop_id = shop_id;
        this.name = name;
        this.address = address;
        this.image = image;
    }
    
    public Shop(ResultSet rs) throws SQLException {
        this.shop_id = rs.getInt("shop_id");
        this.name = rs.getString("name");
        this.address = rs.getString("address");
        this.image = rs.getString("image");
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}

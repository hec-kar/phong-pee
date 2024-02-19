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
public class Product {
    private int id;
    private String name;
    private String description;
    private int shop_id;
    private int quantity;
    private double price;
    private int type;
    private String image;

    public Product() {
    }

    public Product(int id, String name, String description, int shop_id, int quantity, double price, int type, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shop_id = shop_id;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.image = image;
    }
    
    public Product(ResultSet rs) throws SQLException {
        this.id = rs.getInt("product_id");
        this.name = rs.getString("name");
        this.description = rs.getString("decription");
        this.shop_id = rs.getInt("shop_id");
        this.quantity = 1;
        this.price = rs.getDouble("price");
        this.type = rs.getInt("type");
        this.image = rs.getString("image");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}

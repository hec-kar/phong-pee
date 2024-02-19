/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ntphong.data.dao;

import java.util.List;
import ntphong.data.models.Product;

/**
 *
 * @author ngoti
 */
public interface ProductDao {
    public List<Product> findAll();
    public List<Product> findByShop(int shop_id);
    public List<Product> findByOrder(int order_id);
    public boolean insert(String name, String description,int shop_id ,int quantity, int type, double price);
    public boolean update(int product_id,String name, String description, int quantity, int type, double price);
    public boolean delete(int id);
    public Product findProduct(int id);
}

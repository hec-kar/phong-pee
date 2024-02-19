/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ntphong.data.dao;

import java.util.List;
import ntphong.data.models.Order;

/**
 *
 * @author ngoti
 */
public interface OrderDao {
    public List<Order> findAll();
    public List<Order> findOrderByShop(int shop_id);
    public int insert(int user_id, String note);
    public boolean update(int oder_id);
    public boolean delete(int order_id);
    public Order findOrder(int order_id);
}

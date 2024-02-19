/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ntphong.data.dao;

import java.util.List;
import ntphong.data.models.OrderDetail;

/**
 *
 * @author ngoti
 */
public interface OrderDetailDao {
    public List<OrderDetail> findAll();
    public List<OrderDetail> findOrderDetail();
    public int insert(int order_id, int product_id, int quantity);
    public boolean update(OrderDetail orderDetail);
    public boolean delete(int order_id);
    public OrderDetail findOrder(int order_id);
}

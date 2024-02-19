/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.dao;

import ntphong.data.impl.OrderDetailImpl;
import ntphong.data.impl.OrderImpl;
import ntphong.data.impl.ProductImpl;
import ntphong.data.impl.ShopImpl;
import ntphong.data.impl.UserImpl;

/**
 *
 * @author ngoti
 */
public class Database {
    public static ShopDao getShopDao() {
        return new ShopImpl();
    }
    
    public static ProductDao getProductDao() {
        return new ProductImpl();
    }
    
    public static UserDao getUserDao() {
        return new UserImpl();
    }
    
    public static OrderDao getOrderDao() {
        return new OrderImpl();
    }
    
    public static OrderDetailDao getOrderDetailDao() {
        return new OrderDetailImpl();
    }
}

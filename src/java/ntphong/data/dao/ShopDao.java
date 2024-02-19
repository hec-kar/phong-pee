/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.dao;
import java.util.List;
import ntphong.data.models.Shop;
/**
 *
 * @author ngoti
 */
public interface ShopDao {
    public List<Shop> findAll();
    public boolean insert(Shop shop);
    public boolean update(Shop shop);
    public boolean delete(int id);
    public Shop find(int id);
    public List<Shop> findShopByQuery(String input);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ntphong.utils.Constants;

/**
 *
 * @author ngoti
 */
public class MySQLDriver {
    public static Connection getConnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Nap driver!");
            try {
                return DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
            } catch (SQLException ex) {
                Logger.getLogger(MySQLDriver.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

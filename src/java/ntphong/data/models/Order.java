/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ntphong.data.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ngoti
 */
public class Order {
    private int order_id;
    private int user_id;
    private String note;
    private Date date;
    private int due_time;
    private int status;

    public Order() {
    }

    public Order(int order_id, int user_id, String note, Date date, int due_time, int status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.note = note;
        this.date = date;
        this.due_time = due_time;
        this.status = status;
    }
    
    
    public Order(ResultSet rs) throws SQLException {
        this.order_id = rs.getInt("order_id");
        this.user_id = rs.getInt("user_id");
        this.note = rs.getString("note");
        this.date = rs.getDate("date");
        this.due_time = rs.getInt("due_time");
        this.status = rs.getInt("status");
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDue_time() {
        return due_time;
    }

    public void setDue_time(int due_time) {
        this.due_time = due_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}

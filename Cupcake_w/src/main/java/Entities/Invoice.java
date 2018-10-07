/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.sql.Date;
import java.util.List;

/**
 *
 * @author jamal_ahmed
 */
public class Invoice {
    private int order_no;
    private int user_id;
    private int bottom_id;
    private int topping_id;
    private double price;
    private int quantity;
    private Date date;

    public Invoice(int order_no, int user_id, int bottom_id, int topping_id, double price, int quantity, Date date) {
        this.order_no = order_no;
        this.user_id = user_id;
        this.bottom_id = bottom_id;
        this.topping_id = topping_id;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

  
public Invoice(){
    
}

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public void setBottom_id(int bottom_id) {
        this.bottom_id = bottom_id;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(int topping_id) {
        this.topping_id = topping_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "order_no=" + order_no + ", user_id=" + user_id + ", bottom_id=" + bottom_id + ", topping_id=" + topping_id + ", price=" + price + ", quantity=" + quantity + ", date=" + date + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author jamal_ahmed
 */
public class Shoppingcart {
    private int user_id;
    private int bottom_id;
    private int topping_id;
    private double price;
    private int quantity;
    private int delete;

    public Shoppingcart(int user_id, int bottom_id, int topping_id, double price, int quantity, int delete) {
        this.user_id = user_id;
        this.bottom_id = bottom_id;
        this.topping_id = topping_id;
        this.price = price;
        this.quantity = quantity;
        this.delete = delete;
    }

    
    
    public Shoppingcart(){
        
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

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Shoppingcart{" + "user_id=" + user_id + ", bottom_id=" + bottom_id + ", topping_id=" + topping_id + ", price=" + price + ", quantity=" + quantity + ", delete=" + delete + '}';
    }

    
    
}

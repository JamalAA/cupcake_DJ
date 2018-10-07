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
public class User {

    private int user_id;
    private String username;
    private String password;
    private String email;
    private double balance;
    private int Admin;

    public User(int user_id, String username, String password, String email, double balance, int Admin) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.Admin = Admin;
    }

    public User() {
    }

   

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAdmin() {
        return Admin;
    }

    public void setAdmin(int Admin) {
        this.Admin = Admin;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email + ", balance=" + balance + ", Admin=" + Admin + '}';
    }

}

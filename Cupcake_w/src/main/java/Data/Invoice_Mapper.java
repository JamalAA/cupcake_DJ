/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.DBConnector.getConnection;
import Entities.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jamal_ahmed
 */
public class Invoice_Mapper {

    public ArrayList<Invoice> getInvoiceByUserId() {
        ArrayList<Invoice> iv = new ArrayList();

        return iv;
    }

    public void makeInvoicepByUserId(int userid) throws SQLException {
        Scart_Mapper sm = new Scart_Mapper();
        int orderno = this.orderno();

        for (int i = 0; i < sm.listOfshoppingCartByUserId(userid).size(); i++) {
            Invoice iv = new Invoice();
            iv.setUser_id(sm.listOfshoppingCartByUserId(userid).get(i).getUser_id());
            iv.setTopping_id(sm.listOfshoppingCartByUserId(userid).get(i).getTopping_id());
            iv.setQuantity(sm.listOfshoppingCartByUserId(userid).get(i).getQuantity());
            iv.setPrice(sm.listOfshoppingCartByUserId(userid).get(i).getPrice());
            iv.setBottom_id(sm.listOfshoppingCartByUserId(userid).get(i).getBottom_id());

            this.makeInvoice(iv.getUser_id(), iv.getBottom_id(), iv.getTopping_id(), iv.getQuantity(), iv.getPrice(), orderno);

        }
        sm.deleteItemsByUserId(userid);

    }

    private void makeInvoice(int userid, int bottom, int topping, int qty, double price, int orderno) throws SQLException {

        Connection conn = DBConnector.getConnection();
        String insertinvoice = "INSERT INTO invoice (`user_id`, `bottom_id`, `topping_id`, ` price` ,`quantity`,`order_no`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement invoicePstmt = conn.prepareStatement(insertinvoice);

        invoicePstmt.setInt(1, userid);
        invoicePstmt.setInt(2, bottom);
        invoicePstmt.setInt(3, topping);
        invoicePstmt.setDouble(4, price);
        invoicePstmt.setInt(5, qty);
        invoicePstmt.setInt(6, orderno);

        invoicePstmt.executeUpdate();

    }

    private int randomOrderNo() {

        Random rm = new Random();
        int ran = rm.nextInt(999) + 100;

        return ran;
    }

    private int orderno() throws SQLException {
        String sql = "SELECT order_no FROM invoice;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        boolean exists = true;

        int a = 0;

        while (exists) {
            // nyt genereet nr.
            int myRan = this.randomOrderNo();
            while (rs.next()) {
                int order_No = rs.getInt("order_no");

                if (order_No == myRan) {
                    exists = true;

                } else {
                    exists = false;
                    a = myRan;
                    return myRan;
                }

            }

        }
        return a;
    }

    public double checkBalanceByUserId(int userid) throws SQLException {

        String sql = "SELECT * FROM user;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            if (userid == rs.getInt("user_id") && this.totalprice(userid) < rs.getDouble("balance")) {

                double newBalance = rs.getDouble("balance") - this.totalprice(userid);
                
                Connection conn = DBConnector.getConnection();
                String insertbalance = "update user set balance = "+ newBalance +" where user_id = "+userid;
                PreparedStatement balancePstmt = conn.prepareStatement(insertbalance);
                balancePstmt.executeUpdate();
                
                return newBalance;
            }

        }
        return -0;
    }

    private double totalprice(int userid) throws SQLException {
        String sql = "SELECT * FROM shoppingcart;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        double totalprice = 0;

        while (rs.next()) {
            if (userid == rs.getInt("user_id") && rs.getInt("isdelete") == 0) {
                
                totalprice = totalprice + rs.getInt("price");
               
                
            }

        }

        return totalprice;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.DBConnector.getConnection;
import Entities.Shoppingcart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jamal_ahmed
 */
public class Scart_Mapper {

    public ArrayList<Shoppingcart> listOfshoppingCartByUserId(int user_id) throws SQLException {
        ArrayList<Shoppingcart> scart = new ArrayList();

        String sql = "SELECT * FROM shoppingcart;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            String userid = rs.getString("user_id");
            int _userid = Integer.parseInt(userid);
            String _delete = rs.getString("isdelete");
            int delete = Integer.parseInt(_delete);
            Shoppingcart _scart = new Shoppingcart();

            if (_userid == user_id & delete == 0) {

                String userid_ = rs.getString("user_id");
                int userid__ = Integer.parseInt(userid_);
                String delete_ = rs.getString("isdelete");
                int delete__ = Integer.parseInt(delete_);
                String _bottom = rs.getString("bottom_id");
                int bottom = Integer.parseInt(_bottom);
                String _topping = rs.getString("topping_id");
                int topping = Integer.parseInt(_topping);
                String _qty = rs.getString("quantity");
                int qty = Integer.parseInt(_qty);
                String _price = rs.getString("price");
                int price = Integer.parseInt(_price);

                _scart.setUser_id(userid__);
                _scart.setDelete(delete__);
                _scart.setBottom_id(bottom);
                _scart.setQuantity(qty);
                _scart.setTopping_id(topping);
                _scart.setPrice(price);

                scart.add(_scart);
            }

        }

        return scart;
    }

    public void addToShoppingCart(int user_id, int bottom_id, int topping_id, int qty) throws SQLException {
        

        double totalPrice = 0;
        double price1 = 0;
        double price2 = 0;

        Bottom_Mapper bm = new Bottom_Mapper();
        Topping_Mapper tm = new Topping_Mapper();

        price1 = bm.bottomPriceById(bottom_id);
        price2 = tm.toppingPriceById(topping_id);
        totalPrice = qty * (price1 + price2);
        
        

        Connection conn = DBConnector.getConnection();
        String insertCart = "Insert Into shoppingcart (user_id, bottom_id, topping_id, quantity,price) VALUES (?, ?, ?, ?,?)";
        PreparedStatement cartPstmt = conn.prepareStatement(insertCart);

        cartPstmt.setInt(1, user_id);
        cartPstmt.setInt(2, bottom_id);
        cartPstmt.setInt(3, topping_id);
        cartPstmt.setInt(4, qty);
        cartPstmt.setDouble(5, totalPrice);

        cartPstmt.executeUpdate();

    }

    public void deleteItemsByUserId(int user_id) throws SQLException {

        String sql = "SELECT * FROM shoppingcart;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            String userid = rs.getString("user_id");
            int _userid = Integer.parseInt(userid);
            String _delete = rs.getString("isdelete");
            int delete = Integer.parseInt(_delete);

            if (_userid == user_id & delete == 0) {

                Connection conn = DBConnector.getConnection();
                String insertCart = "update shoppingcart set isdelete = 1 where user_id = "+user_id;
                PreparedStatement cartPstmt = conn.prepareStatement(insertCart);
                cartPstmt.executeUpdate();
            }
        }

    }
    
    public void delete(int userid, int bottomid, int toppingid, int qty, double price) throws SQLException{
         String sql = "SELECT * FROM shoppingcart;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        
        while (rs.next()) {
           

            if (userid == rs.getInt("user_id") & rs.getInt("isdelete") == 0 & rs.getInt("bottom_id") == bottomid & rs.getInt("topping_id") == toppingid & rs.getInt("quantity") == qty & rs.getDouble("price") == price) {

                Connection conn = DBConnector.getConnection();
                String insertCart = "update shoppingcart set isdelete = 1 where user_id = "+userid+" && bottom_id= "+bottomid+" && topping_id = "+toppingid+"  && quantity = "+qty+" && price ="+price ;
                PreparedStatement cartPstmt = conn.prepareStatement(insertCart);
                cartPstmt.executeUpdate();
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.DBConnector.getConnection;
import Entities.Topping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jamal_ahmed
 */
public class Topping_Mapper {
     public ArrayList<Topping> getAllBottom() throws SQLException {

        ArrayList<Topping> topping = new ArrayList();

        String sql = "SELECT * FROM topping;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            Topping tp = new Topping();

            String name = rs.getString("name");
            String id = rs.getString("topping_id");
            String price = rs.getString("price");

            int bt_id = Integer.parseInt(id);
            double bt_price = Double.parseDouble(price);

            tp.setId(bt_id);
            tp.setName(name);
            tp.setPrice(bt_price);

            topping.add(tp);
        }

        return topping;
    }

    public String ToppingNameById (int id) throws SQLException{
        Topping topping = new Topping();
        
        String sql = "SELECT * FROM topping;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        
        while (rs.next()) {            
            
            String s_id = rs.getString("topping_id");
            int i_id = Integer.parseInt(s_id);
            if (i_id == id) {
                String name = rs.getString("name");
                topping.setName(name);
            }
            
        }
        

        
        return topping.getName();
    }
    
      public int toppingIdByName(String topping_name) throws SQLException {
        Topping topping = new Topping();

        String sql = "SELECT * FROM topping;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {

            String t_name = rs.getString("name");
            
            if (topping_name.equalsIgnoreCase(t_name)) {
                
                topping.setId(rs.getInt("topping_id"));
            }

        }

        return topping.getId();
    }
    
    public double toppingPriceById(int id) throws SQLException{
        Topping topping = new Topping();
            
        String sql = "SELECT * FROM topping;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            String topping_id = rs.getString("topping_id");
            int _topping_id = Integer.parseInt(topping_id);
            
            if (_topping_id == id) {
                String _price = rs.getString("price");
                int price = Integer.parseInt(_price);
                
                topping.setPrice(price);
                
            }
        }
        
        
        return topping.getPrice();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.DBConnector.getConnection;
import Entities.Bottom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamal_ahmed
 */
public class Bottom_Mapper {

    public ArrayList<Bottom> getAllBottom() throws SQLException {

        ArrayList<Bottom> bottom = new ArrayList();

        String sql = "SELECT * FROM bottom;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            Bottom bt = new Bottom();

            String name = rs.getString("name");
            String id = rs.getString("bottom_id");
            String price = rs.getString("price");

            int bt_id = Integer.parseInt(id);
            double bt_price = Double.parseDouble(price);

            bt.setId(bt_id);
            bt.setName(name);
            bt.setPrice(bt_price);

            bottom.add(bt);
        }

        return bottom;
    }

    public String BottomNameById(int id) throws SQLException {
        Bottom bottom = new Bottom();

        String sql = "SELECT * FROM bottom;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {

            String s_id = rs.getString("bottom_id");
            int i_id = Integer.parseInt(s_id);
            if (i_id == id) {
                String name = rs.getString("name");
                bottom.setName(name);
            }

        }

        return bottom.getName();
    }
    
     public int BottomIdByName(String bottom_name) throws SQLException {
        Bottom bottom = new Bottom();

        String sql = "SELECT * FROM bottom;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {

            String b_name = rs.getString("name");
            
            if (bottom_name.equalsIgnoreCase(b_name)) {
                
                bottom.setId(rs.getInt("bottom_id"));
            }

        }

        return bottom.getId();
    }
    
    
    
    
    
    public double bottomPriceById(int id) throws SQLException {
        Bottom bottom = new Bottom();

        String sql = "SELECT * FROM bottom;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {

           String id_ = rs.getString("bottom_id");
           int _id = Integer.parseInt(id_);
           
            if (id == _id) {
                
           String id_1 = rs.getString("price");
           int id_2 = Integer.parseInt(id_1);
           bottom.setPrice(id_2);
            }

        }

        return bottom.getPrice();

    }

}

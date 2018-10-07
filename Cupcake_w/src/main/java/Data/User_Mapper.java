/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.DBConnector.getConnection;
import Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jamal_ahmed
 */
public class User_Mapper {
      public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList();
        String sql = "SELECT * FROM user;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String userid = rs.getString("user_id");
            int _userid = Integer.parseInt(userid);
            String email = rs.getString("email");
            String balance = rs.getString("balance");
            double _balance = Double.parseDouble(balance);
            String admin = rs.getString("isAdmin");
            int _admin = Integer.parseInt(admin);
            User userBox = new User();
            userBox.setUsername(username);
            userBox.setEmail(email);
            userBox.setPassword(password);
            userBox.setBalance(_balance);
            userBox.setUser_id(_userid);
            userBox.setAdmin(_admin);

            users.add(userBox);
        }
        return users;
    }
      
      
          public User userIdentify (String userName, String password) throws SQLException {

        User user = new User();

        String sql = "SELECT * FROM user;";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        
        while (rs.next()) {
            String nUsername = rs.getString("username");
            String nPassword = rs.getString("password");
            if (userName.equalsIgnoreCase(nUsername) && password.equalsIgnoreCase(nPassword)) {
                
                String _id = rs.getString("user_id");
                int id = Integer.parseInt(_id);
                user.setUser_id(id);
                
                String u_name = rs.getString("username");
                user.setUsername(u_name);
                
                String _password = rs.getString("password");
                user.setPassword(_password);
                
                String _balance = rs.getString("balance");
                double balance = Double.parseDouble(_balance);
                user.setBalance(balance);
               
                String _isAdmin = rs.getString("isAdmin");
                int Admin = Integer.parseInt(_isAdmin);
                user.setAdmin(Admin);
                
                String email = rs.getString("email");
                user.setEmail(email);
        
                 return user;
            }
            
        }
        return null;
    }
          
         public void createUser(String username, String password, String email, double balance) throws SQLException{
        
        double b = balance;
        String _balance = String.valueOf(b);
        
        Connection conn = DBConnector.getConnection();
        String insertUser = "Insert Into user (username, password, email, balance) VALUES (?, ?, ?, ?)";
        PreparedStatement userPstmt = conn.prepareStatement(insertUser);
        ResultSet rs = null;
        userPstmt.setString(1, username);
        userPstmt.setString(2, password);
        userPstmt.setString(3, email);
        userPstmt.setString(4, _balance);
        userPstmt.executeUpdate();

    }
}

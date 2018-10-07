/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Entities.Invoice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jamal_ahmed
 */
public class DBConnector {
     private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://207.154.204.127:3306/cupcake";
    private static final String USER = "jamal";
    private static final String PASSWORD = "abc123123";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //se hele sekvenst til det gik galt. Dette kan skrives til logfil.
                ex.printStackTrace();
            }
        }
        return conn;
	
	    }

    public static void main(String[] args) throws SQLException {
        Bottom_Mapper bm = new Bottom_Mapper();
        User_Mapper um = new User_Mapper();
        Scart_Mapper sm = new Scart_Mapper();
        Topping_Mapper tm = new Topping_Mapper();
        Invoice_Mapper im = new Invoice_Mapper();
        Scart_Mapper scm = new Scart_Mapper();
//        for (int i = 0; i < sm.listOfshoppingCartByUserId(1).size(); i++) {
//                System.out.println(sm.listOfshoppingCartByUserId(1).get(i));
//        }
     //   im.makeInvoice("1", "2","2", "2","5","3");
       // System.out.println(tm.toppingPriceById(5));
       // sm.addToShoppingCart(2, 3, 3, 2);
        //sm.addToShoppingCart(2, 1, 5, 5);
      //  sm.addToShoppingCart(2, 1, 4, 1);
       // System.out.println(bm.BottomNameById(3));
 //System.out.println(tm.ToppingNameById(4));
        // System.out.println(im.checkBalanceByUserId(2));   
       //sm.deleteItemsByUserId(2);
       //im.makeIovice("1", "2","2");
       //scm.delete(4, 4, 7, 8, 112);
      // im.test("1", "2", "2");
     // im.checkBalanceByUserId(5);
      im.makeInvoicepByUserId(5);
      //  im.makeInvoicepByUserId(2);
      //im.makeInvoice("3", "1", "4","3", "5");
        
      //  System.out.println(im.orderno());
    }
}

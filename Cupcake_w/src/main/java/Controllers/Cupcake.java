/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Data.Bottom_Mapper;
import Data.Scart_Mapper;

import Data.Topping_Mapper;
import Data.User_Mapper;
import Entities.Shoppingcart;
import Entities.User;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jamal_ahmed
 */
public class Cupcake extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        HttpSession session = request.getSession();
        String origin = request.getParameter("origin");
        User_Mapper mpu = new User_Mapper();
        Scart_Mapper scm = new Scart_Mapper();
        User user = (User) (session.getAttribute("user"));
        if (origin != null) {
            switch (origin) {
                case "login":

                    try {
                        // her ved vi brugeren har valgt at han vil logge ind..

                        String userName = request.getParameter("username");
                        String password = request.getParameter("password");

                        if (mpu.userIdentify(userName, password) != null) {
                            session.setAttribute("user", mpu.userIdentify(userName, password));
                            request.getRequestDispatcher("home.jsp").forward(request, response);

                        } else {

                            session.setAttribute("message", "user faild");
                            //session.setMaxInactiveInterval(1);

                            request.getRequestDispatcher("login.jsp").forward(request, response);

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Cupcake.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    break;

                case "signup":

                    String userName = request.getParameter("username");
                    String password = request.getParameter("password");
                    String balance = request.getParameter("balance");
                    String email = request.getParameter("email");

                    if (userName != null && password != null && balance != null && email != null) {

                        double _balance = Double.parseDouble(balance);
                        try {
                            mpu.createUser(userName, password, email, _balance);
                            session.setAttribute("message1", "Login with your new Account");
                            session.setMaxInactiveInterval(10);
                            request.getRequestDispatcher("login.jsp").forward(request, response);

                        } catch (SQLException ex) {
                            Logger.getLogger(Cupcake.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                    break;
                case "Logout":
                    //request.getSession().removeAttribute("user");
                    //request.getRequestDispatcher("login.jsp").forward(request, response);
                  //  break;
                case "addtocart":

                    Bottom_Mapper bm = new Bottom_Mapper();
                    Topping_Mapper tm = new Topping_Mapper();
                    
                    Shoppingcart sc = new Shoppingcart();

                    try {
                        int qty = Integer.parseInt(request.getParameter("qty"));
                        int bt = bm.BottomIdByName(request.getParameter("bottom"));
                        int tp = tm.toppingIdByName(request.getParameter("topping"));
                       
                         scm.addToShoppingCart(user.getUser_id(), bt, tp, qty);
                       
                        request.getRequestDispatcher("order.jsp").forward(request, response);

                    } catch (SQLException ex) {
                        Logger.getLogger(Cupcake.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
               
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

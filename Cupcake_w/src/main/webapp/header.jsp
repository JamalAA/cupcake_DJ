<%-- 
    Document   : header
    Created on : 03-10-2018, 20:43:30
    Author     : jamal_ahmed
--%>


<%@page import="Data.Scart_Mapper"%>
<%@page import="Data.Topping_Mapper"%>
<%@page import="Data.Bottom_Mapper"%>
<%@page import="Entities.User"%>

<%
    User user = (User) (session.getAttribute("user"));
    Bottom_Mapper bm = new Bottom_Mapper();
    Topping_Mapper tp = new Topping_Mapper();
    Scart_Mapper scm = new Scart_Mapper();
%>
<%int rownr = 0;%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cupcake Page</title>
        <link rel="stylesheet" href="css/index.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Cupcakes</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Bottom</th>
                                <th scope="col">Topping</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Price</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%                                  if (user != null) {%>

                            <%

                                for (int i = 0; i < scm.listOfshoppingCartByUserId(user.getUser_id()).size(); i++) {
                                    rownr = rownr + 1;
                                    String b_name = bm.BottomNameById(scm.listOfshoppingCartByUserId(user.getUser_id()).get(i).getBottom_id());
                                    String t_name = tp.ToppingNameById(scm.listOfshoppingCartByUserId(user.getUser_id()).get(i).getTopping_id());

                            %>
                            <tr>
                                <th scope="row"><% out.println(rownr); %></th>
                                <td><% out.println(b_name); %></td>
                                <td><% out.println(t_name); %></td>
                                <td><% out.println(scm.listOfshoppingCartByUserId(user.getUser_id()).get(i).getQuantity()); %></td>
                                <td><% out.println(scm.listOfshoppingCartByUserId(user.getUser_id()).get(i).getPrice() + " $"); %></td>
                                <td><form >
                                        
                                            <input class="btn btn-danger" type="submit" name="origin" value="delete"/>    
                                       
                                    </form></td>
                            </tr>
                            <%  }
                            %>
                            <% }
                            %>                          
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Continue Shopping</button>
                    <button type="button" class="btn btn-primary">Buy now</button>
                </div>
            </div>
        </div>
    </div>

    <%            if (user != null) {

            if (request.getRequestURI().equalsIgnoreCase("/Cupcake/home.jsp")) {%>
    <div style=" background-color: aliceblue; height: 70px" >      
        <div  style=" padding-top: 12px;">
            <ul class="nav nav-pills" >

                <li class="nav-item">
                    <a class="nav-link active" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="order.jsp">Make Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="history.jsp">Purchase history</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="profil.jsp">My Account</a>
                </li>
                <div style="padding-left: 640px">
                    <li class="nav-item">
                        <button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <span class="glyphicon glyphicon-shopping-cart"></span> <a > Shopping Cart <%out.println(rownr);%> </a>
                        </button>
                    </li>
                </div>
                <div style="padding-left: 10px;">
                    <li>
                        <form action="Cupcake" method="POST" id="logout-form">
                            <input class="btn btn-danger" type="submit" name="origin" value="Logout"/>                
                        </form>
                    </li>
                </div>



            </ul>
        </div>       
    </div>
    <% } %>

    <% if (request.getRequestURI().equalsIgnoreCase("/Cupcake/profil.jsp")) {%>
    <div style=" background-color: aliceblue; height: 70px" >      
        <div  style=" padding-top: 12px;">
            <ul class="nav nav-pills" >

                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="order.jsp">Make Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="history.jsp">Purchase history</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="profil.jsp">My Account</a>
                </li>
                <div style="padding-left: 640px">
                    <li class="nav-item">
                        <button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <span class="glyphicon glyphicon-shopping-cart"></span> <a > Shopping Cart <%out.println(rownr);%> </a>
                        </button>
                    </li>
                </div>
                <div style="padding-left: 10px;">
                    <li>
                        <form action="Cupcake" method="POST" id="logout-form">
                            <input class="btn  btn-danger " type="submit" name="origin" value="Logout"/>                
                        </form>
                    </li>
                </div>



            </ul>
        </div>       
    </div>

    <% } %>

    <% if (request.getRequestURI().equalsIgnoreCase("/Cupcake/history.jsp")) {%>
    <div style=" background-color: aliceblue; height: 70px" >      
        <div  style=" padding-top: 12px;">
            <ul class="nav nav-pills" >

                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="order.jsp">Make Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="history.jsp">Purchase history</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="profil.jsp">My Account</a>
                </li>
                <div style="padding-left: 640px">
                    <li class="nav-item">
                        <button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <span class="glyphicon glyphicon-shopping-cart"></span> <a > Shopping Cart <%out.println(rownr);%></a>
                        </button>
                    </li>
                </div>
                <div style="padding-left: 10px;">
                    <li>
                        <form action="Cupcake" method="POST" id="logout-form">
                            <input class="btn  btn-danger" type="submit" name="origin" value="Logout"/>                
                        </form>
                    </li>
                </div>



            </ul>
        </div>       
    </div>

    <% } %>
    <% if (request.getRequestURI().equalsIgnoreCase("/Cupcake/order.jsp")) {%>
    <div style=" background-color: aliceblue; height: 70px" >      
        <div  style=" padding-top: 12px;">
            <ul class="nav nav-pills" >

                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="order.jsp">Make Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="history.jsp">Purchase history</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="profil.jsp">My Account</a>
                </li>

                <div style="padding-left: 640px">
                    <li class="nav-item">
                        <button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <span class="glyphicon glyphicon-shopping-cart"></span> <a > Shopping Cart <%out.println(rownr);%></a>
                        </button>
                    </li>
                </div>


                <div style="padding-left: 10px;">
                    <li>
                        <form action="Cupcake" method="POST" id="logout-form">
                            <input class="btn  btn-danger " type="submit" name="origin" value="Logout"/>                
                        </form>
                    </li>
                </div>


            </ul>
        </div>       
    </div>


    <% } %>


    <% }
    %>


</head>
<body>
    <div class="container">
        <%
            if (!request.getRequestURI().equalsIgnoreCase("/Cupcake/index.jsp") && !request.getRequestURI().equalsIgnoreCase("/Cupcake/") && !request.getRequestURI().equalsIgnoreCase("/Cupcake/login.jsp") && !request.getRequestURI().equalsIgnoreCase("/Cupcake/signup.jsp")) {
                if (user == null) {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }

        %>

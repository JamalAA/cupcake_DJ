<%-- 
    Document   : order
    Created on : 04-10-2018, 15:32:43
    Author     : jamal_ahmed
--%>

<%@page import="Entities.Shoppingcart"%>
<%@ include file = "header.jsp" %>
<% Shoppingcart sc = (Shoppingcart) (session.getAttribute("cart"));%>

<font face = "Comic sans MS" size = "10">Make your farvorit Cupcake</font>

<div style="background-color: aliceblue; width: 500px; margin-left: 50px">

    <form action="Cupcake" method="POST">

        <div class="form-group">
            <label for="bottom">Choose Bottom</label>
            <select class="form-control" id="bottom" name="bottom">


                <%                       for (int i = 0; i < bm.getAllBottom().size(); i++) {
                %>
                <option>   <%out.println(bm.getAllBottom().get(i).getName());%></option>

                <%   }

                %>

            </select>
        </div>
        <div class="form-group">
            <label for="topping">Choose Topping</label>
            <select class="form-control" id="topping" name="topping">

                <%                       for (int i = 0; i < tp.getAllBottom().size(); i++) {
                %>
                <option>   <%out.println(tp.getAllBottom().get(i).getName());%></option>

                <%   }

                %>
            </select>


            <input type="hidden" />
        </div>
        <div class="form-group">
            <label for="qty">Quantity</label>
            <select class="form-control" id="qty" name="qty">
                <%           int a = 0;
           for (int i = 0; i < 20; i++) {
               a = a + 1;%>
                <option>   <%out.println(a);%></option>

                <%   }

                %>

            </select>
        </div>      
        <div style="margin-left: 405px">   
            <input type="hidden" name="origin" value="addtocart"/>
            <button type="submit" class="btn btn-primary ">Add to cart</button>

        </div> 
    </form>  


</div>


<%
    if (sc != null) {


out.println(sc.getBottom_id());
out.println(sc.getQuantity());
out.println(sc.getTopping_id());
out.println(sc.getUser_id());


        }
    

%>

<%@ include file = "footer.jsp" %>

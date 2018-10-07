<%-- 
    Document   : signup
    Created on : 03-10-2018, 21:01:25
    Author     : jamal_ahmed
--%>

<%@ include file = "header.jsp" %>
<%
    
    if (user != null) {
           request.getRequestDispatcher("home.jsp").forward(request, response);
        }
%>


<div style=" margin-top: 30px">  <font face = "Comic sans MS" size = "10">Signup</font>  </div> 
        
      <div class="card" style=" margin-top: 70px">
          <div class="card-body" style="background-color: aliceblue">
 
   
   
   <form action="Cupcake" method="POST">
       <div class="form-row" >
        <div class="form-group col-auto">
            <div class="form-group"  >

                <input type="text" class="form-control" name="username" placeholder="username">
                 <input type="hidden" name="origin" value="signup"/>
            </div>
        </div>

        <div class="form-group">

            <input type="password" class="form-control" name="password"  placeholder="Password">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-auto">
            <div class="form-group">

                <input type="number" class="form-control" name="balance" placeholder="Balance">
            </div>
        </div>
        <div class="form-group">

            <input type="email" class="form-control" aria-describedby="emailHelp" name="email" placeholder="E-mail">
           
        </div>
    </div>
    
        

    <div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>

</form>   
   
  </div>
</div>  
        
 <%@ include file = "footer.jsp" %>
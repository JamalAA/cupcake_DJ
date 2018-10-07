<%-- 
    Document   : index
    Created on : 03-10-2018, 20:41:20
    Author     : jamal_ahmed
--%>

<%@ include file = "header.jsp" %>
<%
    
    if (user != null) {
           request.getRequestDispatcher("home.jsp").forward(request, response);
        }
%>       
<link rel="stylesheet" href="css/frontpage.css" />

    <h1 class="text-center">Cupcake Site</h1>
    <div class="h-100 row align-items-center">
    <div class="col">
        <center><a class="btn btn-primary" href="login.jsp" role="button" >Login</a></center>  
    </div>
    </div>
    <br/>
    <div class="h-100 row align-items-center">
    <div class="col">
        <center><a class="btn btn-primary" href="signup.jsp" role="button">Sign Up</a></center>  
    </div>
    </div>
  
    
        
        
        
<%@ include file = "footer.jsp" %>
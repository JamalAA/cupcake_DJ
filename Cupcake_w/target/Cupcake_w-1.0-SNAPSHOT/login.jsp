<%-- 
    Document   : login
    Created on : 03-10-2018, 21:01:16
    Author     : jamal_ahmed
--%>

<%@ include file = "header.jsp" %>

<%
    
    if (user != null) {
           request.getRequestDispatcher("home.jsp").forward(request, response);
        }
%>
<link rel="stylesheet" href="css/frontpage.css" />

<div class="card" >
          <div class="card-body" style="background-color: aliceblue; ">


<div class="row justify-content-center">
    <font face = "Comic sans MS" size = "10">Cupcake <br></font> 
    <font face = "Comic sans MS" size = "10">Login</font> 
</div>
<div class="row justify-content-center"> 
 
 <div class="row justify-content-center"> 
    <form action="Cupcake" method="POST">
        <div class="form-group row">
            <div class="col-sm-10">
                <% if (session.getAttribute("message") != null) {
                     out.println(session.getAttribute("message"));
                    }
                %>
                
            </div>
              <div class="col-sm-10">
                <% if (session.getAttribute("message1") != null) {
                     out.println(session.getAttribute("message1"));
                    }
                %>
                
            </div>    
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" placeholder="Username">
                <input type="hidden" name="origin" value="login"/>
            </div>
        </div>
        <div class="form-group row">

            <div class="col-sm-10">
                <input type="password" class="form-control"  name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">

            <div class="col-sm-10">
                <input type="submit" class="btn btn-primary"  value="Login">
            </div>
        </div>
    </form>
</div>       
</div>
                </div>       
</div>
<%@ include file = "footer.jsp" %>
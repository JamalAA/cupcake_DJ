<%-- 
    Document   : profil
    Created on : 04-10-2018, 13:37:18
    Author     : jamal_ahmed
--%>

<%@ include file = "header.jsp" %>
<%
String username = user.getUsername().substring(0, 1).toUpperCase() + user.getUsername().substring(1);
%>
<div style="padding: 50px; margin-left: -100px;">
<div class="card border-light mb-3" style="max-width: 18rem;" >
    <div class="card-header" style=" background-color: aliceblue; width: 500px" ><font face = "Comic sans MS" size = "6">Welcome <% out.println(username);%></font></div>
  <div class="card-body">
    
    <form>
        <div class="form-row" style=" width: 500px;">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Username</label>
      <input type="text" class="form-control"  value="<% out.println(username);%>" readonly>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" id="inputPassword4" placeholder="<% out.println(user.getPassword());%>" readonly>
    </div>
  </div>
  <div class="form-row"style=" width: 500px;">
    <div class="form-group col-md-6">
      <label for="inputEmail4">E-mail</label>
      <input type="email" class="form-control"  placeholder="<% out.println(user.getEmail());%>" readonly>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Balance</label>
      <input type="password" class="form-control" id="inputPassword4" placeholder="<% out.println(user.getBalance());%>" readonly>
    </div>
  </div>
 
 
  
</form>
  </div>
</div>
</div>  
      
      
<%@ include file = "footer.jsp" %>

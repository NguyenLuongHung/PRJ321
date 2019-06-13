<%-- 
    Document   : List
    Created on : May 27, 2019, 8:19:44 AM
    Author     : sonnt
--%>

<%@page import="model.Human"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%
          ArrayList<Human> humans = (ArrayList<Human>)request.getAttribute("humans");
      %> 
      <table border="1px">  
          <tr>
              <td>Name</td>
              <td>DOB</td>
              <td>Gender</td>
              <td>Type</td>
          </tr>
          <% for (Human h : humans) {
          %>
          <tr>
              <td><%=h.getName()%></td>
              <td><%=h.getDob()%></td>
              <td>
                  <% if(h.isGender()){%>
                  <img src="../img/male-icon.png" alt=""/>
                  <%} else{%>
                  <img src="../img/female-icon.png" alt=""/>
                  <%}%>
              </td>
              <td><%=h.getType().getTypeName()%></td>
          </tr>
          <%}%>
      </table>  
    </body>
</html>

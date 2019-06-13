<%-- 
    Document   : paging
    Created on : Jun 12, 2019, 8:10:15 AM
    Author     : sonnt
--%>

<%@page import="util.HtmlHelper"%>
<%@page import="model.Human"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/paging.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
      <%
          ArrayList<Human> humans = (ArrayList<Human>)request.getAttribute("humans");
          Integer pageindex = (Integer)request.getAttribute("pageindex");
          Integer totalpage = (Integer)request.getAttribute("totalpage");
      %> 
      <%=HtmlHelper.pager(10, pageindex, totalpage) %>
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
      <%=HtmlHelper.pager(10, pageindex, totalpage) %>
    </body>
</html>

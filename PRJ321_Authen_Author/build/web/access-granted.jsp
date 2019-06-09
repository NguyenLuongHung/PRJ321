<%-- 
    Document   : access-granted
    Created on : Jun 8, 2019, 11:29:18 AM
    Author     : Admin
--%>

<%@page import="com.prj321.model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Account user = (Account)session.getAttribute("user");%>
        <h1>Access-granted</h1>
        <h1>Hello user: <%=user.getUsername()%>  <br>with role_id: <%=user.getRoles().get(0)%></h1>
        <form action="Logout" method="get">
            <input type="submit" value="Log out"/>
        </form>
    </body>
</html>

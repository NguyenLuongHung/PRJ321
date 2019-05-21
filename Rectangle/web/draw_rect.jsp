<%-- 
    Document   : draw_rect
    Created on : May 21, 2019, 7:37:14 PM
    Author     : Admin
--%>

<%@page import="Model.Rectangle"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Rectangle> rectList = (List)request.getAttribute("rectList");%>
        <% for (int i = 0; i < rectList.size(); i++){ %>
        <canvas width="<%= rectList.get(i).getWidth()%>" height="<%= rectList.get(i).getHeight() %>" style="border:2px solid #000000;"></canvas>
        </hr>
        <%}%>
        
    </body>
</html>

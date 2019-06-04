<%-- 
    Document   : login
    Created on : Jun 4, 2019, 7:53:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <% String error = (String)request.getAttribute("error"); %>
        <form action="Login" method="get">
            <table>
                <tr>
                    <td><span>Username: </span></td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td><span>Password: </span></td>
                    <td><input type="text" name="passwd"/></td>
                </tr>
                <tr>
                    <td><span></span></td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
                <% //if (!error.equals("")) {%>
                    <tr>
                        <td><span></span></td>
                        <td><%=error%></td>
                    </tr>
                <%//}%>
            </table>
        </form>
    </body>
</html>

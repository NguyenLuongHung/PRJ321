<%-- 
    Document   : insert
    Created on : May 28, 2019, 5:29:59 PM
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
        
        <form action="/CRUDEmployee/CRUDServlet" method="get">
            <input type="hidden" name="command" value="insert">
            
            <table>
                <tr>
                    <td><span>ID: </span></td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td><span>First Name: </span></td>
                    <td><input type="text" name="firstName"/></td>
                </tr>
                <tr>
                    <td><span>Last Name: </span></td>
                    <td><input type="text" name="lastName"/></td>
                </tr>
                <tr>
                    <td><span>Address: </span></td>
                    <td><input type="text" name="address"/></td>
                </tr>
                <tr>
                    <td><span>Gender: </span></td>
                    <td><input type="text" name="gender"/></td>
                </tr>
                <tr>
                    <td><span>Join Date: </span></td>
                    <td><input type="date" name="joinDate"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Insert"/></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>

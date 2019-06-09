<%-- 
    Document   : login
    Created on : Jun 8, 2019, 11:20:10 AM
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
        <form action="Login" method="get">
            <table>
                <tr>
                    <td><span>Username:</span></td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td><span>Password:</span></td>
                    <td><input type="text" name="password"/></td>
                </tr>
                <tr>
                    <td><span>Remember:</span></td>
                    <td><input type="checkbox" name="remember"/></td>
                </tr>
                <tr>
                    <td><span></span></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>

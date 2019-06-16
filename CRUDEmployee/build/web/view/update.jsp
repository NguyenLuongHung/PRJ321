<%-- 
    Document   : update
    Created on : May 28, 2019, 7:15:08 PM
    Author     : Admin
--%>

<%@page import="com.prj321.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Employee emp = (Employee)request.getAttribute("emp");%>
        <form action="/CRUDEmployee/CRUDServlet" method="get">
            <input type="hidden" name="command" value="update" />
            <input type="hidden" name="oldId" value="<%=emp.getId()%>" />
            <table>
                <tr>
                    <td><span>ID: </span></td>
                    <td><input type="text" value="<%=emp.getId()%>" name="id"/></td>
                </tr>
                <tr>
                    <td><span>First Name: </span></td>
                    <td><input type="text" value="<%=emp.getFirsName()%>" name="firstName"/></td>
                </tr>
                <tr>
                    <td><span>Last Name: </span></td>
                    <td><input type="text" value="<%=emp.getLastName()%>" name="lastName"/></td>
                </tr>
                <tr>
                    <td><span>Address: </span></td>
                    <td><input type="text" value="<%=emp.getAddress()%>" name="address"/></td>
                </tr>
                <tr>
                    <td><span>Gender: </span></td>
                    <td><input type="text" value="<%=emp.getGender()%>" name="gender"/></td>
                </tr>
                <tr>
                    <td><span>Join Date: </span></td>
                    <td><input type="date" value="<%=emp.getJoin_date()%>" name="joinDate"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"/></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>

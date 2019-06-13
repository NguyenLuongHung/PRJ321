<%-- 
    Document   : Insert
    Created on : May 27, 2019, 8:41:12 AM
    Author     : sonnt
--%>

<%@page import="model.HumanType"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<HumanType> types = (ArrayList<HumanType>) request.getAttribute("types");
        %>
    </head>
    <body>
        <form action="insert" method="POST">
            <table> 
                <tr>
                    <td>ID</td>
                    <td> <input type="text" name="id"/> </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td> <input type="text" name="name"/> </td>
                </tr>
                <tr>
                    <td>DOB</td>
                    <td><input type="date" name="dob"/> </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td> 
                        <input type="radio" name="gender" value="male"/>Male
                        <input type="radio" name="gender" value="female"/>Female
                    </td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td> 
                        <select name="typeid" >
                            <%for (HumanType h : types) {
                            %>
                            <option value="<%=h.getTypeID()%>"><%=h.getTypeName()%></option>
                            <%}%>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Save"/> </td>
                </tr>
            </table>
        </form>
    </body>
</html>

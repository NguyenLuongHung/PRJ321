<%-- 
    Document   : employee_list
    Created on : May 28, 2019, 4:52:02 PM
    Author     : Admin
--%>

<%@page import="com.prj321.dao.EmployeeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.prj321.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            EmployeeDAO empDao = new EmployeeDAO();
            List<Employee> empList = empDao.getEmployees();
        %>
        
        <form action="/CRUDEmployee/view/insert.jsp" method="get">
            <input type="submit" value="Insert">
        </form>
        
        <table border="2px">
                <tr>
                    <th><span>ID</span></th>
                    <th><span>First Name</span></th>
                    <th><span>Last Name</span></th>
                    <th><span>Address</span></th>
                    <th><span>Gender</span></th>
                    <th><span>Join Date</span></th>
                    <th><span>Action</span></th>
                </tr>
            <%for (int i = 0; i < empList.size(); i++) { %>

                <tr>
                    <td><%= empList.get(i).getId() %></td>
                    <td><%= empList.get(i).getFirsName()%></td>
                    <td><%= empList.get(i).getLastName()%></td>
                    <td><%= empList.get(i).getAddress() %></td>
                    <td><%= empList.get(i).getGender() %></td>
                    <td><%= empList.get(i).getJoin_date() %></td>
                    <td><a href="/CRUDEmployee/CRUDServlet?command=get&id=<%= empList.get(i).getId()%>">Update</a>
                         | 
                        <a href="/CRUDEmployee/CRUDServlet?command=delete&id=<%= empList.get(i).getId()%>">Delete</a>
                    </td>

                </tr>
            
            <%}%>
            
        </table>
    </body>
</html>

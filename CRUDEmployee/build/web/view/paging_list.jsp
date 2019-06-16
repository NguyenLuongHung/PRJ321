<%-- 
    Document   : paging_list
    Created on : Jun 13, 2019, 8:46:35 PM
    Author     : Admin
--%>

<%@page import="com.prj321.util.Pager"%>
<%@page import="java.util.List"%>
<%@page import="com.prj321.model.Employee"%>
<%@page import="com.prj321.dao.EmployeeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%      
            List<Employee> empList = (List)request.getAttribute("emp_list");
            Integer pageIndex = (Integer)request.getAttribute("page_index");
            Integer totalPage = (Integer)request.getAttribute("total_page");
        %>
        <link href="resources/style.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <%=Pager.Pager(3,pageIndex,totalPage)%>
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
        <%=Pager.Pager(3,pageIndex,totalPage)%>
    </body>
</html>

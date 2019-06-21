<%-- 
    Document   : list
    Created on : Jun 21, 2019, 7:00:49 PM
    Author     : Admin
--%>

<%@page import="com.prj321.dao.HumanTypeDao"%>
<%@page import="com.prj321.model.Human"%>
<%@page import="java.util.List"%>
<%@page import="com.prj321.model.HumanType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<HumanType> hmTypeList = (List) request.getAttribute("hm_type_list");
            List<Human> hmList = (List) request.getAttribute("hm_list");
            HumanTypeDao hmTypeDao = new HumanTypeDao();
            String id = (String) request.getAttribute("id");
            if (id == null){
                id = "";
            }
            String name = (String) request.getAttribute("name");
            if (name == null){
                name = "";
            }
            String gender = (String) request.getAttribute("gender");
            String dateFrom = (String) request.getAttribute("dateFrom");
            if (dateFrom == null){
                dateFrom = "";
            }
            String dateTo = (String) request.getAttribute("dateTo");
            if (dateTo == null){
                dateTo = "";
            }
            String type = (String) request.getAttribute("type");
            
        %>
        
        <h1>Type: <%=type%></h1>
        
        <form action="list" method="get">
            <table>
                <tr>
                    <td><span>ID:</span></td>
                    <td><input type="text" name="id" value="<%=id%>"/></td>
                </tr>
                <tr>
                    <td><span>Name:</span></td>
                    <td><input type="text" name="name" value="<%=name%>" /></td>
                </tr>
                <tr>
                    <td><span>Gender:</span></td>
                    <td>
                        <input type="radio" id="0" name="gender" value="0"/>M
                        <input type="radio" id="1" name="gender" value="1"/>F
                        <input type="radio" id="all" name="gender" value="all"/>All
                    </td>

                </tr>
                <tr>
                    <td><span>Date From:</span></td>
                    <td><input type="text" name="dateFrom" value="<%=dateFrom%>"/></td>
                </tr>
                <tr>
                    <td><span>Date To:</span></td>
                    <td><input type="text" name="dateTo" value="<%=dateTo%>"/></td>
                </tr>
                <tr>
                    <td><span>Type:</span></td>
                    <td>
                        <select id="type" name="type">
                            <option value="all">All</option>
                            <% for (int i = 0; i < hmTypeList.size(); i++) {%>
                            <option value="<%=hmTypeList.get(i).getId()%>"><%=hmTypeList.get(i).getName()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search"/></td>
                </tr>
            </table>
        </form>

        <div id="tablediv">
            <table id="humanTable">
                <tr>
                    <th><span>ID</span></th>
                    <th><span>Name</span></th>
                    <th><span>Birth</span></th>
                    <th><span>Gender</span></th>
                    <th><span>Type</span></th>
                </tr>


                <%for (int i = 0; i < hmList.size(); i++) {%>
                <tr>
                    <td><span><%=hmList.get(i).getId()%></span></td>
                    <td><span><%=hmList.get(i).getName()%></span></td>
                    <td><span><%=hmList.get(i).getBirth()%></span></td>
                    <td><span><%=hmList.get(i).getGender()%></span></td>
                    <td><span><%=hmTypeDao.getHumanType(hmList.get(i).getTypeId()).getName()%></span></td>
                </tr>
                <%}%>


            </table>
        </div>
        <script src="js/jquery-3.4.1.min.js"></script>
        
        <script>
            document.getElementById("<%=gender%>").checked = true;
            document.getElementById("type").value = "<%=type%>";
            
        </script>
    </body>
</html>

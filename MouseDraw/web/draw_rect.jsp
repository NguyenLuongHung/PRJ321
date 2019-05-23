<%-- 
    Document   : draw_rect
    Created on : May 21, 2019, 7:37:14 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.fpt.Model.Rectangle"%>
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
        <canvas onclick="alertRect(event)" id="myCanvas"></canvas>
        <span id="test"></span>
        <p id="demo"></p>
        <span id="test2"></span>
        <span id="test3"></span>
        
        <script> 

            var rectList = [];
            var rectListAlert = [];
            var c = document.getElementById("myCanvas");
            c.width = window.innerWidth;
            c.height = window.innerHeight;
            var ctx = c.getContext("2d");
            
            <% for (int i = 0; i < rectList.size() ; i++) { %>     
                var x = <%= rectList.get(i).getX() %>
                var y = <%= rectList.get(i).getY() %>
                var width = <%= rectList.get(i).getWidth() %>
                var height = <%= rectList.get(i).getHeight() %>     
                var newRect = new Rectangle(x,y,width,height);
                rectList.push(newRect);
            <% }; %>
             
            for (var j = 0; j < rectList.length ; j++) {
                var x = rectList[j].x;
                var y = rectList[j].y;
                var width = rectList[j].width;
                var height = rectList[j].height;
                ctx.beginPath();
                ctx.lineWidth = "2";
                ctx.strokeStyle = "black";
                ctx.rect(x, y, width, height);
                ctx.stroke();
                
             }
            
            function Rectangle(x,y,width, height){
                this.x = x;
                this.y = y;
                this.width = width;
                this.height = height;
            }
            
            function genWithin(corX,corY){
                for (var i = 0; i < rectList.length; i++){ 
                    if (((rectList[i].x <= corX) && (corX <= (rectList[i].x + rectList[i].width))) 
                         && ((rectList[i].y <= corY) && (corY <= (rectList[i].y + rectList[i].height)))){
                         rectListAlert.push(rectList[i]);
                    }
                } 
            }
            
            function alertRect(e){
                var alert = '';
                e = e || window.event;
                var x = event.pageX;
                var y = event.pageY;
                if (x === undefined){
                    x = e.clientX += document.body.scrollLeft + document.documentElement.scrollLeft;
                    x = e.clientY += document.body.scrollTop + document.documentElement.scrollTop;
                }
                genWithin(x,y);
                for (var i = 0; i <rectListAlert.length;i++){
                    alert += "Rect " + i +": " + "\n";
                    alert += "x = " + rectListAlert[i].x + ", ";
                    alert += "y = " + rectListAlert[i].y + ", ";
                    alert += "width = " + rectListAlert[i].width + ", ";
                    alert += "height = " + rectListAlert[i].height + "\n";
                    
                }
                rectListAlert = [];
                window.alert(alert);
  
            }
        </script>
        
    </body>
    <style>
        body {
            margin: 0;
        }
        
    </style>
</html>
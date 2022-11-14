<%-- 
    Document   : index
    Created on : Nov 14, 2022, 1:40:13 PM
    Author     : Septovan D. S. Saian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1><%="Scriptlets"%></h1>
        <%
            String[] names = {"agus", "budi", "charlie", "dhini", "erna"};
            for(String s : names){
                out.println(s + "<br/>");
            }
            out.println("<br/>");
            for(int i=1; i<=100; i++){
                out.println("Perulangan Ke : " + i + "<br/>");
            }
        %>
    </body>
</html>
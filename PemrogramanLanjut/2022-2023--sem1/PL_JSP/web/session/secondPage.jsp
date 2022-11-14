<%-- 
    Document   : secondPage
    Created on : Nov 14, 2022, 2:37:53 PM
    Author     : Septovan D. S. Saian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Second Page</title>
    </head>
    <body>
        <h1>Second Page</h1>
        <%
            String readSession = (String) session.getAttribute("nama");
            if (readSession == null) {
                out.print("No Session");
            } else {
                out.print("Nama Anda : " + session.getAttribute("nama")); 
            }
            out.print("<a href='index.jsp'> Out Session</a>");
        %>
    </body>
</html>

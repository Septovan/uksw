<%-- 
    Document   : doProcess
    Created on : Nov 14, 2022, 2:37:45 PM
    Author     : Septovan D. S. Saian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SESSION</title>
    </head>
    <body>
        <h1>Session</h1>
        <%           
            String objNama = request.getParameter("nama");
            session.setAttribute("nama", objNama);
        %>
        Data Anda telah disimpan dalam session<br/>
        masuk ke halaman <a href="secondPage.jsp">Second Page</a>
    </body>
</html>
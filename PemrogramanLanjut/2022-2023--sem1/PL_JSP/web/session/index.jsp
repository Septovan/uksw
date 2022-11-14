<%-- 
    Document   : index
    Created on : Nov 14, 2022, 2:37:30 PM
    Author     : Septovan D. S. Saian
--%>

<%
    session.removeAttribute("nama");   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SESSION</title>
    </head>
    <body>
        <h1>Session</h1>
        <form method="post" action="doProcess.jsp">
            <input type="text" name="nama"/><br/>
            <input type="submit" name="kirim" value="send"/><br/>
        </form>
    </body>
</html>


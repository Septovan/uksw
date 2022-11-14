<%-- 
    Document   : doProcessForm
    Created on : Nov 14, 2022, 2:14:25 PM
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
        <h1>Data : </h1>
        NIM : <%= request.getParameter("nim")%><br/>
        Nama : <%= request.getParameter("nama")%><br/>
        Progdi : <%= request.getParameter("progdi")%><br/>        
    </body>
</html>
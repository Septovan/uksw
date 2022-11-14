<%-- 
    Document   : index
    Created on : Nov 14, 2022, 2:14:08 PM
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
        <h1>FORM</h1>
        <form method="post" action="doProcessForm.jsp">
            NIM : <input type="text" name="nim"/><br/>
            Nama : <input type="text" name="nama"/><br/>
            Progdi : <input type="text" name="progdi"/><br/>
            <input type="submit" value="Send"/>
        </form>
    </body>
</html>
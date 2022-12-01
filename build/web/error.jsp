<%-- 
    Document   : error
    Created on : 07-Oct-2022, 10:37:30 AM
    Author     : root
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>error World!</h1>
        ${Exception}
    </body>
</html>

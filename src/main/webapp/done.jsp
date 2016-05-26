<%-- 
    Document   : done
    Created on : 15 бер. 2016, 19:50:29
    Author     : nazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/custom.css" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Congratulation. New rows have been added</h1>
        <h2>It  added ${requestScope.count} rows</h2>
        <a href="index.html" class="btn">Back to Main Page</a>
        <a href="show" class="btn">Preview</a>
    </body>
</html>

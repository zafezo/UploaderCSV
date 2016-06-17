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
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="js/app.js"></script>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
    <nav>
        <div class="nav-wrapper">
            <a href="index.html" class="brand-logo">UploaderCVS</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="index.html" class="btn btn-preview blue darken-4  white-text ">Main Page</a></li>
                <li><a href="show" class="btn btn-preview blue darken-4  white-text">Preview</a></li>
                <li><a href="admin" class="btn btn-preview blue darken-4  white-text">Panel Page</a></li>
            </ul>
        </div>
    </nav>
        <h2>Congratulation. New rows have been added</h2>
        <h3>It  added ${requestScope.count} rows</h3>
    </body>
</html>

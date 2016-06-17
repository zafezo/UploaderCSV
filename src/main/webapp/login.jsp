<%--
  Created by IntelliJ IDEA.
  User: swen
  Date: 6/17/16
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="js/app.js"></script>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <a href="index.html" class="brand-logo">UploaderCVS</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="index.html" class="btn btn-preview blue darken-4  white-text ">Main Page</a></li>
        </ul>
    </div>
</nav>
<form action="/ulpoader-cvs/login" method="post">
    <h3>Please entr your admin's password</h3>
    <div class="input-field col s6">
        <input id="last_name" type="password" name="password" class="validate">
        <label for="last_name">Password</label>
    </div>
    <input  class="btn btn-preview blue darken-4  white-text" type="submit" value="submit">
</form>

</body>
</html>

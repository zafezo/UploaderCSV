<%--
  Created by IntelliJ IDEA.
  User: Khomenko_D
  Date: 27.05.2016
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Title</title>

    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="js/app.js"></script>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>


</head>


<body>

    <caption class="center-align"><a href="index.html" class="btn btn-preview blue darken-4  white-text ">Main Page</a><h1>You have in DataBase ${count} rows</h1></caption>




    <!-- Modal Structure -->
    <div id="modal1" class="modal modal-fixed-footer">
        <div class="modal-content">
            <h4>Edit User</h4>
            <div>
                <table class="striped bordered card-panel">
                <thead class="grey darken-4 white-text">
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Gender</th>
                </tr >
                </thead>
                <tbody>
                    <tr class="edituser grey darken-2 white-text">
                        <td class="inputid"></td>
                        <td ><input class="inpfirs" type="text"  value=""/></td>
                        <td ><input class="inplast" type="text"  value="" /></td>
                        <td><input id="email" type="email" class="inpemail validate"/>
                            <label for="email" data-error="wrong" data-success="right"></label>
                        </td>
                        <td><input class="gender" type="text"  value="" /></td>
                    </tr>
                </tbody>

                </table>
            </div>
        </div>
        <div class="modal-footer row">
            <a href="#!" class="disagree modal-action modal-close waves-effect waves-green btn-flat left-align">Update</a>
            <a href="#!" class="cancel modal-action modal-close waves-effect waves-green btn-flat right-align">Cancel</a>
        </div>
    </div>

    <ul class="collapsible" data-collapsible="accordion">

<li>
    <div class="collapsible-header">Users</div>
    <div class="collapsible-body">
<table class="striped bordered card-panel grey darken-4 ">
    <thead class="grey darken-4 white-text">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Gender</th>
    </tr >
        </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr class="useritems  grey darken-2 white-text">
            <td class="userid">${user.id}</td>
            <td class="firstname">${user.first_name}</td>
            <td class="lastname">${user.last_name}</td>
            <td class="email">${user.email}</td>
            <td class="gender">${user.gender}</td>
            <td><button class="deletebutton btn blue darken-4  white-text">Delete</button></td>
            <td><button class="editbutton btn blue darken-4  white-text waves-effect waves-light ">Edit</button></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
        </div>
            </li>

        <li>
            <div class="collapsible-header">Statistic</div>
            <div class="collapsible-body">
    <table class="striped bordered card-panel">
        <thead class="grey darken-4 white-text">
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Info</th>
            <th>Quantity</th>
        </tr >
        </thead>
        <tbody>
        <c:forEach items="${statistics}" var="statistic">
            <tr class="useritems  grey darken-2 white-text">
                <td class="statid">${statistic.id}</td>
                <td class="date">${statistic.date}</td>
                <td class="info">${statistic.info}</td>
                <td>${statistic.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
                 </div>
        </li>

    </ul>
</body>
</html>


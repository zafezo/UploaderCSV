<%--
    Document   : done
    Created on : 15 бер. 2016, 19:50:29
    Author     : nazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/custom.css" type="text/css"/>
    <title>JSP Page</title>
</head>

<body>
    <table>
        <caption><a href="index.html" class="btn btn-preview">Main Page</a><h1>You have in DataBase ${count} rows</h1></caption>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Gender</th>
        </tr>
        <c:forEach items="${users}" var="user">
          <tr>
              <td>${user.id}</td>
              <td>${user.first_name}</td>
              <td>${user.last_name}</td>
              <td>${user.email}</td>
              <td>${user.gender}</td>
          </tr>
        </c:forEach>
    </table>
</body>
</html>

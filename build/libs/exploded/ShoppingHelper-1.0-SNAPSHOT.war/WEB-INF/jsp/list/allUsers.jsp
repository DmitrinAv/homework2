<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap-theme.min.css" >
    <link rel="stylesheet" type="text/css" href="../resources/css/index.css" >
</head>
<body>

<div class="well">
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>User Name</th>
            <th style="width: 36px;"></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items="${users}">
            <%--<p><a href="/car/${car.id}"> ${car.id} ${car.carName} ${car.date} </a></p>--%>
            <tr>
                <td>${user.user_id}</td>
                <td>${user.username}</td>
                <td>---</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

</body>
</html>
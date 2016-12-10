<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
    <spring:url value="/resources/css/index.css" var="mainCss" />
    <spring:url value="/resources/js/index.js" var="mainJs" />
    <link  href="${mainCss}" rel="stylesheet" />
    <script src="${mainJs}"></script>
</head>
<body>

<c:if test="${username != null}">
    <h1>Added  : ${username} </h1>
</c:if>

<spring:url var="authUrl" value="/j_spring_security_logout" />
<form method="post" action="${authUrl}">
    <div class="login">
        <input type="button" value="Home" class="button" onclick="javascript:window.location='/index'" />
        <input type="submit" value="Logout" class="btn btn-primary btn-block btn-large" />
    </div>
</form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 020 20.11.16
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <label>username:</label>
      <input type="text"     name="username" value="" /><br>
    <label>password:</label>
      <input type="password" name="password" value="" /><br>
      <input type="submit"   name="submit"   value="LOG IN" />
</form>
<br>
<a href="/adduser.jsp">Register new User</a><br>
</body>
</html>



<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <spring:url value="/resources/css/index.css" var="mainCss" />
    <spring:url value="/resources/js/index.js"   var="mainJs" />
    <link href="${mainCss}" rel="stylesheet" />
    <script src="${mainJs}"></script>
</head>

<div class="login">
    <h1>Login</h1>
    <spring:url var="authUrl" value="/j_spring_security_check" />
    <form method="post" action="${authUrl}">
        <input  type="text"     name="j_username" placeholder="Username" required="required" />
        <input  type="password" name="j_password" placeholder="Password" required="required" />
        <button type="submit"   class="btn btn-primary btn-block btn-large">Let me in.</button>
        <!-- Флажок "запомнить меня" -->
        <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
        <label for="remember_me" class="inline">Remember me</label>
    </form>
    <br>
    <input type="button" value="Register" class="btn btn-primary btn-block btn-large"
           onclick="javascript:window.location='/adduser'" />
</div>

</body>
</html>
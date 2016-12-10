<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <spring:url value="/resources/css/index.css" var="mainCss" />
    <spring:url value="/resources/js/index.js" var="mainJs" />
    <link  href="${mainCss}" rel="stylesheet" />
    <script src="${mainJs}"></script>
</head>
<body>
    <div class="login">
        <h1>Registration</h1>
        <form action="addUser" method="post">
            <input  type="text"     name="username"  placeholder="Username" required="required" />
            <input  type="password" name="password"  placeholder="Password" required="required" />
            <input  type="password" name="password2" placeholder="Confirm Password" required="required" />
            <button type="submit"   class="btn btn-primary btn-block btn-large">Register</button>
        </form>
    </div>
</body>
</html>



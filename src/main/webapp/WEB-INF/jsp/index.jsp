<%@page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h1>Welcome : ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a></h1>
</c:if>

<div class="login">
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <input type="button" value="Login"    class="button" onclick="javascript:window.location='/login'" />
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <input type="button" value="Edituser"    class="button" onclick="javascript:window.location='/edituser'" />
    </c:if>
        <input type="button" value="Add User" class="button" onclick="javascript:window.location='/adduser'" />

    <form action="listUsers" method="post">
        <button type="submit"   class="btn btn-primary btn-block btn-large">All Users</button>
    </form>
</div>

<%--<script type="javascript" src="resources/js/bootstrap.min.js"></script>--%>
<%--<script type="javascript" src="resources/js/jquery-3.1.1.min.js"></script>--%>
</body>

</html>
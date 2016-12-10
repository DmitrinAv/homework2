<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
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
        <h1>Edit form</h1>
        <form action="editUser" method="post">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
            <input type="text"   name="username"  placeholder="${pageContext.request.userPrincipal.name}" required="required" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </c:if>
            <button type="submit"   class="btn btn-primary btn-block btn-large">Edit</button>
        </form>
    </div>
</body>
</html>



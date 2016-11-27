<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css" >
    <link rel="stylesheet" type="text/css" href="resources/css/index.css" >
</head>
<body>
<%
    //allow access only if session exists
    Object mainSessionId = session.getAttribute("main");
    String userName = (String) session.getAttribute("userName");

/*    String user = (String) session.getAttribute("user");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }*/
%>

<h2>Session: <%=mainSessionId %></h2>
<%--<h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>--%>
<%--<br>--%>
<%--User=<%=user %>--%>
<%--<br>--%>
<h2>Hi <%=userName %>, Login successful.</h2>


<form action="LogoutServlet" method="post">
    <div class="login">
        <input type="button" value="Home" class="button" onclick="javascript:window.location='/home.jsp'" />
        <input type="submit" value="Logout" class="btn btn-primary btn-block btn-large" />
    </div>
</form>



<script type="javascript" src="resources/js/bootstrap.min.js"></script>
<script type="javascript" src="resources/js/jquery-3.1.1.min.js"></script>
</body>
</html>
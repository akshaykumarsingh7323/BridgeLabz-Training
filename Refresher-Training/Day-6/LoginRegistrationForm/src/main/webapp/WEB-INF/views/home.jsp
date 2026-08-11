<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.springmvcpractice.entity.User" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Welcome</title>

</head>

<body>

<%

User user =
    (User) session.getAttribute("loggedInUser");

%>

<%

if (user != null) {

%>


<h1>

    Welcome!

</h1>


<h2>

    <%= user.getName() %>

</h2>


<p>

    You have successfully logged in.

</p>


<br>


<a href="${pageContext.request.contextPath}/profile">

    Update Password

</a>


<br><br>


<a href="${pageContext.request.contextPath}/delete-account">

    Delete Account

</a>


<%

} else {

%>


<p>

    Session expired. Please login again.

</p>


<a href="${pageContext.request.contextPath}/login">

    Login

</a>


<%

}

%>


</body>

</html>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.springmvcpractice.entity.User" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Update Password</title>

</head>

<body>


<%

User user =

    (User) request.getAttribute(
        "user"
    );

%>


<h2>

    Update Password

</h2>


<p>

    Name:

    <%= user.getName() %>

</p>


<p>

    Email:

    <%= user.getEmail() %>

</p>


<form
    action="${pageContext.request.contextPath}/update-password"
    method="post">


    <label>

        New Password:

    </label>


    <br><br>


    <input
        type="password"
        name="password"
        required>


    <br><br>


    <button type="submit">

        Update Password

    </button>


</form>


<br>


<a href="${pageContext.request.contextPath}/home">

    Back to Home

</a>


</body>

</html>
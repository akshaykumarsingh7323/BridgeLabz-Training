<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Login</title>

</head>


<body>


<h2>Login Form</h2>


<%

if (request.getAttribute("success") != null) {

%>

    <p style="color: green;">

        <%= request.getAttribute("success") %>

    </p>

<%

}

%>


<%

if (request.getAttribute("error") != null) {

%>

    <p style="color: red;">

        <%= request.getAttribute("error") %>

    </p>

<%

}

%>


<form

    action="${pageContext.request.contextPath}/login"

    method="post">


    <label>Email:</label>


    <input

        type="email"

        name="email"

        required>


    <br><br>


    <label>Password:</label>


    <input

        type="password"

        name="password"

        required>


    <br><br>


    <button type="submit">

        Login

    </button>


</form>


<br>


<a href="${pageContext.request.contextPath}/register">

    Create New Account

</a>


</body>

</html>
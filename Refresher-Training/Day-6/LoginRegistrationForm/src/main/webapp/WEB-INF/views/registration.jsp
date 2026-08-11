<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Registration</title>

</head>


<body>


<h2>Registration Form</h2>


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

    action="${pageContext.request.contextPath}/register"

    method="post">


    <label>Name:</label>


    <input

        type="text"

        name="name"

        required>


    <br><br>


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

        Register

    </button>


</form>


<br>


<a href="${pageContext.request.contextPath}/login">

    Already have an account? Login

</a>


</body>

</html>
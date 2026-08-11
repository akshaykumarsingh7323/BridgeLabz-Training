<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Edit User</title>

</head>

<body>

    <h2>Edit User</h2>


    <form action="${pageContext.request.contextPath}/update" method="post">


        <!-- ID -->

        <input type="hidden"
               name="id"
               value="${user.id}">


        <!-- Name -->

        <label>Name:</label>

        <input type="text"
               name="name"
               value="${user.name}"
               required>

        <br><br>


        <!-- Email -->

        <label>Email:</label>

        <input type="email"
               value="${user.email}"
               readonly>

        <br><br>


        <!-- Password -->

        <label>Password:</label>

        <input type="password"
               name="password"
               value="${user.password}"
               required>

        <br><br>


        <button type="submit">

            Update

        </button>

    </form>


    <br>


    <a href="${pageContext.request.contextPath}/users">

        Back to Users

    </a>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Users</title>

</head>

<body>

    <h2>User List</h2>

    <table border="1">

        <tr>

            <th>ID</th>

            <th>Name</th>

            <th>Email</th>

            <th>Password</th>

            <th>Action</th>

        </tr>

        <c:forEach var="user" items="${users}">

            <tr>

                <td>${user.id}</td>

                <td>${user.name}</td>

                <td>${user.email}</td>

                <td>${user.password}</td>

                <td>

                    <a href="${pageContext.request.contextPath}/edit/${user.id}">
                        Edit
                    </a>

                    |

                    <a href="${pageContext.request.contextPath}/delete/${user.id}">
                        Delete
                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a href="${pageContext.request.contextPath}/logout">
        Logout
    </a>

</body>

</html>
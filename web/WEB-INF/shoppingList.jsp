<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${"username"}</p>
        <a href="?action=logout">Logout</a>
        <h2>List</h2>
        <form method="POST" action="">
            <label for ="add_item">Add item: </label>
            <input type="text" id="add_item" name="add_item">
            <input type="submit" value="Add">
        </form>
        <form method="POST" action="">
            <c:forEach var="list" items="${list}">
                <input type="radio" id="${list}" name="list_item" value="${list}">
                <label for="${list}">${list}</label>
        </form>
    </body>
</html>

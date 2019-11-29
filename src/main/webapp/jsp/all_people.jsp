<%@ page language="java" contentType="text/html; UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign up</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<c:forEach items="${resultSet}" var="post">
    ${post.name} ${post.lastName} ${post.patronymic} ${post.dateOfBirth}<br>
</c:forEach>
</body>
</html>
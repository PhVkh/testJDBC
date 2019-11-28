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
<jsp:useBean id="resultSet" scope="request" type="java.sql.Array"/>
<c:forEach items="${resultSet}" var="post">
    ${post}<br>
</c:forEach>
</body>
</html>
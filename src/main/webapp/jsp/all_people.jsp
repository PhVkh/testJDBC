<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<c:forEach items="${resultSet}" var="post">
    ${post.getName()} ${post.getLastName()} ${post.getPatronymic()} ${post.getDate()}<br>
</c:forEach>
</body>
</html>
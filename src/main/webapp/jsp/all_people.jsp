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
<c:forEach items="${resultSet}" var="addressWithPerson">
    ${addressWithPerson.key.getStreet()} ${addressWithPerson.key.getHouse()} ${addressWithPerson.key.getFlat()}:<br>
    <c:forEach items="${addressWithPerson.value}" var="occupant">
        ...........${occupant.getName()} ${occupant.getLastName()} ${occupant.getPatronymic()} ${occupant.getDateOfBirth()}<br>
    </c:forEach>
</c:forEach>
</body>
</html>
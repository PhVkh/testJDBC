<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sign up</title>
        <link rel="stylesheet" type="text/css" href="style/style.css">
    </head>
    <body>
        <div id="container">
            <form action="/database/add" method="post">
                <input type="text" name="name" placeholder="Имя"/><br>
                <input type="text" name="lastName" placeholder="Фамилия"/><br>
                <input type="text" name="patronymic" placeholder="Отчество"/><br>
                <input type="text" name="date" placeholder="Дата рождения"/><br>
                <input type="submit" name="click" value="Добавить" id="button"/>
            </form>
        </div>
    </body>
</html>
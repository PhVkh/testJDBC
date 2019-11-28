<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="windows-1251">
        <title>Sign up</title>
        <link rel="stylesheet" type="text/css" href="style/style.css">
    </head>
    <body>
        <div id="container">
            <form action="/database/add" method="post">
                <input type="text" name="name" placeholder="Имя"/><br>
                <input type="text" name="lastName" placeholder="Last name"/><br>
                <input type="text" name="patronymic" placeholder="Patronymic"/><br>
                <input type="text" name="date" placeholder="Date of Birth"/><br>
                <input type="submit" name="click" value="Post" id="button"/>
            </form>
        </div>
    </body>
</html>
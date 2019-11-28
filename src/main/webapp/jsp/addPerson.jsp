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
                <input type="text" name="name" placeholder="Name"/><br>
                <input type="text" name="lastName" placeholder="Last name"/><br>
                <input type="text" name="patronymic" placeholder="Patronymic"/><br>
                <input type="text" name="date" placeholder="Date of Birth"/><br>
                <input type="submit" name="click" value="Next" id="button"/>
            </form>
        </div>
    </body>
</html>
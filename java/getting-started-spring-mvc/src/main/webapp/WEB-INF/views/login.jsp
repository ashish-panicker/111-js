<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <h1>Login Page</h1>
    <form id="loginViewModel" action="login" method="post">
        <div>
            <label for="userName">Username:</label>
            <input id="userName" name="userName" type="text" value="">
        </div>
        <div>
            <label for="password">Password:</label>
            <input id="password" name="password" type="password" value="">
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </form>
</body>
</html>
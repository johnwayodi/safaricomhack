<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/4/2018
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<h2>Log In to access portal: </h2>
<form action="login" method="post">
    <pre>
        Username :<input type="text" name="email"/>
        Password :<input type="password" name="password"/>
        <input type="submit" value="Log In"/>
        ${msg}
    </pre>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/4/2018
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Applicant Registration</h2>
<form action="registerUser" method="post">
    <pre>
        First Name: <input type="text" name="firstName"/>
        Last Name: <input type="text" name="lastName"/>
        Email: <input type="text" name="email"/>
        Phone: <input type="text" name="phone"/>
        Education Level: <input type="text" name="educationLevel"/>
        Years of Experience: <input type="text" name="yearsOfExperience"/>
        Password: <input type="password" name="password"/>
        Confirm Password: <input type="password" name="confirmPassword"/>
        <input type="submit" value="Register"/>
    </pre>
</form>



</body>
</html>

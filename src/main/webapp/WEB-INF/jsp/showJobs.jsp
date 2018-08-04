<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/4/2018
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Type</th>
        <th>Years of Experience</th>
        <th>Education level</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${jobList}" var="job">
    <tr>
        <td>${job.name}</td>
        <td>${job.description}</td>
        <td>${job.jobType}</td>
        <td>${job.yearsOfExperience}</td>
        <td>${job.educationLevel}</td>
        <td>${job.status}</td>
        <td><a href="showApplication?jobName=${job.name}">Select</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>

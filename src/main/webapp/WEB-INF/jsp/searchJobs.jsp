<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/4/2018
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Find Job</h2>

<form action="searchJobs" method="post">
    Enter Job Type:<input type="text" name="jobType"/>
    <input type="submit" value="search"/>
</form>

<h2>Available Job Types:</h2>
${typesOfJobs}

<h2>Jobs already Applied for</h2>
<table>
<tr>
    <th>Job Name</th>
    <th>Job Type</th>
</tr>

<c:forEach items="${jobsApplied}" var="job">
    <tr>
        <td>${job.job.name}</td>
        <td>${job.job.jobType}</td>

        <td><a href="#">Select</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>

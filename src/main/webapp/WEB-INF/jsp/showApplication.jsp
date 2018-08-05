<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/4/2018
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Apply for Job</h2>

Job ID: ${selectedjob.id}<br/>

<form action="completeApplication" method="post">
    <pre>
        <h2>Applicant Details:</h2>
        Applicant Email: <input type="text" name="applicantEmail"/>

        <input type="hidden" name="jobId" value="${job.id}"/>
        <input type="submit" value="confirm"/>
    </pre>
</form>

</body>
</html>

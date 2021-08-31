<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mruma_000
  Date: 18.08.2021
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add plane</title>
</head>
<body>

<form:form action="plane-added" modelAttribute="plane">
    Company: <form:input path="company"/>
    <br><br>
    Model: <form:input path="model"/>
    <br><br>
    Seats: <form:input path="seats"/>
    <br><br>

    <input type="submit" value="Submit">
</form:form>

</body>
</html>

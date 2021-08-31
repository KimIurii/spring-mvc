<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mruma_000
  Date: 19.08.2021
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<h3>Fill out the field below</h3>
<hr>
<form action="passenger-added">
    <input type="text" name="firstName" placeholder="First name">
    <br>
    <input type="text" name="lastName" placeholder="Last name">
    <br>
    <input type="email" name="email" placeholder="Email">
    <br>
    <input type="text" name="phoneNumber" placeholder="Phone number">
    <br>
    <input type="text" name="passDet" placeholder="Passport Details">
    <br>
    <input type="date" name="dob" placeholder="Birth date">
    <br>
    <input type="text" name="sex" placeholder="Choose sex">
    <br>
    <input type="submit" placeholder="Register">
</form>
</body>
</html>

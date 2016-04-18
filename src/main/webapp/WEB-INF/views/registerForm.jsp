<%--
  Created by IntelliJ IDEA.
  User: Sergiy
  Date: 4/4/2016
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Spittr Register Form</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
  <h1>Register</h1>
  <sf:form method="POST" commandName="spitter" enctype="multipart/form-data">
    <sf:errors path="*" element="div" cssClass="errors" />

      <sf:label path="firstName" cssErrorClass="error">First Name: </sf:label>
        <sf:input path="firstName" /><br/>
      <sf:label path="lastName" cssErrorClass="error">Last Name: </sf:label>
        <sf:input path="lastName" /><br/>
      <%--<sf:label path="email" cssErrorClass="error">Email: </sf:label>
        <sf:input path="email" /><br/>--%>
      <sf:label path="username" cssErrorClass="error">Username: </sf:label>
        <sf:input path="username" /><br/>
      <sf:label path="password" cssErrorClass="error">Password: </sf:label>
        <sf:password path="password" /><br/>

      <label>Profile Picture: </label>
        <input name="profilePicture" type="file" accept="image/jpeg, image/png, image/gif"/>

    <input type="submit" value="Register" />
  </sf:form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Sergiy
  Date: 4/4/2016
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spitter Profile</title>
</head>
<body>
  <h1>Your Profile</h1>
  <c:out value="${spitter.username}" /><br/>
  <c:out value="${spitter.firstName}" />
  <c:out value="${spitter.lastName}" />
  <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</body>
</html>

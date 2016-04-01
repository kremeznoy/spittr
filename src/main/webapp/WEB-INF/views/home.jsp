<%--
  Created by IntelliJ IDEA.
  User: Sergiy
  Date: 3/30/2016
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
  <title>Spittr</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
  <h1>Welcome to Spittr</h1>
  <a href="<c:url value="/spittles" />">Spittles</a> |
  <a href="<c:url value="/spitter/register" />">Register</a>
  <a href="<c:url value="/spittles?max=238900&count=6" />">6 Spittles</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Sergiy
  Date: 4/4/2016
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="spittleView">
  <div class="spittleMessage">
    <c:out value="${spittle.message}" />
  </div>
  <div>
    <span class="spittleTime">
      <c:out value="${spittle.time}" />
    </span>
  </div>
</div>
<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</body>
</html>

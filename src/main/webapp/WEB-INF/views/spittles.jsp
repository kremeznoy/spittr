<%--
  Created by IntelliJ IDEA.
  User: Sergiy
  Date: 3/31/2016
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %><html>
<html>
<head>
    <title>Spittles List</title>
</head>
<body>
   <c:forEach items="${spittleList}" var="spittle" >
      <li id="spittle_<c:out value="spittle.id"/>">
        <div class="spittleMessage">
          <c:out value="${spittle.message}" />
        </div>
        <div>
          <span class="spittleTime"><c:out value="${spittle.time}" /></span>
          <span class="spittleLocation">
            (<c:out value="${spittle.latitude}" />,
            <c:out value="${spittle.longitude}" />)
          </span>
        </div>
      </li>
    </c:forEach>
</body>
</html>

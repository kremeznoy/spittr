<%--
  Created by IntelliJ IDEA.
  User: kremezniy
  Date: 7/11/2016
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Login Page</title></head>
<body onload='document.f.username.focus();'>
<h3>Login with Username and Password</h3>
<form name='f' action='/spittr/login' method='POST'>
  <table>
    <tr><td>User:</td><td>
      <input type='text' name='username' value=''></td></tr>
    <tr><td>Password:</td>
      <td><input type='password' name='password'/></td></tr>
    <tr><td colspan='2'>
      <input name="submit" type="submit" value="Login"/></td></tr>
    <input name="_csrf" type="hidden"
           value="6829b1ae-0a14-4920-aac4-5abbd7eeb9ee" />
    <input id="remember_me" name="remember-me" type="checkbox"/>
    <label for="remember_me" class="inline">Remember me</label>
  </table>
</form>
</body>
</html>
<%@ page  session="true" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Profile Page</title>
</head>
<body>
 <center>
  <h1>User profile page !!!</h1>
  <c:url var="logoutUrl" value="j_spring_security_logout" />
  <form action="${logoutUrl}" method="post">
   <input type="submit" value="Log out" /> <input type="hidden"
    name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
 </center>

</body>
</html>

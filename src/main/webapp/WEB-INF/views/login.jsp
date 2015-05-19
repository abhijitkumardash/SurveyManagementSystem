<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- <link href="resources/css/materialize.css" rel="stylesheet"> -->
<!-- <link href="resources/css/materialize.min.css" rel="stylesheet"> -->
<link href="resources/css/login.css" rel="stylesheet">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- <script src="resources/js/materialize.js"></script> -->
<!-- <script src="resources/js/materialize.min.js"></script> -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="resources/js/prefixfree.min.js"></script>
<title>Login</title>
</head>
<body>

  <div class="body"></div>
  
		<div class="grad"></div>
		<div class="lhead">
		<div class="logo"></div>
		<div class="header">
					<div>
				Survey<span>Master</span>
			</div>
		</div>
		</div>
		<br>
		<div class="login">
		<span
				style="color: red">${message}</span>
		
			<form action="j_spring_security_check" method="POST">
				<table>
					<tr>
						<td><input name="username" type="text" placeholder="username"/></td>
					</tr>
					<tr>
						<td><input name="password" type="password"  placeholder="password"/></td>
					</tr>
					<tr>
						<td><input type="submit"  value="Login"/></td>
						<td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> </td>
					</tr>
				</table>
			</form>
			<span>Not a member?<a class="signup-link" href="signup">Sign up Now &#10142;</a></span>
		</div> 
  

</body>
</html>

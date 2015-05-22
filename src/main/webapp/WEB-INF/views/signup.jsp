<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup</title>
<link href="resources/css/signup.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="resources/js/prefixfree.min.js"></script>
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

	<div class="wrapper">
		<h1>Register For An Account</h1>
		<p>To sign-up for a free basic account please provide us with some
			basic information using the contact form below. Please use valid
			credentials.</p>
		<form class="form" action="signup" method="post">
			<input type="text" name="username" placeholder="Username">
			<input name="password" type="password"  placeholder="Password"/>
			<input name="confirm-password" type="password"  placeholder="Confirm Password"/>
			<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
			<input type="submit" class="submit" value="Register">
		</form>
	</div>	
</body>
</html>
<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/chart.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>

<!-- <script type="text/javascript" src="resources/js/addSurveyPoll.js"></script> -->
<script type="text/javascript" src="resources/js/chart.js"></script>

<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>
<title>Survey Chart</title>
</head>
<body>
<div class="body"></div>
	<div class="grad"></div>
<div class="row">
	  	<c:url var="logoutUrl" value="j_spring_security_logout" />
		 <form action="${logoutUrl}" method="post">
			  <input id="logoutButton" type="submit" value="Logout" /> 
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		 </form>
		 
		 <div id="user">
			<sec:authentication property="principal.username" />
		</div>
		<div id="dash">
		<a href="dashboard">Dashboard</a>
	</div>
	</div>

<div>

	 <div>
	          <input id="survey-id"  hidden="true" value="${surveyId}">
	     
	  </div>
	   	     
 </div>


	<div id="chart-container"></div>
</body>
</html>
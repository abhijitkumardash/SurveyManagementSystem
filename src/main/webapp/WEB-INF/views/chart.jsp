<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


<div>

	 <div>
	          <input id="survey-id"  hidden="true" value="${surveyId}">
	     
	  </div>
	   	     
 </div>


	<div id="chart-container"></div>
</body>
</html>
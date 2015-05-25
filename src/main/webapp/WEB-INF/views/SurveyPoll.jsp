<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/surveyPoll.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>
<script src="resources/js/surveyPoll.js"></script>
<title>Survey Poll</title>
</head>
<body>
  <div class="body"></div>
  <div class="grad"></div>		
	<div class="row">
		<div class="col s12 m6" id="survey-wrap">
	 		<div class="card medium">
				<img class="blackImg" /> 
			    <form action="saveSurveyPoll" method="post">
			   		<c:forEach items="${questionList}" var="question">
			        	<div class="card-content white-text">
			            <span class="card-title">Survey Title:${question.survey.surveyTitle}</span>
			            <p>Question:${question.questionTitle}</p>
			            <c:forEach items="${question.answers}" var="answer">
				            <p>

							<input name="answers${question.questionId}" type="radio" id="${answer.answerId}" value="${answer.answerId}"/>
						      <label for="${answer.answerId}"> ${answer.answerDesc}</label>
						    </p>
					    </c:forEach>
			           
			   			</div>
		   			</c:forEach>
		   			<button id="poll-submit" type="submit">Done</button>
		   			<button type="reset">Reset</button>
		   			</form>

		    </div>
		           
	   </div>
	</div>
</body>
</html>
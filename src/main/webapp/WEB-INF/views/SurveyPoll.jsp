<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/surveyPoll.css" rel="stylesheet">

      
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="resources/js/addSurveyPoll.js"></script>
<title>Survey Poll</title>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="row">
		<div class="col s12 m6" id="survey-wrap">
			<div class="card ">

				<img class="blackImg" /> <span class="card-title">Survey
					Title: ${surveyTitle}</span>

				<c:forEach items="${questionList}" var="question">
					<div class="card-content white-text">
						<p>Question:${question.questionTitle}</p>
						<c:if test="${question.questionType=='multipleChoice'}">
							<c:forEach items="${question.answers}" var="answer">

								<p>
									<input name="answers${question.questionId}" type="radio"
										id="${answer.answerId}" value="${answer.answerId}"
										data-surveyId="${question.survey.surveyId}"
										data-questionId="${question.questionId}"
										class="questionAndAnswer" /> <label for="${answer.answerId}">
										${answer.answerDesc}</label>
								</p>
							</c:forEach>
						</c:if>
						
						<div class="input-field col s10">
							<c:if test="${question.questionType.equals('dropdown')}">

								<select class="browser-default" id="${question.questionId}">
								<option value="">select</option>
									<c:forEach items="${question.answers}" var="answer">
										

										<option class="opt" value="${answer.answerId}"
											data-surveyId="${question.survey.surveyId}"
											data-questionId="${question.questionId}">
											${answer.answerDesc}</option>
									</c:forEach>
								</select>
								  
							</c:if>

						</div>
					</div>
				</c:forEach>
				<div class="center-align col s12  ">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button class="btn waves-effect waves-light " id="poll-submit">
						Submit</button>
				</div>
				<!-- 					<button class="btn waves-effect waves-light" type="reset" -->
				<!-- 						name="action"> -->
				<!-- 						Reset choices <i class="mdi-action-autorenew right"></i> -->
				<!-- 					</button> -->
				<!-- 				<button class="btn waves-effect waves-light" id="poll-submit" type="submit" -->
				<!-- 						name="action"> -->
				<!-- 						Submit <i class="mdi-content-send right"></i> -->
				<!-- 					</button> -->

			</div>

		</div>
	</div>
	<div id="container"
		style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
</body>
</html>
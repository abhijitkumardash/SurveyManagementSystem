<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/surveyPoll.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>
<script src="resources/js/addSurveyPoll.js"></script>
<title>Survey Poll</title>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="row">
		<div class="col s12 m6" id="survey-wrap">
			<div class="card ">
				<img class="blackImg" />

				<form>
					<span class="card-title">Survey Title: ${surveyTitle}</span>
					<c:forEach items="${questionList}" var="question">
						<div class="card-content white-text">
							<p>Question:${question.questionTitle}</p>
								<input type="hidden" name="surveyId"
									value="${question.survey.surveyId}" /> <input type="hidden"
									name="questionId" value="${question.questionId}" />
							<c:forEach items="${question.answers}" var="answer">
								<p>
									<input name="answers${question.questionId}" type="radio"
										id="${answer.answerId}" value="${answer.answerId}" /> <label
										for="${answer.answerId}"> ${answer.answerDesc}</label>
							</c:forEach>
						</div>
					</c:forEach>
					<button class="btn waves-effect waves-light" type="submit"
						id="poll-submit" name="action">
						Submit <i class="mdi-content-send right"></i>
					</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button class="btn waves-effect waves-light" type="reset"
						name="action">
						Reset choices <i class="mdi-action-autorenew right"></i>
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
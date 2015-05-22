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

 <div class="row">
        <div class="col s12 m6" id="survey-wrap">
          <c:forEach items="${questionList}" var="question">
          <div class="card blue-grey darken-1">
           <form action="saveSurveyPoll" method="post">
            <div class="card-content white-text">
              <span class="card-title">Survey Title: ${surveytitle} ${question.survey.surveyTitle}</span>
              <p>Question: ${questionTitle} ${question.questionTitle}</p>
              
    <p>
      <input name="group1" type="radio" id="answer1" value="answer1" answerId=${answer1Id} />
      <label for="answer1">Answer1: ${answer1}</label>
    </p>
    <p>
      <input name="group1" type="radio" id="answer2" value="answer2" answerId=${answer2Id} />
      <label for="answer2">Answer2 :  ${answer2}</label>
    </p>
   
     
  </form>
            </div>
            </c:forEach>
                     </div>
        </div>
        <c:forEach items="${questionList}" var="question">
		${question.questionTitle} ${question.survey.surveyTitle}
		<br />
	</c:forEach>

</body>
</html>
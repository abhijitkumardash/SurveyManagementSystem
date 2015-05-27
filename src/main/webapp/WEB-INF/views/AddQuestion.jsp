<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/addQuestion.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/addQuestion.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>


<title>Survey Creation</title>
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
	</div>
	 
   <div class="row">
   	  <div  class="card large">
	     <img class="blackImg" /> 
	     <ul  id="question-answer-container">
	     	<li ><h5>Survey ID :<i id="survey-id" >${surveyId}</i></h5></li>
	     	<li id="error-msg"></li>
	     	<li id="question-wrap">
	     		<label>Question:</label>
	     		<input type="text" placeholder="Enter the question" id="question" name="question" required/>
	     	</li>
	     	<li>
		     	<ul id="answer-wrap">
		     		<li><label>Answers:</label></li>
		     		<li class="right-align">
		     			<a class="btn-floating btn-small waves-effect waves-light green" id="addInputField" title="add a new input field" >
						  <i class="mdi-content-add"></i>
						 </a>
						 <a class="btn-floating btn-small waves-effect waves-light red" id="removeInputField" title="remove last input field">
						  <i class="mdi-content-remove"></i>
						 </a>
		     		</li>
			     	<li>
			     		<input type="text" placeholder="Enter the answer" name="answer1" id="answer1" />
			     	</li>
			     	<li>
			     		<input type="text" placeholder="Enter the answer" name="answer2" id="answer2"/>
			     	</li>
				</ul>
			</li>
			<li id="buttons-wrap">
			 	<a class="waves-effect waves-light btn"  id="save-question-answer" >Save</a>
				<a class="waves-effect waves-light btn red" id="cancel">Clear all</a>
				<a class="waves-effect waves-light btn"  id="addAnother-question-answer" >Add another Question</a>
			</li>	
	     </ul>
	   </div>
  </div>


</body>
</html>
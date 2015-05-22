<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
   
   <div  class="card large">
     <img class="blackImg" /> 
     <ul  id="question-answer-container">
     	<li ><h5>Survey ID :<i id="survey-id" >${surveyId}</i></h5></li>
     	<li id="question-wrap">
     		<label>Question:</label>
     		<input type="text" placeholder="Enter the question" id="question" name="question" required/>
     	</li>
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
		<div id="buttons-wrap">
		 	<a class="waves-effect waves-light btn"  id="save-question-answer" >Save</a>
			<a class="waves-effect waves-light btn red">Cancel</a>
			<a class="waves-effect waves-light btn"  id="addAnother-question-answer" >Add another Question</a>
		</div>	
     	</li>
     	<p id="generated-link"/></p>
     	
     </ul>

  </div>


</body>
</html>
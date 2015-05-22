<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
      <!-- Left Side Panel -->
  
    <ul class="collection " id="left-container">
      <li class="collection-item"><a href="#!" class="collection-item">Multiple Choice</a></li>
      <li class="collection-item"><a href="#!" class="collection-item">Dropdown</a></li>
      <li class="collection-item"><a href="#!" class="collection-item">Matrix</a></li>
      <li class="collection-item"><a href="#!" class="collection-item">Comment Box</a></li>
    </ul>
     <!-- For adding Question and answer -->     
      
     <ul id="question-answer-container">
     	<li >Survey ID :<i id="survey-id" >${surveyId}</i></li>
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
		 	<a class="waves-effect waves-light btn"  id="save-question-answer" >Save</a>
			<a class="waves-effect waves-light btn red">Cancel</a>
			
     	</li>
     	<p id="generated-link"/></p>
     	
     </ul>

   

</body>
</html>
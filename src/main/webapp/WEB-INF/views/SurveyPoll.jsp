<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/surveyPoll.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>
<title>Survey Poll</title>
</head>
<body>

 <div class="row">
        <div class="col s12 m6" id="survey-wrap">
        
          <div class="card blue-grey darken-1">
           <form action="#">
            <div class="card-content white-text">
              <span class="card-title">Survey Title: ${surveytitle}</span>
              <p>Question: ${questionTitle}</p>
              
    <p>
      <input name="group1" type="radio" id="answer1" />
      <label for="answer1">Answer1: ${answer1}</label>
    </p>
    <p>
      <input name="group1" type="radio" id="answer2" />
      <label for="answer2">Answer2 :  ${answer2}</label>
    </p>
   
     
  </form>
            </div>
                     </div>
        </div>

</body>
</html>
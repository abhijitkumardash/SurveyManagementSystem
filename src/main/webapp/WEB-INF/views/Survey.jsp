<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/addSurvey.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/addSurvey.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>
<title>Insert title here</title>
</head>
<body>

 <div class="row">
        <div class="col s12 m6" id="survey-wrap">
        
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Survey Title ${surveytitle}</span>
              <p>Question ${questionTitle}</p>
              <ul>
              	<li>Answer1 ${answer1}</li>
              	<li>Answer2 ${answer2}</li>
              	<li>Answer3 ${answer3}</li>
              	
              	
              </ul>
            </div>
                     </div>
        </div>
      </div>
</body>
</html>
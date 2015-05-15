$(document).ready(function(){
	
	$('#save-question-answer').click(function(){
		alert("save clicked");
		var question= $("#question").val();
		var answer1=$("#answer1").val();
		var answer2=$("#answer2").val();
		var answer3=$("#answer3").val();
		var answer4=$("#answer4").val();
		var surveyId=$("#survey-id").val();
		
		$.ajax({  
		     type : "GET",   
		     url : "/saveQuestionAnswer",   
		     data : "question=" + question + "&answer1=" + answer1 + "&answer2="  
		       + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4+
		       "&surveyId=" + surveyId,
		     success : function(response) {  
		    	 alert(response);   
		     },  
		     error : function(e) {  
		      alert('Error: ' + e);   
		     }  
		    });  
	});

	var NoOfInputFiled=2;//default number of input fields
	
	$("#addInputField").click(function(){
	
		if(NoOfInputFiled<4){
			alert("in loop");
			NoOfInputFiled++;
			var currentInputFieldId="answer"+NoOfInputFiled;
			var newdiv = document.createElement('li');
			var str ="<input type='text' placeholder='Enter the answer' name='answer' id="+currentInputFieldId;
			newdiv.innerHTML =str+">";
			document.getElementById('answer-wrap').appendChild(newdiv);
		}
		else {
			$('#addInputField').hide();
		}
	});
	
	$( "#removeInputField" ).click(function() {
	
		if(NoOfInputFiled>2){
			$('#addInputField').show();
			NoOfInputFiled--;
			$( "input" ).last().remove();
		}
	
	});
	
});
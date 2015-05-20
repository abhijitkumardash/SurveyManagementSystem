
$(document).ready(function(){
	
	$('#save-question-answer').click(function(){
		var question = {};
		question.question= $("#question").val();
		
		question.answers = [];
		question.answers.push($("#answer1").val());
		question.answers.push($("#answer2").val());
		question.answers.push($("#answer3").val());
		question.answers.push($("#answer4").val());
		
		question.surveyId=$("#survey-id").html();
		
var surveyId=$("#survey-id").html();
		
		$.ajax({  
			type: 'POST',
			url: "saveQuestionAnswer", 
			contentType: "application/json",
			data:JSON.stringify(question),
		     success : function(data) {  
		    	 console.log(data);
		    	$("#generated-link").html("GENERATED URL :  http://localhost:8080/modules/"+$("#survey-id").html());
		    	$("#survey-id").html(surveyId);
			    $('#question-answer-container').find('input:text').val('');
			    
		     },  
		     error : function(e) {  
//		      alert('Error: ' + e);   
		     }  
		    }); 
	});
	


	var NoOfInputFiled=2;//default number of input fields
	
	$("#addInputField").click(function(){
	
		if(NoOfInputFiled<4){
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
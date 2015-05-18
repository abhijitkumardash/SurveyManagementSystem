$(document).ready(function(){
	
	$('#save-question-answer').click(function(){
		var question= $("#question").val();
//		alert("save clicked");
		var answer1=$("#answer1").val();
		var answer2=$("#answer2").val();
		var answer3=$("#answer3").val();
		var answer4=$("#answer4").val();
		var surveyId=$("#survey-id").html();

		if(question!== null&& question!="" &&answer1!=""||answer2!=""){
			
			$.ajax({  
			     type : "POST",   
			     url : "saveQuestionAnswer",   
			     data : "question=" + question + "&answer1=" + answer1 + "&answer2="  
			       + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4+ "&surveyId=" + surveyId,
			     success : function(surveyId) {  
			    	// alert(surveyId); 
			    	 $("#generated-link").html("GENERATED URL :  http://localhost:8080/modules/fsdfdfs"+surveyId);
			     },  
			     error : function(e) {  
//			      alert('Error: ' + e);   
			     }  
			    }); 
		}
			
		
		 
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
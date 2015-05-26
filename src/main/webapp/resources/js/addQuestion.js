
$(document).ready(function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	function getQuestionAnswer(){
		
		var question = {};
        question.question= $("#question").val();
        question.answers = [];
        var i=1;
        while(i<=4){
        	question.answers.push($("#answer"+i).val())
        	i++;
        }
        question.surveyId=$("#survey-id").html();
        var surveyId=$("#survey-id").html();
		return question;
	}
	
	function isFieldEmpty(){
		 var inputs = document.getElementsByTagName('input');
		 for(var i = 0; i < inputs.length; i++){
	            if(inputs[i].value === ''){
	            	$("#error-msg").html("Field shouldn't be empty"); 
		            return true;
	            }
	     }
		 return false;
	}
	
	$('#save-question-answer').click(function(){
		if(isFieldEmpty()===false){
			$.ajax({ 
	            type: 'POST',
	            url: "saveQuestionAnswer",
	            contentType: "application/json",
	            data:JSON.stringify(getQuestionAnswer()),
	            beforeSend: function(xhr){
		           xhr.setRequestHeader(header, token);
		        },
	             success : function(data) { 
	                window.location.replace("/SurveyManagementSystem/survey="+$("#survey-id").html()); 
	             }, 
	             error : function(e) { 
	              console.log('Error: ' + e);  
	             } 
	        });
		}
		
    });
	
	$('#addAnother-question-answer').click(function(){

		if(isFieldEmpty()===false){
			$.ajax({ 
	            type: 'POST',
	            url: "saveQuestionAnswer",
	            contentType: "application/json",
	            data:JSON.stringify(getQuestionAnswer()),
	            beforeSend: function(xhr){
		           xhr.setRequestHeader(header, token);
		        },
	             success : function(data) { 
	                $('#question-answer-container').find('input:text').val('');
	             }, 
	             
	             error : function(e) { 
	              alert('Post object fail .Error: ' + e);  
	             } 
	        });
		}

	});
	
	
	var NoOfInputField=2;//default number of input fields
	
	$("#addInputField").click(function(){
		if(NoOfInputField<4){
			NoOfInputField++;
			var currentInputFieldId="answer"+NoOfInputField;
			var newdiv = document.createElement('li');
			var str ="<input type='text' placeholder='Enter the answer' name='answer' id="+
				currentInputFieldId;
			newdiv.innerHTML =str+">";
			document.getElementById('answer-wrap').appendChild(newdiv);
		}
		else {
			$('#addInputField').hide();
		}
	});
	
	$( "#removeInputField" ).click(function() {
	
		if(NoOfInputField>2){
			$('#addInputField').show();
			NoOfInputField--;
			$( "input" ).last().remove();
		}
	
	});
	
});
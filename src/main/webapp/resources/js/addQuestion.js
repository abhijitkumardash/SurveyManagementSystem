
$(document).ready(function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	function getQuestionAnswer(){
		
		var question = {};
        question.question= $("#question").val();
        question.answers = [];
        question.answers.push($("#answer1").val())
        question.answers.push($("#answer2").val());
        question.answers.push($("#answer3").val());
        question.answers.push($("#answer4").val());
        question.surveyId=$("#survey-id").html();
        
        var surveyId=$("#survey-id").html();
		return question;
	}
	
	$('#save-question-answer').click(function(){
		
		$.ajax({ 
            type: 'POST',
            url: "saveQuestionAnswer",
            contentType: "application/json",
            data:JSON.stringify(getQuestionAnswer()),
            beforeSend: function(xhr){
	           xhr.setRequestHeader(header, token);
	        },
             success : function(data) { 
                window.location.replace("/modules/"+$("#survey-id").html()); 
             }, 
             error : function(e) { 
              console.log('Error: ' + e);  
             } 
        });
    });
	
	$('#addAnother-question-answer').click(function(){

		$.ajax({ 
            type: 'POST',
            url: "saveQuestionAnswer",
            contentType: "application/json",
            data:JSON.stringify(getQuestionAnswer()),
            beforeSend: function(xhr){
	           xhr.setRequestHeader(header, token);
	        },
             success : function(data) { 
            	 alert(data);
                $("#generated-link").html("GENERATED URL :  http://localhost:8080/modules/"+$("#survey-id").html());
                $('#question-answer-container').find('input:text').val('');
             }, 
             error : function(e) { 
            	 console.log('Error: ' + e);   
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
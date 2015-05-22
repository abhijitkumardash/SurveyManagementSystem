
$(document).ready(function(){
	
	$('#save-question-answer').click(function(){
		
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
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
        $.ajax({ 
            type: 'POST',
            url: "saveQuestionAnswer",
            contentType: "application/json",
            data:JSON.stringify(question),
            
            beforeSend: function(xhr){
	           xhr.setRequestHeader(header, token);
	        },
             success : function(data) { 
                $("#generated-link").html("GENERATED URL :  http://localhost:8080/modules/"
                		+$("#survey-id").html());
                $("#survey-id").html(surveyId);
                $('#question-answer-container').find('input:text').val('');
             }, 
             error : function(e) { 
              alert('Post object fail .Error: ' + e);  
             } 
            });
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
$(document).ready(function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var answerId=[];
	var questionId=[] ;
	var surveyId;
	
	$("input:radio[type=radio]").click(function() {
	   answerId.push($(this).val());
	   questionId.push($(this).attr("data-questionId"));
	   surveyId=$(this).attr("data-surveyId");
	   console.log("questionId:"+questionId);
	   console.log("answerId:"+answerId);
	   
	});
	
	function getPollInputs(){

		var userPoll={};
		userPoll.surveyId=surveyId;
		userPoll.questions=questionId;
		userPoll.answers=answerId;
		
		return userPoll;
	}

	$('#poll-submit').click(function(){

		$.ajax({ 
            type: 'POST',
            url: "savePoll",
            contentType: "application/json",
            data:JSON.stringify(getPollInputs()),
            beforeSend: function(xhr){
	           xhr.setRequestHeader(header, token);
	        },
             success : function() { 
            	 alert("Poll submit using post completed")
            	 window.location.replace("http://localhost:8080/SurveyManagementSystem/");
             }, 
             error : function(e) { 
              console.log('Error: ' + e);  
             } 
        });
    });
});


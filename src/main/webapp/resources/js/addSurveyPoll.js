$(document).ready(function() {

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var answerId = [];
	var questionId = [];
	var surveyId;


	function getPollInputs() {

		var userPoll = {};
		userPoll.surveyId = surveyId;
		userPoll.questions = questionId;
		userPoll.answers = answerId;
		return userPoll;
	}

	$('#poll-submit').click(function() {
		answerId = [];
		questionId = [];
		surveyId;
		
		
		var inputElements = document.getElementsByClassName('questionAndAnswer');
		for(var i=0; inputElements[i]; ++i){
		      if(inputElements[i].checked){
		    	answerId.push((inputElements[i].value));
		  		questionId.push((inputElements[i].getAttribute("data-questionId")));
		  		surveyId = Number(inputElements[i].getAttribute("data-surveyId"));
		  	  }
		 }
		
		var dropdownElements = document.getElementsByClassName('opt');
		 for(var i=0; dropdownElements[i]; ++i){
			if(dropdownElements[i].selected){
		    	answerId.push((dropdownElements[i].value));
		  		questionId.push((dropdownElements[i].getAttribute("data-questionId")));
		  		surveyId = Number(dropdownElements[i].getAttribute("data-surveyId"));
		  	}  
		}
	
		$.ajax({
			type : 'POST',
			url : "savePoll",
			contentType : "application/json",
			data : JSON.stringify(getPollInputs()),
			beforeSend : function(xhr) {
				xhr.setRequestHeader(header, token);
			},

			success : function(data) {
				 window.location.replace("/SurveyManagementSystem").html();
			},
			error : function(e) {
				console.log('Error: ' + e);

			}
		});
	});


});



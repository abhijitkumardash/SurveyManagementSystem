$(document).ready(function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	function getPollInputs(){

		var poll={};
		poll.surveyId=("1");
		poll.questions=["1","2"];
		poll.answers=["1","2"];

		return poll;
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
             success : function(data) { 
            	 alert("Poll submit using post completed")
             }, 
             error : function(e) { 
              console.log('Error: ' + e);  
             } 
        });
    });
});


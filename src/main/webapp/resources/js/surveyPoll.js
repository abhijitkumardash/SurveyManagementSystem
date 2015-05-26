$(document).ready(function(){
	var answerId;
	var questionId;
	var surveyId;
	
	$("input:radio[type=radio]").click(function() {
	   answerId = $(this).val();
	   questionId=$(this).attr("questionId");
	   surveyId=$(this).attr("surveyId");
	   
	});

});

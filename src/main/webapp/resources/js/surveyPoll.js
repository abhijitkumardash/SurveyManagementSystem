$(document).ready(function(){
	var answerId;
	var questionId;
	var surveyId;
	
	$("input:radio[type=radio]").click(function() {
	   answerId = $(this).attr("id");
	   console.log(answerId);
	   
	   console.log($(answerId).siblings());
	   
	   surveyId=document.getElementsByName(surveyId);
//	   surveyId = $("input[name=surveyId]").val();
//console.log("answerId:"+answerId +"surveyId:"+surveyId+"questionId:"+questionId);
	});

});

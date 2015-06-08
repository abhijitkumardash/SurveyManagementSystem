 $(window).load(function() {
	 $("#delete-button").click(function(){
		 alert("blaahhhhhhhhh")
		 var surveyId=$("input:radio[name='survey']:checked").val();
		 alert(surveyId);
		 $.ajax({
				type : 'GET',
				url : 'deleteSurvey',
				contentType : "application/json",
				data : "surveyId="+surveyId,
				success : function() {
					alert("Django");
					location.reload();
				},
				error : function(e) {
					console.log('Error: ' + e);
				}
			});
	 });
 });
 $(document).ready(function(){
	    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
	    $('.modal-trigger').leanModal();
	  });
 
 $(document).ready(function(){
	 $("#details-button").click(function(){
		 
		 var surveyId=$("input:radio[name='survey']:checked").val();
		 
		 $.ajax({
				type : 'GET',
				url : 'surveyDetails',
				contentType : "application/json",
				data : "surveyId="+surveyId,
				success : function(data) {
					$("#surveyTitle").html("Survey Name: "+data[0]);
					$("#pollCount").html("Poll Count: "+data[1]);
					$("#link").html("http://localhost:8080/SurveyManagementSystem/survey="+data[2]);
//					var link="http://localhost:8080/SurveyManagementSystem/survey="+data[2];
					$("#link").attr("href","http://localhost:8080/SurveyManagementSystem/survey="+data[2]);
				},
				error : function(e) {
					console.log('Error: ' + e);
				}
			});
	 });
 });
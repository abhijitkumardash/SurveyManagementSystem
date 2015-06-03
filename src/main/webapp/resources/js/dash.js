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
			    location.reload();
				},
				error : function(e) {
					console.log('Error: ' + e);
				}
			});
	 });
 });
 
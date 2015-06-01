$(document).ready(function() {

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var answerId = [];
	var questionId = [];
	var surveyId;

	$("input:radio[type=radio]").click(function() {

		answerId.push(Number($(this).val()));
		questionId.push(Number($(this).attr("data-questionId")));
		surveyId = Number($(this).attr("data-surveyId"));

		console.log("questionId:" + questionId);
		console.log("answerId:" + answerId);

	});

	function getPollInputs() {

		var userPoll = {};
		userPoll.surveyId = surveyId;
		userPoll.questions = questionId;
		userPoll.answers = answerId;
		return userPoll;
	}

	$('#poll-submit').click(function() {

		$.ajax({
			type : 'POST',
			url : "savePoll",
			contentType : "application/json",
			data : JSON.stringify(getPollInputs()),
			beforeSend : function(xhr) {
				xhr.setRequestHeader(header, token);
			},

			success : function(data) {
				// window.location.replace("/SurveyManagementSystem").html();
//				console.log(data);
//				console.log(data[1]);
				console.log(data[0]);

				
				$(function() {
					$('#container').highcharts({
						chart : {
							type : 'bar'
						},
						title : {
							text : data[0].questionTitle
						},
						xAxis : {
							categories : data[0].answerTitles,
							title : {
								text : 'Answers'
							}
						},
						yAxis : {
							min : 0,
							max : 100,
							title : {
								text : 'Poll',
								align : 'high'
							},
							labels : {
								overflow : 'justify'
							}
						},
						tooltip : {
							valueSuffix : '%'
						},
						plotOptions : {
							bar : {
								dataLabels : {
									enabled : false
								}
							}
						},
						credits : {
							enabled : true
						},
						series : [ {
							data : data[0].countPercentage
						} ]
					});
				});
				
				
				

			},
			error : function(e) {
				console.log('Error: ' + e);

			}
		});
	});


});




 $(window).load(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$("#survey-id-submit").click(function(){
		
		var surveyId=$("#survey-id").val();
		alert(surveyId);
		sId={"surveyId":surveyId};
		$.ajax({
			type : 'GET',
			url : 'chart1',
			contentType : "application/json",
			data : "surveyId="+surveyId,
			success : function(data) {

				for(var i=0;i<data.length;i++){
					
					chart(data[i],i);
				}

			},
			error : function(e) {
				alert(e);
				console.log('Error: ' + e);

			}
		});
		
	});
	
});


function chart(data,i){

	var str="<div id='chart"+i+"'></div>"
	$('#chart-container').append(str);

					$("#chart"+i).highcharts({
						chart : {
							type : 'bar'
						},
						title : {
							text : data.questionTitle
						},
						xAxis : {
							categories : data.answerTitles,
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
							data : data.countPercentage
						} ]
					});
				};
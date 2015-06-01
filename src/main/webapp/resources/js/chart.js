$(document).ready(function() {
	 $.ajax({
		 type: 'GET',
		 url: "analysis",
	     success: function (data) {
	    	var qt=data[0].questionTitle;
	    	var at=data[0].answerTitle;
	    	var cp=data[0].countPercentage;
	    	
	        chart(data[0]);
	    }
	  });
	 });
function chart(data) { 
    $('#container').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: data.questionTitle
        },
        xAxis: {
            categories: data.answerTitles,
            title: {
                text: 'Answers'
            }
        },
        yAxis: {
            min: 0,
            max:100,
            title: {
                text: 'Poll',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: '%'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: false
                }
            }
        },
        credits: {
            enabled: true
        },
        series: [{
        
            data: data.countPercentage
            
        }]
    });
};

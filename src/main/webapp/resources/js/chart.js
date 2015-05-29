/**
 * 
 */
function chart(data) { 
    $('#container').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: data[0].questionTitle
        },
        xAxis: {
            categories: data[0].categories,
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
        
            data: data[0].series
            
        }]
    });
};

$(document).ready(function() {
	 $.ajax({
	    url: '/analysis',
	    type: 'GET',
	    dataType: "json",
	    success: function (data) {
	        chart(data);
	    }
	  });
	 });
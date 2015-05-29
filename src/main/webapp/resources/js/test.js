$(function () {
    $('#container').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Q1'
        },
        xAxis: {
            categories: ['A1', 'A2', 'A3', 'A4'],
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
        
            data: [80, 31, 50, 20]
            
        }]
    });
});
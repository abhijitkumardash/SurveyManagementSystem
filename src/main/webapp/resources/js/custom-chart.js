/* Custom functions that help in getting remote data and drawing a chart to a div */

function createNewChart(divId) {
    var chart = {
        options: {
            chart: {
                renderTo: divId
            }
        }
    };
    chart = jQuery.extend(true, {}, getBaseChart(), chart);
    chart.init(chart.options);
    return chart;
}


function getBaseChart() {

    var baseChart = {
        highchart: null,
        defaults: {

            chart: {
                renderTo: null,
                shadow: true,
                type: 'bar'
            },
            credits: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            title: {
                text: null,
                align: 'high',
            },
            xAxis: {
                categories: [],
                
                title: {
                    text: null,
                },
                labels: {
                    rotation: -25,
                    align: 'right',
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: null,
            
                },
                labels: {
                    overflow: 'justify'
                },
            },
            tooltip: {
                valueSuffix: null
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -40,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                shadow: true
            },
            credits: {
                enabled: false
            },
            series: []

        },

        // here you'll merge the defaults with the object options
        init: function(options) {
            this.highchart = jQuery.extend({}, this.defaults, options);
        },

        create: function() {
            new Highcharts.Chart(this.highchart);
        }

    };
    return baseChart;
}//function end


function getRemoteDataDrawChart(url, chart) {

    $.ajax({
        url: url,
        dataType: 'json',
        success: function(data) {

            var categories = data.categories;
            var title = data.title;
            var yTitle = data.yAxisTitle;
            var xTitle = data.xAxisTitle;
            var divId =  data.divId;

            //populate the Chart options (highchart)
            chart.highchart.xAxis.categories = categories;
            chart.highchart.title.text = title;
            chart.highchart.yAxis.title.text = yTitle;
            chart.highchart.xAxis.title.text = xTitle;
            chart.highchart.chart.renderTo = divId;

            $.each(data.series, function(i, seriesItem) {
                console.log(seriesItem) ;
                var series = {
                    data: []
                };
                series.name = seriesItem.name;

                $.each(seriesItem.data, function(j, seriesItemData) {
                    console.log("Data (" + j +"): "+seriesItemData) ;
                    series.data.push(parseFloat(seriesItemData));
                });

                chart.highchart.series[i] = series;
            });

            //draw the chart
            chart.create();
        },
    });
} //function end
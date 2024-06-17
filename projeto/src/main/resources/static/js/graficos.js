google.charts.load('current', {
    'packages': ['line', 'corechart', 'bar', 'gauge']
});
google.charts.setOnLoadCallback(drawSelectedChart);

function drawSelectedChart() {
    var chartType = document.getElementById('chartType').value;
    clearChartDiv();
    if (chartType === 'line') {
        drawLineChart();
    } else if (chartType === 'bar') {
        drawBarChart();
    } else if (chartType === 'gauge') {
        drawGaugeChart();
    }
}

function clearChartDiv() {
    var chartDiv = document.getElementById('chart_div');
    chartDiv.innerHTML = '';
}

function drawLineChart() {
    var chartDiv = document.getElementById('chart_div');
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Horário');
    data.addColumn('number', "Temperatura lida");

    data.addRows([
        ['08:00', -.5],
        ['09:00', .4],
        ['10:00', .5],
        ['11:00', 2.9],
        ['12:00', 6.3],
        ['13:00', 9],
        ['14:00', 10.6],
        ['15:00', 10.3],
        ['16:00', 7.4],
        ['17:00', 4.4],
        ['18:00', 1.1],
        ['19:00', -.2]
    ]);

    var options = {
        chart: {
            title: 'Gráfico de linhas'
        },
        width: 900,
        height: 500,
        series: {
            0: {axis: 'Temps'}
        },
        axes: {
            y: {
                Temps: {label: 'Temperatura (Celsius)'}
            }
        }
    };

    var chart = new google.charts.Line(chartDiv);
    chart.draw(data, options);
}

function drawBarChart() {
    var chartDiv = document.getElementById('chart_div');
    var data = google.visualization.arrayToDataTable([
        ['Horário', 'Temperatura'],
        ['08:00', 21],
        ['09:00', 23],
        ['10:00', 27],
        ['11:00', 31],
        ['12:00', 35],
        ['13:00', 32]
    ]);

    var options = {
        chart: {
            title: 'Gráfico de barras',
        },
        bars: 'horizontal'
    };

    var chart = new google.charts.Bar(chartDiv);
    chart.draw(data, google.charts.Bar.convertOptions(options));
}

function drawGaugeChart() {
    var chartDiv = document.getElementById('chart_div');
    var data = google.visualization.arrayToDataTable([
        ['Label', 'Value'],
        ['Mínima', 12],
        ['Atual', 33],
        ['Máxima', 36]
    ]);

    var options = {
        width: 400, height: 120,
        redFrom: 90, redTo: 100,
        yellowFrom: 75, yellowTo: 90,
        minorTicks: 5
    };

    var chart = new google.visualization.Gauge(chartDiv);
    chart.draw(data, options);

    setInterval(function() {
        data.setValue(0, 1, 40 + Math.round(60 * Math.random()));
        chart.draw(data, options);
    }, 13000);
    setInterval(function() {
        data.setValue(1, 1, 40 + Math.round(60 * Math.random()));
        chart.draw(data, options);
    }, 5000);
    setInterval(function() {
        data.setValue(2, 1, 60 + Math.round(20 * Math.random()));
        chart.draw(data, options);
    }, 26000);
}

// Load the Visualization API and the corechart package.
google.charts.load('current', {
	'packages' : [ 'corechart' ]
});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

var pronum = parseInt($('#start').find('.pronum').text());
var malnum = parseInt($('#start').find('.malnum').text());
var webnum = parseInt($('#start').find('.webnum').text());
var sipnum = parseInt($('#start').find('.sipnum').text());
var sshnum = parseInt($('#start').find('.sshnum').text());
var dbnum = parseInt($('#start').find('.dbnum').text());

function drawChart() {

	// Create the data table.
	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Topping');
	data.addColumn('number', 'Slices');
	data.addRows([ [ 'PROBING', pronum ], [ 'WEB', webnum ],
			[ 'MALWARE', malnum ], [ 'SIP', sipnum ], [ 'SSH', sshnum ],
			[ 'DB', dbnum ] ]);

	// Set chart options
	var options = {
		'title' : 'Pie Chart',
		is3D : true,
		'width' : 380,
		'height' : 320
	};

	var options2 = {
		'title' : 'Bar Chart',
		is3D : true,
		'width' : 380,
		'height' : 320
	};

	// Instantiate and draw our chart, passing in some options.
	var chart = new google.visualization.PieChart(document
			.getElementById('pie'));
	chart.draw(data, options);

	var chart1 = new google.visualization.BarChart(document
			.getElementById('bar'));
	chart1.draw(data, options2);

}
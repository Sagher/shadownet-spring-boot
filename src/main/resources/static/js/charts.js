// Load the Visualization API and the corechart package.
google.charts.load('current', {
	'packages' : [ 'corechart' ]
});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

var pronum = parseInt($('#pcount').find('.pronum').text());
var malnum = parseInt($('#pcount').find('.malnum').text());
var webnum = parseInt($('#pcount').find('.webnum').text());
var sipnum = parseInt($('#pcount').find('.sipnum').text());
var sshnum = parseInt($('#pcount').find('.sshnum').text());
var dbnum = parseInt($('#pcount').find('.dbnum').text());

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
		'height' : '100%'
	};

	var options2 = {
		'title' : 'Bar Chart',
		is3D : true,
		'width' : 380,
		'height' : '100%'
	};

	// Instantiate and draw our chart, passing in some options.
	var chart = new google.visualization.PieChart(document
			.getElementById('pie'));
	chart.draw(data, options);

	var chart1 = new google.visualization.BarChart(document
			.getElementById('bar'));
	chart1.draw(data, options2);

}
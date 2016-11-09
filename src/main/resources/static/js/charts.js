var pronum = parseInt($('#pcount').find('.pronum').text());
var malnum = parseInt($('#pcount').find('.malnum').text());
var webnum = parseInt($('#pcount').find('.webnum').text());
var sipnum = parseInt($('#pcount').find('.sipnum').text());
var sshnum = parseInt($('#pcount').find('.sshnum').text());
var dbnum = parseInt($('#pcount').find('.dbnum').text());

var randomColorFactor = function() {
	return Math.round(Math.random() * 255);
};
var randomColor = function(opacity) {
	return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ','
			+ randomColorFactor() + ',' + (opacity || '.7') + ')';
};

var graphData = {
	labels : [ "PROBING", "MALWARE", "WEB", "SIP", "SSH", "DB" ],
	datasets : [ {
		data : [ pronum, malnum, webnum, sipnum, sshnum, dbnum ],
		backgroundColor : [ randomColor(0.7), randomColor(0.7),
				randomColor(0.7), randomColor(0.7), randomColor(0.7),
				randomColor(0.7) ]
	} ]

};

window.onload = function() {
	var pie = document.getElementById("pie");
	window.myPie = new Chart(pie, {
		type : 'doughnut',
		data : graphData,
		options : {
			responsive : true,
			legend : {
				position : 'top',
			},
			title : {
				display : false,
				text : 'Pie Chart'
			}
		}
	});
	var bar = document.getElementById("bar");
	window.myBar = new Chart(bar, {
		type : 'bar',
		data : graphData,
		options : {
			responsive : true,
			legend : {
				display : false
			},
			title : {
				display : false,
				text:'Bar Chart'
			}
		}
	});

};
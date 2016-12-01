var pronum = parseInt($('#pcount').find('.pronum').text());
var malnum = parseInt($('#pcount').find('.malnum').text());
var webnum = parseInt($('#pcount').find('.webnum').text());
var sipnum = parseInt($('#pcount').find('.sipnum').text());
var sshnum = parseInt($('#pcount').find('.sshnum').text());
var dbnum = parseInt($('#pcount').find('.dbnum').text());


var graphData = {
	labels : [ "PROBING", "MALWARE", "WEB", "SIP", "SSH", "DB" ],
	datasets : [ {
		data : [ pronum, malnum, webnum, sipnum, sshnum, dbnum ],
		backgroundColor : [ '#B2912F', '#F15854', '#FAA43A', '#DECF3F',
				'#5DA5DA', '#B276B2', ]
	} ]

};

window.onload = function() {
	var pie = document.getElementById("pie");
	window.myPie = new Chart(pie, {
		type : 'doughnut',
		data : graphData,
		options : {
			responsive : true,
			height : '300px',
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
				text : 'Bar Chart'
			}
		}
	});
};
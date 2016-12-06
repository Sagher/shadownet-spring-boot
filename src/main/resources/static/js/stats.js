var ip1 = $('#top10ips').find('#ikey1').text();
var ip2 = $('#top10ips').find('#ikey2').text();
var ip3 = $('#top10ips').find('#ikey3').text();
var ip4 = $('#top10ips').find('#ikey4').text();
var ip5 = $('#top10ips').find('#ikey5').text();
var ip6 = $('#top10ips').find('#ikey6').text();
var ip7 = $('#top10ips').find('#ikey7').text();
var ip8 = $('#top10ips').find('#ikey8').text();
var ip9 = $('#top10ips').find('#ikey9').text();
var ip10 = $('#top10ips').find('#ikey10').text();

var country1 = $('#top10countries').find('#ckey1').text();
var country2 = $('#top10countries').find('#ckey2').text();
var country3 = $('#top10countries').find('#ckey3').text();
var country4 = $('#top10countries').find('#ckey4').text();
var country5 = $('#top10countries').find('#ckey5').text();
var country6 = $('#top10countries').find('#ckey6').text();
var country7 = $('#top10countries').find('#ckey7').text();
var country8 = $('#top10countries').find('#ckey8').text();
var country9 = $('#top10countries').find('#ckey9').text();
var country10 = $('#top10countries').find('#ckey10').text();

var i1 = parseInt($('#top10ips').find('.value1').text());
var i2 = parseInt($('#top10ips').find('.value2').text());
var i3 = parseInt($('#top10ips').find('.value3').text());
var i4 = parseInt($('#top10ips').find('.value4').text());
var i5 = parseInt($('#top10ips').find('.value5').text());
var i6 = parseInt($('#top10ips').find('.value6').text());
var i7 = parseInt($('#top10ips').find('.value7').text());
var i8 = parseInt($('#top10ips').find('.value8').text());
var i9 = parseInt($('#top10ips').find('.value9').text());
var i10 = parseInt($('#top10ips').find('.value10').text());

var c1 = parseInt($('#top10countries').find('.value1').text());
var c2 = parseInt($('#top10countries').find('.value2').text());
var c3 = parseInt($('#top10countries').find('.value3').text());
var c4 = parseInt($('#top10countries').find('.value4').text());
var c5 = parseInt($('#top10countries').find('.value5').text());
var c6 = parseInt($('#top10countries').find('.value6').text());
var c7 = parseInt($('#top10countries').find('.value7').text());
var c8 = parseInt($('#top10countries').find('.value8').text());
var c9 = parseInt($('#top10countries').find('.value9').text());
var c10 = parseInt($('#top10countries').find('.value10').text());

var ipgraphData = {
	labels : [ ip1, ip2, ip3, ip4, ip5, ip6, ip7, ip8, ip9, ip10 ],
	datasets : [ {
		data : [ i1, i2, i3, i4, i5, i6, i7, i8, i9, i10 ],
		backgroundColor : [ '#FAA43A', '#DECF3F', '#5DA5DA', '#B276B2',
				'#DECF3F', '#FAA43A', '#5DA5DA', '#B276B2', '#000333',
				'#FAA43A' ]
	} ]
};

var ubar = document.getElementById("ubar");
window.myBar = new Chart(ubar, {
	type : 'bar',
	data : ipgraphData,
	options : {
		responsive : true,
		legend : {
			display : false
		},
		title : {
			display : true,
			text : 'Most Detected IPs'
		}
	}
});

var cgraphData = {
	labels : [ country1, country2, country3, country4, country5, country6,
			country7, country8, country9, country10 ],
	datasets : [ {
		data : [ c1, c2, c3, c4, c4, c5, c5, c6, c7, c8, c9, c10 ],
		backgroundColor : [ '#FAA43A', '#DECF3F', '#5DA5DA', '#B276B2',
				'#DECF3F', '#FAA43A', '#5DA5DA', '#B276B2', '#000333',
				'#FAA43A' ]
	} ]

};
var cbar = document.getElementById("cbar");
window.myBar = new Chart(cbar, {
	type : 'bar',
	data : cgraphData,
	options : {
		responsive : true,
		legend : {
			display : false
		},
		title : {
			display : true,
			text : 'Top 10 Countries'
		}
	}
});
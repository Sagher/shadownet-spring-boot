var arcs = new Datamap({
	element : document.getElementById("map"),
	scope : 'world',
	fills : {
		defaultFill : '#1c1b1b'
	},
	geographyConfig : {
		hideAntarctica : true,
		borderWidth : 1,
		borderOpacity : 1,
		borderColor : '#68becc',
		popupOnHover : true,
		highlightOnHover : false,
		highlightFillColor : '',
		highlightBorderColor : '',
		highlightBorderWidth : 1,
		highlightBorderOpacity : 1
	},
	arcConfig : {
		strokeColor : 'orange',
		strokeWidth : 2,
		arcSharpness : 1,
		animationSpeed : 600
	},

});

setInterval(function() {
	var cc = $('.countrycode').find('#div1').text();
	var c2 = $('.countrycode').find('#div2').text();
	var c3 = $('.countrycode').find('#div3').text();
	var c4 = $('.countrycode').find('#div4').text();

	arcs.arc([ {
		origin : cc,
		destination : 'PAK'
	}, {
		origin : c2,
		destination : 'PAK'
	}, {
		origin : c3,
		destination : 'PAK'
	}, {
		origin : c4,
		destination : 'PAK'
	} ]);
}, 2200);
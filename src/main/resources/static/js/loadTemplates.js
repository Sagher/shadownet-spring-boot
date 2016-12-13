$(function() {

	$("#navigation").load("/elements/navbar.js");

	$("#sidebar").load("/elements/sidebar.js");

	$("#modal").load("/elements/modal.js");

});

$(document).ready(function() {
	setTimeout(function() {
		var user = $('#sessionuser').text();
		$('#user').html(user);

		var form = $('#hiddenform');
		$('#form').html(form);
	}, 100);

});

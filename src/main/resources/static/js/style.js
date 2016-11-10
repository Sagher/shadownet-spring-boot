// implementing datatables
$(window).ready(function() {
	$('.table').dataTable({
		"iDisplayLength" : 10,
		"sPaginationType" : "full_numbers",
		"bLengthChange" : true

	});

});
//showing and hiding navigation tabs
$(document).ready(function() {
	$(".nav-tabs a").click(function() {
		$(this).tab('show');
	});
});

// implementing datatables
$(window).ready(function() {
	$('.one').dataTable();
});
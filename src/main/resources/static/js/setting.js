$('#block').click(function() {
	var url = '/setting?ip=';
	var inputURL = $('#ip').val();
	var urll = url + inputURL;
	$.get(urll, function() {
		window.location.href = '/setting?ip=default';

	});
})

$('#block').click(function() {
	var url = '/blocklist?ip=';
	var inputURL = $('#ip').val();
	var urll = url + inputURL;
	$.get(urll, function() {
		window.location.href = '/blocklist';

	});
})

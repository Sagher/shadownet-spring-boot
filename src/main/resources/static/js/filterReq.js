$('#probing').click(function() {
	var url = '/probing?size=';
	var inputURL = parseInt($('#pcount').find('.pronum').text());
	window.location.href = url + inputURL;
	return false;

})

$('#malware').click(function() {
	var url = '/malware?size=';
	var inputURL = parseInt($('#pcount').find('.malnum').text());
	window.location.href = url + inputURL;
	return false;

})

$('#web').click(function() {
	var url = '/web?size=';
	var inputURL = parseInt($('#pcount').find('.webnum').text());
	window.location.href = url + inputURL;
	return false;

})

$('#sip').click(function() {
	var url = '/sip?size=';
	var inputURL = parseInt($('#pcount').find('.sipnum').text());
	window.location.href = url + inputURL;
	return false;

})

$('#ssh').click(function() {
	var url = '/ssh?size=';
	var inputURL = parseInt($('#pcount').find('.sshnum').text());
	window.location.href = url + inputURL;
	return false;

})

$('#db').click(function() {
	var url = '/db?size=';
	var inputURL = parseInt($('#pcount').find('.dbnum').text());
	window.location.href = url + inputURL;
	return false;

})

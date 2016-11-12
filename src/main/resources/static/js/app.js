var stompClient = null;

function connect() {
	var socket = new SockJS('/newMessage');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/newMessage', function(message) {
			refreshMessages(JSON.parse(JSON.parse(message.body).content));
		});
	});
}

var count = 1;
function refreshMessages(messages) {
	$(".media-list").html("");
	$.each(messages, function(i, message) {
		if (message.countryCode != null) {
			$(".media-list").append(
					'<div class="col-sm-3"><div class="bar-live"></div>&nbsp;<text>'
							+ message.time + '<br/>&nbsp;Source: <b>'
							+ message.sourceIP + '<br/> &nbsp;'
							+ message.maliciousType + ' <br/> &nbsp;'
							+ message.location + '&nbsp;, '
							+ message.countryCode + '</b></text></div>');

			if (count > 4) {
				$(".countrycode").html("");
				count = 1;
			} else {
				var html = "<div id='div" + count + "'>" + message.countryCode
						+ "</div>";
				$(".countrycode").append(html);
				count++;
			}
		} else {

		}

	});
}

$(function() {
	connect();

})

$(document).ready(function() {
	setInterval(function() {
		$.get("/messages", function(messages) {
			refreshMessages(messages)
		});
	}, 2000);
});

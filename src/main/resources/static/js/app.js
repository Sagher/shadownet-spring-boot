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
function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}
}

function refreshMessages(messages) {
	$(".media-list").html("");
	$.each(messages, function(i, message) {
		if ((message.maliciousType.length != 4)
				&& (message.direction == "INCOMING")) {
			$(".media-list").append(
					'&nbsp;&nbsp;<li style="float: left;background-color:#e1f4e9">'
							+ message.time + '&nbsp;&emsp;&emsp;'
							+ '<br/> Source: <b>' + message.sourceIP + '<br/> '
							+ message.maliciousType + ' <br/>'
							+ message.location + '</b> </li>');
		} else {

		}

	});
}

$(function() {

	connect();

})

$(document).ready(function() {
	setInterval(function() {
		var randomnumber = Math.floor(Math.random() * 100)
		$.get("/messages", function(messages) {
			refreshMessages(messages)
		});
	}, 2000);
});
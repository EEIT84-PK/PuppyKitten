<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
<script src="<%=request.getContextPath()%>/jquery/jquery-2.2.2.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/jquery-ui.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			var websocket = new WebSocket("ws://localhost:8080/PuppyKitten/chatEndpoint.chat");
			websocket.onopen = function processOpen(){
				websocket.send("open");
				websocket.protocol("123");
			}
			websocket.onmessage = function processMessage(message) {
				var jsonData = JSON.parse(message.data);
				if(jsonData.message!=null){
					area.value += jsonData.message +"\n";
				}
				
			}
			
			$(function(){
				$('#sendmsg').click(function(){
					websocket.send(text.value);
					text.value="";
				});
			});
		</script>
	</head>
	<body>
		<textarea id="area" readonly="readonly" rows="10" cols="45"></textarea><br>
		<input type="text" id="text" size="50" /><input id="sendmsg" type="button" value="送出" />

		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="websocketdiv" ><c:import url="/import/websocket.jsp"></c:import></div>
	<footer>
	
			
			<ul id="footer_left">
				<li>© 2016 Copyright  All rights reserved Puppy x Kitten
					寵物精品網 | 台北市大安區復興南路一段390號2樓</li>
			</ul>
			<ul id="footer_right">
				<li><span id="footermsg">即時客服</span></li>
			</ul>	
	</footer>
			<script type="text/javascript">
var websocket = new WebSocket("ws://localhost:8080/PuppyKitten/chatEndpoint.chat");
websocket.onmessage = function processMessage(message) {
	var jsonData = JSON.parse(message.data);
	if(jsonData.message!=null){
		area.value += jsonData.message +"\n";
	}
	
}
</script>
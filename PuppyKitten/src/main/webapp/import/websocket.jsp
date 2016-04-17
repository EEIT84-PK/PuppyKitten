<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<span style="color:white">即時客服</span>
    	<img src="<%=request.getContextPath()%>/images/minus.png" style="height: 10px;width: 20px;float: right;display: block;" />
		<textarea id="area" style="font-size: 20px;margin-top: 20px;" readonly="readonly" rows="10" cols="38"></textarea><br>
		<input type="text" id="text" size="53" /><input id="sendmsg" type="button" value="送出" />

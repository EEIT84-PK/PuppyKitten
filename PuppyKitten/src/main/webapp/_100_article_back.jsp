<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head_back.jsp"></c:import>
<title>後台系統 - 討論大廳系統</title>
<style>
    @IMPORT url("<%=request.getContextPath()%>/css/index_back.css");
    
.formtr{
text-align: center;
}

.bodyhide,#id,#kind,#time,#hot,#user{
cursor: pointer;
color:#400000;
}
</style>
<script src="<%=request.getContextPath()%>/javascript/article_back.js"></script>
<script>
$(function(){
	$('.formtrhide').hide();
	$('thead th').mouseover(function(){
		$(this).css("background","rgba(255, 240, 200, 1)").mouseout(function(){
			$(this).css("background","rgba(255, 255, 215, 0.4)");
		});
	});	
});

</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/article/articleBackAction.action" method="get">
	<input type="submit" value="查詢" style="float:left;height:25px;">
</form>
<!-- ArticleBean -->
<c:choose>
<c:when test="${not empty select}">
<b style="font-size:25px;">討論大廳資訊</b><b id="success" style="font-size:20px;color:red"></b>
<table id="datatable" border="1" style="border-collapse: collapse;width:850px;">
	<thead>
	<tr style="background:rgba(255, 255, 215, 0.4);">
		<td style="text-align: center;"><b>內容</b></td>
		<th id="id"><a href='<c:url value="/article/articleBackAction.action" ></c:url>'>編號</a></th>
		<th id="kind"><a href='<c:url value="/article/articleBackAction.action" ><c:param name="use">kind</c:param></c:url>'>類別</a></th>
		<th>標題</th>
		<th id="user"><a href='<c:url value="/article/articleBackAction.action" ><c:param name="use">user</c:param></c:url>'>發言人</a></th>
		<th id="time"><a href='<c:url value="/article/articleBackAction.action" ><c:param name="use">time</c:param></c:url>'>時間</a></th>
		<th id="hot"><a href='<c:url value="/article/articleBackAction.action" ><c:param name="use">hot</c:param></c:url>'>點擊率</a></th>
		<th>編輯</th>
	</tr>
	</thead>
	<tbody>	
	<c:forEach var="article" items="${select}">
	<tr class="formtr">
		<td class="bodyhide"><img src="<%=request.getContextPath()%>/images/body.png" width="15px;"></td>		
		<td>${article.ART_ID}</td>
		<td>${article.ART_KIND}</td>
		<td style="width:250px;">${article.ART_TITLE}</td>
		<td style="width:100px;">${article.ART_MEM_ID}</td>
		<td style="width:250px;">${article.ART_TIME}</td>
		<td style="width:70px;">${article.ART_HOT}</td>
		<td style="width:30px;"><input type="button" class="delete" value="移除" /></td>		
	</tr>
	<tr class="formtrhide" style="text-align: center;"><td colspan="8" style="text-align: left;padding-left: 20px;"><img src="${article.ART_IMG}"><p>${article.ART_BODY}</p></td></tr>	
	</c:forEach>
	</tbody>
</table>
</c:when>
</c:choose>
</body>
</html>
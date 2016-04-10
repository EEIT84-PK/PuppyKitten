<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head_back.jsp"></c:import>
<title>後台系統 - 討論大廳系統</title>
<style>
#formtr td{
text-align: center;
}

</style>
</head>
<body>
<form action="<%=request.getContextPath()%>/article/articleBackAction.action" method="get">
	<input type="submit" value="查詢" style="float:left;height:25px;">
</form>
<!-- ArticleBean -->
<c:choose>
<c:when test="${not empty select}">
<table id="datatable" border="1" style="border-collapse: collapse;width:850px;">
	<thead>
	<tr style="background:rgba(255, 255, 215, 0.4);">
		<th>編號</th>
		<th>類別</th>
		<th>標題</th>
		<th>時間</th>
		<th>點擊率</th>
		<th>編輯</th>
	</tr>
	</thead>
	<tbody>	
	<c:forEach var="article" items="${select}">
	<tr id="formtr">		
		<td>${article.ART_ID}</td>
		<td>${article.ART_KIND}</td>
		<td style="width:250px;">${article.ART_TITLE}</td>
		<td style="width:250px;">${article.ART_TIME}</td>
		<td style="width:70px;">${article.ART_HOT}</td>
		<td style="width:30px;"><input type="button" class="delete" value="移除" /></td>		
	</tr>
	
	</c:forEach>
	</tbody>
</table>
</c:when>
</c:choose>
</body>
</html>
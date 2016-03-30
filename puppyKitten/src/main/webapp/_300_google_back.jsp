<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/jquery/jquery-2.2.2.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/jquery-ui.min.js"></script>
<title>後台系統 - Google Map</title>

<style>
	#mapform input[type="button"]{
		
	}
</style>
<script>
$(document).ready(function(){
	var $update =$('#mapform input[class="update"]');
	var path = "${pageContext.request.contextPath}";
 	var url = path+"/map/mapActionBack.action";
 	
	$update.click(function(){
		var $text =$(this).parent().siblings().eq(0).text();
		$('#updateid').val($text);
	 	var queryString = "&mapBean.MAP_ID="+$text+"&dummy="+new Date().getTime();
	 	alert(queryString);
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send(null);
	});
	
	function doReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				console.log("SUCCESS!");
				
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}
});

</script>


</head>
<body>
<form action="<%=request.getContextPath()%>/map/mapActionBack.action" method="get">
地圖編號<input type="text" name="mapBean.MAP_ID" value="${mapBean.MAP_ID}" pattern=""/>
<input type="submit" value="查詢" name="choose">
</form>
<c:choose>
<c:when test="${not empty select}">
<h3>搜尋到的店家:</h3>
<table border="1" style="border-collapse: collapse;">
	<thead>
	<tr style="background:#DDDDDD">
		<th>編號</th>
		<th>類別</th>
		<th>店名</th>
		<th>地址</th>
		<th>電話</th>
		<th>編輯</th>
	</tr>
	</thead>
	<tbody>	
	<c:forEach var="map" items="${select}">
	<tr id="mapform">		
		<td>${map.MAP_ID}</td>
		<td><input type="text" value="${map.MAP_KIND}" style="border-style: none;width:70px;"></td>
		<td><input type="text" value="${map.MAP_NAME}" style="border-style: none;width:180px;"></td>
		<td><input type="text" value="${map.MAP_ADD}" style="border-style: none;width:250px;"></td>
		<td><input type="text" value="${map.MAP_PHONE}" style="border-style: none;width:100px;"></td>
		<td><input type="button" class="update" name="choose" value="查詢"/><input type="button" value="刪除" /></td>		
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:when>
<c:otherwise>
<h3>未搜尋到任何店家</h3>
</c:otherwise>
</c:choose>
<form action="<%=request.getContextPath()%>/map/mapActionBack" method="get" id="updateform">
	<input id="updateid" type="text" name="mapBean.MAP_ID" value="${mapBean.MAP_ID}">
	<input type="submit" value="修改" name="choose">
</form>	
</body>
</html>
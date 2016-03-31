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

<script>

$(document).ready(function(){
	var $update =$('input[class="update"]');
	var $delete =$('input[class="delete"]');
	var $useUpdate = $update.attr('name');
	var $useDelete = $delete.attr('name');
	var path = "${pageContext.request.contextPath}";
 	var url = path+"/map/mapActionBack.controller";
 	
	$update.click(function(){
		var $text =$(this).parent().siblings().eq(0).text();
		var $kind =$(this).parent().siblings().children().eq(0).val();
		var $name =$(this).parent().siblings().children().eq(1).val();
		var $address = $(this).parent().siblings().children().eq(2).val();
		var $phone = $(this).parent().siblings().children().eq(3).val();
	 	var queryString = "&mapBean.MAP_ID="+$text+"&mapBean.MAP_KIND="+$kind+"&mapBean.MAP_NAME="+$name
	 	+"&mapBean.MAP_ADD="+$address+"&mapBean.MAP_PHONE="+$phone+"&mapBean.use"+$useUpdate+"&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
	});
	$delete.click(function(){
		var $text =$(this).parent().siblings().eq(0).text();
	 	var queryString = "&mapBean.MAP_ID="+$text+"&mapBean.use"+$useDelete+"&dummy="+new Date().getTime();
	 	alert($useDelete);
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
	});
	
	function doReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				$('#success').html(request.responseText);
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
地圖編號<input type="text" name="mapBean.MAP_ID" value="${mapBean.MAP_ID}" />
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
	<tr>		
		<td>${map.MAP_ID}</td>
		<td><input type="text" value="${map.MAP_KIND}" style="border-style: none;width:70px;"></td>
		<td><input type="text" value="${map.MAP_NAME}" style="border-style: none;width:180px;"></td>
		<td><input type="text" value="${map.MAP_ADD}" style="border-style: none;width:250px;"></td>
		<td><input type="text" value="${map.MAP_PHONE}" style="border-style: none;width:100px;"></td>
		<td><input type="submit" class="update" name="update" value="修改"/>
		<input type="button" class="delete" name="delete" value="移除" /></td>		
	</tr>
	<h4 id="success" style="color:red"></h4>
	</c:forEach>
	</tbody>
</table>
</c:when>
<c:otherwise>
<h3>未搜尋到任何店家</h3>
</c:otherwise>
</c:choose>
</body>
</html>
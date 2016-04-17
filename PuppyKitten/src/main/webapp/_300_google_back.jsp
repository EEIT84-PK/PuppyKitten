<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head_back.jsp"></c:import>
<title>後台系統 - Google Map</title>
<script src="<%=request.getContextPath()%>/javascript/googlemap_back.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/google_back.css">

<script>


</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/map/mapBackAction.action" method="get">
	<input type="submit" value="查詢" style="float:left;height:25px;">
</form>

<!-- MapBean -->
<c:choose>
<c:when test="${not empty select}">
<div style="border-bottom: 1px solid #DDDDDD;">
<b style="font-size:25px;">店家資訊</b><b id="success" style="font-size:20px;color:red"></b>
<button id="create-user" style="float:right">新增店家資訊</button>
<br><br>
</div>
<table id="datatable" border="1" style="border-collapse: collapse;width:850px;">
	<thead>
	<tr style="background:rgba(255, 255, 215, 0.4);">
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
		<td style="width:50px;">${map.MAP_ID}</td>
		<td style="width:100px;">${map.MAP_KIND}</td>
		<td style="width:150px;"><input type="text" value="${map.MAP_NAME}" style="border-style: none;"></td>
		<td style="width:250px;"><input type="text" value="${map.MAP_ADD}" style="border-style:none;width:250px;"></td>
		<td style="width:100px;"><input type="text" value="${map.MAP_PHONE}" style="border-style:none;width:100px;"></td>
		<td style="width:78px;"><input style="display:inline" type="button" class="update" value="修改" /><input style="display:inline" type="button" class="delete" value="移除" /></td>		
	</tr>
	
	</c:forEach>
	</tbody>
</table>
</c:when>
</c:choose>
<div id="dialog-form" title="新增店家資訊">
  <p class="validateTips">管理員您好</p>
 
  <form>
    <fieldset>
      <label for="kind">店家種類</label>
      <input type="text" name="kind" id="kind" value="寵物醫院" class="text ui-widget-content ui-corner-all">
      <label for="name">店家名稱</label>
      <input type="text" name="name" id="name" value="陳柏安的寵物店" class="text ui-widget-content ui-corner-all">
      <label for="phone">店家電話</label>
      <input type="text" name="phone" id="phone" value="02-2855-5508" class="text ui-widget-content ui-corner-all">
      <label for="city">縣市</label>
      <input type="text" name="city" id="city" value="新北市" class="text ui-widget-content ui-corner-all">
      <label for="area">區域</label>
      <input type="text" name="area" id="area" value="樹林區" class="text ui-widget-content ui-corner-all">
      <label for="address">地址</label>
      <input type="text" name="address" id="address" value="新北市樹林區資策路84號" class="text ui-widget-content ui-corner-all">

      <input id="insert" type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>

</body>
</html>
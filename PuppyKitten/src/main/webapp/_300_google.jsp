<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<title>米沃貓窩 - Google Map</title>
<script src="https://maps.googleapis.com/maps/api/js?key=&signed_in=true&callback=initMap" async defer></script>
<script src="<%=request.getContextPath()%>/jquery/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/javascript/googlemap.js"></script>

<style>
#map {height: 40%;width: 40%;position: absolute; float: right; display:inline;bottom: 200px;left:1000px}
.trcolor {background: white;}
</style>
</head>
<body>
	<c:import url="/import/header.jsp"></c:import>

	<section>
		<article>
			<form action="<%=request.getContextPath()%>/map/mapAction.action"
				method="get" id="form">
				<h2 style="display: inline">您選擇的是 :</h2>
				<b id="select" style="font-size: xx-large">${mapBean.MAP_KIND}</b> <br>
				<br> <select id="taipei">
					<option value="1">請輸入縣市</option>
					<option value="台北市">台北市</option>
					<option value="新北市">新北市</option>
				</select> <select id="taipeiarea">
					<option>請輸入區域</option>
				</select> <br> <br> <input class="click" type="submit" value="寵物醫院"
					style="height: 50px"> <input class="click" type="submit"
					value="寵物用品店" style="height: 50px"> <input class="click"
					type="submit" value="寵物餐廳" style="height: 50px"> <input
					type="text" name="mapBean.MAP_KIND" id="kind"
					value="${mapBean.MAP_KIND}" class="text"> <input
					type="text" name="mapBean.MAP_CITY" id="city"
					value="${mapBean.MAP_CITY}" class="text"> <input
					type="text" name="mapBean.MAP_AREA" id="area"
					value="${mapBean.MAP_AREA}" class="text"> <br>
			</form>
			<c:choose>
				<c:when test="${not empty select}">
					<h3>搜尋到的店家:</h3>
					<table id="datatable" border="1" style="border-collapse: collapse;">
						<thead>
							<tr style="background: rgba(255, 255, 215, 0.4)">
								<th>編號</th>
								<th>類別</th>
								<th>店名</th>
								<th>地址</th>
							</tr>
						</thead>
						<tbody style="font-size: 20px;">
							<c:forEach var="map" items="${select}">
								<tr class="trcolor">
									<td>${map.MAP_ID}</td>
									<td style="width: 100px;">${map.MAP_KIND}</td>
									<td style="width: 200px;">${map.MAP_NAME}</td>
									<td>${map.MAP_ADD}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br>
	地址:<input type="text" id="address" style="width: 400px">
					<input id="submit" type="button" value="Google Map">

				</c:when>
				<c:otherwise>
					<h3>未搜尋到任何店家</h3>
				</c:otherwise>
			</c:choose>
		</article>
		<div id="map"></div>

		<h3 id="msg" style="float: right;"></h3>
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
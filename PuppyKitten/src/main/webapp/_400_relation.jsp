<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩(交友中心)</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<style type="text/css">
	td{
		width: 100px;
		word-break:break-all;
	}	
</style>
<body style="font-family: 微軟正黑體; font-size: large">
<c:import url="/import/header.jsp"></c:import>
<section>
	<article>
		<h1>寵物聯誼(交友中心)</h1>
		<font color="red"><b>喜歡我的人是</b></font>
		<table border="1" style="border-collapse: collapse;" >
		<c:forEach var="sort" items="${list}">
				<tr>
					<td>寵物編號：</td>
					<td>${sort.PET_ID}</td>
				</tr>
				<tr>
					<td>會員編號：</td>
					<td>${sort.PET_ID}</td>
				</tr>
				<tr>
					<td>寵物名字：</td>
					<td>${sort.PET_NAME }</td>
				</tr>
				<tr>
					<td>寵物年齡：</td>
					<td>${sort.PET_AGE}</td>
				</tr>
				<tr>
					<td>寵物體重：</td>
					<td>${sort.PET_WEIGHT}kg</td>
				</tr>
				<tr>
					<td>寵物種類：</td>
					<td>${sort.PET_KING}</td>
				</tr>
				<tr>
					<td>寵物品種：</td>
					<td>${sort.PET_SORT_NAME}</td>
				</tr>
				<tr>
					<td>寵物性別：</td>
					<td>${sort.PET_SEX}<BR></td>
				</tr>
				<tr>
					<td>寵物照片：</td>
					<td><img src="${sort.PET_IMAGE}" width="300" height="300"></td>
				</tr>				
				<tr>
					<td>寵物介紹：</td>
					<td>${sort.PET_BODY}</td>
				</tr>
				</c:forEach>
			</table>	
	</article>	
</section>
	
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
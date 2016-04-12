<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	td{
		width: 100px;
		word-break:break-all;
	}	
</style>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩-配對系統</title>
</head>
<body style="font-family: 微軟正黑體; font-size: large">
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<article>
			<h1>寵物聯誼(配對系統)</h1>			
			<a href='<c:url value="/petLike/PetLikeAction.action" ></c:url>'>感興趣</a>
			<a href='<c:url value="/petNotLike/PetNotLikeAction.action" ></c:url>'>不感興趣</a>
			<table border="1" style="border-collapse: collapse;" >
				<tr>
					<td>寵物編號：</td>
					<td>${petBean.PET_ID }</td>
				</tr>
				<tr>
					<td>會員編號：</td>
					<td>${petBean.PET_OWN_ID}</td>
				</tr>
				<tr>
					<td>寵物名字：</td>
					<td>${petBean.PET_NAME }</td>
				</tr>
				<tr>
					<td>寵物年齡：</td>
					<td>${PET_AGE}</td>
				</tr>
				<tr>
					<td>寵物體重：</td>
					<td>${petBean.PET_WEIGHT}kg</td>
				</tr>
				<tr>
					<td>寵物種類：</td>
					<td>${petBean.PET_KING}</td>
				</tr>
				<tr>
					<td>寵物品種：</td>
					<td>${Sortbean.PET_SORT_NAME}</td>
				</tr>
				<tr>
					<td>寵物性別：</td>
					<td>${petBean.PET_SEX}<BR></td>
				</tr>
				<tr>
					<td>寵物照片：</td>
					<td><img src="${petImg}" width="300" height="300"></td>
				</tr>
				<tr>
					<td>寵物介紹：</td>
					<td>${bean.PET_BODY}</td>
				</tr>
			</table>			
		</article>
		<aside>			
		</aside>
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
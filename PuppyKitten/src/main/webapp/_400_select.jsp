<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	td{
		width: 100px;
	}	
</style>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
<title>米沃貓窩-個人寵物資訊</title>
</head>
<body style="font-family: 微軟正黑體; font-size: large">
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<article>
			<h1>寵物聯誼(個人寵物資訊)</h1>
			<a href="<%=request.getContextPath()%>/_400_index.jsp">回寵物大廳</a>
			<table border="1" style="border-collapse: collapse;" >
				<tr>
					<td>寵物編號：</td>
					<td>${bean.PET_ID }</td>
				</tr>
				<tr>
					<td>會員編號：</td>
					<td>${bean.PET_OWN_ID}</td>
				</tr>
				<tr>
					<td>寵物名字：</td>
					<td>${bean.PET_NAME }</td>
				</tr>
				<tr>
					<td>寵物年齡：</td>
					<td>${PET_AGE}</td>
				</tr>
				<tr>
					<td>寵物體重：</td>
					<td>${bean.PET_WEIGHT}kg</td>
				</tr>
				<tr>
					<td>寵物種類：</td>
					<td>${bean.PET_KING}</td>
				</tr>
				<tr>
					<td>寵物品種：</td>
					<td>${Sortbean.PET_SORT_NAME}</td>
				</tr>
				<tr>
					<td>寵物性別：</td>
					<td>${bean.PET_SEX}<BR></td>
				</tr>
				<tr>
					<td>寵物照片：</td>
					<td><img src="${petImg}"></td>
				</tr>
			</table>			
		</article>
		<aside>			
		</aside>
=======
<title>米沃貓窩-寵物資訊</title>
</head>
<body style="font-family: 微軟正黑體; font-size: large">
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<article>
			<h1>寵物聯誼(寵物資訊)</h1>
			<table border="1" style="border-collapse: collapse;" >
				<tr>
					<td>寵物編號：</td>
					<td>${bean.PET_ID }</td>
				</tr>
				<tr>
					<td>會員編號：</td>
					<td>${bean.PET_OWN_ID}</td>
				</tr>
				<tr>
					<td>寵物名字：</td>
					<td>${bean.PET_NAME }</td>
				</tr>
				<tr>
					<td>寵物年齡：</td>
					<td>${PET_AGE}</td>
				</tr>
				<tr>
					<td>寵物體重：</td>
					<td>${bean.PET_WEIGHT}kg</td>
				</tr>
				<tr>
					<td>寵物種類：</td>
					<td>${bean.PET_KING}</td>
				</tr>
				<tr>
					<td>寵物品種：</td>
					<td>${Sortbean.PET_SORT_NAME}</td>
				</tr>
				<tr>
					<td>寵物性別：</td>
					<td>${bean.PET_SEX}<BR></td>
				</tr>
				<tr>
					<td>寵物照片：</td>
					<td><img src="${petImg}"></td>
				</tr>
			</table>
			
		</article>
		<aside></aside>
>>>>>>> branch 'master' of https://github.com/EEIT84-PK/PuppyKitten.git
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
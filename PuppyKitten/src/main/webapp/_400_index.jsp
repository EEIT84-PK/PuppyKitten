<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩(寵物大廳)</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<body style="font-family: 微軟正黑體; font-size: large">
<c:import url="/import/header.jsp"></c:import>
<section>
	<article>
		<h1>寵物聯誼(寵物大廳)</h1>
	<a href='<c:url value="/petFriendship/petFriendshipAction.action" ></c:url>'>寵物配對系統</a>
	<a href='<c:url value="/petSelect/PetSelectAction.action" ></c:url>'>查詢寵物資訊</a>

	
	</article>
	<aside>

	</aside>
</section>
	
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
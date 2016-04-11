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
<title>米沃貓窩-配對系統</title>
</head>
<body style="font-family: 微軟正黑體; font-size: large">
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<article>
			<h1>寵物聯誼(配對系統)</h1>
			<font color="red"><b>${end}<br></b></font>								
			<a href='<c:url value="/petRelation/petRelationaAction.action" ></c:url>'>交友中心</a>						
		</article>
		<aside>			
		</aside>
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
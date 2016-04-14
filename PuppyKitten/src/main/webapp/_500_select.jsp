<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td {
	width: 200px;
	word-break: break-all;
}
</style>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>米沃貓窩-個人寵物資訊</title>
</head>
<body style="font-family: 微軟正黑體; font-size: large">
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<article>
			<h1 style="font-size: 50px;">會員資料(個人資料)</h1>

			<table border="1" style="border-collapse: collapse;">

				<tr>
					<td>姓名:</td>
					<td>${bean.MEM_NAME}</td>
				</tr>
				<tr>
					<td>身分證字號:</td>
					<td>${bean.MEM_IDCARD}</td>
				</tr>
				<tr>
					<td>生日:</td>
					<td>${bean.MEM_BIRTHDAY}</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>${bean.MEM_ADD}</td>
				</tr>
				<tr>
					<td>手機:</td>
					<td>${bean.MEM_PHONE}</td>
				</tr>
				<tr>
					<td>信箱:</td>
					<td>${bean.MEM_EMAIL}</td>
				</tr>
			</table>
			<form
				action="<%=request.getContextPath()%>/login/updateAction.action">
				<input type="submit" value="修改帳戶">
			</form>
			
		</article>
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
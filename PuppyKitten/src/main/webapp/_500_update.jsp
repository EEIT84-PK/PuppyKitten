<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#age").attr("readonly", "readonly").datepicker({
			showOn : "focus",
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd",
			minDate : new Date("1950-12-01"),
			maxDate : new Date("2016-04-05"),
		})
	});
</script>

<title>米沃貓窩 - 修改資料</title>
</head>
<body>
	<c:import url="/import/header.jsp"></c:import>

	<section>
		<article>
			<h1 style="font-size: 50px;">修改資料</h1>
			<form action="login/updateAction.action" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="memberBean.MEM_ID" value="${bean.MEM_ID}">
				<table>
					<tr>
						<td>姓名:</td>
						<td><input type="text" name="memberBean.MEM_NAME"
							value="${bean.MEM_NAME}"></td>
						<td style="color: red">${errors.MEM_NAME[0]}</td>
					</tr>
					<tr>
						<td>身分證字號:</td>
						<td><input type="text" name="memberBean.MEM_IDCARD"
							 value="${bean.MEM_IDCARD}"></td>
						<td style="color: red">${errors.MEM_IDCARD[0]}</td>
					</tr>
					<tr>
						<td>生日:</td>
						<td><input type="text" name="memberBean.MEM_BIRTHDAY" id="age"
							value="<fmt:formatDate pattern="yyyy-MM-dd" value="${bean.MEM_BIRTHDAY}"/>"/>
							
						<td style="color: red">${errors.MEM_BIRTHDAY[0]}</td>
					</tr>
					<tr>
						<td>地址:</td>
						<td><input type="text" name="memberBean.MEM_ADD"
							value="${bean.MEM_ADD}"></td>
						<td style="color: red">${errors.MEM_ADD[0]}</td>
					</tr>
					<tr>
						<td>手機:</td>
						<td><input type="text" name="memberBean.MEM_PHONE"
							value="${bean.MEM_PHONE}"></td>
						<td style="color: red">${errors.MEM_PHONE[0]}</td>
					</tr>
					<tr>
						<td>信箱:</td>
						<td><input type="email" name="memberBean.MEM_EMAIL"
							value="${bean.MEM_EMAIL}"></td>
						<td style="color: red">${errors.MEM_EMAIL[0]}</td>
					</tr>
				</table>
				<input type="submit" value="修改會員">
			</form>
			
		</article>

	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
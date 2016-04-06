<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>米沃貓窩 - 會員註冊</title>
</head>
<body>
	<c:import url="/import/header.jsp"></c:import>

	<section>
		<article>
			<h1 style="font-size: 50px;">會員註冊</h1>

			<form action="login/insertAction.action" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>帳號:<br></td>
						<td><input type="text" name="bean.MEM_ACCOUNT"
							value="${param.MEM_ACCOUNT }"><span style="color: red">${errors.MEM_ACCOUNT}</span></td>
					</tr>
					<tr>
						<td>密碼:</td>
						<td><input type="password" name="password"
							value="${param.password }"><span style="color: red">${errors.password}</span></td>
					</tr>
					<tr>
						<td>確認密碼:</td>
						<td><input type="password" name="checkpassword"
							value="${param.password }"><span style="color: red">${errors.password }</span></td>
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input type="text" name="bean.MEM_NAME"
							value="${param.MEM_NAME }"><span style="color: red">${errors.MEM_NAME}</span></td>
					</tr>
					<tr>
						<td>身分證字號:</td>
						<td><input type="text" name="bean.MEM_IDCARD"
							value="${param.MEM_IDCARD }"><span style="color: red">${errors.MEM_IDCARD }</span></td>
					</tr>
					<tr>
						<td>生日:</td>
						<td><input type="text" name="bean.MEM_BIRTHDAY" id="#age"
							value="${param.MEM_BIRTHDAY }"><span style="color: red">${errors.MEM_BIRTHDAY }</span></td>
					</tr>
					<tr>
						<td>地址:</td>
						<td><input type="text" name="bean.MEM_ADD"
							value="${param.MEM_ADD }"><span style="color: red">${errors.MEM_ADD }</span></td>
					</tr>
					<tr>
						<td>手機:</td>
						<td><input type="text" name="bean.MEM_PHONE"
							value="${param.MEM_PHONE }"><span style="color: red">${errors.MEM_PHONE }</span></td>
					</tr>
					<tr>
						<td>信箱:</td>
						<td><input type="text" name="bean.MEM_EMAIL"
							value="${param.MEM_EMAIL }"><span style="color: red">${errors.MEM_EMAIL}</span></td>
					</tr>

					<tr>
						<td></td>
						<td style="float: center"><input type="submit" value="加入會員"></td>
					</tr>

				</table>
			</form>
		</article>
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
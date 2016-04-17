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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<title>米沃貓窩 - 會員密碼</title>
</head>
<body>
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<article>
			<h1 style="font-size: 50px;">修改密碼</h1>
				<form action="login/passwordAction.action" method="post">
				<input type="hidden" name="bean.MEM_ID" value="${bean.MEM_ID}">
				<table>
					<tr>
						<td>舊密碼:</td>
						<td><input type="password" name="password"
							value="${password}"></td>
						<td style="color: red">${errors.password[0]}</td>
					</tr>
					<tr>
						<td>新密碼:</td>
						<td><input type="password" name="checkpassword"
							 value="${checkpassword}"></td>
						<td style="color: red">${errors.checkpassword[0]}</td>
					</tr>
					<tr>
						<td>確認密碼:</td>
						<td><input type="password" name="check" 
							value="${check}"></td>
						<td style="color: red">${errors.check[0]}</td>
					
				</table>
				<input type="submit" value="變更密碼">
			</form>
			
        </article>
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩 - 會員註冊</title>
</head>
<body>
<c:import url="/import/header.jsp"></c:import>

<section>
<article>
<h1 style="font-size:50px;">會員註冊</h1>

<form action="login/insertAction.action">
<table>
<tr><td>帳號:<br></td><td><input type="text" name="bean.MEM_ACCOUNT" value=""></td></tr>
<tr><td>密碼:</td><td><input type="password" name="password" value=""></td></tr>
<tr><td>確認密碼:</td><td><input type="password" name="checkpassword" value=""></td></tr>
<tr><td>姓名:</td><td><input type="text" name="bean.MEM_NAME" value=""></td></tr>
<tr><td>身分證字號:</td><td><input type="text" name="bean.MEM_IDCARD" value=""></td></tr>
<tr><td>生日:</td><td><input type="text" name="bean.MEM_BIRTHDAY" value=""></td></tr>
<tr><td>地址:</td><td><input type="text" name="bean.MEM_ADD" value=""></td></tr>
<tr><td>手機:</td><td><input type="text" name="bean.MEM_PHONE" value=""></td></tr>
<tr><td>信箱:</td><td><input type="text" name="bean.MEM_EMAIL" value=""></td></tr>

<tr><td></td><td style="float:right"><input type="submit" value="加入會員"></td></tr>

</table>
</form>
</article>
</section>

<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
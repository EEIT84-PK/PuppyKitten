<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩(交友中心)</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<style type="text/css">
td {
	word-break: break-all;
}
</style>
<body style="font-family: 微軟正黑體; font-size: large">
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<article style="width: 1500px;">
			<h1>寵物聯誼(交友中心)</h1>
			<font color="red"><b>喜歡我的人是</b><br>
			</font><font color="red"><b>${noOne}</b></font>
			<table border="1" style="border-collapse: collapse; width: 700px;"
				id="listTable">
				<tr>
					<td style="width: 100px" align='center' valign="middle">寵物編號</td>
					<td style="width: 100px" align='center' valign="middle">會員編號</td>
					<td style="width: 60px" align='center' valign="middle">名字</td>
					<td style="width: 60px" align='center' valign="middle">年齡</td>
					<td style="width: 60px" align='center' valign="middle">體重</td>
					<td style="width: 60px" align='center' valign="middle">種類</td>
					<td style="width: 110px" align='center' valign="middle">品種</td>
					<td style="width: 60px" align='center' valign="middle">性別</td>
				</tr>

				<c:forEach var="sort" items="${list}">

					<tr>
						<td class="imgclick" align='center' valign="middle">${sort.PET_ID}</td>
						<td align='center' valign="middle">${sort.PET_OWN_ID}</td>
						<td align='center' valign="middle">${sort.PET_NAME }</td>
						<td align='center' valign="middle">${sort.PET_AGE}</td>
						<td align='center' valign="middle">${sort.PET_WEIGHT}kg</td>
						<td align='center' valign="middle">${sort.PET_KING}</td>
						<td align='center' valign="middle">${sort.PET_SORT_NAME}</td>
						<td align='center' valign="middle">${sort.PET_SEX}<BR></td>
					</tr>
					<tr>
						<td  align='center' colspan="2"	valign="middle" style="width: 200px;">照片</td>
						<td  align='center' valign="middle" colspan="5">介紹</td>
						<td align='center' valign="middle">感覺</td>
					</tr>
					<tr>
						<td id="img" align='center' valign="middle" colspan="2">
						<img src="${sort.PET_IMAGE}" width="200" height="200"></td>
						<td id="body" align='center' valign="middle" colspan="5">${sort.PET_BODY}</td>
						
							<c:choose>
							<c:when test="${sort.PET_CHECK==1}">
								<td align='center' valign="middle">
									<a href='<c:url value="/petRelationLike/petRelationLikeAction.action?PET_OWN_ID=${sort.PET_OWN_ID}" ></c:url>'>喜歡</a><BR><br>
										<font color="red"><b>不喜歡</b></font>					
								</td>
							</c:when>
							<c:otherwise>
								<td align='center' valign="middle">
									<a href='<c:url value="/petRelationLike/petRelationLikeAction.action?PET_OWN_ID=${sort.PET_OWN_ID}" ></c:url>'>喜歡</a><BR><br>
									<a href='<c:url value="/petRelationNotLike/petRelationNotLikeAction.action?PET_OWN_ID=${sort.PET_OWN_ID}" ></c:url>'>不喜歡</a>						
								</td>
							</c:otherwise>							
							</c:choose>
						
					</tr>					
				</c:forEach>
			</table>
		</article>
	</section>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
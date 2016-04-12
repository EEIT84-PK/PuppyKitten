<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<script src="<%=request.getContextPath()%>/jquery/jquery-2.2.2.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/jquery-ui.min.js"></script>
<%-- <c:import url="/import/head.jsp"></c:import> --%>
<style type="text/css">
.pro_1 {
	float: left;
	margin: 10px;
	width: 450px;
	border: 1px solid red
}

.btn_1 {
	width: 90px;
	height: 30px;
	font-size: 15px
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩 -購物車</title>
</head>
<body>
<%-- 	<c:import url="/import/header.jsp"></c:import> --%>
	<section>
		<article>
		<form action="<%=request.getContextPath()%>/shop/shopBackAction_3.action" method="get">
			<input class="btn_1" type="submit" value="查詢">
		</form>
			<input
				class="btn_1" type="submit" value="新增商品"
				onclick="location.href='<%=request.getContextPath()%>/_200_shop_back_insert.jsp'"
				style="cursor: pointer;"><br>
			<h2>商品清單</h2>
							<c:choose>
					<c:when test="${not empty select_list}">
			<table border="1">
				<thead>
					<tr>
						<th style="width: 80px;">商品編號</th>
						<th style="width: 80px;">商品類型</th>
						<th style="width: 80px;">商品種類</th>
						<th style="width: 400px;">商品名稱</th>
						<th style="width: 80px;">販售價格</th>
						<th style="width: 80px;">上架</th>
						<th style="width: 80px;">下架</th>
					</tr>
				</thead>
						<tbody>
							<c:forEach var="sel" items="${select_list}">
								<tr>
									<td>${sel.PRO_ID}</td>
									<td>${sel.PRO_ANIMAL}</td>
									<td>${sel.PRO_KIND}</td>
									<td>${sel.PRO_NAME}</td>
									<td>${sel.PRO_PRICE}</td>
									
									<td><a href='<c:url value="/_200_shop_back_update_2.jsp">
									<c:param name="Product_ID">${sel.PRO_ID}</c:param>
									<c:param name="Product_ANIMAL">${sel.PRO_ANIMAL}</c:param>
									<c:param name="Product_KIND">${sel.PRO_KIND}</c:param>
									<c:param name="Product_NAME">${sel.PRO_NAME}</c:param>
									<c:param name="Product_PROJECT">${sel.PRO_PROJECT}</c:param>
									<c:param name="Product_PRICE">${sel.PRO_PRICE}</c:param>
									<c:param name="Product_BUY1">${sel.PRO_BUY1}</c:param>
									<c:param name="Product_BUY2">${sel.PRO_BUY2}</c:param>
									<c:param name="Product_WEIGHT">${sel.PRO_WEIGHT}</c:param>
									<c:param name="Product_STOCK">${sel.PRO_STOCK}</c:param>
<%-- 									<c:param name="Product_IMAGE">${sel.PRO_IMAGE}</c:param> --%>
									<c:param name="Product_BODY">${sel.PRO_BODY}</c:param>
									</c:url>'>編輯</a></td>
									<th><input
										type="submit" value="移除" style="cursor: pointer; margin: 5px;"></th>
								</tr>
							</c:forEach>
						</tbody>

				<tfoot>
				</tfoot>
			</table>
					</c:when>
				</c:choose>
		</article>
		<%-- 	<c:import url="/import/footer.jsp"></c:import> --%>
	</section>
</body>
</html>
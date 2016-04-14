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
		<h2>${delete_OK}</h2>
		<article>
			<form
				action="<%=request.getContextPath()%>/shop/shopBackAction_3.action"
				method="post">
				<input class="btn_1" type="submit" value="查詢">
			</form>
			<input class="btn_1" type="submit" value="新增商品"
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
								<form action="<%=request.getContextPath()%>/shop/shopBackAction_4" method="post">
									<tr>
										<td>${sel.PRO_ID}</td>
										<td>${sel.PRO_ANIMAL}</td>
										<td>${sel.PRO_KIND}</td>
										<td>${sel.PRO_NAME}</td>
										<td>${sel.PRO_PRICE}</td>


										<td><a
											href='<c:url value="/shop/shopBackAction_3">
									<c:param name="shopbean.PRO_ID">${sel.PRO_ID}</c:param>
									<c:param name="shopbean.PRO_ANIMAL">${sel.PRO_ANIMAL}</c:param>
									<c:param name="shopbean.PRO_KIND">${sel.PRO_KIND}</c:param>
									<c:param name="shopbean.PRO_NAME">${sel.PRO_NAME}</c:param>
									<c:param name="shopbean.PRO_PROJECT">${sel.PRO_PROJECT}</c:param>
									<c:param name="shopbean.PRO_PRICE">${sel.PRO_PRICE}</c:param>
									<c:param name="shopbean.PRO_BUY1">${sel.PRO_BUY1}</c:param>
									<c:param name="shopbean.PRO_BUY2">${sel.PRO_BUY2}</c:param>
									<c:param name="shopbean.PRO_WEIGHT">${sel.PRO_WEIGHT}</c:param>
									<c:param name="shopbean.PRO_STOCK">${sel.PRO_STOCK}</c:param>
									<c:param name="shopbean.PRO_IMAGE">${sel.PRO_IMAGE}</c:param>
									<c:param name="shopbean.PRO_BODY">${sel.PRO_BODY}</c:param>
									<c:param name="use">update</c:param>
									</c:url>'>編輯</a></td>

										<th><input id="sel_PRO_ID" type="text" name="shopbean.PRO_ID"  value="${sel.PRO_ID}" >
											<input id="val_1" type="text" name="shopbean.PRO_ANIMAL" value="${shopbean.PRO_ANIMAL}">
										
										<input type="submit" value="移除"
											style="cursor: pointer; margin: 5px;"></th>
									</tr>
									</form>
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
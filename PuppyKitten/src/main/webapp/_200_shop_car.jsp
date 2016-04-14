<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
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
<script type="text/javascript">
	$win.bind('scroll resize', function() {
		var $this = $(this);

		// 控制 #abgne_float_ad 的移動
		$ad.stop().animate({
			top : $this.scrollTop() + $this.height() - _height - _diffY,
			left : $this.scrollLeft() + $this.width() - _width - _diffX
		}, _moveSpeed);
	}).scroll();
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩 -購物車</title>
</head>
<body>
	<c:import url="/import/header.jsp"></c:import>
	<section>
		<table border="1">
			<thead>
				<tr>
					<th>商品編號</th>
					<th>商品名稱</th>
					<th>購買數量</th>
					<th>原價</th>
					<th>售價</th>
					<th>小計</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<th><input type="submit" value="刪除" style="cursor: pointer;"></th>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<th><input type="submit" value="刪除" style="cursor:pointer;"></th>
				</tr>
			</tbody>
			<tfoot>
			<tr>
					<th>總計：</th>
				</tr>
			</tfoot>
		</table>

		<input type="submit" value="返回購物" style="cursor: pointer;"> 
		<input type="submit" value="下一步" style="cursor: pointer;">

	</section>
	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
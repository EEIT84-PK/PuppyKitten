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
		<input class="btn_1" type="submit" name="dog" value="汪星人"> <input
			class="btn_1" type="submit" name="cat" value="喵星人"> <select
			class="btn_1">
			<option>主食乾糧</option>
			<option>外出專用</option>
			<option>精選罐頭</option>
			<option>嚴選零嘴</option>
			<option>休閒玩具</option>
			<option>生活用品</option>
			<option>衣著打扮</option>
		</select> <input class="btn_1" type="text" name="search_something"
			placeholder="Search.."> <input class="btn_1" type="submit"
			value="Search"><br>
		<table border="1">
			<thead>
				<tr>
					<th>商品編號</th>
					<th>商品類型</th>
					<th>商品種類</th>
					<th>商品名稱</th>
					<th>販售價格</th>
					<th>維護</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<th><input type="submit" value="修改" onclick="location.href='_200_shop_back_update_2.jsp'"	style="cursor: pointer; margin: 5px;"><input type="submit"
						value="刪除" style="cursor: pointer; margin: 5px;"></th>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<th><input type="submit" value="修改" onclick="location.href='_200_shop_back_update_2.jsp'" style="cursor: pointer; margin: 5px;"><input type="submit"
						value="刪除" style="cursor: pointer; margin: 5px;"></th>
				</tr>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</section>
	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
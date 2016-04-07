<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<script src="ckeditor/ckeditor.js"></script>
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
<title>米沃貓窩 -後台系統</title>
</head>
<body>
	<c:import url="/import/header.jsp"></c:import>
	<section>

		<article style="width: 1500px; background-color: white;">
		<h2>商品維護</h2>
			<form action="/shop/shopbackAction" method="get" id="shop_form">
				商品編號：<input type="text" name="shopbean.PRO_ID"><br>
				<br> 商品類型：<select name="shopbean.PRO_ANIMAL">
					<option>汪星人</option>
					<option>喵星人</option>
				</select><br> <br> 商品種類：<select name="shopbean.PRO_KIND">
					<option>主食乾糧</option>
					<option>外出專用</option>
					<option>精選罐頭</option>
					<option>嚴選零嘴</option>
					<option>休閒玩具</option>
					<option>生活用品</option>
					<option>衣著打扮</option>
				</select><br> <br> 商品名稱：<input type="text" name="shopbean.PRO_NAME"><br>
				<br> 優惠方案：<select name="shopbean.PRO_PROJCET">
					<option>指定價格</option>
					<option>買X送X</option>
					<option>指定折扣</option>
				</select><br> <br> 商品重量：<input type="text" name="shopbean.PRO_WEIGHT"><br>
				<br> 販售價格：<input type="text" name="shopbean.PRO_PRICE"><br>
				<br> 庫存數量：<input type="text" name="shopbean.PRO_STOCK"><br>
				<br> 商品照片：<input type="file" name="shopbean.PRO_IMAGE"><br>
				<br> 商品介紹：<br>
				<textarea name="shopbean.PRO_BODY" id="content" rows="10" cols="80"></textarea>
				<input type='button' value='送出' onclick='processData()'>
				<script>
					CKEDITOR.replace('shopbean.PRO_BODY', {});
				</script>
				<table>
					<tr>
						<th style="vertical-align: bottom;"></th>
					</tr>
				</table>
				<br> <input type="submit" value="更新上架"> <input
					type="submit" value="商品下架">
			</form>

		</article>

	</section>
	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
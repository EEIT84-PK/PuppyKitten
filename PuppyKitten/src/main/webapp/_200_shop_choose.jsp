<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<style type="text/css">
.choose_pro1 {
	width: 1400px;
	border: 1px solid red;
	margin: 20px;
	height: 50px;
}

.choose_pro2 {
	float:left;
	width: 450px;
	margin: 10px;
	height: 390px;
	border: 1px solid blue;
    padding: 5px;
}

.choose_pro3 {
	float:right;
	width: 400px;
	border: 1px solid red;
	margin: 10px;
	height: 390px;
	padding: 5px;
}

.choose_1 {
	float: left;
	margin: 10px;
	width: 1450px;
	height: 530px;
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
<title>米沃貓窩 -購物商城</title>
</head>
<body>
	<c:import url="/import/header.jsp"></c:import>
	<section>

		<article style="width: 1500px; background-color: white;">
			<form action="/shop/shopAction" method="get">

				<div class="choose_1">
					<div class="choose_pro1">自動抓取商品路徑(尚未設定-ex: 喵星人->主食乾糧->XXX商品)</div>
					<div class="choose_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</div>

					<div class="choose_pro3">
						<span>建議售價：999元</span><br> <br> <input type="button"
							value="加入購物車" style="cursor: pointer;">
					</div>

					<div class="choose_pro3">
						<span>商品介紹</span><br> <br>

					</div>

				</div>
			</form>

		</article>

	</section>
	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
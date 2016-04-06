<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<style type="text/css">


.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}


.index_pro1 {
	width: 420px;
	border: 1px solid red;
	margin: 10px;
	height: 35px;
	text-shadow: 2px 2px 5px red;
	
}

.index_pro2 {
	width: 100px;
	margin: 10px;
	height: 90px;
	border: 1px solid #ddd;
    border-radius: 4px;
    padding: 5px;
}

.index_pro3 {
	width: 140px;
	border: 1px solid red;
	margin: 10px;
	height: 90px;
}

.pro_1 {
	float: left;
	margin: 10px;
	width: 450px;
	height: 250px;
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
			<form action="/shop/shopAction" method="get" id="shop_form">
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
				</select> <input class="btn_1" type="text" name="search_something" placeholder="Search.."> <input
					class="btn_1" type="button" value="Search"><br>

				<div class="pro_1">
				
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>
				<div class="pro_1">
					<div class="index_pro1">自動抓取商品名稱(尚未設定)</div>
					<article class="index_pro2">
						<img alt="" src="images/smalllogo.png" height="90" width="100">
					</article>
					<aside class="index_pro3">
						<span>建議售價：999元</span><br>
						<br> <input class="button1" type="button" value="加入購物車">
					</aside>
				</div>

				<!-- 				<table border="1" style="border-collapse: collapse;"> -->
				<!-- 					<thead style="background-color: #E8CCFF"> -->
				<!-- 						<tr> -->
				<!-- 							<th>種類</th> -->
				<!-- 							<th>產品名稱</th> -->
				<!-- 							<th>價格</th> -->
				<!-- 							<th>庫存</th> -->
				<!-- 							<th>照片</th> -->

				<!-- 						</tr> -->
				<!-- 					</thead> -->
				<!-- 					<tbody> -->

				<!-- 						<tr> -->
				<!-- 							<td></td> -->
				<!-- 							<td></td> -->
				<!-- 							<td></td> -->
				<!-- 							<td></td> -->
				<!-- 							<td></td> -->

				<!-- 						</tr> -->
				<!-- 					</tbody> -->
				<!-- 				</table> -->

				<!-- 				<input type="submit" value="查詢"> -->
			</form>

		</article>

	</section>
	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<style type="text/css">
fieldset {
	border-radius: 12px;
}

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

		<article
			style="width: 1500px; background-color: white; line-height: 40px;">
			<fieldset>
				<form action="/shop/shopbackAction" method="get">
					訂購人姓名：<input type="text" name="" size="10"> <input
						type="radio">先生 <input type="radio">小姐<br>
					身分證字號：<input type="text" name=""> 生日 西元 &nbsp&nbsp <input
						type="text" size="4" name="">年&nbsp&nbsp <input type="text"
						size="4" name="">月&nbsp&nbsp <input type="text" size="4" name="">日<br>
					信用卡卡號：<select name="">
						<option>MasterCard</option>
						<option>VISA</option>
						<option>JCB</option>
					</select> <input type="text" size="4" name="">- <input type="text" size="4" name="">-
					<input type="text" size="4" name="">- <input type="text" size="4" name="">
					有效期限：<select name="">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select>月 <select name="">
						<option>2016</option>
						<option>2017</option>
						<option>2018</option>
						<option>2019</option>
						<option>2020</option>
						<option>2021</option>
						<option>2022</option>
						<option>2023</option>
						<option>2024</option>
						<option>2025</option>
						<option>2026</option>
						<option>2027</option>
						<option>2028</option>
						<option>2029</option>
						<option>2030</option>
					</select>年 &nbsp&nbsp (限台灣核發之信用卡)<br> 手機號碼： <input type="text" name="">
					信用卡帳單地址：<input type="text" size="50" name="">

					<table>
						<tr>
							<th style="vertical-align: bottom;"></th>
						</tr>
					</table>
				</form>
				<span>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</span>
				<form action="/shop/shopbackAction" method="get">
					收貨人姓名：<input type="text" name="pro_id" size="10"> <input
						type="radio">先生 <input type="radio">小姐<br>
					手機號碼：<input type="text" name=""><br> 收貨地址：<input
						type="text" name="" size="50">

					<table>
						<tr>
							<th style="vertical-align: bottom;"></th>
						</tr>
					</table>
					<br> <input type="submit" value="確認送出" style="cursor: pointer;">
				</form>
			</fieldset>
		</article>

	</section>
	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
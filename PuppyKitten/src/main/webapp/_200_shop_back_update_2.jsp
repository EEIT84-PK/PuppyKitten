<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<script src="<%=request.getContextPath()%>/jquery/jquery-2.2.2.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/jquery-ui.min.js"></script>
<script src="ckeditor/ckeditor.js"></script>
<%-- <c:import url="/import/head.jsp"></c:import> --%>

<style type="text/css">
.errorUpdate{
color: red;
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
$(function(){
	$('#sel_1 :selected').text('汪星人');
	
	$('#price_5').hide();
	$('#price_6').hide();
	
	$('#val_1').hide();
	$('#sel_1').change(function(){
		$('#val_1').val($(this).val());
	});
	
	$('#val_2').hide();
	$('#sel_2').change(function(){
		$('#val_2').val($(this).val());
	});
	
	$('#val_3').hide();
	$('#sel_3').change(function(){
		$('#val_3').val($(this).val());
		
		if($('#val_3').val()=="指定價格"){
			$('#price_6').hide();
			$('#price_5').show();
			}else{
			if($('#val_3').val()=="買X送X"){
			$('#price_6').show();
			$('#price_5').show();
			}
		}
		
	});
	
	
	$('#update_number').attr("readonly","readonly")
});



</script>

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
<%-- 	<c:import url="/import/header.jsp"></c:import> --%>
	<section>
		<article style="width: 1500px; background-color: white;">
		<h2>商品維護</h2><h2 style="color: red">${updateOK}</h2>
			<form action="<%=request.getContextPath()%>/shop/shopBackAction_2" method="get" id="shop_form">
				商品編號：<input type="text" name="shopbean.PRO_ID" id="update_number"><br><br> 
				商品類型：<select id="sel_1">
					<option>請選擇</option>
					<option>汪星人</option>
					<option>喵星人</option>
					</select><span class="errorUpdate">${errors.errorUpdateAnimal[0]}</span><br><br>
					<input id="val_1" type="text" name="shopbean.PRO_ANIMAL">
				商品種類：<select id="sel_2">
					<option>請選擇</option>
					<option>主食乾糧</option>
					<option>外出專用</option>
					<option>精選罐頭</option>
					<option>嚴選零嘴</option>
					<option>休閒玩具</option>
					<option>生活用品</option>
					<option>衣著打扮</option>
					</select><span class="errorUpdate">${errors.errorUpdateKind[0]}</span><br><br><input id="val_2" type="text" name="shopbean.PRO_KIND"> 
				商品名稱：<input type="text" name="shopbean.PRO_NAME" value="${param.Product_NAME}"><span class="errorUpdate">${errors.errorUpdateName[0]}</span><br><br> 
				優惠方案：<select id="sel_3" >
					<option>請選擇</option>
					<option>指定價格</option>
					<option>買X送X</option>
					</select><span class="errorUpdate">${errors.errorUpdateProject[0]}</span><br><br><input id="val_3" type="text" name="shopbean.PRO_PROJCET"> 
				<span id="price_5">
				指定價格：<input type="text" name="shopbean.PRO_PRICE" id="price_1"><span class="errorInsert">${errors.errorInsertPrice[0]}</span>
				<br><br></span>	
				<span id="price_6">
				買：<input type="text" name="shopbean.PRO_PRICE" id="price_2"><span class="errorInsert">${errors.errorInsertPrice[0]}</span>
				送：<input type="text" name="shopbean.PRO_PRICE" id="price_3"><span class="errorInsert">${errors.errorInsertPrice[0]}</span><br><br>
				</span>	
				商品重量：<input type="text" name="shopbean.PRO_WEIGHT"><br><br> 	
				庫存數量：<input type="text" name="shopbean.PRO_STOCK"><span class="errorUpdate">${errors.errorUpdateStock[0]}</span><br><br> 
				商品照片：<input type="file" name="shopbean.PRO_IMAGE"><span class="errorUpdate">${errors.errorUpdateImage[0]}</span><br><br> 
				商品介紹：<br>
				<textarea name="shopbean.PRO_BODY" id="content" rows="10" cols="80" ></textarea>
				<script>
					CKEDITOR.replace('shopbean.PRO_BODY', {});
				</script>
				<table>
					<tr>
						<th style="vertical-align: bottom;"></th>
					</tr>
				</table>
				<br> <input type="submit" value="送出">
			</form>

		</article>

	</section>
<%-- 	<c:import url="/import/footer.jsp"></c:import> --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<title>米沃貓窩</title>

<style>
@IMPORT url("css/ad.css");
</style>
<script>
$(document).ready(function(){
	$('#skip').click(function(){
		$(this).fadeOut(2000);
		$('#adBlock').fadeOut(2000,function(){
			window.location.replace("index.jsp");
		});
	});
	$('#skip').mouseover(function(){
		$(this).css("color","white").mouseout(function(){
			$(this).css("color","#AAAAAA");
		});
	});
		
	
});
</script>
<script>
$(function(){
	// 先取得必要的元素並用 jQuery 包裝
	// 再來取得 $block 的高度及設定動畫時間
	var $block = $('#adBlock'),
		$slides = $('ul.list', $block),
		_width = $block.width(),
		$li = $('li', $slides),
		_animateSpeed = 600;
 
	// 產生 li 選項
	var _str = '';
	for(var i=0, j=$li.length;i<j;i++){
		// 每一個 li 都有自己的 className = playerControl_號碼
		_str += '<li class="playerControl_' + (i+1) + '"></li>';
	}
 
	// 產生 ul 並把 li 選項加到其中
	// 並幫 li 加上 mouseover 事件
	$('<ul class="playerControl"></ul>').html(_str).appendTo($slides.parent()).css('left', function(){
		// 把 .playerControl 移到置中的位置
		return (_width - $(this).width()) / 2;
	}).find('li').mouseover(function(){
		var $this = $(this);
		$this.addClass('current').siblings('.current').removeClass('current');
		
		// 移動位置到相對應的號碼
		$slides.stop().animate({
			left: _width * $this.index() * -1
		}, _animateSpeed);
 
		return false;
	}).eq(0).mouseover();
});
</script>

</head>
<body>
<h1 style="font-family:meow;font-size:85px;">米沃貓窩</h1>
	<div id="adBlock">
		<ul class="list">
			<li><img src="images/ad/01.png"></li>
			<li><img src="images/ad/02.png"></li>
			<li><img src="images/ad/03.png"></li>
			<li><img src="images/ad/04.png"></li>
			<li><img src="images/ad/05.png"></li>
		</ul>
		<ul>
			<li id="skip">skip</li>
		</ul>
	</div>

	<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
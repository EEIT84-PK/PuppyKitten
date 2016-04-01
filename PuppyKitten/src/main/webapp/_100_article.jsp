<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩 - 討論區</title>
<style>

#thead div{
	width:200px;
	cursor: pointer;
	height:30px;	
	background:rgba(250, 235, 215, 0.4);
	text-align: center;
	display: inline-block;
	font-size: 20px;

}
#tbody{
	background:rgba(250, 235, 215, 0.8);
	height: 500px;
	width:1016px;

}

</style>
<script type="text/javascript">
$(function(){
	$('#thead div').click(function(){
		$(this).css("background","rgba(250, 235, 215, 0.8)");
		$(this).siblings().css("background","rgba(250, 235, 215, 0.4)");
		
	});
	
});
</script>
</head>
<body>
<c:import url="/import/header.jsp"></c:import>
<section>
<article>
<div id="thead">
<div style="background:rgba(250, 235, 215, 0.8);">所有</div>
<div>公告</div>
<div>活動</div>
<div>心得</div>
<div>問題</div>
</div>
<div id="tbody">

</div>
</article>
<aside>
</aside>
</section>
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
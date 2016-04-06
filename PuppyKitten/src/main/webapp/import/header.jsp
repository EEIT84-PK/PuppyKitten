<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<header>
	<ul id="header_left">
		<li><img src="<%=request.getContextPath()%>/images/smalllogo.png"
			width="20px" /></li>
		<li><a href="<%=request.getContextPath()%>/index.jsp">首頁</a></li>
	</ul>
	<div id="nav_main">
		<div id="menu">
			<div class="item">
				<div class="main">寵物新知</div>
				<div class="sub">
					<ul>
						<li><a href="">購買須知</a></li>
						<li><a href="">商品分析</a></li>
						<li><a href="">運費方式</a></li>
					</ul>
				</div>
			</div>
			<div class="item">
				<div class="main">精品購物</div>
				<div class="sub">
					<ul>
						<li><a href="">產品介紹</a></li>
						<li><a href="">熱門商品</a></li>
						<li><a href="">購物車清單</a></li>
					</ul>
				</div>
			</div>
			<div class="item">
				<div class="main">寵物聯誼</div>
				<div class="sub">
					<ul>
						<li><a href="_400_insert.jsp">新增寵物資訊</a></li>
					<li><a href="<s:url action="petSelect/PetSelectAction" />">查詢寵物資訊</a></li>
					<li><a href="">配對系統</a></li>
					<li><a href="">交友中心</a></li>
					</ul>
				</div>
			</div>
			<div class="item">
				<div class="main">寵物旅遊</div>
				<div class="sub">
					<ul>
						<li><a href="">旅遊介紹</a></li>
						<li><a href="<%=request.getContextPath()%>/_300_google.jsp">店家位置</a></li>
						<li><a href='<c:url value="/map/mapActionBack.action" ><c:param name="mapBean.MAP_ID"></c:param></c:url>'>後台系統</a></li>
					</ul>
				</div>
			</div>
			<div class="item">
				<div class="main">討論區</div>
				<div class="sub">
					<ul>
						<li><a href='<c:url value="/article/articleAction.action" ></c:url>'>討論大廳</a></li>
						<li><a href="">留言板</a></li>
					</ul>
				</div>
			</div>

		</div>

	</div>
	<ul id="header_right">
		<li class="buttons" style="border-left: 0; padding-left: 40px;">
			<a class="facebook"
			href="https://www.facebook.com/%E7%B1%B3%E6%B2%83%E8%B2%93%E7%AA%A9-150232665031651/?fref=ts">
				<img src="<%=request.getContextPath()%>/images/css/facebook.png" />
		</a>
		</li>
		<li><a href="">聯絡我們<img
				src="<%=request.getContextPath()%>/images/phone.png" width="15px"></a></li>
		<li><a href="">購物車<img
				src="<%=request.getContextPath()%>/images/cart.png" width="15px"></a></li>
		<li><a href="">會員中心</a></li>
		<li><a href="">註冊</a></li>
		<li><a href="">登入</a></li>
	</ul>
</header>
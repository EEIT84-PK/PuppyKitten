<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="utf-8">
<title>後台系統</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
<style>
/*CSS*/
@import url('<%=request.getContextPath()%>/css/st1.css');

* {
	margin: 0
}
</style>

<script>
	//Javascript
</script>
</head>
<body>
	<header>
		<nav id="nav1">
			<ul id="menu">
				<label class="leftlabel">
					<li><a href="<%=request.getContextPath()%>/index_back.jsp">後台</a>
				</li>
					<li><a href="">Nike+</a></li>
					<li><a href=""><img
							src="<%=request.getContextPath()%>/images_back/jordan.png"
							width="20"></a></li>
				</label>
				<label class="rightlabel">
					<li><a href=""><img
							src="<%=request.getContextPath()%>/images_back/ROC.jpg"
							width="20"></a></li>
					<li><a href=""><img
							src="<%=request.getContextPath()%>/images_back/cart.png"
							width="20"></a></li>
					<li><a href="">Help</a></li>
					<li><a href="">Feedback</a></li>
					<li><a
						href="<c:url value="/login/loginBackAction.action" ></c:url>">Join/Log
							in</a></li>
							<c:choose>
						<c:when test="${not empty backLoginOK}"><li>${backLoginOK},您好</li></c:when>
					</c:choose>
				</label>
			</ul>
		</nav>

		<nav id="nav2">
			<table id="secmenu">
				<tr style="margin: 0">
					
					<td id="lsl"><a
						href="<%=request.getContextPath()%>/index_back.jsp"><img
							src="<%=request.getContextPath()%>/images_back/NIKELOGO.png"
							width="80"></a></td>

					<td class="msl"><a href="">寵物新知</a></td>
					<td class="msl"><a href="">精品購物</a></td>
					<td class="msl"><a href="">寵物聯誼</a></td>
					<td class="msl"><a href="">寵物旅遊</a></td>
					<td class="msl"><a href="">討論區</a></td>
					<td class="msl"><a
						href="<%=request.getContextPath()%>/_600_websocket_back.jsp">客服中心</a></td>

					<td id="rsl"><img
						src="<%=request.getContextPath()%>/images_back/Q.png" width="20">
						<input type="text" name="Q" placeholder="search"></td>

				</tr>
			</table>

		</nav>
	</header>
	<div id="content">

		<article style="height: 850px; text-align: center">
			<iframe width="1120" height="630"
				src="https://www.youtube.com/embed/XoOS2iRfghs"
				style="padding: 5%; border: 0px;"></iframe>
		</article>

		<footer>

			<ul id="footermenu">
				<label style="list-style-type: none">
					<li><img
						src="<%=request.getContextPath()%>/images_back/ROC.jpg" width="20"><span
						style="color: white">Taiwan&nbsp;&nbsp;</span><span>&copy;
							2015 Nike, Inc. All Rights Reserved</span></li>
				</label>
				<label id="footermenu2">
					<li><a href="">Guides</a></li>
					<li><a href="">Terms Of Use</a></li>
					<li><a href="">Nike Privaty Policy</a></li>
				</label>
			</ul>

		</footer>
	</div>
</body>

</html>
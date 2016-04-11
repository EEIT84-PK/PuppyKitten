<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<title>米沃貓窩 - 討論區</title>
<script src="<%=request.getContextPath()%>/javascript/article.js"></script>
<script type="text/javascript">

</script>
<style>
#thead{
width:1056px;
}
#thead div{
	width:150px;
	cursor: pointer;
	height:30px;	
	background:rgba(250, 235, 215, 0.4);
	text-align: center;
	display: inline-block;
	font-size: 20px;
	border-top-right-radius:15px ;
	border-top-left-radius:15px ;
	
}

#tbody{
	background:rgba(250, 235, 215, 0.8);
	height: 490px;
	width:1016px;
	overflow:auto;
	padding: 20px;
	font-size: 20px;
}
#success td{
	text-align: center;
	cursor: pointer;
}
#error{
color:red;
list-style: none;
}

#insert{
	float:right;
	font-size:20px;
	width:150px;
	text-align: center;
}
</style>
</head>
<body>
<c:import url="/import/header.jsp"></c:import>
<section>
<article>

<div id="thead">
<div id="all" style="background:rgba(250, 235, 215, 0.8);">所有</div>
<div id="post">公告</div>
<div id="activity">活動</div>
<div id="reviews">心得</div>
<div id="question">問題</div>

<div id="insert" style="width:120px;"><a href="<%=request.getContextPath()%>/_100_insert.jsp">新增文章</a></div>
</div>

<div id="tbody">
<table>

<c:choose><c:when test="${not empty select}">
						<thead id="shide" style="background:rgba(255, 255, 215, 0.4);">
							<tr>
								<th>類型</th>
								<th>主題</th>
								<th>發言人</th>
								<th>時間</th>
								<th>點擊率</th>
							</tr>
						</thead>
						</c:when></c:choose>
						<tbody id="success">
							
							<c:forEach var="article" items="${select}"><tr class="trcolor">
									<td style="width: 100px;text-align: center;">${article.ART_KIND}</td>
									<td style="width: 350px;text-align: center;">${article.ART_TITLE}</td>
									<td style="width: 150px;text-align: center;">${article.ART_MEM_ID}</td>
									<td style="width: 250px;text-align: center;"><fmt:formatDate value="${article.ART_TIME}" pattern="yyyy-MM-dd HH:mm"/></td>
									<td style="width: 120px;text-align: center;">${article.ART_HOT}</td>
								</tr></c:forEach>
						</tbody>
					</table>



<div id="msgdiv" style="width:400px;">
<hr>

<div id="msg"></div>

<c:choose>
<c:when test="${session.loginOK!=null}">
</c:when>
<c:otherwise>
姓名:<br><s:textfield id="msgname" value="匿名"></s:textfield><br>
</c:otherwise>
</c:choose>
留言內容:<br><s:textarea id="msgarea" cols="55" rows="5" value=""></s:textarea><br>

<input id="msgsubmit" type="button" style="float:right" value="送出" />



</div>
</div>
</article>
<aside>
<h1 style="font-size: 20px;text-align: center;background:rgba(255, 255, 215, 0.4);">熱門文章</h1>
<table style="font-size: 20px;"><c:forEach var="sort" items="${sort}" end="5"><tr class="trcolor">
									<td style="width: 70px;">${sort.ART_KIND}</td>
									<td style="width: 300px;">${sort.ART_TITLE}</td>
									<td style="width: 30px;text-align: right;">${sort.ART_HOT}</td>
								</tr></c:forEach></table>
</aside>
</section>
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>

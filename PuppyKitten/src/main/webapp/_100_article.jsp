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
	border-top-right-radius:15px ;
	border-top-left-radius:15px ;
}

#tbody{
	background:rgba(250, 235, 215, 0.8);
	height: 400px;
	width:1016px;
	overflow:auto;
	padding: 20px;
	overflow: 
}
#use{
	background:rgba(250, 235, 215, 0.8);
}
</style>
<script type="text/javascript">
$(function(){
	$('#thead a').click(function(){
 		$('#thead div').siblings().css("background","red");
// 		$('#thead div').css("background","rgba(250, 235, 215, 0.8)");
		
		$(this).parent().addClass('use');

		
	});
	$('#post').click(function(){
		var queryString ="&use=公告&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
    });
	$('#activity').click(function() {
		var queryString ="&use=活動&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
    });
	
	$('#reviews').click(function() {
		var queryString ="&use=心得&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
    });
	$('#question').click(function() {
		alert("失敗的點");
		var queryString = "&use=問題&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
    });
 
	
	function doReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}
	
});
</script>
</head>
<body>
<c:import url="/import/header.jsp"></c:import>
<section>
<article>
<div id="thead">
<div id="use">
<a href='<c:url value="/article/articleAction.action" ></c:url>'>所有</a></div>
<div id="post">公告</div>
<div id="activity">活動</div>
<div id="reviews">心得</div>
<div id="question">問題</div>
</div>
<div id="tbody">
<br><br>
<table>
						<thead style="background: #DDDDDD;">
							<tr>
								<th>類型</th>
								<th>主題</th>
								<th>發言人</th>
								<th>時間</th>
								<th>次數</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="article" items="${select}">
								<tr class="trcolor">
									<td style="width: 50px;text-align: center;">${article.ART_KIND}</td>
									<td style="width: 300px;text-align: center;">${article.ART_TITLE}</td>
									<td style="width: 100px;text-align: center;">${article.ART_MEM_ID}</td>
									<td style="width: 200px;text-align: center;">${article.ART_TIME}</td>
									<td style="width: 50px;text-align: center;">${article.ART_HOT}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	
</div>

</article>
<aside>
</aside>
</section>
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩 - 討論區</title>
<style>

#thead div{
	width:100px;
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
<script type="text/javascript">
$(function(){	
	
	var $path = "/PuppyKitten";
 	var $url = $path+"/article/articleAction.controller";
 	var $bodyurl = $path+"/article/articleBodyAction.controller";
 	$('#all').click(function(){
 		$('#shide').show();
		$(this).css("background","rgba(250, 235, 215, 0.8)");
		$(this).siblings().css("background","rgba(250, 235, 215, 0.4)");
		var $queryString ="&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", $url+"?"+$queryString, true);
		request.send();
    });
	$('#post').click(function(){
		$('#shide').show();
		$(this).css("background","rgba(250, 235, 215, 0.8)");
		$(this).siblings().css("background","rgba(250, 235, 215, 0.4)");
		var $queryString ="&use=公告&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", $url+"?"+$queryString, true);
		request.send();
    });
	$('#activity').click(function() {
		$('#shide').show();
		$(this).css("background","rgba(250, 235, 215, 0.8)");
		$(this).siblings().css("background","rgba(250, 235, 215, 0.4)");
		var $queryString ="&use=活動&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		console.log($url+"?"+$queryString);
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", $url+"?"+$queryString, true);
		request.send();
    });
	
	$('#reviews').click(function() {
		$('#shide').show();
		$(this).css("background","rgba(250, 235, 215, 0.8)");
		$(this).siblings().css("background","rgba(250, 235, 215, 0.4)");
		var $queryString ="&use=心得&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", $url+"?"+$queryString, true);
		request.send();
    });
	$('#question').click(function() {
		$('#shide').show();
		$(this).css("background","rgba(250, 235, 215, 0.8)");
		$(this).siblings().css("background","rgba(250, 235, 215, 0.4)");
		var $queryString = "&use=問題&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", $url+"?"+$queryString, true);
		request.send();
    });

	function doReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				$('#success').html(request.responseText);
				$('#success tr').click(function(){
					$('#shide').hide();
					$('#success').hide();
						var $title=$(this).children().eq(1).text();
						var $hot = $(this).children().eq(4).text();
						var $queryString = "&title="+$title+"&hot="+$hot+"&dummy="+new Date().getTime();
						request = new XMLHttpRequest();
						request.onreadystatechange = doBodyReadyStateChange;
						request.open("GET", $bodyurl+"?"+$queryString, true);
						request.send();
					
				});
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}
	
	function doBodyReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
					$('#success').hide().fadeIn(1000).html(request.responseText);
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}
	
	$('#success tr').click(function(){
		$('#shide').hide();
		$('#success').hide();
			var $title=$(this).children().eq(1).text();
			var $hot = $(this).children().eq(4).text();
			var $queryString = "&title="+$title+"&hot="+$hot+"&dummy="+new Date().getTime();
			request = new XMLHttpRequest();
			request.onreadystatechange = doBodyReadyStateChange;
			request.open("GET", $bodyurl+"?"+$queryString, true);
			request.send();
		
	});
	$('#insert').mouseover(function(){
		$(this).css("background","rgba(255, 255, 215, 0.8)").mouseout(function(){
			$(this).css("background","rgba(255, 255, 215, 0.4)");
		});
	});
	
});

</script>
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
</div>

<div id="tbody">
<div style="float:left">
<table>


<c:choose><c:when test="${not empty select}">
						<thead style="background:rgba(255, 255, 215, 0.4);" id="shide">
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
									<td style="width: 50px;text-align: center;">${article.ART_KIND}</td>
									<td style="width: 300px;text-align: center;">${article.ART_TITLE}</td>
									<td style="width: 100px;text-align: center;">${article.ART_MEM_ID}</td>
									<td style="width: 200px;text-align: center;">${article.ART_TIME}</td>
									<td style="width: 70px;text-align: center;">${article.ART_HOT}</td>
								</tr></c:forEach>
						</tbody>
					</table>
					
					
</div>
<div id="insert"><a href="<%=request.getContextPath()%>/_100_insert.jsp">新增文章</a></div>
</div>

</article>
<aside>
<h1>熱門文章(失敗)</h1>
<table><c:forEach var="sort" items="${sort}"><tr class="trcolor">
									<td style="width: 50px;text-align: center;">${sort.ART_KIND}</td>
									<td style="width: 300px;text-align: center;">${sort.ART_TITLE}</td>
									<td style="width: 70px;text-align: center;">${sort.ART_HOT}</td>
								</tr></c:forEach></table>
</aside>
</section>
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
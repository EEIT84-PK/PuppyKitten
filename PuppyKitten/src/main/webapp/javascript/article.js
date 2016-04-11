$(function(){	
	var $path = "/PuppyKitten";
 	var $url = $path+"/article/articleAction.controller";
 	var $bodyurl = $path+"/article/articleBodyAction.controller";
 	var $msgurl = $path+"/message/messageAction.controller";
 	var $replyurl = $path+"/message/replyAction.controller";
	
 	$('#msgsubmit').click(function(){
		var $name=$('#msgname').val();
		var $area=$('#msgarea').val();
		$('#msgarea').val("");
		var $queryString ="&name="+$name+"&area="+$area+"&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doMsgReadyStateChange;
		request.open("GET", $msgurl+"?"+$queryString, true);
		request.send();
	});
	
 	function doMsgReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				$('#msg').html(request.responseText).show().fadeOut(5000);
				
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}
	
	$('#msgdiv').hide();
	
 	$('#all').click(function(){
 		$('#shide').show();
		$('#msgdiv').hide();
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
		$('#msgdiv').hide();
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
		$('#msgdiv').hide();
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
		$('#msgdiv').hide();
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
		$('#msgdiv').hide();
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
					$('#msgdiv').fadeIn(1000);
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
					$('#msgdiv').fadeIn(1000);
					$('.reply').click(function(){
						var $reply=$(this).siblings().eq(2).val();
						var $time =$(this).siblings().eq(0).text();
						var $queryString = "&reply="+$reply+"&time="+$time+"&dummy="+new Date().getTime();
						request = new XMLHttpRequest();
						request.onreadystatechange = doMsgReadyStateChange;
						request.open("GET", $replyurl+"?"+$queryString, true);
						request.send();
					});
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
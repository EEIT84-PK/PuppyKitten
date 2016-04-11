$(document).ready(function(){
	var $delete =$('input[class=delete]');
	var path = "/PuppyKitten";
 	var url = path+"/article/articleBackAction.controller";
	
	$delete.click(function(){
		$(this).parents('tr').fadeOut(1500);
		var $id =$(this).parent().siblings().eq(0).text();
	 	var queryString = "&id="+$id+"&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
		
	});
	function doReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				$('#success').html(request.responseText);
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}

	
	$('.bodyhide').click(function(){
		$(this).parent().next().stop().fadeToggle();
	});
});

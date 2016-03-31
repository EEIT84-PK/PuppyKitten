<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/jquery/jquery-2.2.2.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/jquery.dataTables.min.js"></script>
<title>後台系統 - Google Map</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<style type="text/css">
@IMPORT url("//cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css");
	body{width:850px;}
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }

</style>
	
<script>

$(document).ready(function(){
	$('#inputforhide').hide();
	$('#datatable').DataTable();
	var $update =$('input[class=update]');
	var $delete =$('input[class=delete]');
	var path = "${pageContext.request.contextPath}";
 	var url = path+"/map/mapActionBack.controller";
 	
	$update.click(function(){
		var $text =$(this).parent().siblings().eq(0).text();
		var $kind =$(this).parent().siblings().eq(1).text();
		var $name =$(this).parent().siblings().children().eq(0).val();
		var $address = $(this).parent().siblings().children().eq(1).val();
		var $phone = $(this).parent().siblings().children().eq(2).val();
	 	var queryString = "&id="+$text+"&kind="+$kind+"&name="+$name
	 	+"&address="+$address+"&phone="+$phone+"&use=update&dummy="+new Date().getTime();
	 	request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
	});
	$delete.click(function(){
		$(this).parents('tr').fadeOut(1500);
		var $text =$(this).parent().siblings().eq(0).text();
	 	var queryString = "&id="+$text+"&use=delete&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
		
	});
	
	function insert() {
		var $kind = $('#kind').val();
		var $name = $('#name').val();
		var $phone = $('#phone').val();
		var $city = $('#city').val();
		var $area = $('#area').val();
		var $address = $('#address').val();
		var queryString = "&kind="+$kind+"&name="+$name+"&phone="+$phone+"&city="+$city+
		"&area="+$area+"&address="+$address+"&use=insert&dummy="+new Date().getTime();
		dialog.dialog( "close" );
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
    }
 
	
	function doReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				$('#success').html(request.responseText);
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}
			//新增店家的部分
		    var dialog, form,
		 
		      // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
		   
		      name = $( "#name" ),
		      email = $( "#email" ),
		      password = $( "#password" ),
		      allFields = $( [] ).add( name ).add( email ).add( password ),
		      tips = $( ".validateTips" );
		 
		    function updateTips( t ) {
		      tips
		        .text( t )
		        .addClass( "ui-state-highlight" );
		      setTimeout(function() {
		        tips.removeClass( "ui-state-highlight", 1500 );
		      }, 500 );
		    }
		 
		    function checkLength( o, n, min, max ) {
		      if ( o.val().length > max || o.val().length < min ) {
		        o.addClass( "ui-state-error" );
		        updateTips( "Length of " + n + " must be between " +
		          min + " and " + max + "." );
		        return false;
		      } else {
		        return true;
		      }
		    }
		 
		    function checkRegexp( o, regexp, n ) {
		      if ( !( regexp.test( o.val() ) ) ) {
		        o.addClass( "ui-state-error" );
		        updateTips( n );
		        return false;
		      } else {
		        return true;
		      }
		    }
		 
		    
		    dialog = $( "#dialog-form" ).dialog({
		      autoOpen: false,
		      height: 500,
		      width: 350,
		      modal: true,
		      buttons: {
		        "新增": insert,
		        "取消": function() {
		          dialog.dialog( "close" );
		        }
		      },
		      close: function() {
		        form[ 0 ].reset();
		        allFields.removeClass( "ui-state-error" );
		      }
		    });
		 
		    form = dialog.find( "form" ).on( "submit", function( event ) {
		      event.preventDefault();
		      addUser();
		    });
		 
		    $( "#create-user" ).button().on( "click", function() {
		      dialog.dialog( "open" );
		    });

});

</script>


</head>
<body>
<form action="<%=request.getContextPath()%>/map/mapActionBack.action" method="get">
<input id="inputforhide" type="text" name="mapBean.MAP_ID" value="${mapBean.MAP_ID}" />
<input type="submit" value="查詢" name="choose" style="float:left;height:35px;">
</form>
<c:choose>
<c:when test="${not empty select}">
<div style="border-bottom: 1px solid #DDDDDD;">

<b style="font-size:25px;">店家資訊</b><b id="success" style="font-size:20px;color:red"></b>
<button id="create-user" style="float:right">新增店家資訊</button>


<br><br>
</div>
<table id="datatable" border="1" style="border-collapse: collapse;width:850px;">
	<thead>
	<tr style="background:#DDDDDD;">
		<th>編號</th>
		<th>類別</th>
		<th>店名</th>
		<th>地址</th>
		<th>電話</th>
		<th>編輯</th>
	</tr>
	</thead>
	<tbody>	
	<c:forEach var="map" items="${select}">
	<tr>		
		<td style="width:50px;">${map.MAP_ID}</td>
		<td style="width:100px;">${map.MAP_KIND}</td>
		<td style="width:150px;"><input type="text" value="${map.MAP_NAME}" style="border-style: none;"></td>
		<td style="width:250px;"><input type="text" value="${map.MAP_ADD}" style="border-style:none;width:250px;"></td>
		<td style="width:100px;"><input type="text" value="${map.MAP_PHONE}" style="border-style:none;width:100px;"></td>
		<td style="width:50px;"><input type="button" class="update" value="修改" />
		<input type="button" class="delete" value="移除" /></td>		
	</tr>
	
	</c:forEach>
	</tbody>
</table>
</c:when>
</c:choose>



<div id="dialog-form" title="新增店家資訊">
  <p class="validateTips">管理員您好</p>
 
  <form>
    <fieldset>
      <label for="kind">店家種類</label>
      <input type="text" name="kind" id="kind" value="動物醫院" class="text ui-widget-content ui-corner-all">
      <label for="name">店家名稱</label>
      <input type="text" name="name" id="name" value="陳柏安的寵物店" class="text ui-widget-content ui-corner-all">
      <label for="phone">店家電話</label>
      <input type="text" name="phone" id="phone" value="02-2855-5508" class="text ui-widget-content ui-corner-all">
      <label for="city">縣市</label>
      <input type="text" name="city" id="city" value="新北市" class="text ui-widget-content ui-corner-all">
      <label for="area">區域</label>
      <input type="text" name="area" id="area" value="樹林區" class="text ui-widget-content ui-corner-all">
      <label for="address">地址</label>
      <input type="text" name="address" id="address" value="新北市樹林區資策路84號" class="text ui-widget-content ui-corner-all">

      <input id="insert" type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>

</body>
</html>
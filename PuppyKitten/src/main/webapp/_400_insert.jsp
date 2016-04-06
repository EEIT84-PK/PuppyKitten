<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩-新增寵物資訊</title>

<style type="text/css">
	.error {color: #FF0000}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
$(function() {
    $( "#age" ).attr("readonly", "readonly").datepicker({		
		showOn: "focus",
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		defaultDate: "2010-12-01",
	});
    
    $("#king" ).change(function() {
    	if($("#king" ).val()=="non"){
    		$("#sort option").remove();
    		$("input[name='petBean.PET_KING']").val("");
    		$("input[name='petBean.PET_SORT_ID']").val("");
    		$("#sort").append($("<option></option>").attr("value", "zero").text("請選擇品種"));
    	}
  	  if($("#king" ).val()=="cat"){
  		$("#sort option").remove();
  		$("input[name='petBean.PET_KING']").val("");
  		$("input[name='petBean.PET_KING']").val("貓");
  		$("input[name='petBean.PET_SORT_ID']").val("");
  		$("#sort").append($("<option></option>").attr("value", "").text("請選擇品種"));
  		$("#sort").append($("<option></option>").attr("value", "4101").text("暹邏貓"));
  		$("#sort").append($("<option></option>").attr("value", "4102").text("波斯貓"));
  		$("#sort").append($("<option></option>").attr("value", "4103").text("布偶貓"));
  		$("#sort").append($("<option></option>").attr("value", "4104").text("美國短毛貓"));
  		$("#sort").append($("<option></option>").attr("value", "4105").text("俄羅斯藍貓"));
  		$("#sort").append($("<option></option>").attr("value", "4106").text("美國捲耳貓"));
  		$("#sort").append($("<option></option>").attr("value", "4107").text("土耳其安哥拉貓"));
  	  }
  	  if($("#king" ).val()=="dog"){
  		$("#sort option").remove();
  		$("input[name='petBean.PET_KING']").val("");
  		$("input[name='petBean.PET_KING']").val("狗");
  		$("input[name='petBean.PET_SORT_ID']").val("");
  		$("#sort").append($("<option></option>").attr("value", "").text("請選擇品種"));
  		$("#sort").append($("<option></option>").attr("value", "4201").text("柴犬"));
  		$("#sort").append($("<option></option>").attr("value", "4202").text("巴哥"));
  		$("#sort").append($("<option></option>").attr("value", "4203").text("貴賓犬"));
  		$("#sort").append($("<option></option>").attr("value", "4204").text("吉娃娃"));
  		$("#sort").append($("<option></option>").attr("value", "4205").text("哈士奇"));
  		$("#sort").append($("<option></option>").attr("value", "4206").text("拉布拉多"));
  		$("#sort").append($("<option></option>").attr("value", "4207").text("黃金獵犬"));
  	  }
  	});  
    
    $("#sort" ).change(function() {    	
    	$("input[name='petBean.PET_SORT_ID']").val("");
  		$("input[name='petBean.PET_SORT_ID']").val($("#sort").find(":selected").val());    	
    });
    
  });
 
function clearForm() {
	var $inputs = $("input[type='text']");
			$inputs.val('');
}
</script>

</head>
<body style="font-family: 微軟正黑體; font-size: large">
<c:import url="/import/header.jsp"></c:import>
<section>
<article>
<h1>寵物聯誼(新增寵物資訊)</h1>
	<form action="<%=request.getContextPath()%>/pet/petAction.action" method="post" enctype="multipart/form-data">
		會員編號：<input type="text" name="petBean.PET_OWN_ID" size="20" value="${session.memberID}" readonly="readonly">
		<span class="error">${request.PET_OWN_ID}</span><BR>
		寵物名字： <input type="text" name="petBean.PET_NAME" size="10" value="${petBean.PET_NAME}"> 
		<span class="error">${request.PET_NAME}</span><BR>
		出生年月日： <input type="text" name="petBean.PET_AGE" size="10" id="age" value="${petBean.PET_AGE}">
		<span class="error">${request.PET_AGE}</span><BR>
		寵物體重： <input type="text" name="petBean.PET_WEIGHT" size="10" value="${petBean.PET_WEIGHT}">
		<span class="error">${request.PET_WEIGHT}</span><BR>
		
			寵物種類：<select name="PET_KING_CHOICE" id="king">
				<option value="non">請選擇種類</option>
				<option value="cat">貓</option>
				<option value="dog">狗</option>
			</select>
			<input type="text" name="petBean.PET_KING" size="3" readonly="readonly" value="${petBean.PET_KING}">
			<span class="error">${request.PET_KING}</span><BR>
		
			品種選擇： <select name="PET_SORT_ID_CHOICE" id="sort"><option>請選擇品種</option></select> 
			<input type="text" name="petBean.PET_SORT_ID" size="12" readonly="readonly" value="${petBean.PET_SORT_ID}">
			<span class="error">${request.PET_SORT_ID}</span><BR>
			性別：
			<input name="petBean.PET_SEX" type="radio" value="公" id="sex" checked="checked">公
			<input name="petBean.PET_SEX" type="radio" value="母" id="sex">母	<br>
			寵物照片：<input type="file" name="PET_IMAGE" size="30"/>
			<span class="error">${request.PET_IMAGE}</span><BR>	 
		介紹：<BR>
			<textarea name="petBean.PET_BODY" cols="50" rows="10" ><s:property value="petBean.PET_BODY" /></textarea>
			<span class="error">${request.PET_BODY}</span><BR>
			<input type="submit" value="送出"><input type="button" value="清除" onclick="clearForm()"><BR>
	</form>
</article>
<aside>

</aside>
</section>
	
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
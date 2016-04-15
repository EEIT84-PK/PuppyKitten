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
	$("input[name='petBean.PET_SEX'][value=${petBean.PET_SEX}]").prop("checked", true);	
	
// 	if($("input[name='petBean.PET_KING']").val()==""){
// 		$('#king option[value=non]').attr('selected', 'selected');
// 	}else if($("input[name='petBean.PET_KING']").val()=="貓"){
// 		$('#king option[value=cat]').attr('selected', 'selected');
// 	}else if($("input[name='petBean.PET_KING']").val()=="狗"){
// 		$('#king option[value=dog]').attr('selected', 'selected');}
	
		  $("input[name='petBean.PET_SORT_ID']").hide();
		  $("input[name='petBean.PET_KING']").hide();
    $( "#age" ).attr("readonly", "readonly").datepicker({    	 
		showOn: "focus",
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		yearRange : "-25:+0",//左邊為現年2016-25 開始為1991年  結束為現年2016+0=2016年
		defaultDate: (new Date(new Date().getFullYear() - 25
                + "/01/01") - new Date())
                / (1000 * 60 * 60 * 24),//設定預設值=現年2016-25--->1991年
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
  		for( j=4201;j<=4207;j++){
  			if($("input[name='petBean.PET_SORT_ID']").val()==j.toString()){
  				$('#sort option[value=PET_SORT_ID]').attr('selected', 'selected');
  			}
  		}
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
	<font color="red"><b><s:property value="errorMsg" /></b></font>
	<form action="<%=request.getContextPath()%>/pet/petAction.action" method="post" enctype="multipart/form-data">
		會員編號：<input type="text" name="petBean.PET_OWN_ID" size="20" value="${session.memberID}" readonly="readonly"><BR>		
		寵物名字： <input type="text" name="petBean.PET_NAME" size="10" value="${petBean.PET_NAME}"> 
		<span class="error">${request.PET_NAME}</span><BR>
		出生年月日： <input type="text" name="petBean.PET_AGE" size="10" id="age" value="${date}">
		<span class="error">${request.PET_AGE}</span><BR>
		寵物體重： <input type="number" name="petBean.PET_WEIGHT" size="10" value="${petBean.PET_WEIGHT}" >
		<span class="error">${request.PET_WEIGHT}</span><BR>		
			寵物種類：<select name="PET_KING_CHOICE" id="king">
				<option value="non">請選擇種類</option>
				<option value="cat">貓</option>
				<option value="dog">狗</option>
			</select>
			<input type="text" name="petBean.PET_KING" size="3" readonly="readonly" value="${petBean.PET_KING}" id="PET_KING">
			<span class="error">${request.PET_KING}</span><BR>
		
			品種選擇： <select name="PET_SORT_ID_CHOICE" id="sort"><option>請選擇品種</option></select> 
			<input type="text" name="petBean.PET_SORT_ID" size="12" readonly="readonly" value="${petBean.PET_SORT_ID}" id="PET_SORT_ID">
			<span class="error">${request.PET_SORT_ID}</span><BR>
			性別：
			<input name="petBean.PET_SEX" type="radio" value="公" id="sex" checked="checked">公
			<input name="petBean.PET_SEX" type="radio" value="母" id="sex">母	<br>
			寵物照片：<input type="file" name="PET_IMAGE" size="30" />
			<span class="error">${request.PET_IMAGE}</span><BR>
			<font color="red"><b><s:fielderror/></b></font>							 
		介紹：<BR>
			<textarea name="petBean.PET_BODY" cols="50" rows="10" ><s:property value="petBean.PET_BODY" /></textarea>
			<span class="error">${request.PET_BODY}</span><BR>
			<input type="submit" value="送出"><input type="button" value="清除" onclick="clearForm()"><BR>
	</form>	
</article>
</section>	
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
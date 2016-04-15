<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩-修改寵物資訊</title>

<style type="text/css">
	.error {color: #FF0000}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
$(function() {	
	$("input[name='petBean.PET_SEX'][value=${petBean.PET_SEX}]").prop("checked", true);    
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
<h1>寵物聯誼(修改寵物資訊)</h1>
	<font color="red"><b>只能修改寵物照片或者寵物介紹！！</b></font><br>
	<font color="blue"><b>${success }</b></font>
	<form action="<%=request.getContextPath()%>/petUpdate/petUpdate2Action.action" method="post" enctype="multipart/form-data">		
		會員編號：<input type="text" name="petBean.PET_OWN_ID" size="20" value="${petBean.PET_OWN_ID}" readonly="readonly"><BR>		
		寵物編號：<input type="text" name="petBean.PET_ID" size="20" value="${petBean.PET_ID}" readonly="readonly"><BR>	
		寵物名字： <input type="text" name="petBean.PET_NAME" size="10" value="${petBean.PET_NAME}" readonly="readonly"> 
		<BR>
		出生年月日： <input type="text" name="petBean.PET_AGE" size="10" id="age" value="${date}" readonly="readonly"> 
		<BR>
		寵物體重： <input type="number" name="petBean.PET_WEIGHT" size="10" value="${petBean.PET_WEIGHT}" readonly="readonly">
		<BR>
		寵物種類：			
		<input type="text" name="petBean.PET_KING" size="3" readonly="readonly" value="${petBean.PET_KING}" id="PET_KING">
		<BR>
		寵物品種：			 
		<input type="text" name="petBean.PET_SORT_ID" size="12" readonly="readonly" value="${Sortbean.PET_SORT_NAME}" id="PET_SORT_ID" > 
		<BR>
		性別：
		<input name="petBean.PET_SEX" type="radio" value="公" id="sex" disabled>公
		<input name="petBean.PET_SEX" type="radio" value="母" id="sex" disabled>母	<br>
		寵物照片：<input type="file" name="PET_IMAGE" size="30" />
		<span class="error">${request.PET_IMAGE}</span><BR>
		<font color="red"><b><s:fielderror/></b></font>							 
		介紹：<BR>
		<textarea name="PET_BODY" cols="50" rows="10" ><s:property value="PET_BODY" /></textarea>
		<span class="error">${request.PET_BODY}</span><BR>
		<input type="submit" value="送出"><input type="button" value="清除" onclick="clearForm()"><BR>
	</form>	
</article>
</section>
	
<c:import url="/import/footer.jsp"></c:import>
</body>
</html>
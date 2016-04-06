<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/import/head.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩 - 新增文章</title>
</head>
<body>
<c:import url="/import/header.jsp"></c:import>
<section>
<article>
<h1 style="font-size:40px;">新增文章</h1>
<s:form action="/article/uploadAction" method="Post" enctype="multipart/form-data" theme="simple">
類型:<s:select name="bean.ART_KIND" list="{'公告','活動','心得','問題'}"></s:select><br>
<c:choose>
<c:when test="${session.loginOK!=null}">
</c:when>
<c:otherwise>
姓名:<s:textfield name="bean.ART_MEM_ID" value="匿名"></s:textfield><br>
</c:otherwise>
</c:choose>

標題:<s:textfield name="bean.ART_TITLE" value=""></s:textfield><br>
內容:<br><s:textarea name="bean.ART_BODY" cols="50" rows="5" value=""></s:textarea><br>
請選擇圖片:<br>
<s:file name="img"></s:file>
<s:submit value="送出"></s:submit>
<s:fielderror cssStyle="color:red;list-style:none"></s:fielderror>
</s:form>
</article>	
</section>
<c:import url="/import/footer.jsp"></c:import>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="upload" namespace="/petImg" method="post">
		<s:label value="上傳一張寵物照片"/>
		<s:file name="PET_IMG" label="上傳檔案"/>
		<s:submit 開始上傳/>
	</s:form>
</body>
</html>
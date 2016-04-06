<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米沃貓窩-新增寵物照片</title>
</head>
<body>
	<h1>新增寵物照片</h1>
	<s:form action="PetImgAction" namespace="/petImg" enctype="multipart/form-data" method="post">
            <s:file name="PET_IMAGE" label="寵物照片" size="30"/>            
            <br/>
            <s:submit value="上傳照片" />
        </s:form>
</body>
</html>
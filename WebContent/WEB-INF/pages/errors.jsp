<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>
<%
	String basePath = request.getContextPath();
	String uploadPath = basePath + "/pages/emp/upload.action";
%>

<div class="container contentback">
	<img src="<%= basePath %>/images/500.jpg"/>
</div>

<a href="index.action" >返回主界面</a>
<h1>default出错了!! ${errors} </h1>
</body>
</html>
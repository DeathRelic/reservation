<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<img src="<%= basePath %>/images/404.jpg"/>
<h1>default出错了!! ${errors}，没有相应的权限</h1>
</body>
</html>
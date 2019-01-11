<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/mldn.css"/>

<title>Error Page</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/plugins/include_javascript_head.jsp" />
<%
	String basePath = request.getContextPath();
	String uploadPath = basePath + "/pages/emp/upload.action";
%>
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="font-size:50px">
				<shiro:lacksRole name="member">
					<p >
						<span class="glyphicon glyphicon-warning-sign" >[<shiro:principal/>]没有权限</span>
					</p>
				</shiro:lacksRole>
			</div>
		</div>
		<div class="row">
		<div class="col-md-6" style="font-size:50px">	
			<span><a href="index.action">返回主页</a></span>
		</div>
	</div>
	</div>
	
<jsp:include page="/WEB-INF/pages/plugins/include_splitpage_bar.jsp"></jsp:include>
</body>
</html>
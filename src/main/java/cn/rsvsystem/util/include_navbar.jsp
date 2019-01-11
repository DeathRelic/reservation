<%@page import="org.apache.ibatis.annotations.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="col-md-12">
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.action">
				预约系统
			</a>
		</div>
		<ul class="nav navbar-nav">
			<li id="nav1"><a href="index.action" ><strong><span class="glyphicon glyphicon-home"></span>&nbsp;首页</strong></a></li>
			<li id="nav2"><a href="news_list.action" ><strong><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;公告</strong></a></li>
			<li id="nav3"><a href="reserve.action"><strong><span class="glyphicon glyphicon-calendar"></span>&nbsp;预约报名</strong></a></li>
			<li id="nav4"><a href="loginUrl.action" ><strong><span class="glyphicon glyphicon-user"></span>&nbsp;登录</strong></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			<strong>&nbsp;${name==null?"tourist":name }</strong>
			<span class="caret">&nbsp;</span>
			</a>
			<ul class="dropdown-menu">
				<li ><a href="index.action"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;Home</a></li>
				<shiro:user>
					<li><a href="logoutUrl.action"><span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;Log Out</a></li>
					<li><a href="successUrl.action"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Management</a>
				</shiro:user>
				<shiro:guest>
					<li><a href="loginUrl.action"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;Log In</a></li>
				</shiro:guest>
			</ul>
			</li>
		</ul>
	</nav>
</div>

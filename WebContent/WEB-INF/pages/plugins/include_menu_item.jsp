<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro"  uri="http://shiro.apache.org/tags" %>
<%@include file="/WEB-INF/pages/plugins/include_basepath.jsp" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="images/dao-icon.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p> ${name }</p>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-slack"></i> 预约系统 </li>
			<shiro:hasRole name="member">
				<li class="treeview"><a href="#"> <i
						class="fa fa-group"></i> 
						<span> 用户管理</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu"> 
						<shiro:hasPermission name="member:add">
							<li class="active"><a href="back/account.action"><i class="fa fa-plus-square"></i>
									增加用户</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="member:list">
							<li class="active"><a href="back/listMember.action"><i class="fa fa-list-alt"></i>
									用户列表</a></li>
						</shiro:hasPermission>
					</ul></li>
			</shiro:hasRole>
			<shiro:hasRole name="news">
			<li class="${param.role=='news' ? 'active' : ''} treeview"><a href="<%=basePath%>pages/back/index.jsp"> <i class="fa fa-bullhorn"></i>
					<span>公告管理</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<shiro:hasPermission name="news:add">
						<li class=""><a href="pages/back/news/news_add.jsp"><i
								class="fa fa-plus-circle"></i> 发布公告</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="news:list">
						<li class="${param.action=='news:list' ? 'active' : ''}"><a href="pages/back/news/news_list.jsp?type=list"><i
								class="fa fa-list-ul"></i> 公告列表</a></li>
						<li class="${param.action=='news:unlist' ? 'active' : ''}"><a href="pages/back/news/news_list.jsp?type=unlist"><i
								class="fa fa-archive"></i> 公告草稿箱</a></li>
					</shiro:hasPermission>
				</ul></li>
			</shiro:hasRole>
			<shiro:hasRole name="bespeak">
				<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i class="fa  fa-slideshare"></i>
						<span>预约报名管理</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<shiro:hasPermission name="bespeak:edit">
							<li ><a href="pages/back/bespeak/bespeak_list.jsp?type=new"><i
									class="fa fa-exclamation-circle"></i> 新的预约报名</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="bespeak:list">				
							<li ><a href="pages/back/bespeak/bespeak_list.jsp?type=all"><i
									class="fa fa-laptop"></i> 预约报名列表</a></li>
							<li ><a href="pages/back/bespeak/bespeak_list.jsp?type=wait"><i
									class="fa fa-vine"></i> 待处理预约报名</a></li>
							<li ><a href="pages/back/bespeak/bespeak_list.jsp?type=finish"><i
									class="fa fa-ticket"></i> 已处理预约报名</a></li>
							<li ><a href="pages/back/bespeak/bespeak_list.jsp?type=invalid"><i
									class="fa fa-trash">
									</i> 无效预约报名</a></li>
						</shiro:hasPermission>
					</ul>
					</li>
				</shiro:hasRole>
				<li class="treeview"><a href="#"><i class="glyphicon glyphicon-home">
				</i><span>回到主页</span><i class="fa fa-angle-left pull-right"></i></a>
					<ul class="treeview-menu">
							<li><a href="index.action"><i class="glyphicon glyphicon-home"></i>回到主页</a></li>
					</ul>
				</li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
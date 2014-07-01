<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
	$(document).ready(function(){
		sidebar_page_init();
	});
</script>

<div id="sidebar">
	<div id="sidebar-wrapper">
		<h1 id="sidebar-title">
			<a href="#"></a>
		</h1>
		<a href="#" target="_blank">
			<img id="logo" src="images/logo.png" />
		</a>
		<div id="profile-links">
			你好 &nbsp; ${currentUser.lastName}${currentUser.firstName}
			<br />
			<br />
			<a href="common/logout" title="退出系统">退出系统</a>
		</div>
		<ul id="main-nav">
			<li><a id="my-information" href="user/my-information" class="nav-top-item no-submenu">我的信息 </a></li>
			<li><a id="contact" href="#" class="nav-top-item">联系人 </a>
				<ul>
					<li>
						<a id="contact-group" href="contact/list-groups">分组</a>
					</li>
					<li>
						<a id="contact-contact" href="contact/list-contacts/1">联系人</a>
					</li>
				</ul>
			</li>
			<security:authorize access="hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')">
			<li><a id="system-setting" href="#" class="nav-top-item">系统管理</a>
				<ul>
					<li>
						<a id="list-users" href="user/list-users/1">禁用账户</a>
					</li>
				</ul>
			</li>
			</security:authorize>
			<li><a id="setting" href="#" class="nav-top-item">设置 </a>
				<ul>
					<li>
						<a id="change-passwod" href="user/change-password">更改密码</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
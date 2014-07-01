<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#my-information").addClass("current");
	});
</script>
<div id="main-content">
	<ul class="shortcut-buttons-set">
		<li>
			<a class="shortcut-button" href="user/edit-information">
				<span>
					<img src="images/icons/pencil_48.png"/><br/>测试成功
				</span>
			</a>
		</li>
	</ul>
	<div class="content-box">
		<div class="content-box-content">
			<div class="content-box-header">
				<h3>&nbsp;</h3>
				<div class="clear"></div>
			</div>
			<table border="0">
				<tr>
					<td>用户名</td>
					<td>${currentUser.username}</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>${currentUser.lastName}${currentUser.firstName}</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="footer">
		<small>
			Powered by <a href="#" target="_blank">孟杰</a> | <a href="mailto:mengjie@wondersgroup.com">联系我</a>
		</small>
	</div>
</div>
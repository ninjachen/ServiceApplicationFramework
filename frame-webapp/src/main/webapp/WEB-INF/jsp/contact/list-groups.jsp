<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#contact").addClass("current");
		$("#contact-group").addClass("current");
		$("#contact").click();
	});
</script>
<div id="main-content">
	<ul class="shortcut-buttons-set">
		<li>
			<a class="shortcut-button" href="contact/add-group">
				<span>
					<img src="images/icons2/plus_48.png"/><br/>添加
				</span>
			</a>
		</li>
	</ul>
	<div class="clear"></div>
	<div class="content-box">
		<div class="content-box-content">
			<div class="content-box-header">
				<h3>&nbsp;</h3>
				<div class="clear"></div>
			</div>
			<c:if test="${hasErrors}">
			<div class="notification error png_bg">
				<a class="close" style="cursor: pointer;"><img src="images/icons/cross_grey_small.png"/></a>
				<div>
					<c:forEach items="${errors}" var="msg">
						${msg}
					</c:forEach>
				</div>
			</div>
			</c:if>
			<table border="0">
				<thead>
					<tr>
					<th>名称</th>
					<th>备注</th>
					<th>操作</th>
					<th></th>
					<th></th>
					</tr>
				</thead>
				<c:forEach items="${groups}" var="g" varStatus="s">
				<tr>
					<td>${g.name}</td>
					<td>${g.description}</td>
					<td><a href="contact/delete-group/${g.id}" title="删除"><img src="images/icons2/delete_16.png"/></a></td>
					<td></td>
					<td></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
	<div id="footer">
		<small>
			Powered by <a href="#" target="_blank">孟杰</a> | <a href="mailto:mengjie@wondersgroup.com">联系我</a>
		</small>
	</div>
</div>
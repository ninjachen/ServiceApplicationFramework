<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#system-setting").addClass("current");
		$("#list-users").addClass("current");
		$("#system-setting").click();
	});
</script>
<div id="main-content">
	<div class="clear"></div>
	<div class="content-box">
		<div class="content-box-content">
			<div class="content-box-header">
				<h3>&nbsp;</h3>
				<div class="clear"></div>
			</div>
			<table border="0">
				<thead>
					<tr>
					<th>用户名</th>
					<th>姓名</th>
					<th>性别</th>
					<th>操作</th>
					<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.content}" var="user" varStatus="s">
				<tr>
					<td>${user.username}</td>
					<td>${user.lastName}&nbsp;${user.firstName}</td>
					<td>${user.gender == 'MALE' ? '男' : '女'}</td>
					<td>
						<c:if test="${user.enabled}">
							<a href="user/lock/${user.id}/current-page/${page.number}" title="禁用"><img src="images/icons2/stop_16.png"/></a>
						</c:if>
						<c:if test="${!user.enabled}">
							<a href="user/unlock/${user.id}/current-page/${page.number}" title="启用"><img src="images/icons2/key_16.png"/></a>
						</c:if>
					</td>
					<td></td>
				</tr>
				</c:forEach>
				</tbody>
				<tfoot>
					<tr>
					<td colspan="5">
					<div class="pagination">
						<a href="user/list-users/1">&laquo; 第一页</a>
						<c:forEach begin="1" end="${page.totalPages}" var="pageNumber">
							<c:if test="${page.number == pageNumber}">
								<a href="user/list-users/${pageNumber}" class="number current">${pageNumber}</a>
							</c:if>
							<c:if test="${page.number != pageNumber}">
								<a href="user/list-users/${pageNumber}" class="number">${pageNumber}</a>
							</c:if>
						</c:forEach>
						<a href="user/list-users/${page.totalPages}" title="Last Page">最后一页 &raquo;</a>
					</div>
					</td>
					</tr>
				</tfoot>
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
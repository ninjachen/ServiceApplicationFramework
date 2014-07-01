<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#contact").addClass("current");
		$("#contact-contact").addClass("current");
		$("#contact").click();
	});
</script>
<div id="main-content">
	<ul class="shortcut-buttons-set">
		<li>
			<a class="shortcut-button" href="contact/add-contact">
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
			<table border="0">
				<thead>
					<tr>
					<th>姓名</th>
					<th>手机号</th>
					<th>个人邮件</th>
					<th>工作邮件</th>
					<th>分组</th>
					<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.content}" var="c" varStatus="s">
				<tr>
					<td>${c.name.lastName}&nbsp;${c.name.firstName}</td>
					<td>${c.cellPhoneNumber}</td>
					<td>${c.personalEmail}</td>
					<td>${c.workEmail}</td>
					<td>${c.group == null ? '(未分组)' : c.group.name}</td>
					<td>
						<a href="contact/delete-contact/${c.id}/current-page/${pageNumber}" title="删除"><img src="images/icons2/delete_16.png"/></a>
					</td>
				</tr>
				</c:forEach>
				</tbody>
				<tfoot>
					<tr>
					<td colspan="6">
					<div class="pagination">
						<a href="contact/list-contacts/1">&laquo; 第一页</a>
						<c:forEach begin="1" end="${page.totalPages}" var="pageNumber">
							<c:if test="${page.number == pageNumber}">
								<a href="contact/list-contacts/${pageNumber}" class="number current">${pageNumber}</a>
							</c:if>
							<c:if test="${page.number != pageNumber}">
								<a href="contact/list-contacts/${pageNumber}" class="number">${pageNumber}</a>
							</c:if>
						</c:forEach>
						<a href="contact/list-contacts/${page.totalPages}" title="Last Page">最后一页 &raquo;</a>
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
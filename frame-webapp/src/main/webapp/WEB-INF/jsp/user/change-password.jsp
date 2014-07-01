<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function() {
		$("#setting").addClass("current");
		$("#change-passwod").addClass("current");
		$("#setting").click();
		change_password_page_init();
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
			<form:form action="" method="post" modelAttribute="changePasswordForm">
			<c:if test="${hasErrors}">
			<div class="notification error png_bg">
				<a class="close" style="cursor: pointer;"><img src="images/icons/cross_grey_small.png"/></a>
				<div>
					<form:errors path="*" />
				</div>
			</div>
			</c:if>
			<table id="table1" border="0">
				<tbody>
				<tr>
					<td>旧密码</td>
					<td><form:password path="oldPassword" cssClass="text-input small-input"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><form:password path="password1" cssClass="text-input small-input"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><form:password path="password2" cssClass="text-input small-input"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</tbody>
			</table>
			<p>
				<br/>
				<input class="button" type="submit" value="提交" />
            </p>
			</form:form>
		</div>
	</div>
	<div class="clear"></div>
	<div id="footer">
		<small>
			Powered by <a href="#" target="_blank">孟杰</a> | <a href="mailto:mengjie@wondersgroup.com">联系我</a>
		</small>
	</div>
</div>
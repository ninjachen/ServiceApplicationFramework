<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function(){
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
			<form:form id="form1" action="" method="post" modelAttribute="addGroupForm">
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
					<td>名称</td>
					<td><form:input path="name" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>描述(最多255个字符)</td>
					<td><form:textarea path="description" class="text-input small-input" /> </td>
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

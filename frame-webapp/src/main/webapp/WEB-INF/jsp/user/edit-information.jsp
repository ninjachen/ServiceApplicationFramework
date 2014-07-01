<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function(){
		edit_information_page_init();
	});
</script>

<div id="main-content">
	<ul class="shortcut-buttons-set">
		<li>
			<a id="addEmail" class="shortcut-button" style="cursor: pointer;">
				<span>
					<img src="images/icons2/plus_48.png"/><br/>添加邮件
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
			<form:form id="form1" action="" method="post" modelAttribute="userInformationForm">
			<table id="table1" border="0">
				<tbody>
				<tr id="clone">
					<td>邮件</td>
					<td><input type="text" name="emails" value="" class="text-input small-input" /></td>
					<td><a name="deleteEmail" title="删除"><img src="images/icons2/delete_16.png"/></a></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>姓</td>
					<td><form:input path="lastName" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>名</td>
					<td><form:input path="firstName" class="text-input small-input" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<c:forEach items="${userInformationForm.genderOptions}" var="each">
							<form:radiobutton path="gender" value="${each}"/> ${each}
						</c:forEach>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach items="${userInformationForm.emails}" var="email">
				<tr>
					<td>邮件</td>
					<td><input type="text" name="emails" value="${email}" class="text-input small-input" /></td>
					<td><a name="deleteEmail" title="删除"><img src="images/icons2/delete_16.png"/></a></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:forEach>
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

<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<base href="<%=basePath%>" />
	<title>FRAME</title>

	<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen" />

	<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="js/me.js"></script>
	<script type="text/javascript">
	
	</script>
</head>

<body id="login">
	<div id="login-wrapper" class="png_bg">
		<div id="login-top">
			<h1>FRAME</h1>
			<a href="#" target="_blank">
				<img id="logo" src="images/logo.png" />
			</a>
		</div>
		<div id="login-content">
			<div class="notification error png_bg">
      			<div>由于您不具有相应的权限，您的操作被服务器拒绝。</div>
    		</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery</title>
<link rel="stylesheet" href="js/left_js/jquery.treeview.css" />
<link rel="stylesheet" href="js/left_js/shipin_class.css" />
<script src="js/left_js/jquery.js" type="text/javascript"></script>
<script src="js/left_js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/left_js/jquery.treeview.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$("#browser").treeview();
		});
	</script>
	<style>
li {
	cursor:pointer;
}
a{
text-decoration:none;
}
</style>
	</head>
	

	<base target="mainFrame">
	<body bgcolor="#CCCCCC">
<div id="main">
<ul id="browser" class="filetree">
<li><img src="../images/folder.gif" /> 用户管理</span>
		<ul>
		<li ><a href="user_new_cont.html">用户列表</a></li>
		<li ><a href="user_search.html">用户查询</a></li>
	</ul>
	</li>
<li><img src="../images/folder.gif" /> 数据管理</span>
		<ul>
		<li>管理1</li>
		<li>管理2 </li>
		<li><img src="../images/folder.gif" /> 管理3</span>
				<ul>
				<li>管理4</li>
				<li>管理5 </li>
				<li>管理6 </li>
			</ul>
			</li>
	</ul>
	</li>
</body>
</html>

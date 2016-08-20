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

</head>
<body bgcolor="#CCCCCC">
	<div id="main">
		<ul id="browser" class="filetree">
			<li><img src="images/left_picture/folder.gif" /> 用户管理</span>
				<ul>
					<li onClick='parent.window.set_content();'>管理1<img
						src="images/left_picture/file.gif" /></li>
				</ul>
				<ul>
					<li onClick='parent.window.set_content();'>管理2<img
						src="images/left_picture/file.gif" /></li>
				</ul>
			</li>

			<li><img src="images/left_picture/folder.gif" /> 数据管理</span>
				<ul>
					<li>blabla</li>
					<li>blabla</li>
					<li><img src="images/left_picture/folder.gif" /> 管理1</span>
						<ul>
							<li>blabla</li>
							<li>blabla</li>
							<li>blabla</li>
							<li>blabla</li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>
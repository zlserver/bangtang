<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<base href="<%=basePath%>" />
<body>

<iframe id="user_news_content" src="user_new_cont.html" align="middle" scrolling="auto" width="100%"  height="450px" frameborder="0"></iframe>
<iframe align="middle" src="page.html" height="60px" width="100%" scrolling="no" frameborder="0"></iframe>
</body>
</html>
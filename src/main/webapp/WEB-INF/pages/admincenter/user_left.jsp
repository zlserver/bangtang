<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.user_left_class{
	background-color:#0F9;
	border-style:solid;
	border-width:2px;
	border-color:#000;
	border-bottom-left-radius:1em;
	border-bottom-right-radius:1em;
	border-top-left-radius:1em;
	border-top-right-radius:1em;
	width:200px;
	height:50px;
	line-height:50px;
	text-align:center;
	box-shadow: 5px 5px 2.5px #999;
}
</style>
</head>

<body bgcolor="#00FFFF">
<div class="user_left_class" id="user_shipin" onclick='parent.window.set_shipin();'>视频</div>
<div class="user_left_class" id="user_tupian" onclick='parent.window.set_tupian();'>图片</div>
</body>
</html>

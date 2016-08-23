<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<style>
.left_div{
	float:left;
}
.right_div{
	float:right;
}
.input_class{
	width:150px;
	height:25px;	
}
</style>

<body>
<h3 align="right" >用户信息查询</h3>
<div  class="left_div" id="left">精确查询
<form  id="accurate">
	<input type="text" id="name" class="input_class"  title="请输入查询用户的名字" />
	<input type="submit" id="submit" />
</form>
</div>
<div class="right_div" id="right">模糊查询
<form id="dim">
	<input type="text" id="name"  class="input_class" title="请输入相关信息"/>
	<input type="submit" id="submit" />
</form>
</div>
</body>
</html>

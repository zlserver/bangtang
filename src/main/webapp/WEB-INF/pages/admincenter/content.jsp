<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>内容</title>

<style>
.div_headline{
	width:10%;
	height:20px;
	background-color:#CCC;
	float:left;
	position:relative;
}
.div_contentline{
	width:10%;
	height:20px;
	float:left;
	position:relative;
}
</style>
<script type="text/javascript">
function change_in()
{
	var falg = true;
	var divid = document.getElementById("content_data");
	var tag = divid.getElementsByTagName("div"); 
	var len = tag.length;
		for(var i = 0; i < len; i++)
		{
			tag.item(i).style.backgroundColor="#ccc";
		}
}
function change_out()
{
	var falg = true;
	var divid = document.getElementById("content_data");
	var tag = divid.getElementsByTagName("div"); 
	var len = tag.length;
		for(var i = 0; i < len; i++)
		{
			tag.item(i).style.backgroundColor="";
		}
	}
</script>
</head>

<body>
<h1 align="center">所有用户的信息</h1>
<div id="headline_div">
	<div id="hesdline" align="center"  class="div_headline">用户昵称</div>
	<div id="hesdline" align="center"  class="div_headline">密码</div>
	<div id="hesdline" align="center"  class="div_headline">性别</div>
	<div id="hesdline" align="center"  class="div_headline">国籍</div>
	<div id="hesdline" align="center"  class="div_headline">学习语言</div>
	<div id="hesdline" align="center"  class="div_headline">激活状态</div>
	<div id="hesdline" align="center"  class="div_headline">注册时间</div>
	<div id="hesdline" align="center"  class="div_headline">登陆次数</div>
	<div id="hesdline" align="center"  class="div_headline">登录时间</div>
	<div id="hesdline" align="center"  class="div_headline">登录设备</div>
</div>
<div  id="content_data"  onMouseOver="change_in()" onMouseOut="change_out()">
	<div id="name" align="center"  class="div_contentline">s</div>
	<div id="password" align="center"  class="div_contentline">s</div>
	<div id="gender" align="center"  class="div_contentline">s</div>
	<div id="nation" align="center"  class="div_contentline">s</div>
	<div id="language" align="center"  class="div_contentline">s</div>
	<div id="state" align="center"  class="div_contentline">s</div>
	<div id="regTime" align="center"  class="div_contentline">s</div>
	<div id="loginCount" align="center"  class="div_contentline">s</div>
	<div id="reLoTime" align="center"  class="div_contentline"></div>
	<div id="machine" align="center"  class="div_contentline"></div>
</div>
</body>
</html>


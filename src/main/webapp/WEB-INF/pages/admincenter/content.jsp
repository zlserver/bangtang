<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>
<style>
td {
	width:100px;
	height:20px;
}
</style>
<script>
window.onload=function()
{
	var aR=[];
	for (var a=0;a<100;a++)
	{
		aR.push(a);
	}
	var oBody = document.getElementById("tB");
	for(var i=0; i<aR.length;i++)
	{
		var oTr = document.createElement("tr");
		for(j=0;j<10;j++)
		{
			var oTd = document.createElement("td");
			oTd.innerHTML=aR[i];
			oTr.appendChild(oTd);
		}
		oBody.appendChild(oTr);
	}
	for(i=0;i<oBody.rows.length;i++)
	{
		if(i%2==0)
		{
			oBody.rows[i].style.backgroundColor="#ccc";
		}
	}
	var color='';
	for(i=0;i<oBody.rows.length;i++)
	{ 
		oBody.rows[i].onmouseover=function(){
			color=this.style.backgroundColor;
			this.style.backgroundColor="red";
		}
		oBody.rows[i].onmouseout=function(){
		    this.style.backgroundColor=color;
		}
		oBody.rows[i].onclick=function(){
			parent.window.document.set_all_user(oBody.rows[i].cells[0].innerHTML);
		}
	}
}
</script>
<base href="<%=basePath %>" />
<body>
<h2 align="center">所有用户的信息</h2>
<table border="1" id="data">
	<thead>
		<tr>
			<td>用户昵称</td>
			<td>密码</td>
			<td>性别</td>
			<td>国籍</td>
			<td>学习语言</td>
			<td>激活状态</td>
			<td>注册时间</td>
			<td>登陆次数</td>
			<td>登录时间</td>
			<td>登录设备</td>
		</tr>
	</thead>
	<tbody id="tB">
	</tbody>
</table>
</body>
</html>

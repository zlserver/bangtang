<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.one{ width:100%; height:150px; background-color:#0F0; clear:both; text-align:center}
.two{ width:100%; height:480px; background-color:#CCC; clear:both;}
.button{ width:50px; height:35px; background-color:#0F0}
.three{ width:100%; height:30px; background-color:#0F0; clear:both; text-align:center}
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
</style>


<script type="text/javascript" language="javascript">
function checkUser()
{
	var account=document.getElementById("login").value;
	var password=document.getElementById("password").value;
	if(account!=""){
		if(password==""){
			alert("密码不能为空！");
			return false;
		}
		else
		{window.location.href="menu/main.html";return true;
			}
	}
	else{
		alert("账号不能为空！");
		return false;
		}
}
</script>
</head>

<body>
<div  class="one">
<table width="100%" height="150" border="0">
	<tr>
		<td align="center"><font size="+5">单词棒棒糖后台管理中心</font></td>
	</tr>
</table>
</div>
<div id="main" class="two">
  <table width="500" height="480" border="0" align="center"  >
     <tr>
      <td width="200" align="center">&nbsp;</td>
      <td width="300">&nbsp;</td>
    </tr>
    <tr>
	
      <td width="200" align="center"><font size="+3"><strong>账号：</strong></font></td>
      <td width="300"><input type="text" id="login"  style="widows:300px; height:25px"/></td>
    </tr>
    <tr>
      <td width="200" align="center"><font size="+3"><strong>密码：</strong></font></td>
      <td width="300"><input type="text" id="password"  style="widows:300px; height:25px"/></td>
    </tr>
    <tr>
      <td></td>
      <td align="right"><input type="button" onclick="checkUser()" id="Login" align="middle" value="登录" class="button"/></td>
    </tr>
  </table>
</div>
<div class="three">北京悠游视记股份有限公司www.wordslollipop.com</div>
</body>
</html>

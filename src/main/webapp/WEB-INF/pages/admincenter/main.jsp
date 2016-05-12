<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>main</title>
<script language="javascript" type="text/javascript">
function set_content(){
	frame=document.getElementById("mainFrame");
	frame.src="first.html";
}
</script>
</head>
<frameset rows="120,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="common/admin/loginUi.action" name="topFrame" scrolling="no"  id="topFrame" title="topFrame" />
	<frameset cols="220,*" frameborder="no" border="0" framespacing="0">
		<frame src="control/center/left.action" name="leftFrame" scrolling="yes" id="leftFrame" title="leftFrame" />
		<frame src="control/center/content.action" name="mainFrame" id="mainFrame" title="mainFrame"  scrolling="yes"/>
	</frameset>
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
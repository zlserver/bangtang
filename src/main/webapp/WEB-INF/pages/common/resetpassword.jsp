<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>

</head>
<body>
<form action="mobile/common/resetPassword.action" method="post">
<input type="hidden" name="resetCode" value="${resetCode}">
新密码：<input type="password"  name="password" >
<input type="submit" value="提交 ">
</form>
</body>
</html>
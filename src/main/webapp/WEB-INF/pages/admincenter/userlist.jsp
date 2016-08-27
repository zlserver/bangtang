<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">   
<title>新闻列表</title> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/WEB-INF/pages/share/bootstrap.jsp"></jsp:include>
<style type="text/css">

</style>
<script type="text/javascript">
	//查询
	function topage(pageNumber)
	{
		
		var form = document.forms[0];
		form.pageNumber.value= pageNumber;
		form.submit();
	}

</script>
</head>
<body style="position: relative;">
<div class="panel panel-default">
  <div class="panel-heading">
  <a href="control/client/list.action">
  	用户列表
  </a>
  </div>
  <div class="panel-body">
	<form  action="<c:url value='control/client/list.action'/>" method="post">
    <input type="hidden" name="pageNumber" value="${formbean.pageNumber}" >
	<table class="table table-bordered table-striped"> <!-- table-bordered -->
		<thead>
		<tr>
			<td>邮箱</td>
			<td>用户昵称</td>
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
		<tbody>
		 <c:forEach items="${formbean.page }" var="entity" varStatus="status">
			<tr>
			<td> ${entity.email } </td>
			<td> ${entity.nickname } </td>
			  <td> ${entity.gender }  </td>
			  <td> ${entity.nation } </td>
			 <td>  学习语言--</td>
			 <td>  ${entity.emailstatus }</td>
			 <td> ${entity.regtime }</td>
			 <td>登陆次数</td>
			 <td>登录时间</td>
			 <td>登录设备</td>
			 </tr>
		   </c:forEach>
		</tbody>
	</table>
	</form>
  </div>
   <div class="panel-footer">
      <%@ include file="/WEB-INF/pages/share/fenye.jsp"%>
   </div>
</div>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		function sq(teaId){
			$.ajax({
				url:"tea_addSq",
				data:{
						teaId:teaId
					},
				success:function(data){
					if(data=='success'){
						$("#td"+teaId).html("申请中...")
					}
				}
			});
		}
	</script>
  </head>
  
  <body>
   <table border="1" width="80%">
   	<tr>
   		<th>序号</th><th>姓名</th><th>课程</th><th>状态</th>
   	</tr>
   	<c:forEach items="${teaList}" var="t" varStatus="s">
   		<tr>
   			<td>${s.count }</td>
   			<td>${t.teaName }</td>
   			<td>${t.keCheng }</td>
   			<td id="td${t.id }">
   			<c:choose>
   				<c:when test="${t.teaStatus==0}">申请中</c:when>
   				<c:when test="${t.teaStatus==1}">已被拒绝</c:when>
   				<c:when test="${t.teaStatus==2}">成功</c:when>
   				<c:when test="${t.teaStatus==3}"><a href="javascript:void(0);" onclick="sq(${t.id})" id="a">申请</a></c:when>
   			</c:choose>
   			</td>
   		</tr>
   	</c:forEach>
   </table>
  </body>
</html>

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
		function tyOrjj(stuId,status){
			$.ajax({
				url:"stu_updateSq",
				data:{
						stuId:stuId,
						status:status
					},
				success:function(data){
					if(data=='success'){
						if(status==2){
							$("#td"+stuId).html("成功");
						}else{
							$("#td"+stuId).html("拒绝");
						}
					}
				}
			});
		}
	</script>
  </head>
  
  <body>
   <table border="1" width="80%">
   	<tr>
   		<th>序号</th><th>姓名</th><th>状态</th>
   	</tr>
   	<c:forEach items="${stuList}" var="stu" varStatus="s">
   		<tr>
   			<td>${s.count }</td>
   			<td>${stu.stuName }</td>
   			<td id="td${stu.id }">
   			<c:choose>
   				<c:when test="${stu.stuStatus==0}"><a href="javascript:void(0);" onclick="tyOrjj(${stu.id},2)">同意</a>||<a href="javascript:void(0);" onclick="tyOrjj(${stu.id},1)">拒绝</a></c:when>
   				<c:when test="${stu.stuStatus==1}">已被拒绝</c:when>
   				<c:when test="${stu.stuStatus==2}">成功</c:when>
   				<c:when test="${stu.stuStatus==3}">未申请</c:when>
   			</c:choose>
   			</td>
   		</tr>
   	</c:forEach>
   </table>
  </body>
</html>

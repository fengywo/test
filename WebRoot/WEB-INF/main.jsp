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
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body> 
  	欢迎  <c:if test="${s==1}">
  		   学生  ${sstu.stuName } 登陆
  		</c:if>
  		<c:if test="${s==2}">
  		   教师  ${stea.teaName } 登陆
  		</c:if>
  		<hr/>
  	<c:if test="${s==1}">
		 <a href="${pageContext.request.contextPath }/tea_queryAll">查询老师</a>	
	</c:if>	
  	<c:if test="${s==2}">
  		 <a href="${pageContext.request.contextPath }/stu_queryAll">查询学生</a>
  	</c:if>
  		
    
  </body>
</html>

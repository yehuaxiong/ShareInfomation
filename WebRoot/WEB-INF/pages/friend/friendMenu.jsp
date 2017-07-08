<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'friendMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
	    *{
	        padding: 0px;
	    }
	    ul{
	        list-style: none;
	    }
	    ul li a{
	        color: blueviolet;
	        text-align: center;
	        text-decoration: none;
	    }
	    ul li a:hover{
	        color: red;
	    }
	</style>
  </head>
  
  <body style="background-image: url('./images/friendmenu.jpg');background-repeat: no-repeat;">
    	<div  >
        <ul>
            <li><a href="friendList.action" target="iframe_center">好友列表</a></li>
            <li><a href="page_friend_addFirend.action" target="iframe_center">添加好友</a></li>
            <li><a href="page_friend_addFriendNotice.action" target="iframe_center">新好友通知</a></li>
        </ul>
   		</div>
  </body>
</html>

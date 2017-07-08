<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
<style type="text/css">
    *{
        margin: 0px;
        padding: 0px;
    }
    .a1{
        width:100%;
        height: 100%;
    }
    ul{
        list-style: none;
    }
    ul li{
    	  padding: 10px;
    }
    ul li a{
   		color:blue;
        font-weight:bolder;
        text-align: center;
        text-decoration: none;
    }
    ul li a:hover{
        color: red;
    }
</style>


</head>
<body style="background-image: url('./images/dt.jpg');background-repeat: no-repeat;">
    <div class="a1">
        <ul>
            <li><a href="page_dynamic_firendDynamic.action" target="iframe_center">动态</a></li>
            <li><a href="page_dynamic_writeDynamic.action" target="iframe_center">发表动态</a></li>
        </ul>
    </div>
</body>
</html>
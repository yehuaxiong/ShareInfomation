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
        background-color: pink ;
    }
    ul{
        list-style: none;
    }
    ul li{
    
        padding: 10px;
  
    }
    ul li a{
        font-weight:bolder;
        color:blue;
        text-align: center;
        text-decoration: none;
    }
    ul li a:hover{
        color: red;
    }
</style>


</head>
<body>
    <div class="a1" style="background-image: url('./images/tz.jpg');background-repeat: no-repeat;">
        <ul>
            <li><a href="ShowNotice.action" target="iframe_center">公告</a></li>
            <li><a href="page_notice_writeNotice.action" target="iframe_center">发布公告</a></li>
        </ul>
    </div>
</body>
</html>
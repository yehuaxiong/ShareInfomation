<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link  rel="stylesheet" type="text/css"
           href="css/style2.css">
</head>
<body >
    <div style="width: 100%;height: 100%">
        <ul style="width: 100%;list-style: none" class="ul2">
            <li>作者</li>
            <li>标题</li>
            <li>删除</li>
        </ul>

    </div>
</body>
</html>
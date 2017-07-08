<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!--<base href="<%=basePath%>">-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css"
          href="css/all.css">
<script type="text/javascript">
$(function(){
 $(".editpassword").click(function () {			
                window.open("page_admin_editpw.action","iframe_center");
            });
 $(".editinfo").click(function () {			
                window.open("student_query.action","iframe_center");
            });
})

</script>
</head>
<body>
<div style="background-image: url('./images/leftbg.jpg');background-repeat: no-repeat;">
	<h3>-个人信息-</h3>
    <div style="height:20%;margin-left:5px;margin-top:5px;padding: 0">
        <label>姓名:${sessionScope.username}</label>
    </div>
    <div style="height:20%;margin-left:5px;padding: 0" >
         <a href="#" style="color: black;text-decoration: none;" class="editpassword">修改密码</a>
    </div>
    <div style="height:50%;margin-left:5px;padding: 0" >
        <a href="#" style="color: black;text-decoration: none;" class="editinfo">修改信息</a>
    </div>
</div>



</body>
</html>
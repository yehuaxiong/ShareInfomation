<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryPersonInfo.jsp' starting page</title>
      <script src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	$(function(){
		$(".edit").click(function(){
			  window.open("studentperson_edit.action","iframe_center");
		});
	
	
	})
</script>
  </head>
  
  <body style="width: 100%;">
  <div style="width: 50%;margin: 0 auto;">
  <form action="" method="post" id="">
   <table style="width: 694px;margin: 0 auto; height: 312px" >
  <tr>
    <td colspan="2"><h3 style="margin-left: 200px">个人信息</h3></td>
  </tr>
  <tr >
    <td style="width: 190px; "><label>用户名:${student.id}</label></td>
    <td style="width: 153px; "><label>姓名:${student.name}</label></td>
  </tr >
    <tr >
    <td style="width: 240px; "><label>性别:${student.sex}</label></td>
    <td><label>电话:${student.phone }</label></td>
  </tr>
    <tr >
    <td><label>学院:${student.claname.specialty.department.dname}</label></td>
    <td style="width: 321px; "><label>班级:${student.claname.cname}</label></td>
  </tr>
      <tr>
    <td><label>职务:${student.job}</label></td>
    <td><label>邮箱:${student.email}</label></td>
  </tr>
        <tr >
    <td><label>政治面貌:${student.politicalStatus}</label></td>
  </tr>
          <tr style="text-align: center">
    <td><input type="button" value="修改" class="edit"></td>
  </tr>
</table>
</form>
</div>
  </body>
</html>

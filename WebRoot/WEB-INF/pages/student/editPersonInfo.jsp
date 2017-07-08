<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editPersonInfo.jsp' starting page</title>
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
	
	$(".ok").click(function(){
	alert("修改成功");			
	});	
	$(".cancle").click(function(){		
	alert("dfrgsg");
           
       
	});
	})
	</script>
  </head>
  
  <body style="width: 100%">
   <div style="width: 50%;margin: 0 auto">
  <form action="studentperson_save.action" method="post" id="">
   <table style="width: 455px;margin: 0 auto; height: 266px">
   <tr style="text-align: center;">
   <td colspan="2"><h3>修改个人信息</h3></td>
   </tr>
    <tr style="text-align: center; width: 460px">
    <td style="width: 200px;"><label>性别:</label><input type="text" name="sex"></td>
    <td><label>电话:</label><input type="text" name="phone"></td>
  </tr >
      <tr style="text-align: center">
    <td><label>职务:</label><input type="text" name="job"></td>
    <td><label>邮箱:</label><input type="text" name="email"></td>
  </tr>
     <tr style="text-align: center">
    <td style="width: 227px; "><label>政治面貌:</label><input type="text" name="politicalStatus"></td>
  </tr>
          <tr style="text-align: center">
    <td><input type="submit" value="确定" class="ok"></td>
    <td><input type="button" value="取消" class="cancel"></td>
  </tr>
</table>
</form>
</div>
  </body>
</html>

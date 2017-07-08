
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'editSudentInfo.jsp' starting page</title>



	<!-- 导入jQuery核心类库 -->
    <script type="text/javascript"
            src="./js/jquery-1.8.0.min.js"></script>
    <!-- 导入easyui核心类库 -->
    <script type="text/javascript"
            src="./js/easyui/jquery.easyui.min.js"></script>
    <!-- 国际化 -->
    <script
            src="./js/easyui/locale/easyui-lang-zh_CN.js"
            type="text/javascript"></script>
    <!-- easyui核心css -->
    <link id="easyuiTheme" rel="stylesheet" type="text/css"
          href="./js/easyui/themes/default/easyui.css">
    <!-- 图标css -->
    <link rel="stylesheet" type="text/css"
          href="./js/easyui/themes/icon.css">

	<link  rel="stylesheet" type="text/css"
		   href="css/style2.css">


<style>
* {
	margin: 0;
	padding: 0;
}

tr {
	height: 45px;
}

td label {
	size: 50px;
}
</style>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		$(function(){
			 $('#save').click(function(){
			 	$('#form_edit').submit();
            });
            
            $('#form_edit').form({
	        onSubmit: function(){
				// return false to prevent submit;
	        },
	        success:function(data){
				top.$.messager.show({
					title:"提示",
					msg:"保存成功",
					timeout:3000
				})
				location.href="page_student_studentList.action";
	        }
		});
		});
	</script>

</head>

<body style="width: 100%;height:100%">
	<div style="width: 100%;height:100%;background-color: lightblue">
		<h3
			style="width: 100%;height: 5%;background-color: #3498DB;text-align: center">编辑学生信息</h3>
		<form id="form_edit" method="post" action="student_save">
			<table style="width: 504px;height: 90%;margin:auto" cellspacing=”10″
				cellpadding=”2″ border="1">
				<input name="id" type="hidden" value=<s:property value="%{model.id}"/>>
				<input name="password" type="hidden" value=<s:property value="%{model.password}"/>>			
				<tr style="text-align: center">
					<td><label>姓名:</label><input name="name" value=<s:property value="%{model.name}"/>></td>
					<td><label>性别:</label><input name="sex" value=<s:property value="%{model.sex}"/>></td>
				</tr>
				<tr style="text-align: center">
					<td><label>班级:<input name="bj" value=<s:property value="%{model.claname.getCname()}"/>></td><!--  -->
					<td><label>专业:<input name="zy" value=<s:property value="%{model.claname.getSpecialty().getSname()}"/>></td><!--  -->
				</tr>
				<tr style="text-align: center">
					<td><label>政治面貌:<input name="politicalStatus" value=<s:property value="%{model.politicalStatus}"/>></td>
					<td><label>职务:<input name="job" value=<s:property value="%{model.job}"/>></td>
				</tr>
				<tr style="text-align: center">
					<td><label>电话:<input name="phone" value=<s:property value="%{model.phone}"/>></td>
					<td><label>邮箱:<input name="email" value=<s:property value="%{model.email}"/>></td>
				</tr>
				<tr>
					<td colspan="2"><label>学院:<input name="xy" value=<s:property value="%{model.claname.getSpecialty().getDepartment().getDname()}"/>></td><!--  -->

				</tr>
				<tr align="center">
					<td colspan="2">
						<!-- <input type="button" name="ok" value="编辑信息"
							class="bj"> -->
							<a id="save" class="easyui-linkbutton" plain="true" icon="icon-save">保存</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>

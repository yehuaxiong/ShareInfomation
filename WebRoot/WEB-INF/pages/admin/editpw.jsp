<%@ page language="java" import="java.util.*,org.apache.struts2.ServletActionContext,com.ssss.shareInfo.model.Admin" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    
    <!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js"></script>
	
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
    <style type="text/css">
            td{
            padding-right: 60px;
            padding-bottom: 20px;
            text-align: left;
        }
    
    
    </style>
    <script type="text/javascript">
    	$(function() { 
    		<%-- <%!
    			String function(){
    				Admin admin= (Admin)ServletActionContext.getRequest().getSession().getAttribute("existAdmin");
    				return admin.getPassword();
    			}
    		%>    --%>  
    			
    				   		
    	
    		var p=${sessionScope.password};
    		
    		var id=${sessionScope.id};
    		
    		
    		$("#bt").click(function(){
    			var $pwd = $('#password');
    			var $pwd1 = $('#newpwd1');
            	var $pwd2 = $('#newpwd2');
            	
            	
            	 if ($pwd.val() == '') {
            		$.messager.alert('系统提示', '请输入原密码！', 'warning');
                	return false;
            	 }
            	 
            	if($pwd.val()!=p){
            		$.messager.alert('系统提示', '原密码不正确，请重新输入！', 'warning');
                	return false;
            	 } 
            	 
            	 if ($pwd1.val() == '') {
            		$.messager.alert('系统提示', '请输入新密码！', 'warning');
                	return false;
            	 }
            	 
            	 if ($pwd2.val() == '') {
            		$.messager.alert('系统提示', '请确认密码！', 'warning');
                	return false;
            	 }
            	 
            	 if ($pwd1.val() != $pwd2.val()) {
            		$.messager.alert('系统提示', '两次密码不一至！请重新输入', 'warning');
                	return false;
            	 }
            	 
            	 $.post('${pageContext.request.contextPath}/edit_pwd.action?' , {password:$pwd2.val(), id:id}, function(msg) {
            			
            			$.messager.alert('系统提示', '密码修改成功！', 'info',function(){   
   				 			location.href="page_admin_editpw.action";
						});
            			           			
            			$('.panel-tool-close').hide(); /* 隐藏右上角的关闭图标 */
            	}); 
    		});
    	
    	});
    	
    </script>
    
    
</head>
<body style="background-image: url('./images/tianjia.jpg');background-repeat: no-repeat;">
<div align="center" style="color:blue;"><p style="font-size: 25px">修改密码</p></div>
<div align="center">
    <table>
    <tr>
    <td> 原密码:<input id="password" name="password" type="text"></td>
    </tr>
     <tr>
    <td> 新密码:<input id="newpwd1" name="newpwd1" type="password"></td>
    </tr>
    <tr>
    <td> 新密码:<input id="newpwd2" name="newpwd2" type="password"></td>
    </tr>
    <tr>
    <td>
    <button id="bt" type="button" style="margin:0 auto;">确定</button>
    </td>
    </tr>
    </table>
</div>
</body>
</html>
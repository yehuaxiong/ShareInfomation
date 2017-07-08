<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <!DOCTYPE html> -->
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style_grey.css" />

<script type="text/javascript">
	$(function(){
		$("#loginform").attr("action", "admin_login");
	
		$("#loginBtn").click(function(){
			$("#loginform").get(0).submit();
		});
		
		$("#admin").attr("checked",true);
		
		$("#admin").click(function(){
			$("#loginform").attr("action", "admin_login");
		});
		
		$("#teacher").click(function(){
			$("#loginform").attr("action", "teacher_login");
		});
		
		$("#student").click(function(){
			$("#loginform").attr("action", "student_login");
		});
	});
</script>

<style>
input[type=text] {
	width: 80%;
	height: 25px;
	font-size: 12pt;
	font-weight: bold;
	margin-left: 45px;
	padding: 3px;
	border-width: 0;
}

input[type=password] {
	width: 80%;
	height: 25px;
	font-size: 12pt;
	font-weight: bold;
	margin-left: 45px;
	padding: 3px;
	border-width: 0;
}

#loginform\:codeInput {
	margin-left: 1px;
	margin-top: 1px;
}

#loginform\:vCode {
	margin: 0px 0 0 60px;
	height: 34px;
}
</style>

</head>



<body>

	<div
		style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: -280px;">
		<%-- <img src="${pageContext.request.contextPath }/images/logo.png" style="border-width: 0; margin-left: 0;" /> --%>
		<span style="float: right; margin-top: 35px; color: #488ED5;">此系统为方便学院师生分享个人信息、状态、日记和图片，且具有一定社会化网络系统的特性</span>
	</div>
	
	<div class="main-inner" id="mainCnt"
		style="width: 900px; height: 440px; overflow: hidden; position: absolute; left: 50%; top: 50%; margin-left: -450px; margin-top: -220px; background-image: url('${pageContext.request.contextPath }/images/login.jpg')">
		<div id="loginBlock" class="login"
			style="margin-top: 80px; height: 255px;">
			
			<div class="loginFunc">
				<div id="lbNormal" class="loginFuncMobile">用户登录</div>
			</div>
			
			<div class="loginForm">
				<!-- form表单 -->
				<s:form id="loginform" name="loginform" method="post" cssClass="niceform" action="admin_login" namespace="/" theme="simple">
					<div style="padding-left:80px;">
						<s:fielderror></s:fielderror>
						<s:actionerror/>
					</div>
					<div id="idInputLine" class="loginFormIpt showPlaceholder"
						style="margin-top: 25px;">
						<s:textfield id="loginform:idInput" name="id" cssClass="loginFormTdIpt" maxlength="50" tabindex="1" title="请输入帐号" ></s:textfield>	
						<label for="idInput" class="placeholder" id="idPlaceholder">帐号：</label>
					</div>
					<!-- <div class="forgetPwdLine"></div> -->
					<div id="pwdInputLine" class="loginFormIpt showPlaceholder">
						<s:password id="loginform:pwdInput" cssClass="loginFormTdIpt" name="password" tabindex="2" title="请输入密码"></s:password>		
						<label for="pwdInput" class="placeholder" id="pwdPlaceholder">密码：</label>
					</div>
					<div style="padding:10px 0 0 80px;">
						<label><input id="admin" name="user" type="radio" value=""/>管理员</label>
						<label style="margin-left:20px;"><input id="teacher" name="user" type="radio" value=""/>老师</label>
						<label style="margin-left:20px;"><input id="student" name="user" type="radio" value=""/>学生</label>
					</div>
					<div class="loginFormIpt loginFormIptWiotTh"
						style="margin-top:50px;">
						<div id="codeInputLine" class="loginFormIpt showPlaceholder"
							style="margin-left:0px;margin-top:-40px;width:50px;">
							<input id="loginform:codeInput" class="loginFormTdIpt" type="text"
								name="checkcode" title="请输入验证码" />
							<img id="loginform:vCode" src="${pageContext.request.contextPath }/validatecode.jsp"
								onclick="javascript:document.getElementById('loginform:vCode').src='${pageContext.request.contextPath }/validatecode.jsp?'+Math.random();" />
						</div>
						<a href="javascript:void(0)" id="loginform:j_id19" name="loginform:j_id19">
						<span
							id="loginBtn" class="btn btn-login"
							style="margin-top:-36px;">登录</span>
						</a>
					</div>
				</s:form>
			</div>
			
		</div>
	</div>
	
	<div
		style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: 220px;">
		<span style="float: right; color: #488ED5;">师生信息分享系统 </span>
	</div>
	
</body>
</html>
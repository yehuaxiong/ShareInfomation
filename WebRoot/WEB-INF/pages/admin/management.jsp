<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理</title>

    <!-- 导入jQuery核心类库 -->
    <script type="text/javascript"
            src="js/jquery-1.8.0.min.js"></script>
    <!-- 导入easyui核心类库 -->
    <script type="text/javascript"
            src="js/easyui/jquery.easyui.min.js"></script>
    <!-- 国际化 -->
    <script type="text/javascript">
        $(function(){
            $(".t1").click(function(){
                $(".iframe_r").attr("src","page_student_addStudent.action");
            });
            $(".t2").click(function(){
                $(".iframe_r").attr("src","page_student_batchAddStudent.action");
            });
            $(".t3").click(function(){
                $(".iframe_r").attr("src","query_information.html");
            });
            $(".t4").click(function(){
                $(".iframe_r").attr("src","page_teacher_addTeacher.action");
            });
            $(".t5").click(function(){
                $(".iframe_r").attr("src","Delete_Teacher.html");
            });
            $(".t6").click(function(){
                $(".iframe_r").attr("src","adminShowNotice.action");
            });
            $(".t7").click(function(){
                $(".iframe_r").attr("src","page_notice_writeNotice.action");
            });
            $(".t8").click(function(){
                $(".iframe_r").attr("src","page_student_queryInformation.action");
            });
            $(".t9").click(function(){
                $(".iframe_r").attr("src","page_admin_editpw.action");
            });
            $(".t11").click(function(){
                $(".iframe_r").attr("src","page_teacher_queryInformation2.action");
            });
            
            $(".quit").click(function(){
				$.messager
					.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {
					if (isConfirm) {
						location.href = '${pageContext.request.contextPath }/invalidate.jsp';
					}
				});
			});

        })
    </script>
    <script
            src="js/easyui/locale/easyui-lang-zh_CN.js"
            type="text/javascript"></script>
    <!-- easyui核心css -->
    <link id="easyuiTheme" rel="stylesheet" type="text/css"
          href="js/easyui/themes/default/easyui.css">
    <link  rel="stylesheet" type="text/css"
          href="css/style2.css">

</head>
<body>
    <div class="body">
        <div class="top" style="color:blue;">师生信息交流系统后台管理</div>
        <div class="center">
            <div class="cleft" style="background-image: url('./images/glyl.jpg');">
            <h3 style="color:graytext;margin-left: 5px">帐号管理</h3>
	            <ul class="ul1">
					<li class="t1"><a href="#">添加学生</a></li>
                    <li class="t2"><a href="#">批量添加学生</a></li>
                    <li class="t4"><a href="#">添加教师</a></li>
                </ul>
                <h3 style="color:graytext;margin-left: 5px">信息管理</h3> 
                <ul class="ul1">
                 
                    <li class="t6"><a href="#">公告管理</a></li>
                    <li class="t7"><a href="#">发布公告</a></li>
                    <li class="t8"><a href="#">查询修改学生</a></li>
                    <li class="t11"><a href="#">查询修改教师</a></li>
                </ul>
                 <h3 style="color:graytext;margin-left: 5px">个人管理</h3> 
                <ul class="ul1">
                  
                    <li class="t9"><a href="#">修改密码</a></li>
                </ul>
                <ul class="ul1">
                    <li class="t10"><a href="#" class="quit">退出</a></li>
                </ul>
            </div>
            <div class="cright" >
                <iframe class="iframe_r" style="width: 100%;height: 650px;" frameborder=0 scrolling="no" src="page_student_addStudent.action">

                </iframe>
            </div>
        </div>
    </div>
</body>
</html>

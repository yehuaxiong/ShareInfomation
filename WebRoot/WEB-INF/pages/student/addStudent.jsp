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
            
            
            
            
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
          td{
            padding-right: 60px;
            padding-bottom: 40px;
            text-align: left;
        }
    </style>
    <script type="text/javascript">
    
    	function change1(){
    		$('#specialty').empty();
    		$('#claname').empty();
    		//获取专业的Option
          	$.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/specialty_option.action?dname="+$("#department option:selected").val(),
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var sname = obj[i].sname; 
                               var opt = '<option>'+sname+'</option>';
                               $('#specialty').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取专业信息出错-");
                   }
            });
            //获取班级的Option
           /*  $.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/claname_option.action?sname="+$("#specialty option:selected").val(),
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var cname = obj[i].cname; 
                               var opt = '<option>'+cname+'</option>';
                               $('#claname').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取班级信息出错-");
                   }
            }); */ 
            setTimeout(function(){change2()},300);         
    	}
    	
    	function change2(){
    		$('#claname').empty();
    		
    		//获取班级的Option
            $.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/claname_option.action?sname="+$("#specialty option:selected").val(),
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var cname = obj[i].cname; 
                               var opt = '<option>'+cname+'</option>';
                               $('#claname').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取班级信息出错-");
                   }
            });
    	}
    	
        $(function(){
                      
            //获取学院的Option
            $.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/department_option.action",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var dname = obj[i].dname; 
                               var opt = '<option>'+dname+'</option>';
                               $('#department').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取学院信息出错-");
                   }
            });
            
            //获取专业的Option
             $.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/specialty_option.action?dname=数学与计算机学院",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var sname = obj[i].sname; 
                               var opt = '<option>'+sname+'</option>';
                               $('#specialty').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取专业信息出错-");
                   }
            });
            
            //获取班级的Option
            setTimeout(function(){$.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/claname_option.action?sname="+$("#specialty option:selected").val(),
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var cname = obj[i].cname; 
                               var opt = '<option>'+cname+'</option>';
                               $('#claname').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取班级信息出错-");
                   }
            })},300);
            
            
             //点击添加按钮提交表单
            $('#add').click(function(){
                $('#form').submit();
            });
            
            //监听form是否成功提交，并进行相应的逻辑操作
           $('#form').form({
	        onSubmit: function(){
				// return false to prevent submit;
	        },
	        success:function(){
				top.$.messager.show({
					title:"提示",
					msg:"保存成功",
					timeout:3000
				})
				location.href="page_student_addStudent.action";
	        }
		});
            
        });
    </script>
</head>
<body style="width: 100%;height: 1000px;background-image: url('./images/tianjia.jpg');background-repeat: no-repeat;" >
<div  align="center" style="color:blue;padding-top: 10px">
<p style="font-size: 25px">添加学生信息</p>
</div>
<div style="width: 100%;height: 100%" align="center">
    <form id="form" method="post" action="student_add">
    <table>
        <tr>
            <td>
                    <label for="name">姓名：</label><input type="text" name="name" id="name" maxlength="10">
            </td>
            <td>
                    专业：<select name="specialty" id="specialty" onChange="change2()">
                   
                </select>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                    <label for="xuehao"> 学号：</label><input type="text" name="id" id="xuehao" maxlength="10" disabled="disabled">
            </td>
            <td>
                    班级：<select name="claString" id="claname">
                    
                </select>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                    <label for="pass">密码：</label><input type="text" name="password" id="pass" value="123456" readonly="readonly" size="6" maxlength="6">
            <td>
                	职务：
                <input type="text" name="job" id="pass" value="普通" readonly="readonly" size="6" maxlength="6">
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                    学院：<select name="department" id="department"  onChange="change1()">
                                 
                </select>
            </td>
            <td>
                    政治面貌：<input type="text" name="politicalStatus" id="pass" value="群众" readonly="readonly" size="6" maxlength="6">
                </select>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td>
                <input id="add" type="button" name="button" value="添加"/>&nbsp;&nbsp;&nbsp;
                <input type="button" name="button" value="取消"/></td>
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
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
    	
    	//获取学院的Option
		function FunDept(){			
            $.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/department_option.action",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       
                       //var o='<option>'+"所有学院"+'</option>';////////
                       //$('#department').append(o);////////
                       
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
		}
		
		//获取专业的Option
		function FunSpec(){		
             $.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/specialty_option.action?dname=数学与计算机学院",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       
                       //var o='<option>'+"所有专业"+'</option>';//////////
                       //$('#specialty').append(o);/////////
                       
                       
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
		}
		
		
		//获取班级的Option
		function FunCla(){		
            setTimeout(function(){$.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/claname_option.action?sname="+$("#specialty option:selected").val(),
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       
                       
                       //var o='<option>'+"所有班级"+'</option>';//////////
                       //$('#claname').append(o);/////////
                       
                       
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
		}	
		
		
		
		//选择学院时产生
		function change1(){
			$('#specialty').empty();
    		$('#claname').empty();
    		
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
    		
    		setTimeout(function(){change2()},300);
		}
		
		//选择专业时候产生
		function change2(){
			$('#claname').empty();
			
			FunCla();
		}
    	
    	
    	
    
    	$(function(){
    	
    		FunDept();
			
			FunSpec();
			
			FunCla();
    	
    	
    	
    		$('#next').click(function(){
                $('#form').submit();
            });
    	});
    	
    	  /* //监听form是否成功提交，并进行相应的逻辑操作
           $('#form').form({
	        onSubmit: function(){
				// return false to prevent submit;
	        },
	        success:function(){
	        	alert("成功了");
				location.href="${pageContext.request.contextPath}/page_student_batchAddGrid.action";
	        }
			}); */
    </script>
    
</head>


<body style="width: 100%;height: 1000px;background-image: url('./images/tianjia.jpg');background-repeat: no-repeat;">
<div style="color:blue;padding-top: 10px" align="center" ><p style="font-size: 25px">批量添加学生信息</p></div>
<div style=";width: 100%;height: 100%;"align="center">
	<form id="form" method="post" action="student_batch_add.action">
    <table>
        <tr>
            <td>
                    <label for="name">人数：</label><input type="text" name="number" id="name" maxlength="10">
            </td>
            <td>
                    班级：<select name="claString" id="claname">
                    <!-- <option>14软件工程一班</option>
                    <option>14软件工程二班</option>
                    <option>数学一班</option>
                    <option>数学二班</option> -->
                </select>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                    <label for="pass">密码：</label><input type="text" readOnly="readonly" value="123456" name="password" id="pass" size="6" maxlength="6">
            </td>
            <td>
                    <label for="zhicheng">职务：</label><input type="text" name="job" id="zhicheng" value="普通" readOnly="readonly">
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                    学院：<select name="department" id="department" onChange="change1()">
                    <!-- <option>外国语学院</option>
                    <option>理学院</option>
                    <option>数计学院</option>
                    <option>体育学院</option> -->
                </select>
            <td>
                <label for="mianmao">政治面貌：</label><input type="text" name="politicalStatu" id="mianmao" value="群众" readOnly="readonly">
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                    专业：<select name="specialty" id="specialty" onChange="change2()">
                    <!-- <option>软件工程</option>
                    <option>物联网工程</option>
                    <option>计算机科学与技术</option>
                    <option>数学专业</option> -->
                </select>
            </td>
            <td>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td>
                <input id="next" type="button" name="button" value="下一步"/>&nbsp;&nbsp;&nbsp;
                <input type="button" name="button" value="取消"/></td>
                <%-- <a href="${pageContext.request.contextPath}/page_student_batchAddGrid.action">链接</a> --%>
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
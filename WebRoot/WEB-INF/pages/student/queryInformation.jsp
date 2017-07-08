<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		   
	<script type="text/javascript">
	
		//获取学院的Option
		function FunDept(){			
            $.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/department_option.action",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       
                       var o='<option>'+"所有学院"+'</option>';////////
                       $('#department').append(o);////////
                       
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
                   url: "${pageContext.request.contextPath}/specialty_option.action?dname=null",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       
                       var o='<option>'+"所有专业"+'</option>';//////////
                       $('#specialty').append(o);/////////
                       
                       
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
                   url: "${pageContext.request.contextPath}/claname_option.action?",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       
                       
                       var o='<option>'+"所有班级"+'</option>';//////////
                       $('#claname').append(o);/////////
                       
                       
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
		
		/* //选择学院时产生
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
		} */
		
		/* //选择专业时候产生
		function change2(){
			$('#claname').empty();
			
			FunCla();
		} */
	
	
	
		$(function(){
		
			FunDept();
			
			/* FunSpec();
			
			FunCla(); */
		
		
		
			$('#query').click(function() {		
			var elWin = $("#studentlist").get(0).contentWindow;
			elWin.$('#grid').datagrid( { // 表格重新加载数据
				pagination : true,
				url : "${pageContext.request.contextPath}/student_list.action",
				method : "post",
				queryParams : {
					department:$("#department option:selected").val(),
					specialty:$("#specialty option:selected").val(),
					claname:$("#claname option:selected").val(),
					job:$("#job option:selected").val()
				}
			});
		});
		});
		
	</script>
		
</head>
<body class="easyui-layout"><!--  style="visibility:hidden;" -->
	
	<div data-options="region:'north',border:false" style="width: 100%;height: 40px">
		<form id="form" method="post">
		<ul style="width: 100%;list-style: none;margin-top: 10px;" class="ul2">
			<li><select id="department" name="department"><!-- <option>所有学院</option><option>外国语学院</option><option>理学院</option><option>数学与计算机学院</option><option>体育学院</option> --></select></li>
			<li><select id="specialty" name="specialty" ><option>所有专业</option><option>软件工程</option><option>网络工程</option><option>应用数学</option><option>商务英语</option><option>英语教育</option></select></li>
			
			<li><select id="claname" name="claname"><option>所有班级</option><option>14软件工程一班</option><option>14软件工程二班</option><option>15软件工程一班</option><option>15软件工程二班</option><option>14网络工程一班</option><option>14网络工程二班</option>
			<option>15网络工程一班</option><option>15网络工程二班</option><option>14应用数学一班</option><option>14商务英语一班</option><option>14商务英语二班</option><option>14英语教育一班</option></select>
			
			</li>
			
			<li><select id="job" name="job"><option>所有职务</option><option>班长</option><option>学习委员</option><option>团支书</option><option>体育委员</option><option>文娱委员</option><option>生活委员</option></select></li>					
			<li><a id="query" href="#" class="easyui-linkbutton" plain="true" icon="icon-search">查询</a></li>
		</ul>
		</form>
	</div>
	
	<div data-options="region:'center'" style="padding:5px;background:#eee;">
    	<iframe id="studentlist" src="${pageContext.request.contextPath }/page_student_studentList.action"  style="width:100%;height:100%;border:0;"></iframe>
	</div>
</body>
</html>
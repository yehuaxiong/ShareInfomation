<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		
		//获取教研室
		function FunOfc(){
			$.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/office_option.action?dname=数学与计算机学院",
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var rname = obj[i].rname; 
                               var opt = '<option>'+rname+'</option>';
                               $('#office').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取教研室信息出错-");
                   }
            });
		}
		
		
		function FunOfc2(){
			$.ajax({
                   type: "post",
                   url: "${pageContext.request.contextPath}/office_option.action?dname="+$("#department option:selected").val(),
                   dataType: "text",
                   success: function (data) {
                       var obj = eval('(' + data + ')');
                       for (var i=0;i<obj.length;i++){                               
                               var rname = obj[i].rname; 
                               var opt = '<option>'+rname+'</option>';
                               $('#office').append(opt);
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert("-取教研室信息出错-");
                   }
            });
		}
		
		
		
		//选择学院时产生
		function change1(){
			$('#office').empty();
			
			setTimeout(FunOfc2(),300);
		}
	
	
	
		$(function(){
		
			FunDept();
			
			setTimeout(FunOfc(),300);
			
		
			$('#query').click(function() {		
			var elWin = $("#teacherlist").get(0).contentWindow;
			elWin.$('#grid').datagrid( { // 表格重新加载数据
				pagination : true,
				url : "${pageContext.request.contextPath}/teacher_list.action",
				method : "post",
				queryParams : {
					department:$("#department option:selected").val(),
					office:$("#office option:selected").val(),
					title:$("#title option:selected").val()
				}
			});
		});
		});
	</script>	   

</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="width: 100%;height: 40px">
		<ul style="width: 100%;list-style: none;margin-top: 10px;" class="ul2">
			<li><select id="department" onChange="change1()"></select></li>
			<li><select id="office"></select></li>
			<li><select id="title"><option>所有职称</option><option>教授</option><option>副教授</option><option>讲师</option></select></li>
			<li><a id="query" href="#" class="easyui-linkbutton" plain="true" icon="icon-search">查询</a></li>
		</ul>
	</div>
	<div data-options="region:'center'" style="padding:5px;background:#eee;">
    	<iframe id="teacherlist" src="${pageContext.request.contextPath }/page_teacher_teacherList.action" scrolling="no" style="width:100%;height:100%;border:0;"></iframe>
	</div>
</body>
</html>
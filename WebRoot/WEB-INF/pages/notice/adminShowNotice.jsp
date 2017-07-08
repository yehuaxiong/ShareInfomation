<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowNotice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="./js/jquery-1.8.0.min.js""></script>
	<!-- 导入easyui核心类库 -->
	<script type="text/javascript" src="./js/easyui/jquery.easyui.min.js"></script>
	<!-- 国际化 -->
	<script src="./js/easyui/locale/easyui-lang-zh_CN.js"
		type="text/javascript"></script>
	<!-- easyui核心css -->
	<link id="easyuiTheme" rel="stylesheet" type="text/css"
		href="./js/easyui/themes/default/easyui.css">
	<!-- 图标css -->
	<link rel="stylesheet" type="text/css"
		href="./js/easyui/themes/icon.css">
	<script type="text/javascript">
		var kk=0;
		function init(){
			<c:forEach items="${notices}" var="arr" begin="0" end="10000" step="1"
				varStatus="i">
				 $('#dg').datagrid('insertRow', {
					row : {
						id :'${arr.id}',
						sname :'${arr.sname}',
						title :'${arr.title}',
						content:'${arr.content}',
						time:'${arr.time}',
						xq: '<input type="button" value="查看详情">',
						btn: '<input type="button" value="删除">'
					}
				  });
			</c:forEach> 
		}
		function initPage(){
			 var p = $("#dg").datagrid('getPager'); //tt为表格id
		     $(p).pagination({ 
			    pageList: [20],//可以设置每页记录条数的列表 
			    beforePageText: '第',//页数文本框前显示的汉字 
		        afterPageText: '页    共{pages} 页', 
		        total:${total}-kk,
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		    });
		}
		$(function(){
			//初始化表格
			 init();
			 //设置分页控件 
		    initPage();
		    
		    var pg = $("#dg").datagrid("getPager");  
			if(pg)  
			{  
			   $(pg).pagination({  
			       onSelectPage:function(pageNumber,pageSize){  
			          // 清除数据  
		          	  var item = $('#dg').datagrid('getRows');    
		              for (var i = item.length - 1; i >= 0; i--) {    
		                  var index = $('#dg').datagrid('getRowIndex', item[i]);    
		                  $('#dg').datagrid('deleteRow', index);    
		              } 
			        //  alert(pageNumber);
			          if(pageNumber==1){
			          	init();initPage();
			          }else{
				              $.ajax({
				                url:"adminShowNotice.action",
				                type:"post",
				                data:{pageNumber:pageNumber},
				                success:function(data){
				                	var dd = eval(data); 
									//alert(dd[1].id);
									for(var i=0;i<dd.length;i++){
										$('#dg').datagrid('insertRow', {
										row : {
												id :dd[i].id,
												sname :dd[i].sname,
												title :dd[i].title,
												content:dd[i].content,
												time:dd[i].time,
												xq: '<input type="button" value="查看详情">',
												btn: '<input type="button" value="删除">'
											 }
										  });		
									}
				              		initPage();
				              		 
				                },
				                error:function(e){
				                    alert("错误！！");
			                	}
			          	     });  
			          }
			        }  
			   });  
			} 
			
		});
		function onClickCell(index, field,val) {
		  	 //var row = $('#dg').datagrid('getData').rows[index];	//selectRow
		 	//var row = $('#dg').datagrid('selectRow',{index:0});

			$('#dg').datagrid('selectRow',index);
			var row=$('#dg').datagrid('getSelected');
			//查看公告详情
			if(field=="xq")$.messager.alert('公告内容', "作者: "+row.sname+"<br>"+"标题: "+row.title+"<br>"+"内容: "+row.content+"<br>"+"时间: "+row.time, '');
			 if(field=="btn"){
					$.ajax({
		                url:"adminDeleteNotice.action",
		                type:"post",
		                data:{rid:row.id},
		                success:function(data){
		                	alert("删除成功");
		                	kk++;
		                	$('#dg').datagrid('deleteRow',index);
		                	var p = $("#dg").datagrid('getPager'); //tt为表格id
						     $(p).pagination({ 
							    pageList: [20],//可以设置每页记录条数的列表 
							    beforePageText: '第',//页数文本框前显示的汉字 
						        afterPageText: '页    共{pages} 页', 
						        total:${total}-kk,
						        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
						    });
		                },
		                error:function(e){
		                    alert("错误！！");
	                	}
	          	     });   
			   }
		}
	</script>
  </head>
  
  <body style="width: 100%;height: 100%;margin: 0;padding: 0">
  <table  id="dg"  class="easyui-datagrid"
  data-options="iconCls: 'icon-edit',
  				singleSelect: true,  
				rownumbers : true,    
				fitColumns:'true',   
				pageList: [20],
			pagination : true,    
				onClickCell: onClickCell
			"
   title="显示公告">  
    <thead>  
        <tr>  
            <thead>
				<tr>
					<th data-options="field:'id',width:100,hidden:true">作者</th>
					<th data-options="field:'sname',width:100">作者</th>
					<th data-options="field:'title',width:100,editor:'text'">标题</th>
					<th data-options="field:'content',width:300,editor:'text'">内容</th>
					<th data-options="field:'time',width:120,editor:'text'">时间</th>
					<th data-options="field:'xq',width:100,editor:'button'">&nbsp&nbsp查看详情</th>
					<th data-options="field:'btn',width:150,editor:'button'">&nbsp&nbsp删除</th>
				</tr>
			</thead> 
        </tr>  
    </thead>  
</table>  
	<!-- <table id="dg" class="easyui-datagrid" 
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				method:'get',
				rownumbers : true,
				onClickCell: onClickCell,
				toolbar : toolbar,
				fitColumns:'true'
			"
			title="批量添加学生姓名">
			<thead>
				<tr>
					<th data-options="field:'sname',width:100">作者</th>
					<th data-options="field:'title',width:100,editor:'text'">标题</th>
					<th data-options="field:'content',width:100,editor:'text'">内容</th>
					<th data-options="field:'time',width:100,editor:'text'">时间</th>
				</tr>
			</thead>
		</table> -->
	<br>
	<%-- <br>
		<c:forEach items="${receivenotices}" var="arr" begin="0" end="100" step="1"
				varStatus="i">
				<ul >
					<li id="q">作者:&nbsp;&nbsp;${arr.notice.sname}  </li>
				   	<li id="q">标题:&nbsp;&nbsp;${arr.notice.title}  </li>
					<li id="q">内容:&nbsp;&nbsp;${arr.notice.content}</li>
					<li id="q">时间:&nbsp;&nbsp;${arr.notice.time}</li>
				</ul> 
				<br />
			</c:forEach>
		<br> --%>
		<%-- "${sessionScope.id}"; --%>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
	
	<script type="text/javascript">
	
	
	// 工具栏
	var toolbar = [ {
		id : 'button-ok',
		text : '同意',
		/*iconCls : 'icon-add',*/
		iconCls : 'icon-ok',
		handler : doAgree
	}, {
		id : 'button-ignore',
		text : '忽略',
		iconCls : 'icon-cancel',
		handler : doIgnore
	}];

	// 定义标题栏
	var columns = [ [ {
		field : 'id',
		title : '消息编号',
		hidden:true,
		width : 60,
		rowspan : 2,
		align : 'center'
	},{
		field : 'sendId',
		title : '请求者ID',
		width : 60,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'sendName',
		title : '请求人',
		width : 60,
		rowspan : 2,
		align : 'center'
	},{
		field : 'content',
		title : '验证消息',
		width : 150,
		rowspan : 2,
		align : 'center'
	} ,{
		field : 'time',
		title : '时间',
		width : 60,
		rowspan : 2,
		align : 'center'
	}] ];
	
	$(function(){
		// 初始化 datagrid
		// 创建grid
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fitColumns:'true',
			border : false,
			rownumbers : true,/* 设置为true将显示行数。 */
			striped : true,/* 设置为true将交替显示行背景。 */
			pageList: [10,50,100],
			pagination : true,/* 设置true将在数据表格底部显示分页工具栏。 */
			/* url : "users.json", */ 
			url : "${pageContext.request.contextPath}/addFriendNotice.action",
			idField : 'id', /* 表明该列是一个唯一列。 */
			columns : columns,
			singleSelect: true,
			toolbar : toolbar,/* 设置工具栏 */
			onDblClickRow : doDblClickRow
		});
		
		
	});
	
	// 双击
	function doDblClickRow(rowIndex, rowData) {
		alert("双击");
	}


	function doAgree() {
		alert("同意？");
		var item = $('#grid').datagrid('getSelected');
		console.info(item.sendId);
		
		/* location.href = "${pageContext.request.contextPath}/agreeFriend.action?id_="+item.sendId+"&noticeId="+item.id; */ 
		
		$.post("${pageContext.request.contextPath}/agreeFriend.action", {id_:item.sendId,noticeId:item.id}, function(data){
			$('#grid').datagrid('reload');
			$('#grid').datagrid('uncheckAll'); // 取消所有元素选中效果
			
			top.$.messager.show({
					title:"提示",
					msg:"已同意",
					timeout:3000
				})
		});
	}

	function doIgnore() {
		alert("忽略？");

		var item = $('#grid').datagrid('getSelected');
		
		// 先删除 后 reload
		$.post("${pageContext.request.contextPath}/ignoreFriend.action", {noticeId:item.id}, function(data){
			$('#grid').datagrid('reload');
			$('#grid').datagrid('uncheckAll'); // 取消所有元素选中效果
			
			top.$.messager.show({
					title:"提示",
					msg:"已忽略",
					timeout:3000
				})
		});
		
	}
	
</script>
</head>
  
<body class="easyui-layout"><!-- style="visibility:hidden;" -->
    <div region="center" border="false" >
    	<table id="grid" style="height: 400px"></table>
	</div>
</body>
</html>

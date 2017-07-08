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
		id : 'button-add',
		text : '编辑',
		/*iconCls : 'icon-add',*/
		iconCls : 'icon-edit',
		handler : doEdit
	}, {
		id : 'button-delete',
		text : '删除',
		iconCls : 'icon-cancel',
		handler : doDelete
	}];
	//定义冻结列
	var frozenColumns = [ [ {
		field : 'select',
		checkbox : true,
		rowspan : 2
	},{
		field : 'id',
		title : '职工号',
		width : 80,
		/*checkbox : true,*/
		rowspan : 1,
		align : 'center'
	}, {
		field : 'name',
		title : '姓名',
		width : 80,
		rowspan : 2,
		align : 'center'
	} ] ];


	// 定义标题栏
	var columns = [ [ {
		field : 'sex',
		title : '性别',
		width : 60,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'phone',
		title : '电话',
		width : 120,
		rowspan : 2,
		align : 'center'
	},{
		field : 'email',
		title : '邮箱',
		width : 120,
		rowspan : 2,
		align : 'center'
	} ,{
		field : 'department',
		title : '二级学院',
		width : 80,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'office',
		title : '教研室',
		width : 80,
		rowspan : 2,
		align : 'center'
	},{
		field : 'title',
		title : '职称',
		width : 80,
		rowspan : 2,
		align : 'center'
	},{
		field : 'politicalStatus',
		title : '政治面貌',
		width : 80,
		rowspan : 2,
		align : 'center'
	},{
		field : 'password',
		title : '用户密码',
		width : 80,
		rowspan : 2,
		align : 'center'
	}] ];
	$(function(){
		// 初始化 datagrid
		// 创建grid
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,/* 设置为true将显示行数。 */
			striped : true,/* 设置为true将交替显示行背景。 */
			pageList: [10,20,30],
			pagination : true,/* 设置true将在数据表格底部显示分页工具栏。 */
			toolbar : toolbar,/* 设置工具栏 */
			/* url : "users.json", */
			url : "${pageContext.request.contextPath}/teacher_list.action",
			idField : 'id', /* 表明该列是一个唯一列。 */
			frozenColumns : frozenColumns,
			columns : columns,
			onClickRow : onClickRow,
			onDblClickRow : doDblClickRow
		});
		
		/* $("body").css({visibility:"visible"}); */
		
	});

	// 双击
	function doDblClickRow(rowIndex, rowData) {
		var items = $('#grid').datagrid('selectRow',rowIndex);
		doEdit();
	}
	// 单击
	function onClickRow(rowIndex){

	}

	function doEdit() {
		alert("编辑用户");
		var item = $('#grid').datagrid('getSelected');
		console.info(item.id);
		
		location.href = "${pageContext.request.contextPath}/teacher_edit.action?id="+item.id; 
	}

	function doDelete() {
		alert("删除用户");
		var ids = [];
		var items = $('#grid').datagrid('getSelections');
		for(var i=0; i<items.length; i++){
		    ids.push(items[i].id);	       
		}
			
		console.info(ids.join(","));
		
		// 先删除 后 reload
		$.post("${pageContext.request.contextPath}/teacher_delete.action", {"ids":ids.join(",")}, function(data){
			$('#grid').datagrid('reload');
			$('#grid').datagrid('uncheckAll'); // 取消所有元素选中效果
		});
		
	}
	
</script>
</head>
  
<body class="easyui-layout"><!-- style="visibility:hidden;" -->
    <div region="center" border="false">
    	<table id="grid"></table>
	</div>
</body>
</html>

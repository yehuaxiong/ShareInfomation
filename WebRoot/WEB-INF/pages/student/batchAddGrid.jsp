<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<!-- 导入jQuery核心类库 -->
<script type="text/javascript" src="./js/jquery-1.8.0.min.js"></script>
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
		

		$(function() {

			for (var i = 0; i < ${number}; i++) {
				$('#dg').datagrid('insertRow', {
					row : {
						id : $("#q" + i).text()
					}
				});
			}

		});
		

		$.extend($.fn.datagrid.methods, {
			editCell : function(jq, param) {
				return jq.each(function() {
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields', true)
							.concat($(this).datagrid('getColumnFields'));
					for (var i = 0; i < fields.length; i++) {
						var col = $(this)
								.datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field) {
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for (var i = 0; i < fields.length; i++) {
						var col = $(this)
								.datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});
		

		var editIndex = undefined;
		
		function endEditing() {
			if (editIndex == undefined) {
				return true
			}
			if ($('#dg').datagrid('validateRow', editIndex)) {
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}

		function onClickCell(index, field) {
			if (endEditing()) {
				$('#dg').datagrid('selectRow', index).datagrid('editCell', {
					index : index,
					field : field
				});
				editIndex = index;
			}
		}
		
		
		function doSave() {

			alert("保存用户");
			$('#dg').datagrid('acceptChanges');
			var rowsData = $('#dg').datagrid('getRows');
			var id_array = [];
			var name_array = [];

			$.each(rowsData, function(i) {
				id_array.push(rowsData[i].id);
				name_array.push(rowsData[i].name);
			});
			
			/* alert(id_array.join(",")); */
			
			$.post("${pageContext.request.contextPath}/student_batch_save.action"
				,{"ids":id_array.join(","),"name":name_array.join(","),"job":"普通","password":"${password}","claString":"${claString}","politicalStatu":"${politicalStatu}"}
				,function(data){
					top.$.messager.show({
						title:"提示",
						msg:"保存成功",
						timeout:3000
					});
					location.href="page_student_batchAddStudent.action";
				}
			);
			

		}
		
	</script>

</head>

<body class="easyui-layout">
	<div region="center" border="false">
		<ul style="display:none">
			<c:forEach items="${idArray}" var="arr" begin="0" end="100" step="1"
				varStatus="i">
				<li id="q${i.index}">${arr}</li>
				<br />
			</c:forEach>
		</ul>
		<table id="dg" class="easyui-datagrid"
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
					<th data-options="field:'id',width:100">学号</th>
					<th data-options="field:'name',width:100,editor:'text'">姓名</th>
				</tr>
			</thead>
		</table>
		<div style="text-align:center;"><input type="button" id="save" value="保存" onclick="doSave()" ></div>
	</div>
	
</body>
</html>

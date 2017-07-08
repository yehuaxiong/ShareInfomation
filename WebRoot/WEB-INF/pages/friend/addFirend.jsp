<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加好友</title>
    <style>
        .top{
            width: 100%;
            height: 20px;
            background: #ffa500;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .left{
            width: 30%;
            height: 1000px;
            background: #d8bfd8;
            float: left;
            margin: 0;
            padding: 0;
        }
        .right{
            width: 70%;
            height: 1000px;
            background: #E5E5E5;
            float: left;
            margin: 0;
            padding: 0;
        }
    </style>
    
    <link rel="stylesheet" type="text/css"
          href="css/all.css">
      
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
            
            
                 
    <script type="text/javascript"
           src="./js/ztree/jquery.ztree.all-3.5.js"></script>
    <link rel="stylesheet" type="text/css"
          href="./js/ztree/zTreeStyle.css">
          
    <script type="text/javascript">
		//<!--
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			/* view:{
				
				
			}, */
			edit: {
				enable: true
			}
		};

		$(function(){
			
//			$.fn.zTree.init($("#tree"), setting, zNodes);

			$.ajax({
				url : "${pageContext.request.contextPath}/tree_list.action", // ------------- 这里可以改为服务器端action
				type : 'POST', // ------ 提交方式
				dataType : 'text', //   ------ 数据类型
				success : function(data) { //   ------ 回调函数
					var remoteData = eval("(" + data + ")"); //  -------------  eval 可以将返回 json字符串 转换 js 对象
					$.fn.zTree.init($("#tree"), setting, remoteData); //  ----------- 初始化树

					var zTree = $.fn.zTree.getZTreeObj("tree");
					zTree.setting.check.chkboxType ={ "Y" : "s", "N" : "ps" };//被勾选时：不关联父 关联子,取消勾选时：关联父 关联子
					
					var nodes=zTree.getCheckedNodes(true);
					//alert(nodes[0].id);
					for(var i=0;i<nodes.length;i++){
              			 alert(nodes[i].id); //获取每个节点的id
          			   }
				},
				error : function(msg) {
					alert('菜单加载异常!');
				}
			});
			
			$('#send').click(function(){
				var zTree = $.fn.zTree.getZTreeObj("tree");
				var nodes=zTree.getCheckedNodes(true); //Checked
				var s=[];
				for(var i=0;i<nodes.length;i++){
					s.push(nodes[i].id);
				}
				$("#nodes").val(s.join(","));
				$('.myform2').action="addFirend.action"//?nodes="+JSON.stringify(nodes); 
				$('.myform2').submit();
			}); 
			
			
			$('.myform2').form({
	        	onSubmit: function(){
				// return false to prevent submit;
	        	},
	        	success:function(data){
					top.$.messager.show({
						title:"提示",
						msg:"发送成功",
						timeout:3000
					});
					location.href="page_friend_addFirend.action";
	        	}
			});
			
			
		});

	</script>    
</head>
<body>



    <div class="left">
       <form action="post" class="myform1">
         <!-- <nobr>  <input type="search" name="search" id="search" placeholder="搜索...">
           <input type="button" value="确定">
         </nobr> -->
          	<div class="top" >
         	<label>选择好友</label>
  			</div>
         <div style="width: 100%;height: 380px;overflow:auto;">
           <ul id="tree" class="ztree"  style="background: lightblue;" >
           </ul>
         </div>
       </form>
    </div>
     <div class="right">
         <form action="addFirend" method="post"  class="myform2">
             <br />
             <br />
             <label style="float: left">内容:</label>
             <textarea style="float: left;resize:none;" placeholder="请输入内容..."  maxlength="200" cols="48" rows="10" name="content"></textarea>
             <br />
                &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
             <div style="clear: left;">
                 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
              <input type="button" value="确定" id="send" />&nbsp;
              <input type="button" value="取消" />
               <input type="text" id="nodes" name="nodes" value="nodes" style="display: none"/>
             </div>

         </form>
     </div>

</body>
</html>
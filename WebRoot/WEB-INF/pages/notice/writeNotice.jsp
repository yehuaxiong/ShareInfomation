<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>发布公告</title>
    <style>
        .top{
            width: 100%;
            height: auto;
           
            margin: 0;
            padding: 0;
        }
        .left{
            width: 30%;
            height: auto;
          
            float: left;
            margin: 0;
            padding: 0;
        }
        .right{
            width: 70%;
            height: auto;
           
            float: left;
            margin: 0;
            padding: 0;
        }
    </style>
    
    <link rel="stylesheet" type="text/css"
          href="css/all.css">
      
    <script type="text/javascript"
            src="./js/jquery-1.8.0.min.js"></script>      
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

		/* var zNodes =[
			{ id:1, pId:0, name:"随意勾选 1", open:true},
			{ id:11, pId:1, name:"随意勾选 1-1", open:true},
			{ id:111, pId:11, name:"随意勾选 1-1-1"},
			{ id:112, pId:11, name:"随意勾选 1-1-2"},
			{ id:12, pId:1, name:"随意勾选 1-2", open:true},
			{ id:121, pId:12, name:"随意勾选 1-2-1"},
			{ id:122, pId:12, name:"随意勾选 1-2-2"},
			{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
			{ id:21, pId:2, name:"随意勾选 2-1"},
			{ id:22, pId:2, name:"随意勾选 2-2", open:true},
			{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
			{ id:222, pId:22, name:"随意勾选 2-2-2"},
			{ id:23, pId:2, name:"随意勾选 2-3"}
		]; */

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
				var s=",";
				for(var i=0;i<nodes.length;i++){
					s+=nodes[i].id;s+=",";
				}
				$("#nodes").val(s);
				$('.myform2').action="writenotice.action"//?nodes="+JSON.stringify(nodes); 
				$('.myform2').submit();
				
			}); 
			
			$('#myform2').form({
	        onSubmit: function(){
				// return false to prevent submit;
	        },
	        success:function(data){
				top.$.messager.show({
					title:"提示",
					msg:"发送成功",
					timeout:3000
				})
				location.href="page_notice_writeNotice.action";
	        }
		});
			
		});
		//-->
	</script>    
</head>
<body style="background-image: url('./images/gg.jpg');background-repeat: no-repeat;">
  <div class="top">
         <p style="color: blue;font-size: 25px">发布公告</p>
  </div>
    <div class="left">
       <form action="post" class="myform1">
         <nobr>  <input type="search" name="search" id="search" placeholder="搜索...">
           <input type="button" value="确定">
         </nobr>
         <div style="width: 100%;height: 380px;overflow:auto;">
           <ul id="tree" class="ztree"  style="background: lightblue;" >
           </ul>
         </div>
       </form>
    </div>
     <div class="right">
         <form action="writenotice" method="post"  class="myform2">
          <label>标题:</label>
             <input type="text" placeholder="请输入标题..." maxlength="20"  name="title"/>
             <br />
             <br />
             <label style="float: left">内容:</label>
             <textarea style="float: left;resize:none;" placeholder="请输入内容..."  maxlength="200" cols="48" rows="10" name="content"></textarea>
             <br />
                &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
             <div style="clear: left;">
              <input type="file" value="上传附件"  />
                 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
              <input type="button" value="确定" id="send" />&nbsp;
              <input type="button" value="取消" />
               <input type="text" id="nodes" name="nodes" value="nodes" style="display: none"/>
             </div>

         </form>
     </div>

</body>
</html>
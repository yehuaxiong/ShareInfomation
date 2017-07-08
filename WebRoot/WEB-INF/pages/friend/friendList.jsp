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
    
    <title>My JSP 'friendList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
    <!--自定义-->
    <link rel="stylesheet" type="text/css"
          href="./css/menu.css">
  </head>
  
  <script type="text/javascript">
  	var chat_id=0;
  	var name1="qwewq";
  	//好友列表点击事件
  	function zTreeOnClick(event, treeId, treeNode) {
  		 if(treeNode.id==chat_id) return ;
   		$(".right_top_name").html('<p style="color: #ff0000">与    '+treeNode.name+'   聊天中</p>');
     	chat_id=treeNode.id;
    	name1=treeNode.name;
    	var zTree = $.fn.zTree.getZTreeObj("tree2");  
    	//if()
       var nodes = zTree.getNodeByParam("id", chat_id, null);  
    	if (nodes==null) {  
    		zTree.addNodes(0, {id:treeNode.id, pId:0, name:treeNode.name});
    	}
    	 
    	$("#chat").html("");
    	
	};
	
	//配置树
	var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			   edit: {
				enable: true
			},
			callback: {
				onClick: zTreeOnClick
			}   
		 };
  	
  	//初始化好友列表
  	 function inittree(){
  	 	$.fn.zTree.init($("#tree"), setting, null ); 
  	 	var zTree = $.fn.zTree.getZTreeObj("tree");  
  	 	zTree.setting.check.chkboxType ={ "Y" : "s", "N" : "ps" };//被勾选时：不关联父 关联子,取消勾选时：关联父 关联子
	//	zTree.addNodes(0, {id:123, pId:0, name:"abc"}); //页面上添加节点 				
		/* 加载好友  */		
		 <c:forEach items="${friends}" var="arr" begin="0" end="100" step="1"
			varStatus="i">
			zTree.addNodes(0, {id:${arr.id.friendId}, pId:0, name:'${arr.friendPname}_${arr.friendName}'}); //页面上添加节点 	
		</c:forEach>
  	 }
  	 
  	 //初始化会话列表
  	 function inittree2(){
  	 	$.fn.zTree.init($("#tree2"), setting, null ); 
  	 	var zTree = $.fn.zTree.getZTreeObj("tree2");  
  	 	zTree.setting.check.chkboxType ={ "Y" : "s", "N" : "ps" };//被勾选时：不关联父 关联子,取消勾选时：关联父 关联子
	//	zTree.addNodes(0, {id:123, pId:0, name:"abc"}); //页面上添加节点 				
		/* 加载好友  */		
		 
  	 }
  	 
  	 //正在聊天
  	 function chating(){
		  setInterval(function(){	
  	 	    if(chat_id==0) return;
			$.ajax({
                url:"chat.action",
                type:"post",
                data:{friendId:chat_id},
                success:function(data){
                	var mes= eval(data);
                	for(var i=0;i<mes.length;i++){
  	 					$("#chat").append('<li>'+name1+'&nbsp&nbsp&nbsp'+mes[i].time+'</li>');
  	 					$("#chat").append("<li style=''>"+mes[i].content+'</li>');
  	 					//alert("sadas");
  	 					
                	}
                },
                error:function(e){
                    alert("错误！！");
                }
            });
		
		},2000);  
  	 }
  	 
  	 
  	 //正在会话
  	 function huihua(){
		  setInterval(function(){	
			 $.ajax({
                url:"huihua.action",
                type:"post",
                data:{},
                success:function(data){
                	
                	//alert(data);
                	//if(data==null) return ;
                	 
                	var mes= eval(data);
                	if(mes[0].id==0){
                		$('.btn_firend_huihua').val("未读人数(0)");
                		return ;
                	}
                	$('.btn_firend_huihua').val("未读人数("+mes.length+")");
                	var zTree = $.fn.zTree.getZTreeObj("tree2");  
    	//if()
		       		
                	 for(var i=0;i<mes.length;i++){
  	 					var nodes = zTree.getNodeByParam("id", mes[i].sendId, null);  
		    			if (nodes==null) {  
		    				zTree.addNodes(0, {id:mes[i].sendId, pId:0, name:mes[i].sendName});
		    			}	
                	 } 
                	//alert(mes.length);
                },
                error:function(e){
                    alert("错误！！");
                }
            }); 
		},3000);  
  	 }
  	 
  	 $(function(){
  	    inittree();
  	    inittree2();
  	 
  	 	chating();
  	 	huihua();  //会话列表更新
  	 
  	    //初始化会话与列表 点击切换事件
  	 	 $(".btn_firend_list").click(function(){
  	 		$(".firend_huihua").css("display","none");
  	 		$(".firend_list").css("display","block");
  	 	 });
  	 	 $(".btn_firend_huihua").click(function(){
  	 		$(".firend_huihua").css("display","block");
  	 		$(".firend_list").css("display","none");
  	 	 });
  	 	 
  	 	 //发送消息
  	 	 send();
  	 });
  	 
  	 //发送消息
  	 function send(){
  	 	$("#send").click(function(){
  	 		if($("#content").val()==null || $("#content").val()=="" || chat_id==0) return;
  	 		var content=$("#content").val();
  	 		$("#content").val("");
  	 		
  	 		//获取时间
  	 		var mydate = new Date();
			var t=mydate.toLocaleString();
  	 		$("#chat").append('<li>'+'${sessionScope.username}&nbsp&nbsp&nbsp'+t+'</li>');
  	 		$("#chat").append("<li style=''>"+content+'</li>');
  	 		
  	 		//$('.firend_huihua').scrollTop = $('.firend_huihua').scrollHeight;
  	 		//$(".firend_huihua").scrollTo('100%');
  	 		
  	 		$.ajax({
                url:"chat_content.action",
                type:"post",
                data:{friendId:chat_id,content:content},
                success:function(data){
                //	alert(content);
                },
                error:function(e){
                    alert("错误！！");
                }
            }); 
  	 		
  	 	});
  	 
  	 
  	 }
  	 
  </script>
  
  <body>
    <div>
    	<div class="left" style="float:left;width: 18%;height:100%; background-color: #ff0000;">
    		<div class="left_top" style="float:left;width: 100%;height:90%; ">
    			<div class="firend_list" style="width: 100%;height:100%; background-color: #ff77ff;overflow: auto;">
    				好友列表
    				<ul id="tree" class="ztree"  style="background: lightblue;" >
          			 </ul>
    			</div>
    			<div class="firend_huihua" style="width: 100%;height:100%; background-color: #f06fff;;display: none;overflow: auto;">
    				消息列表
    				<ul id="tree2" class="ztree"  style="background: lightblue;" >
          			 </ul>
    			</div>
    		</div>
    		<div class="left_buttom" style="float:left;width: 100%;height:10%; background-color: #005500">
    			<input class="btn_firend_list" type="button" value="好友列表" style="float:left;width: 50%;height:100%;">
    			<input class="btn_firend_huihua" type="button" value="会话" style="float:left;width: 50%;height:100%;">
    		</div>
    	</div>
    	<div class="right" style="float:left;width: 62%;height:100%;  background-color: #00ff00">
    		<div class="right_top_name" style="float:left;width: 100%;height:5%;  background-color: #f0f5f5">
    			与自己聊天中
    		</div>
    		<div class="right_top" style="float:left;width: 100%;height:55%;  background-color: #f0f0f0;overflow: auto;">
    			<ul id="chat">
    			
    			</ul>
    		</div>
    		<div class="right_center" style="float:left;width: 100%;height:30%;  background-color: #b1a2f2">
    			<textarea id="content" style="height: 100%;width: 100%"></textarea> 
    		</div>
    		<div class="right_buttom" style="float:left;width: 100%;height:10%;  background-color: #00ff55;text-align: right;">
    			<input id="send" style="height: 100%;width: 30%;" type="button" value="发送">
    		</div>
    	</div>
    	<div class="right_" style="float:left;width: 20%;height:100%;  background-color: #00ffff">
    	</div>
    </div>
  </body>
</html>

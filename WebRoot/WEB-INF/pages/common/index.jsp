<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!--<base href="<%=basePath%>">-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

    <!--自定义-->
    <link rel="stylesheet" type="text/css"
          href="./css/menu.css">

    <script type="text/javascript">
        $(function() {

            //当 主页 被点击的时候
            $(".index").click(function () {
                window.open("page_common_currentUser.action","iframe_west");
                window.open("./blank.html","iframe_center");
            });

            //当 公告 被点击的时候
            $(".notice").click(function () {
                window.open("page_notice_noticeMenu.action","iframe_west");
                window.open("ShowNotice.action","iframe_center");
            });

            //当 动态 被点击的时候
            $(".dynamic").click(function () {
                window.open("page_dynamic_dynamicMenu.action","iframe_west");
                window.open("./blank.html","iframe_center");
            });
            
            //当 好友 被点击的时候
            $(".friend").click(function () {
                window.open("page_friend_friendMenu.action","iframe_west");
                window.open("friendList.action","iframe_center");
            });
            
            //当点击退出的时候
            $(".quit").click(function(){
				$.messager
					.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {
					if (isConfirm) {
						location.href = '${pageContext.request.contextPath }/invalidate.jsp';
					}
				});
			});

        })
    </script>

</head>

<body class="easyui-layout">

<div data-options="region:'north',border:false"
     style="height:150px;padding:10px;background:url('./images/head.jpg') no-repeat right;">
   <div style="margin: 10px 0 10px 0">
        <p align="center" style="font-size: 30px;color:white;font-weight: bolder;">师生信息交流系统</p>
    </div>

   <div>
        <ul id="nav" >
            <li class="index"><a href="#">主页</a></li>
            <!--<li class="notice"><a href="./Announce2.html" target="ifra">公告</a></li>-->
            <li class="notice"><a href="#">公告</a></li>
            <li class="dynamic"><a href="#">动态</a></li>
            <li class="friend"><a href="#">好友</a></li>
            <li><a href="#">BBS论坛</a></li>
            <li><a href="#" class="quit">退出</a></li>
        </ul>
  </div>
  
  
  
</div>

<div data-options="region:'south',border:false"
     style="height:60px;padding:10px;background:url('./images/bottombg.jpg') no-repeat right;background-color: ghostwhite"></div>
<!-- <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div> -->


<div data-options="region:'west',title:' ',split:true" style="width:200px">
    <iframe name="iframe_west" src="page_common_currentUser.action"
            style="width:100%;height:100%;border:0;"></iframe>
</div>

<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <iframe name="iframe_center" src="./blank.html"
            style="width:100%;height:100%;border:0;"  scrolling="no"></iframe>
</div>

</body>
</html>

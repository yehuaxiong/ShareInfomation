<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>发布动态</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .top{
            width: 100%;
            height: 20px;
            background: #ffa500;
            margin: 0;
            padding: 0;
        }
        /*.left{*/
            /*width: 30%;*/
            /*height: 1000px;*/
            /*background: #d8bfd8;*/
            /*float: left;*/
            /*margin: 0;*/
            /*padding: 0;*/
        /*}*/
        .right{
            width:100%;
            height: 1000px;
            background: #E5E5E5;
            float: left;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>



  <div class="top">
         <label>发布动态</label>
  </div>

     <div class="right">
         <form action="post"  class="myform2">
          <label>标题:</label>
             <input type="text" placeholder="请输入标题..." maxlength="20"/>
             <br />
             <br />
             <label style="float: left">内容:</label>
             <textarea style="float: left;resize:none;" placeholder="请输入内容..."  maxlength="200" cols="48" rows="10"></textarea>
             <br />
                &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
             <div style="clear: left;">
              <input type="file" value="上传附件"  />
                 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
              <input type="button" value="确定" />&nbsp;
              <input type="button" value="取消" />
             </div>

         </form>
     </div>

</body>
</html>
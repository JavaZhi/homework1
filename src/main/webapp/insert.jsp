<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/11
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script type="text/javascript">
        function fun1(){
            window.location.href="${pageContext.request.contextPath}/chapter/downFile";
        }


    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/chapter/insertChapter" enctype="multipart/form-data" method="post">
        音频名称：<input type="text" name="title">
        上传文件：<input type="file" name="upFile" >
    <input type="submit" value="提交">
    </form>
     <input type="button" onclick="fun1()" value="下载">
<a href="${pageContext.request.contextPath}/chapter/down">下载</a>
</body>
</html>

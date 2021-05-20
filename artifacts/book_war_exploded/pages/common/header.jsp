<%@ page import="java.lang.ref.ReferenceQueue" %><%--
  Created by IntelliJ IDEA.
  User: 辣鸡电脑
  Date: 2020/7/27
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("base",basepath);
%>
<base href="<%=basepath%>">
<link href="static/css/style.css" rel="stylesheet" type="text/css" >
<script src="static/script/jquery-1.7.2.js" type="text/javascript"></script>
</body>
</html>

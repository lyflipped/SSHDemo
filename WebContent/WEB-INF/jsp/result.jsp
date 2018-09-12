<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13926
  Date: 2017/7/18
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${result}</p>
<table border="1">
    <tr>
        <td>操作</td>
     	<td>结果</td>
        
    </tr>
    <tr>
        <td>${method}</td>
        <td>${result}</td>
    </tr>
   
</table>
</body>
</html>
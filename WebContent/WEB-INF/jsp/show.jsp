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
<table border="1">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>性别</td>
        <td>生日</td>
        <td>邮箱</td>
        <td>省份</td>
        <td>城市</td>
        
    </tr>
        <c:choose>
            <c:when test="${not empty userList}">
                <c:forEach items="${userList}" var="user" varStatus="vs">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.gender}</td>
                        <td>${user.birthday}</td>
                        <td>${user.email}</td>
                        <td>${user.province}</td>
                        <td>${user.city}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
               <tr>
                   <td colspan="2">无数据!</td>
               </tr>
            </c:otherwise>
        </c:choose>
</table>
</body>
</html>

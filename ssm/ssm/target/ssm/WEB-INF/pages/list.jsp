<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-03-19
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--实现遍历效果--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>查询所有</h3>

    <c:forEach items="${list}" var="account">
        ${account.name}
        <br>
        ${account.money}
        <br>
    </c:forEach>

</body>
</html>

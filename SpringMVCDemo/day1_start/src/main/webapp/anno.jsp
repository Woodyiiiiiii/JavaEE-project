<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-03-18
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    常用注解的示例--%>
<%--    RequestParm注解--%>
    <a href="annotation/requestParam?name=test&id=1">
        RequestParam注解示例
    </a>

    <br>
<%--    RequestBody注解--%>
    <form action="annotation/requestBody" method="post">
        username: <input type="text" name="username"/><br>
        password: <input type="password" name="password"/><br>
        money:    <input type="text" name="money"/><br>
        <input type="submit" name="submit"/>
    </form>


</body>
</html>

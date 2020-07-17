<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-03-19
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">测试查询</a>

    <h3>测试包</h3>
    <form action="account/save" method="post">
        name:<input type="text" name="name"/><br>
        money:<input type="text" name="money"/><br>
        <input type="submit" name="submit"/>
    </form>

</body>
</html>

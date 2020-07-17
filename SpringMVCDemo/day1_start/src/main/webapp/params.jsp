<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-03-18
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    请求参数的绑定--%>
<%--    <a href="params/findById?accountId=4214">根据ID查询账户(参数是基本类型)</a>--%>


    <form action="params/saveAccount" method="post">
        username: <input type="text" name="username"/><br>
        password: <input type="text" name="password"/><br>
        money:    <input type="text" name="money"/><br>
        <input type="submit" name="submit"/>
    </form>

</body>
</html>

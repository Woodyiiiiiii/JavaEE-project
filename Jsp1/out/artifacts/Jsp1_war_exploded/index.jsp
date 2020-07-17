<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019-11-25
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
This is JSP note.
--%>
<html>
<head>
    <title>1111</title>
    <meta charset = "utf-8"/>
</head>
<body>
<%
    int a = 4;
    if (a > 3) {
%>
<p>Fuck you</p>
<%
    }
    else {
%>
<p>哈哈啊</p>
<%
    }
%>
<hr />
<%
    // 调用全局函数
    test();
%>
<%!
    // 全局代码块
    public void test()
    {
        System.out.println("JSP is a junk.");
    }
%>
<br>
<a href="/Jsp1_war_exploded/a/a.jsp">a.jsp</a>

<jsp:include page="test1.jsp"></jsp:include>

</body>
</html>

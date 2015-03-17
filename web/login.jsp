<%--
  Created by IntelliJ IDEA.
  User: huihui
  Date: 15-3-17
  Time: 下午6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

    <%= request.getContextPath() %>
    <form action="<%= request.getContextPath() %>/servlet/login" method="post">
    用户名:<input type="text" name="username" /> <br />
    密码:<input type="text" name="password" /> <br />
        <input type="submit" value="提交" />
    </form>
</body>
</html>

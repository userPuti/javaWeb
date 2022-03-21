<%--
  Created by IntelliJ IDEA.
  User: puti
  Date: 2022/3/21
  Time: 14:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="get">
    账号： <input type="text" name="zh" value="${cookie.zh.value}"/> <br>
    口令： <input type="password" name="kl" value="${cookie.kl.value}"/><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>

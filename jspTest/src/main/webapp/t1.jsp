<%--
  Created by IntelliJ IDEA.
  User: puti
  Date: 2022/3/22
  Time: 16:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="head">
    <label for="yhzh">用户账号:</label>
    <input id="yhzh" class="yhzh" type="text" name="yhzh"/>

    <label for="yhbm">用户部门：</label>
    <select id="yhbm" name="yhbm">
        <option value="blank" selected></option>
        <option value="lat">立案庭</option>
        <option value="ywt">业务庭</option>
        <option value="bgs">办公室</option>
    </select>

    <button id="search">查询</button>
    <%--    <button id="addUser">新增</button>--%>
    <a id="addUser" href="${pageContext.request.contextPath}/t2.jsp">新增</a>
<%--    <button id="logoff">注销</button>--%>
    <a href="logoffServlet">注销</a>
</div>
<div style="width:100%; height:100%;" align="left">
    <table id="grid" border="1" cellpadding="10" cellspacing="0" width="95%">
        <thead style="background-color: aquamarine;">
        <tr>
            <td align="center">账户</td>
            <td align="center">姓名</td>
            <td align="center">口令</td>
            <td align="center">性别</td>
            <td align="center">部门</td>
            <td align="center">出生日期</td>
            <td align="center">登记日期</td>
            <td align="center">登记时间</td>
            <td align="center">是否禁用</td>
            <td align="center">排序号</td>
            <td align="center">查看</td>
            <td align="center">删除</td>
            <td align="center">修改</td>
        </tr>
        </thead>
        <tbody id="tbody"></tbody>
    </table>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-cookie/1.4.1-1/jquery.cookie.js"></script>

<script src="./js/t1.js"></script>
</body>
</html>

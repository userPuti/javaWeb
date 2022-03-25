<%--
  Created by IntelliJ IDEA.
  User: puti
  Date: 2022/3/22
  Time: 17:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="./css/check.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/addUserServlet" method="post">
    <table width="95%" border="1" cellpadding="10" cellspace="0" align="center">
        <tr>
            <td colspan="4" align="center" style="word-wrap:break-word;">用户信息</td>
        </tr>
        <tr>
            <td style="word-wrap:break-word;" align="center">
                <span style="color: red; ">*</span>用户账号
            </td>
            <td style="word-wrap:break-word;" align="left">
                <!-- <textarea id="yhidText" name="yhidText" style="width: 100%;height: 100%;border: none;"></textarea> -->
                <input class="input" type="text" name="yhidText" id="yhidText"/>
            </td>
            <td style="word-wrap:break-word;" align="center">
                <span style="color: red; ">*</span>用户姓名
            </td>
            <td style="word-wrap:break-word;" align="left">
                <!-- <textarea id="yhxmText" style="width: 100%;height: 100%;border: none;"></textarea> -->
                <input class="input" type="text" name="yhxmText" id="yhxmText"/>
            </td>
        </tr>
        <tr>
            <td style="word-wrap:break-word;" align="center">
                <span style="color: red; ">*</span>用户口令
            </td>
            <td style="word-wrap:break-word;" align="left">
                <!-- <textarea id="yhklText" style="width: 100%;height: 100%;border: none;"></textarea> -->
                <input class="input" type="text" name="yhklText" id="yhklText"/>
            </td>
            <td style="word-wrap:break-word;" align="center">
                <span style="color: red; ">*</span>重复口令
            </td>
            <td style="word-wrap:break-word;" align="left">
                <!-- <textarea name="cfklText" id="yhidText" style="width: 100%;height: 100%;border: none;"></textarea> -->
                <input class="input" type="text" name="cfklText" id="cfklText"/>
            </td>
        </tr>
        <tr>
            <td style="word-wrap:break-word;" align="center">
                <span style="color: red; ">*</span>用户部门
            </td>
            <td id="yhbmTd" style="word-wrap:break-word;" align="left">
                <select id="yhbm" name="yhbm">
                    <option value="blank" selected></option>
                    <option value="lat">立案庭</option>
                    <option value="ywt">业务庭</option>
                    <option value="bgs">办公室</option>
                </select>
            </td>
            <td style="word-wrap:break-word;" align="center">用户性别</td>
            <td style="word-wrap:break-word;" align="left">
                <select id="xb" name="xb">
                    <option value="blank" selected></option>
                    <option value="male">男</option>
                    <option value="female">女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td style="word-wrap:break-word;" align="center">出生日期</td>
            <td style="word-wrap:break-word;" align="left">
                <input id="date" type="date" name="csrq"/>
            </td>
            <td style="word-wrap:break-word;" align="center">排序号</td>
            <td style="word-wrap:break-word;" align="left">
                <!-- <textarea id="pxhText" style="width: 100%;height: 100%;border: none;"></textarea> -->
                <input class="input" type="text" name="pxhText" id="pxhText"/>
            </td>
        </tr>
        <tr>
            <td style="word-wrap:break-word;" align="center">是否禁用</td>
            <td style="word-wrap:break-word;" align="left">
                <input id="sfjy" type="checkbox" name="sfjy">
            </td>
            <td style="word-wrap:break-word;" align="center"></td>
            <td style="word-wrap:break-word;" align="center"></td>
        </tr>
        <tr>
            <td colspan="4" align="center" style="word-wrap:break-word;">
                <input id="submit" type="submit" value="【保存】"/>
                <input id="back" type="button" value="【返回】"/>
            </td>
        </tr>
    </table>
</form>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-cookie/1.4.1-1/jquery.cookie.js"></script>
<script src="./js/check.js"></script>
</body>
</html>

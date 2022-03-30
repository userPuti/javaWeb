<%--
  Created by IntelliJ IDEA.
  User: puti
  Date: 2022/3/28
  Time: 10:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <jsp:include page="resources/v2/webui.jsp">
        <jsp:param name="UIS" value="FORM_DGRID_LAYER_BTN"/>
    </jsp:include>
    <script src="${pageContext.request.contextPath}/webjars/jquery-cookie/1.4.1-1/jquery.cookie.js"></script>
    <script src="js/userInfo.js"></script>
</head>
<body>
<div class="tdh_form_title">用户信息</div>
<%--<div class="tdh_form_subtitle">副标题</div>--%>
<div class="tdh_form_caption"><i class="tdh_form_tag"></i>基本信息</div>
<form action="${pageContext.request.contextPath}/addUserServlet" method="post">
    <table class="tdh_form">
        <colgroup>
            <col width="11%"/>
            <col width="22%"/>
            <col width="11%"/>
            <col width="22%"/>
            <col width="11%"/>
            <col width="22%"/>
        </colgroup>
        <tr>
            <td class="tdTitle"><i class="required">*</i>用户账号</td>
            <td class="tdCont">
                <%--                <input class="inputText" type="text" placeholder="请输入"/>--%>
            </td>
            <td class="tdTitle"><i class="required">*</i>用户姓名</td>
            <td class="tdCont">
                <%--                <input class="inputText" type="text" placeholder="请输入"/>--%>
            </td>
            <td class="tdTitle"><i class="required">*</i>排序号</td>
            <td class="tdCont">
                <%--                <input class="inputText" type="text" placeholder="请输入"/>--%>
            </td>
        </tr>
        <tr>
            <td class="tdTitle">出生日期</td>
            <td class="tdCont">
                <%--                                <input class="Wdate inputText" type="text" onClick="WdatePicker()" readonly="readonly" />--%>
            </td>
            <td class="tdTitle"><i class="required">*</i>用户口令</td>
            <td class="tdCont">
                <%--                            <input class="inputText" type="text" placeholder="请输入"/>--%>
            </td>
            <td class="tdTitle"><i class="required">*</i>重复口令</td>
            <td class="tdCont">
                <%--                            <input class="inputText" type="text" placeholder="请输入"/>--%>
            </td>
        </tr>
        <tr>
            <td class="tdTitle"><i class="required">*</i>用户部门</td>
            <td class="tdCont">
                <%--                <select class="inputSel" id="yhbm" name="yhbm">--%>
                <%--                    <option value="blank" selected></option>--%>
                <%--                    <option value="lat">立案庭</option>--%>
                <%--                    <option value="ywt">业务庭</option>--%>
                <%--                    <option value="bgs">办公室</option>--%>
                <%--                </select>--%>
            </td>
            <td class="tdTitle">用户性别</td>
            <td class="tdCont">
                <%--                <select class="inputSel" id="xb" name="xb">--%>
                <%--                    <option value="blank" selected></option>--%>
                <%--                    <option value="male">男</option>--%>
                <%--                    <option value="female">女</option>--%>
                <%--                </select>--%>
            </td>
            <td class="tdTitle">是否禁用</td>
            <td class="tdCont" colspan="5">
                <%--                <input name="switch" class="inputSwitch" type="checkbox" data-text="失效/启用"/>--%>
            </td>
        </tr>
    </table>

    <div class="tdh_layout_b" style="height: 40px; text-align: center">
        <input class="tdh_btn tdh_btn_blue" id="back" type="button" value="返回"/>
    </div>
</form>
</body>
</html>

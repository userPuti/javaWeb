<%--
  Created by IntelliJ IDEA.
  User: puti
  Date: 2022/3/30
  Time: 13:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="tdh_form_title">添加用户信息</div>
<%--<div class="tdh_form_subtitle">副标题</div>--%>
<div class="tdh_form_caption"><i class="tdh_form_tag"></i>基本信息</div>
<form action="${pageContext.request.contextPath}/" method="post">
    <jsp:include page="commonTable.jsp"/>
    <div class="tdh_layout_b" style="height: 40px; text-align: center">
        <input class="tdh_btn tdh_btn_blue" type="submit" value="保存"/>
        <input class="tdh_btn tdh_btn_blue" id="back" type="button" value="返回"/>
    </div>
</form>
</body>
</html>

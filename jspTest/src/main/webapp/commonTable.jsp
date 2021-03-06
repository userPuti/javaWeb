<%--
  Created by IntelliJ IDEA.
  User: puti
  Date: 2022/3/30
  Time: 16:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="tdh_form">
    <colgroup>
        <col width="14%"/>
        <col width="24%"/>
        <col width="14%"/>
        <col width="24%"/>
    </colgroup>
    <tr>
        <td class="tdTitle"><i class="required">*</i>用户账号</td>
        <td class="tdCont"><input id="iYhzh" name="iYhzh" class="inputText" type="text" placeholder="请输入"/></td>
        <td class="tdTitle"><i class="required">*</i>用户姓名</td>
        <td class="tdCont"><input id="iYhxm" name="iYhxm" class="inputText" type="text" placeholder="请输入"/></td>
    </tr>
    <tr>
        <td class="tdTitle"><i class="required">*</i>用户口令</td>
        <td class="tdCont"><input id="iYhkl" name="iYhkl" class="inputText" type="text" placeholder="请输入"/></td>
        <td class="tdTitle" id="tCfkl"><i class="required">*</i>重复口令</td>
        <td class="tdCont"><input id="iCfkl" name="iCfkl" class="inputText" type="text" placeholder="请输入"/></td>
    </tr>
    <tr>
        <td class="tdTitle">排序号</td>
        <td class="tdCont"><input id="iPxh" name="iPxh" class="inputText" type="text" placeholder="请输入"/></td>
        <td class="tdTitle">出生日期</td>
        <td class="tdCont">
            <input id="iCsrq" name="iCsrq" class="Wdate inputText" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'} );"
                   readonly="readonly"/>
        </td>
    </tr>
    <tr>
        <td class="tdTitle">用户部门</td>
        <td class="tdCont">
            <select class="inputSel" id="iYhbm" name="iYhbm">
                <option value="" selected></option>
                <option value="lat">立案庭</option>
                <option value="ywt">业务庭</option>
                <option value="bgs">办公室</option>
            </select>
        </td>
        <td class="tdTitle">用户性别</td>
        <td class="tdCont">
            <select class="inputSel" id="iYhxb" name="iYhxb">
                <option value="" selected></option>
                <option value="male">男</option>
                <option value="female">女</option>
                <option value="other">其他</option>
            </select>
        </td>
    </tr>
    <tr>
        <td class="tdTitle">是否禁用</td>
        <td class="tdCont" colspan="3">
            <input id="iSfjy" name="iSfjy" class="inputSwitch" type="checkbox" data-text="失效/启用"/>
        </td>
    </tr>
</table>
</body>
</html>
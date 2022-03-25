$(function () {
    $("form").submit(
        function () {
            return validateForm();
        }
    );

    $("#back").click(function () {
        clear();
        $(location).attr("href", "t1.jsp");
    });

    let type = $.cookie("type");
    if (type === "modify") {
        modifier();
    }
})

function clear() {
    $.removeCookie("yhid");
    $.removeCookie("yhxm");
    $.removeCookie("yhkl");
    $.removeCookie("yhxb");
    $.removeCookie("csrq");
    $.removeCookie("sfjy");
    $.removeCookie("pxh");
    $.removeCookie("yhbm");
}

function modifier() {
    let yhid = $.cookie("yhid");
    // console.log(yhid);
    let yhxm = $.cookie("yhxm");
    let yhkl = $.cookie("yhkl");
    let yhxb = $.cookie("yhxb");
    let csrq = $.cookie("csrq");
    let sfjy = $.cookie("sfjy");
    let pxh = $.cookie("pxh");
    let yhbm = $.cookie("yhbm");

    if (yhid == null || pxh == null || yhxm == null || yhkl == null || yhbm == null || yhxb == null || sfjy == null || csrq == null) {
        return;
    }

    $("#yhidText").val(yhid);
    $("#yhidText").attr("readonly", "readonly");

    $("#pxhText").val(pxh);
    $("#yhxmText").val(yhxm);

    $("#yhklText").val(yhkl);
    $("#cfklText").val(yhkl);


    console.log(yhbm);
    // console.log (yhbm === "立案庭");
    if (yhbm === "立案庭") {
        $("#yhbm option[value='lat']").attr("selected", true);
    } else if (yhbm === "业务庭") {
        console.log("ywt");
        $("#yhbm option[value='ywt']").attr("selected", true);
    } else {
        $("#yhbm option[value='bgs']").attr("selected", true);
    }

    console.log(yhxb);
    // console.log(yhxb === "09_00003-2");

    if (yhxb === "男") {
        $("#xb option[value='male']").attr("selected", true);
    } else if (yhxb === "女") {
        $("#xb option[value='female']").attr("selected", true);
    }

    csrq = insertStr(csrq, 4, "-");
    csrq = insertStr(csrq, 7, "-");
    let birth = new Date(csrq).format("yyyy-MM-dd");
    $("#date").attr("value", birth);

    if (sfjy === "是") {
        $("#sfjy").attr("checked", "checked");
    }
}

function insertStr(soure, start, newStr) {
    return soure.slice(0, start) + newStr + soure.slice(start);
}

function validateForm() {
    let yhid = $("#yhidText").val();
    let yhxm = $("#yhxmText").val();
    let yhkl = $("#yhklText").val();
    let cfkl = $("#cfklText").val();

    if (yhid == null || yhid === "") {
        alert("id必须填写");
        return false;
    }
    if (yhxm == null || yhxm === "") {
        alert("姓名必须填写");
        return false;
    }
    if (yhkl == null || yhkl === "") {
        alert("口令必须填写");
        return false;
    }
    if (cfkl == null || cfkl === "") {
        alert("重复口令必须填写");
        return false;
    }
    if (yhkl !== cfkl) {
        alert("口令不一致");
        return false;
    }

    return true;
}

Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}
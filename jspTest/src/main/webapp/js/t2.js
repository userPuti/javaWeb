$(function () {
    $("form").submit(
        function () {
            return validateForm();
        }
    );

    $("#back").click(function () {
        $(location).attr("href", "t1.jsp");
    });
})


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
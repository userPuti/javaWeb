$(function () {
    isSuccess();

    $("form").submit(function () {
        return validateForm();
    });

    $("#back").click(function () {
        $(location).attr("href", "homePage.jsp");
    });
})

function isSuccess() {
    let isSucc = $("#isSuccess").val();
    // alert(isSucc);

    if(isSucc === "success") {
        layer.msg("添加成功", {
            icon: 1,
            shade: 0.000001,
            time: 2000,
        });
    } else if(isSucc === "defeat"){
        layer.msg("添加失败", {
            icon: 2,
            shade: 0.000001,
            time: 2000,
        });
    }
}

function validateForm() {
    let yhzh = $("#iYhzh").val();
    let yhxm = $("#iYhxm").val();
    let yhkl = $("#iYhkl").val();
    let cfkl = $("#iCfkl").val();

    if (yhzh == null || yhzh === "") {
        layer.msg("id必须填写", {
            icon: 2,
            shade: 0.000001,
            time: 2000,
        });
        return false;
    }
    if (yhxm == null || yhxm === "") {
        layer.msg("姓名必须填写", {
            icon: 2,
            shade: 0.000001,
            time: 2000,
        });
        return false;
    }
    if (yhkl == null || yhkl === "") {
        layer.msg("口令必须填写", {
            icon: 2,
            shade: 0.000001,
            time: 2000,
        });
        return false;
    }
    if (cfkl == null || cfkl === "") {
        layer.msg("重复口令必须填写", {
            icon: 2,
            shade: 0.000001,
            time: 2000,
        });
        return false;
    }
    if (yhkl !== cfkl) {
        layer.msg("口令不一致", {
            icon: 2,
            shade: 0.000001,
            time: 2000,
        });
        return false;
    }
    return true;
}
$(function () {

    showUserInfo();

    $("#back").click(function () {
        closeWindow();
    });


    $("form").submit(function () {
        let reqInfo = validateForm();

        if (reqInfo === false) {
            layer.msg("请检查必填项！", {
                icon: 7,
                shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                time: 2000
            });
            return reqInfo;
        }
    });
})

function doSave() {
    let reqInfo = validateForm();

    if (reqInfo === false) {
        layer.msg("请检查必填项！", {
            icon: 7,
            shade: 0.000001, //不展示遮罩，但是要有遮罩效果
            time: 2000
        });
        return;
    }

    let params = serializeTwo("#form1");
    $.ajax({
        url: _part + "/updateServlet",
        type: "post",
        dataType: "text",
        data: params,
        success: function (data) {
            data = $.trim(data);
            if (data === "1") {
                layer.msg("修改成功！", {
                    icon: 1,
                    shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                    time: 2000
                }, function () {
                    layerReturn("1");
                });
            } else {
                layer.msg("修改失败！", {
                    icon: 0,
                    shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                    time: 2000
                }, function () {
                    layerClose();
                });
            }
        },
        error: function (e) {
            layer.msg("修改失败！", {
                icon: 0,
                shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                time: 2000
            });
        }
    })
}

function closeWindow() {
    parent.layer.closeAll();
}

function getQueryVariable(variable) {
    let query = window.location.search.substring(1);

    let vars = query.split("&");
    for (let i = 0; i < vars.length; i++) {
        let pair = vars[i].split("=");
        if (pair[0] === variable) {
            return decodeURIComponent(pair[1]);
        }
    }
    return false;
}

function validateForm() {
    let yhzh = $("#iYhzh").val();
    let yhxm = $("#iYhxm").val();
    let yhkl = $("#iYhkl").val();

    return yhzh != null && yhzh !== "" && yhxm != null && yhxm !== "" && yhkl != null && yhkl !== "";
}


function showUserInfo() {
    let yhid = getQueryVariable("yhid");

    $.getJSON("viewUserInfoServlet", {"yhid": yhid}, function (user) {
            $("#iYhzh").val(user.yhid);
            $("#iYhzh").attr("readonly", "readonly");
            $("#iYhxm").val(user.yhxm);
            $("#iCsrq").val(user.csrq);
            $("#iPxh").val(user.pxh);
            $("#iYhkl").val(user.yhkl);
            $("#iCfkl").parent().html(" <input id=\"iDjrq\" name=\"iDjrq\" class=\"Wdate inputText\" type=\"text\" onClick=\"WdatePicker()\" readonly=\"readonly\" />");
            $("#tCfkl").html("登记日期");
            $("#iDjrq").val(user.djrq);

            if (user.yhbm === "立案庭") {
                setSelVal("#iYhbm", "lat");
            } else if (user.yhbm === "业务庭") {
                setSelVal("#iYhbm", "ywt");
            } else {
                setSelVal("#iYhbm", "bgs");
            }

            if (user.yhxb === "男") {
                setSelVal("#iYhxb", "male");
            } else if (user.yhxb === "女") {
                setSelVal("#iYhxb", "female");
            } else {
                setSelVal("#iYhxb", "other");
            }

            if (user.sfjy === "是") {
                setSwichVal("#iSfjy", true);
            }
        }
    )


}
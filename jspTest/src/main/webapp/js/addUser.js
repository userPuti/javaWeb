$(function () {


    $("form").submit(function () {
        let reqInfo = validateForm();

        if(reqInfo === false) {
            layer.msg("请检查必填项！", {
                icon: 2,
                shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                time: 2000
            });
            return reqInfo;
        } else {
            layer.msg("添加成功", {
                icon: 1,
                shade: 0.000001,
                time: 2000,
            });
            return reqInfo;
        }
    });

    $("#back").click(function () {
        closeWindow();
    });
})

function closeWindow() {
    parent.layer.closeAll();
}

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

    return yhzh != null && yhzh !== "" && yhxm != null && yhxm !== "" && yhkl != null && yhkl !== "" && cfkl != null && cfkl !== "" && cfkl === yhkl;

}
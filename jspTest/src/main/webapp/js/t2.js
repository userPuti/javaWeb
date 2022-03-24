$(function () {
    $("form").submit(
        function () {
            return validateForm();
        }
    );

    $("#back").click(function () {
        $.removeCookie("yhid");
        $.removeCookie("yhxm");
        $.removeCookie("yhkl");
        $.removeCookie("yhxb");
        $.removeCookie("csrq");
        $.removeCookie("sfjy");
        $.removeCookie("pxh");
        $.removeCookie("yhbm");

        $(location).attr("href", "t1.jsp");
    });

    let type = $.cookie("type");
    // alert(type);
    if (type === "check") {
        console.log(1);
        checkInfo();
    }
})


function checkInfo() {
    let yhid = $.cookie("yhid");
    console.log(yhid);
    let yhxm = $.cookie("yhxm");
    let yhkl = $.cookie("yhkl");
    let yhxb = $.cookie("yhxb");
    let csrq = $.cookie("csrq");
    let sfjy = $.cookie("sfjy");
    let pxh = $.cookie("pxh");
    let yhbm = $.cookie("yhbm");

    $("#yhidText").parent().html(yhid);

    $("#pxhText").parent().html(pxh);
    $("#yhxmText").parent().html(yhxm);

    $("#yhklText").parent().html(yhkl);
    $("#cfklText").parent().html(yhkl);

    $('#yhbm').hide();
    $("#yhbm").parent().html(yhbm);

    $('#xb').hide();
    $("#xb").parent().html(yhxb);

    if (sfjy === '否') {
        $('#sfjy').hide();
        $('#sfjy').parent().html('否');
    } else {
        $('#sfjy').hide();
        $('#sfjy').parent().html('是');
    }

    $('#date').hide();
    $("#date").parent().html(csrq);

    $('#submit').hide();
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
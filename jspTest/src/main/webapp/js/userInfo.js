$(function () {
    let yhid = getQueryVariable("yhid");
    let yhxm = getQueryVariable("yhxm");
    let yhxb = getQueryVariable("yhxb");
    let yhbm = getQueryVariable("yhbm");
    let csrq = getQueryVariable("csrq");
    let pxh  = getQueryVariable("pxh");
    let sfjy = getQueryVariable("sfjy");
    let yhkl = getQueryVariable("yhkl");

    // console.log(yhid);
    $("#iYhzh").val(yhid);
    $("#iYhxm").val(yhxm);
    $("#iYhxb").val(yhxb);
    $("#iYhbm").val(yhbm);
    $("#iCsrq").val(csrq);
    $("#iPxh").val(pxh);
    $("#iSfjy").val(sfjy);
    $("#iYhkl").val(yhkl);


    $("#back").click(function () {
        closeWindow();
    });
})

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
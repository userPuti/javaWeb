$(function () {
    let yhid = getQueryVariable("yhid");

    $.getJSON("viewUserInfoServlet", {"yhid": yhid}, function (user) {
            $("#iYhzh").val(user.yhid);
            $("#iYhxm").val(user.yhxm);
            $("#iYhxb").val(user.yhxb);
            $("#iYhbm").val(user.yhbm);
            $("#iCsrq").val(user.csrq);
            $("#iPxh").val(user.pxh);
            $("#iSfjy").val(user.sfjy);
            $("#iYhkl").val(user.yhkl);
        }
    )

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
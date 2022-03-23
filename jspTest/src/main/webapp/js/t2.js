$(function () {
    $("form").submit(
        function () {
            return validateForm();
        }
    );
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
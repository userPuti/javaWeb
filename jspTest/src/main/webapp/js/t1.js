$(function () {
    $.ajax({
        url: "/jspTest/displayUserInfoServlet", type: "get", dataType: "json", success: function (users) {
            let html = "";
            for (let i in users) {

                html += "<tr>";
                html += "<td>" + users[i].yhid + "</td>";
                html += "<td>" + users[i].yhxm + "</td>";
                html += "<td>" + users[i].yhkl + "</td>";
                html += "<td>" + users[i].yhxb + "</td>";
                html += "<td>" + users[i].yhbm + "</td>";
                html += "<td>" + users[i].csrq + "</td>";
                html += "<td>" + users[i].djsj + "</td>";
                html += "<td>" + users[i].djrq + "</td>";
                html += "<td>" + users[i].sfjy + "</td>";
                html += "<td>" + users[i].pxh + "</td>";
                html += "<td><img src='/jspTest/images/search.png' width='30' height='30' style='cursor:pointer' onclick='checkInfo(this)'/></td>";
                html += "<td><img src='/jspTest/images/delete.png' width='30' height='30' style='cursor:pointer' onclick='deleteInfo(this)'/></td>";
                html += "<td><img src='/jspTest/images/modify.png' width='30' height='30' style='cursor:pointer' onclick='modify(this)'/></td>";
                html += "</tr>";
            }

            $("#tbody").html(html);

        }
    });

    $("#search").click(function () {
        let yhzh = $("#yhzh").val();
        let yhbm = $("#yhbm option:selected").val();
        let html = "";
        $.ajax({
            url: "/jspTest/queryServlet", type: "get", data: {
                "yhzh": yhzh, "yhbm": yhbm
            }, dataType: "json", success: function (users) {
                let html = "";
                for (let i in users) {
                    html += "<tr>";
                    html += "<td>" + users[i].yhid + "</td>";
                    html += "<td>" + users[i].yhxm + "</td>";
                    html += "<td>" + users[i].yhkl + "</td>";
                    html += "<td>" + users[i].yhxb + "</td>";
                    html += "<td>" + users[i].yhbm + "</td>";
                    html += "<td>" + users[i].csrq + "</td>";
                    html += "<td>" + users[i].djsj + "</td>";
                    html += "<td>" + users[i].djrq + "</td>";
                    html += "<td>" + users[i].sfjy + "</td>";
                    html += "<td>" + users[i].pxh + "</td>";
                    html += "<td><img src='/jspTest/images/search.png' width='30' height='30' style='cursor:pointer' onclick='checkInfo(this)'/></td>";
                    html += "<td><img src='/jspTest/images/delete.png' width='30' height='30' style='cursor:pointer' onclick='deleteInfo(this)'/></td>";
                    html += "<td><img src='/jspTest/images/modify.png' width='30' height='30' style='cursor:pointer' onclick='modify(this)'/></td>";
                    html += "</tr>";
                }
                $("#tbody").html(html);
            }
        });
    });

})

function checkInfo(obj) {

    let yhid = $(obj).parent().siblings().eq(0).html();
    let yhxm = $(obj).parent().siblings().eq(1).html();
    let yhkl = $(obj).parent().siblings().eq(2).html();
    let yhxb = $(obj).parent().siblings().eq(3).html();
    let yhbm = $(obj).parent().siblings().eq(4).html();
    let csrq = $(obj).parent().siblings().eq(5).html();
    let sfjy = $(obj).parent().siblings().eq(7).html();
    let pxh = $(obj).parent().siblings().eq(8).html();

    $.cookie("type", "check");
    $.cookie("yhid", yhid);
    $.cookie("yhxm", yhxm);
    $.cookie("yhkl", yhkl);
    $.cookie("yhxb", yhxb);
    $.cookie("yhbm", yhbm);
    $.cookie("csrq", csrq);
    $.cookie("sfjy", sfjy);
    $.cookie("pxh", pxh);

    $(location).attr("href", "t2.jsp");
}


function modify(obj) {

}


function deleteInfo(obj) {
    let yhid = $(obj).parent().siblings().eq(0).html();

    $.get(
        "/jspTest/deleteInfoServlet", {"yhid": yhid}, function () {
            $(obj).parent().parent().remove();
        }
    );
}
$(function () {
    $.ajax({
        url: "/jspTest/displayUserInfoServlet", type: "get", dataType: "json", success: function (users) {
            let html = "";
            for (let i in users) {
                let yhbm = users[i].yhbm;
                if (yhbm === "32010001") {
                    yhbm = "立案庭";
                } else if (yhbm === "32010002") {
                    yhbm = "业务庭";
                } else if (yhbm === "32010003") {
                    yhbm = "办公室";
                }

                let yhxb = users[i].yhxb;
                if(yhxb === "09_00003-1") {
                    yhxb = "男";
                } else if(yhxb === "09_00003-2") {
                    yhxb = "女";
                } else if(yhxb === "09_00003-255") {
                    yhxb = "其他";
                }

                let sfjy = users[i].sfjy;
                if(sfjy === "1") {
                    sfjy = "是";
                } else if(sfjy === "0") {
                    sfjy = "否";
                }

                html += "<tr>";
                html += "<td>" + users[i].yhid + "</td>";
                html += "<td>" + users[i].yhxm + "</td>";
                html += "<td>" + users[i].yhkl + "</td>";
                html += "<td>" + yhxb + "</td>";
                html += "<td>" + yhbm + "</td>";
                html += "<td>" + users[i].csrq + "</td>";
                html += "<td>" + users[i].djsj + "</td>";
                html += "<td>" + users[i].djrq + "</td>";
                html += "<td>" + sfjy + "</td>";
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

                    let yhbm = users[i].yhbm;
                    if (yhbm === "32010001") {
                        yhbm = "立案庭";
                    } else if (yhbm === "32010002") {
                        yhbm = "业务庭";
                    } else if (yhbm === "32010003") {
                        yhbm = "办公室";
                    }

                    let yhxb = users[i].yhxb;
                    if(yhxb === "09_00003-1") {
                        yhxb = "男";
                    } else if(yhxb === "09_00003-2") {
                        yhxb = "女";
                    } else if(yhxb === "09_00003-255") {
                        yhxb = "其他";
                    }

                    let sfjy = users[i].sfjy;
                    if(sfjy === "1") {
                        sfjy = "是";
                    } else if(sfjy === "0") {
                        sfjy = "否";
                    }

                    html += "<tr>";
                    html += "<td>" + users[i].yhid + "</td>";
                    html += "<td>" + users[i].yhxm + "</td>";
                    html += "<td>" + users[i].yhkl + "</td>";
                    html += "<td>" + yhxb + "</td>";
                    html += "<td>" + yhbm + "</td>";
                    html += "<td>" + users[i].csrq + "</td>";
                    html += "<td>" + users[i].djsj + "</td>";
                    html += "<td>" + users[i].djrq + "</td>";
                    html += "<td>" + sfjy + "</td>";
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
    let sfjy = $(obj).parent().siblings().eq(8).html();
    let pxh = $(obj).parent().siblings().eq(9).html();

    $.cookie("type", "check");
    $.cookie("yhid", yhid);
    $.cookie("yhxm", yhxm);
    $.cookie("yhkl", yhkl);
    $.cookie("yhxb", yhxb);
    $.cookie("yhbm", yhbm);
    $.cookie("csrq", csrq);
    $.cookie("sfjy", sfjy);
    $.cookie("pxh", pxh);

    $(location).attr("href", "check.jsp");
}


function modify(obj) {
    let yhid = $(obj).parent().siblings().eq(0).html();
    let yhxm = $(obj).parent().siblings().eq(1).html();
    let yhkl = $(obj).parent().siblings().eq(2).html();
    let yhxb = $(obj).parent().siblings().eq(3).html();
    let yhbm = $(obj).parent().siblings().eq(4).html();
    let csrq = $(obj).parent().siblings().eq(5).html();
    let sfjy = $(obj).parent().siblings().eq(8).html();
    let pxh = $(obj).parent().siblings().eq(9).html();

    $.cookie("type", "modify");
    $.cookie("yhid", yhid);
    $.cookie("yhxm", yhxm);
    $.cookie("yhkl", yhkl);
    $.cookie("yhxb", yhxb);
    $.cookie("yhbm", yhbm);
    $.cookie("csrq", csrq);
    $.cookie("sfjy", sfjy);
    $.cookie("pxh", pxh);

    $(location).attr("href", "modify.jsp");
}


function deleteInfo(obj) {
    let yhid = $(obj).parent().siblings().eq(0).html();

    $.get(
        "/jspTest/deleteInfoServlet", {"yhid": yhid}, function () {
            $(obj).parent().parent().remove();
        }
    );
}
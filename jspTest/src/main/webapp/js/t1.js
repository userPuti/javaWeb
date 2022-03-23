$(function () {
        $.ajax({
            url: "/jspTest/displayUserInfoServlet",
            type: "get",
            dataType: "json",
            success: function (users) {
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
                    html += "<td><img src=\"/jspTest/images/search.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                    html += "<td><img src=\"/jspTest/images/modify.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                    html += "<td><img src=\"/jspTest/images/delete.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                    html += "</tr>";

                }

                $("#tbody").html(html);
            }
        });

        $("#search").click(
            function () {
                let yhzh = $("#yhzh").val();
                let yhbm = $("#yhbm option:selected").val();
                let html = "";
                // $.getJSON("/jspTest/queryServlet",
                //     {
                //         "yhzh": yhzh,
                //         "yhbm": yhbm
                //     },
                //     function (users) {
                //         alert(users.yhid);
                //         alert(users.yhxm);
                //         for (let i in users) {
                //             html += "<tr>";
                //             html += "<td>" + users[i].yhid + "</td>";
                //             html += "<td>" + users[i].yhxm + "</td>";
                //             html += "<td>" + users[i].yhkl + "</td>";
                //             html += "<td>" + users[i].yhxb + "</td>";
                //             html += "<td>" + users[i].yhbm + "</td>";
                //             html += "<td>" + users[i].csrq + "</td>";
                //             html += "<td>" + users[i].djsj + "</td>";
                //             html += "<td>" + users[i].djrq + "</td>";
                //             html += "<td>" + users[i].sfjy + "</td>";
                //             html += "<td>" + users[i].pxh + "</td>";
                //             html += "<td><img src=\"/jspTest/images/search.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                //             html += "<td><img src=\"/jspTest/images/modify.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                //             html += "<td><img src=\"/jspTest/images/delete.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                //             html += "</tr>";
                //         }
                //         $("#tbody").html(html);
                //     }
                // )
                $.ajax({
                    url: "/jspTest/queryServlet",
                    type: "get",
                    data:{
                        "yhzh": yhzh,
                        "yhbm": yhbm
                    },
                    dataType: "json",
                    success: function (users) {
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
                            html += "<td><img src=\"/jspTest/images/search.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                            html += "<td><img src=\"/jspTest/images/modify.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                            html += "<td><img src=\"/jspTest/images/delete.png\" width=\"30\" height=\"30\" style=\"cursor:pointer\"/></td>";
                            html += "</tr>";

                        }

                        $("#tbody").html(html);
                    }
                });
            }
        )

    }
)

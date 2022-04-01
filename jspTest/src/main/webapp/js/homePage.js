let mygrid;
$(function () {
    //构建dgrid表格
    initGrid();

    $("#query").click(function () {
        queryInfo();
    });

    $("#addUser").click(
        function () {
            addForm();
        }
    )
})

function initGrid() {
    mygrid = new dhtmlXGridObject('grid');
    mygrid.setImagePath(CONTEXT_PATH + "/resources/v2/static/plugg/dhtmlx/dhtmlxGrid/codebase/imgs/");
    mygrid.setHeader("#master_checkbox,账户,姓名,性别,部门,出生日期,登记日期,是否禁用,排序号,查看,修改,删除");
    // mygrid.setInitWidths("40,130,130,100,230,230,230,100,100,60,60,60");
    mygrid.setInitWidths("40,130,130,80,80,150,150,80,80,60,60,60");
    mygrid.setColTypes("ch,ro,ro,ro,ro,ro,ro,ro,ro,img,img,img");
    mygrid.setColAlign("center,center,center,center,center,center,center,center,center,center,center,center");
    mygrid.setColSorting("na,str,str,str,str,str,str,str,str,na,na,na");
    mygrid.setSkin("tdh_default");
    mygrid.pagingLayout("first,prev,page,next,last,limit,refresh,skip,count");
    mygrid.pagingLimits("10,20,50");
    mygrid.enablePagingon(true, 20);
    mygrid.init();
    mygrid.loadXML(CONTEXT_PATH + "/displayUserInfoServlet");
}

function addForm() {
    layer.open({
        type: 2,
        title: "新增",
        area: ['700px', '500px'],
        shadeClose: true, //点击遮罩关闭
        content: CONTEXT_PATH + "/addUser.jsp"
    });
}


function queryInfo() {
    let yhzh = $("#yhzh").val();
    let yhbm = $("#yhbm").val();

    if ((yhzh != null && yhzh !== "") || (yhbm != null && yhbm !== "")) {
        mygrid.loadXML(CONTEXT_PATH + "/queryServlet?yhzh=" + yhzh + "&yhbm=" + yhbm);
    }
}


function view(yhid) {
    // alert(user);
    layer.open({
        type: 2,
        title: "用户详细信息",
        area: ['700px', '500px'],
        shadeClose: true, //点击遮罩关闭
        content: CONTEXT_PATH + "/userInfo.jsp?yhid=" + encodeURIComponent(yhid),
    });
}


function modify(yhid) {
    $.getJSON("viewUserInfoServlet", {"yhid": yhid}, function (user) {
        console.log(user);
        let params = "yhid=" + encodeURIComponent(user.yhid);
        openLayerModal(CONTEXT_PATH + "/modify.jsp?" + params, "修改用户", "700", "500", "modifyCallBack");
    })
}

function modifyCallBack(rtn) {
    if (rtn === "1") {
        mygrid.loadPage();
    }
}


function bulkDeletion() {
    layer.confirm('确定删除这些数据吗？', {
        title: '删除提示',
        btn: ['确定', '取消'],
        btn1: function () {
            let gridlist = mygrid.getCheckedRows(0);

            if (gridlist == null || gridlist.length === 0) {
                layer.msg("还没选择任何信息", {
                    icon: 7,
                    shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                    time: 1000
                })
            } else {
                $.getJSON("bulkDeletionServlet", {del: gridlist}, function (isSucc) {
                    isSucc = $.trim(isSucc);
                    console.log(isSucc);
                    if (isSucc === "1") {
                        layer.msg("删除成功！", {
                            icon: 1,
                            shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                            time: 1000
                        }, function () {
                            mygrid.loadPage();
                        })
                    } else {
                        layer.msg("删除失败！", {
                            icon: 2,
                            shade: 0.000001, //不展示遮罩，但是要有遮罩效果
                            time: 1000
                        })
                    }
                });
            }
        },
        btn2: function () {
            layer.close();
        }
    })
}
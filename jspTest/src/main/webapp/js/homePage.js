let mygrid;
$(function () {
    //构建dgrid表格
    initGrid();

    $("#query").click(function () {
        queryInfo();
    });

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

function queryInfo() {
    let yhzh = $("#yhzh").val();
    let yhbm = $("#yhbm").val();

    if ((yhzh != null && yhzh !== "") || (yhbm != null && yhbm !== "")) {
        mygrid.loadXML(CONTEXT_PATH + "/queryServlet?yhzh=" + yhzh + "&yhbm=" + yhbm);
    }
}





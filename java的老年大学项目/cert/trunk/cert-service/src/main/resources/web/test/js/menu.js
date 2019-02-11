var menus = [
    // 00基础服务
    {
        name : "证书模板-新增和修改",
        url : "api/ctTemplate/save.do",
        path : "api/ctTemplate/save",
        clazz : "PP00"
    },{
        name : "证书模板-批量删除",
        url : "api/ctTemplate/deleteById.do",
        path : "api/ctTemplate/deleteById",
        clazz : "PP00"
    },{
        name : "证书模板-详情",
        url : "api/ctTemplate/queryById.do",
        path : "api/ctTemplate/queryById",
        clazz : "PP00"
    },{
        name : "证书模板-列表查询",
        url : "api/ctTemplate/queryManagePage.do",
        path : "api/ctTemplate/queryManagePage",
        clazz : "PP00"
    },{
        name : "证书模板-启用/取消启用",
        url : "api/ctTemplate/modifyStatus.do",
        path : "api/ctTemplate/modifyStatus",
        clazz : "PP00"
    },{
        name : "证书-新增和修改",
        url : "api/ctCert/save.do",
        path : "api/ctCert/save",
        clazz : "PP01"
    },{
        name : "证书-批量删除",
        url : "api/ctCert/deleteById.do",
        path : "api/ctCert/deleteById",
        clazz : "PP01"
    },{
        name : "证书-提交审核",
        url : "api/ctCert/submitCheck.do",
        path : "api/ctCert/submitCheck",
        clazz : "PP01"
    },{
        name : "证书-批量修改审核状态",
        url : "api/ctCert/check.do",
        path : "api/ctCert/check",
        clazz : "PP01"
    },{
        name : "证书-详情",
        url : "api/ctCert/queryById.do",
        path : "api/ctCert/queryById",
        clazz : "PP01"
    },{
        name : "证书-可管理列表查询",
        url : "api/ctCert/queryManagePage.do",
        path : "api/ctCert/queryManagePage",
        clazz : "PP01"
    },{
        name : "证书-可用列表查询",
        url : "api/ctCert/queryShowPage.do",
        path : "api/ctCert/queryShowPage",
        clazz : "PP01"
    },{
        name : "证书-主站下发列表查询",
        url : "api/ctCert/queryMainPage.do",
        path : "api/ctCert/queryMainPage",
        clazz : "PP01"
    },{
        name : "用户证书-新增用户证书",
        url : "api/ctUserCert/save.do",
        path : "api/ctUserCert/save",
        clazz : "PP02"
    },{
        name : "用户证书-证书学员列表",
        url : "api/ctUserCert/queryManagePage.do",
        path : "api/ctUserCert/queryManagePage",
        clazz : "PP02"
    },{
        name : "用户证书-学员证书列表查询",
        url : "api/ctUserCert/queryUserPage.do",
        path : "api/ctUserCert/queryUserPage",
        clazz : "PP02"
    },{
        name : "用户证书-批量发布/取消发布",
        url : "api/ctUserCert/publish.do",
        path : "api/ctUserCert/publish",
        clazz : "PP02"
    }
];


var tplMenus = [ '{@each menus as item}',
    '<button class="PP ${item.clazz}" data-url="${item.url}" ',
    ' data-path="${item.path}" data-opType=${item.opType} ',
    ' onclick="loadForm(this)">${item.name}</button>', '{@/each}' ]
    .join("");

function loadMenus(ftClass,ftCode,ftName) {
    try {
        var datas = [];
        if (ftClass || ftCode || ftName) {
            for (var i = 0, j = menus.length; i < j; i++) {
                var menu = menus[i];
                if(!menu.opType)
                    menu.opType = 0;
                if (ftName && ftName.length > 0
                    && menu.name.indexOf(ftName) >= 0) {
                    datas.push(menu);
                } else if (ftCode && ftCode.length > 0
                    && menu.url.indexOf(ftCode) >= 0) {
                    datas.push(menu);
                } else if (ftClass && ftClass.length > 0
                    && menu.clazz.indexOf(ftClass) >= 0) {
                    datas.push(menu);
                }
            }
        } else {
            datas = menus;
        }
        var html = juicer(tplMenus, {
            menus : datas
        });
        $("#TRAN_AREA").html(html);
    } catch (e) {
        alert(e);
    }
}

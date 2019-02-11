var menus = [
    // 00基础服务
    {
        name : "图片-站点可管理图片",
        url : "api/abmSitePhotoRel/queryPageBySiteId.do",
        path : "api/abmSitePhotoRel/queryPageBySiteId",
        clazz : "PP00"
    },{
        name : "图片-站点可用图片",
        url : "api/abmSitePhotoRel/queryPageByUse.do",
        path : "api/abmSitePhotoRel/queryPageByUse",
        clazz : "PP00"
    },{
        name : "图片-我的列表",
        url : "api/abmPhoto/queryPage.do",
        path : "api/abmPhoto/queryPage",
        clazz : "PP00"
    },{
        name : "图片-新增",
        url : "api/abmPhoto/save.do",
        path : "api/abmPhoto/save",
        clazz : "PP00"
    },{
        name : "图片-删除",
        url : "api/abmPhoto/delete.do",
        path : "api/abmPhoto/delete",
        clazz : "PP00"
<<<<<<< .mine
    },{
        name : "图片-查询",
        url : "api/abmPhoto/quaryById.do",
        path : "api/abmPhoto/quaryById",
        clazz : "PP00"
||||||| .r167
=======
    },{
        name : "图片-审核列表",
        url : "api/abmPhoto/auditPage.do",
        path : "api/abmPhoto/auditPage",
        clazz : "PP00"
    },{
        name : "图片-提交审核",
        url : "api/abmPhoto/submitAuditBatch.do",
        path : "api/abmPhoto/submitAuditBatch",
        clazz : "PP00"
    },{
        name : "图片-审核",
        url : "api/abmPhoto/auditBatch.do",
        path : "api/abmPhoto/auditBatch",
        clazz : "PP00"
>>>>>>> .r192
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

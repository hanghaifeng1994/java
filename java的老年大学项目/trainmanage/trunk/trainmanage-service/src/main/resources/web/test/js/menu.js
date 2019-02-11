var menus = [
    // 00基础服务
    //咨讯
    {
        name : "班级分类-列表",
        url : "api/clzCategory/queryPage.do",
        path : "api/clzCategory/queryPage",
        clazz : "PP00"
    },{
        name : "班级分类-保存",
        url : "api/clzCategory/save.do",
        path : "api/clzCategory/save",
        clazz : "PP00"
    },{
        name : "班级分类-删除",
        url : "api/clzCategory/delete.do",
        path : "api/clzCategory/delete",
        clazz : "PP00"
    },{
        name : "班级分类-详情",
        url : "api/clzCategory/queryById.do",
        path : "api/clzCategory/queryById",
        clazz : "PP00"
    },{
        name : "班级分类-修改",
        url : "api/clzCategory/update.do",
        path : "api/clzCategory/update",
        clazz : "PP00"
    },{
        name : "站点班级分类-列表",
        url : "api/clzSiteCategoryRel/queryPage.do",
        path : "api/clzSiteCategoryRel/queryPage",
        clazz : "PP00"
    },{
        name : "班级分类-批量显示隐藏",
        url : "api/clzSiteCategoryRel/showAndHideBatch.do",
        path : "api/clzSiteCategoryRel/showAndHideBatch",
        clazz : "PP00"
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

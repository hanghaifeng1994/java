var menus = [
    // 00基础服务
    {
        name : "客户学习记录-列表",
        url : "api/stdCustLearnRecord/queryPage.do",
        path : "api/stdCustLearnRecord/queryPage",
        clazz : "PP00"
    },{
        name : "客户学习记录-新增",
        url : "api/stdCustLearnRecord/insert.do",
        path : "api/stdCustLearnRecord/insert",
        clazz : "PP00"
    },{
        name : "客户学习记录-更新最新学习时间",
        url : "api/stdCustLearnRecord/updateById.do",
        path : "api/stdCustLearnRecord/updateById",
        clazz : "PP00"
    },{
        name : "客户学习课程-列表",
        url : "api/stdCustLearnCourse/queryPage.do",
        path : "api/stdCustLearnCourse/queryPage",
        clazz : "PP01"
    },{
        name : "客户学习章节-列表",
        url : "api/stdCustLearnChapter/queryPage.do",
        path : "api/stdCustLearnChapter/queryPage",
        clazz : "PP02"
    },{
        name : "学习对象统计-列表",
        url : "api/stdStudyObjectStatistics/queryPage.do",
        path : "api/stdStudyObjectStatistics/queryPage",
        clazz : "PP03"
    },{
        name : "学习对象统计-详情",
        url : "api/stdStudyObjectStatistics/queryById.do",
        path : "api/stdStudyObjectStatistics/queryById",
        clazz : "PP03"
    },{
        name : "用户扩展-列表",
        url : "api/stdCustExt/queryPage.do",
        path : "api/stdCustExt/queryPage",
        clazz : "PP04"
    },{
        name : "用户扩展-新增",
        url : "api/stdCustExt/insert.do",
        path : "api/stdCustExt/insert",
        clazz : "PP04"
    },{
        name : "用户扩展-详情",
        url : "api/stdCustExt/queryById.do",
        path : "api/stdCustExt/queryById",
        clazz : "PP04"
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

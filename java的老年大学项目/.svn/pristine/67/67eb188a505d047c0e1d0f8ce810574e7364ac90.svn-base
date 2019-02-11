var menus = [
    // 00基础服务
    //咨讯
    {
        name : "咨讯-管理员管理列表",
        url : "api/newsArticle/queryPage.do",
        path : "api/newsArticle/queryPage",
        clazz : "PP00"
    },{
        name : "咨讯-保存",
        url : "api/newsArticle/save.do",
        path : "api/newsArticle/save",
        clazz : "PP00"
    },{
        name : "咨讯-批量删除",
        url : "api/newsArticle/delete.do",
        path : "api/newsArticle/delete",
        clazz : "PP00"
    },{
        name : "咨讯-详情",
        url : "api/newsArticle/queryById.do",
        path : "api/newsArticle/queryById",
        clazz : "PP00"
    },{
        name : "咨讯-提交审核",
        url : "api/newsArticle/subAudit.do",
        path : "api/newsArticle/subAudit",
        clazz : "PP00"
    },{
        name : "咨讯-审核",
        url : "api/newsArticle/audit.do",
        path : "api/newsArticle/audit",
        clazz : "PP00"
    },{
        name : "咨讯-发布/取消发布",
        url : "api/newsArticle/publish.do",
        path : "api/newsArticle/publish",
        clazz : "PP00"
    },{
        name : "咨讯-推荐/取消推荐",
        url : "api/newsArticle/recommend.do",
        path : "api/newsArticle/recommend",
        clazz : "PP00"
    },{
        name : "咨讯-置顶列表",
        url : "api/newsArticle/queryTopPage.do",
        path : "api/newsArticle/queryTopPage",
        clazz : "PP00"
    },{
        name : "咨讯-置顶/取消置顶",
        url : "api/newsArticle/top.do",
        path : "api/newsArticle/top",
        clazz : "PP00"
    },{
        name : "咨讯-主站下发列表",
        url : "api/newsArticle/lowerSendPage.do",
        path : "api/newsArticle/lowerSendPage",
        clazz : "PP00"
    },{
        name : "咨讯-栏目咨讯列表",
        url : "api/newsArticle/queryPageByCatIds.do",
        path : "api/newsArticle/queryPageByCatIds",
        clazz : "PP00"
    },{
        name : "咨讯-列表（id查询）",
        url : "api/newsArticle/queryPageByIds.do",
        path : "api/newsArticle/queryPageByIds",
        clazz : "PP00"
    },{
        name : "栏目-列表",
        url : "api/newsCategory/queryPage.do",
        path : "api/newsCategory/queryPage",
        clazz : "PP01"
    },{
        name : "栏目-详情",
        url : "api/newsCategory/queryById.do",
        path : "api/newsCategory/queryById",
        clazz : "PP01"
    },{
        name : "栏目-保存",
        url : "api/newsCategory/save.do",
        path : "api/newsCategory/save",
        clazz : "PP01"
    },{
        name : "栏目-删除",
        url : "api/newsCategory/deleteById.do",
        path : "api/newsCategory/deleteById",
        clazz : "PP01"
    },{
        name : "栏目-可用分类",
        url : "api/newsCategory/queryShowPage.do",
        path : "api/newsCategory/queryShowPage",
        clazz : "PP01"
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

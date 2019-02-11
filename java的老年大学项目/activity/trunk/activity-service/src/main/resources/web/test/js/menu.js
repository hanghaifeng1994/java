
var menus = [
    // 00基础服务
    {
        name : "活动-可管理的活动列表查询",
        url : "api/actActivity/queryPage.do",
        path : "api/actActivity/queryPage",
        clazz : "PP00"
    },{
        name : "活动-列表(按条件查询)",
        url : "api/actActivity/queryPageByCriteria.do",
        path : "api/actActivity/queryPageByCriteria",
        clazz : "PP00"
    },{
        name : "活动-我参加的列表",
        url : "api/actActivity/myQueryPage.do",
        path : "api/actActivity/myQueryPage",
        clazz : "PP00"
    },{
        name : "活动-新增和修改保存",
        url : "api/actActivity/save.do",
        path : "api/actActivity/save",
        clazz : "PP00"
    },{
        name : "活动-批量删除",
        url : "api/actActivity/delete.do",
        path : "api/actActivity/delete",
        clazz : "PP00"
    },{
        name : "活动-详情获取-前后台共用",
        url : "api/actActivity/queryById.do",
        path : "api/actActivity/queryById",
        clazz : "PP00"
    },{
        name : "活动-提交审核",
        url : "api/actActivity/sumbitAudit.do",
        path : "api/actActivity/sumbitAudit",
        clazz : "PP00"
    },{
        name : "活动-审核",
        url : "api/actActivity/audit.do",
        path : "api/actActivity/audit",
        clazz : "PP00"
    },{
        name : "批量发布、取消发布",
        url : "api/actActivity/publish.do",
        path : "api/actActivity/publish",
        clazz : "PP00"
    },
    {
        name : "活动-主站下发子站活动列表",
        url : "api/actActivity/sendLowerPage.do",
        path : "api/actActivity/sendLowerPage",
        clazz : "PP00"
    },{
        name : "活动-站点可用活动列表",
        url : "api/actActivity/queryPageUse.do",
        path : "api/actActivity/queryPageUse",
        clazz : "PP00"
    },{
        name : "活动-是否报名",
        url : "api/actActivityMemer/isSignUp.do",
        path : "api/actActivityMemer/isSignUp",
        clazz : "PP00"
    },{
        name : "活动-活动报名",
        url : "api/actActivityMemer/signUp.do",
        path : "api/actActivityMemer/signUp",
        clazz : "PP00"
    },{
        name : "活动-活动人员列表",
        url : "api/actActivityMemer/personPage.do",
        path : "api/actActivityMemer/personPage",
        clazz : "PP00"
    }
    ,{
        name : "活动作品-详情",
        url : "api/actActivityWorks/queryById.do",
        path : "api/actActivityWorks/queryById",
        clazz : "PP01"
    },{
        name : "活动作品-删除",
        url : "api/actActivityWorks/delete.do",
        path : "api/actActivityWorks/delete",
        clazz : "PP01"
    },{
        name : "活动作品-我的列表",
        url : "api/actActivityWorks/queryPage.do",
        path : "api/actActivityWorks/queryPage",
        clazz : "PP01"
    },{
        name : "活动作品-根据活动查询",
        url : "api/actActivityWorks/queryPageByActId.do",
        path : "api/actActivityWorks/queryPageByActId",
        clazz : "PP01"
    },{
        name : "活动作品-新增和修改保存-前后台共用",
        url : "api/actActivityWorks/save.do",
        path : "api/actActivityWorks/save",
        clazz : "PP01"
    },{
        name : "活动作品-提交审核",
        url : "api/actActivityWorks/sumbitAudit.do",
        path : "api/actActivityWorks/sumbitAudit",
        clazz : "PP01"
    },{
        name : "活动作品-审核",
        url : "api/actActivityWorks/audit.do",
        path : "api/actActivityWorks/audit",
        clazz : "PP01"
    },{
        name : "活动作品打分-打分记录列表",
        url : "api/actMarking/queryPage.do",
        path : "api/actMarking/queryPage",
        clazz : "PP01"
    }, {
        name : "活动作品打分-新增和修改打分保存",
        url : "api/actMarking/save.do",
        path : "api/actMarking/save",
        clazz : "PP01"
    },{
        name : "活动成果-活动列表查询-前后台公用",
        url : "api/actResults/queryPage.do",
        path : "api/actResults/queryPage",
        clazz : "PP02"
    },{
        name : "活动成果-新增和修改保存-前后台共用",
        url : "api/actResults/save.do",
        path : "api/actResults/save",
        clazz : "PP02"
    },{
        name : "活动成果-批量删除",
        url : "api/actResults/delete.do",
        path : "api/actResults/delete",
        clazz : "PP02"
    },{
        name : "活动成果-详情获取-前后台共用",
        url : "api/actResults/queryById.do",
        path : "api/actResults/queryById",
        clazz : "PP02"
    },{
        name : "活动成果-提交审核",
        url : "api/actResults/sumbitAudit.do",
        path : "api/actResults/sumbitAudit",
        clazz : "PP02"
    },{
        name : "活动成果-修改审核状态",
        url : "api/actResults/audit.do",
        path : "api/actResults/audit",
        clazz : "PP02"
    },{
        name : "活动分类-删除",
        url : "api/actCategory/deleteById.do",
        path : "api/actCategory/deleteById",
        clazz : "PP02"
    },{
        name : "活动分类-详情",
        url : "api/actCategory/queryById.do",
        path : "api/actCategory/queryById",
        clazz : "PP02"
    },{
        name : "活动分类-保存",
        url : "api/actCategory/save.do",
        path : "api/actCategory/save",
        clazz : "PP02"
    },{
        name : "活动分类-列表",
        url : "api/actCategory/queryPage.do",
        path : "api/actCategory/queryPage",
        clazz : "PP02"
    },{
        name : "活动分类-可用列表",
        url : "api/actCategory/queryPageUse.do",
        path : "api/actCategory/queryPageUse",
        clazz : "PP02"
    },{
        name : "活动分类-修改",
        url : "api/actCategory/update.do",
        path : "api/actCategory/update",
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

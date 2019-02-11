
var menus = [
    // 00基础服务
    {
        name : "学习小组分类-管理列表",
        url : "api/sgpCategory/queryPage.do",
        path : "api/sgpCategory/queryPage",
        clazz : "PP00"
    },{
        name : "学习小组分类-保存",
        url : "api/sgpCategory/save.do",
        path : "api/sgpCategory/save",
        clazz : "PP00"
    },{
        name : "学习小组分类-修改",
        url : "api/sgpCategory/update.do",
        path : "api/sgpCategory/update",
        clazz : "PP00"
    },{
        name : "学习小组分类-批量删除",
        url : "api/sgpCategory/delete.do",
        path : "api/sgpCategory/delete",
        clazz : "PP00"
    },{
        name : "学习小组分类-详情",
        url : "api/sgpCategory/queryById.do",
        path : "api/sgpCategory/queryById",
        clazz : "PP00"
    },{
        name : "学习小组分类-批量显示隐藏",
        url : "api/sgpSiteCategory/showAndHideBatch.do",
        path : "api/sgpSiteCategory/showAndHideBatch",
        clazz : "PP00"
    },{
        name : "站点小组分类-列表",
        url : "api/sgpSiteCategory/queryPage.do",
        path : "api/sgpSiteCategory/queryPage",
        clazz : "PP00"
    },{
        name : "小组-可管理的小组列表查询",
        url : "api/sgpStudyGroup/queryPage.do",
        path : "api/sgpStudyGroup/queryPage",
        clazz : "PP01"
    },{
        name : "学习小组-删除",
        url : "api/sgpStudyGroup/delete.do",
        path : "api/sgpStudyGroup/delete",
        clazz : "PP01"
    },{
        name : "学习小组-新增和修改保存-前台",
        url : "api/sgpStudyGroup/save.do",
        path : "api/sgpStudyGroup/save",
        clazz : "PP01"
    },{
        name : "学习小组-详情",
        url : "api/sgpStudyGroup/queryById.do",
        path : "api/sgpStudyGroup/queryById",
        clazz : "PP01"
    },{
        name : "学习小组-提交审核",
        url : "api/sgpStudyGroup/sumbitAudit.do",
        path : "api/sgpStudyGroup/sumbitAudit",
        clazz : "PP01"
    },{
        name : "学习小组-修改审核状态",
        url : "api/sgpStudyGroup/audit.do",
        path : "api/sgpStudyGroup/audit",
        clazz : "PP01"
    },{
        name : "学习小组-主站下发到子站的小组列表",
        url : "api/sgpStudyGroup/sendLowerPage.do",
        path : "api/sgpStudyGroup/sendLowerPage",
        clazz : "PP01"
    },{
        name : "学习小组-可被拉取列表",
        url : "api/sgpStudyGroup/pullGroupPage.do",
        path : "api/sgpStudyGroup/pullGroupPage",
        clazz : "PP01"
    },{
        name : "学习小组-站点的可用小组列表-f",
        url : "api/sgpSiteStudygroupRel/queryPageUse.do",
        path : "api/sgpSiteStudygroupRel/queryPageUse",
        clazz : "PP01"
    },{
        name : "学习小组-小组成员列表",
        url : "api/sgpMember/queryPage.do",
        path : "api/sgpMember/queryPage",
        clazz : "PP01"
    },{
        name : "学习小组-加入小组",
        url : "api/sgpMember/joinTeam.do",
        path : "api/sgpMember/joinTeam",
        clazz : "PP01"
    },{
        name : "学习小组-学员是否参加小组",
        url : "api/sgpMember/isJoin.do",
        path : "api/sgpMember/isJoin",
        clazz : "PP01"
    },{
        name : "学习小组-我参加的小组列表",
        url : "api/sgpMember/myQueryPage.do",
        path : "api/sgpMember/myQueryPage",
        clazz : "PP01"
    },{
        name : "小组才艺-列表",
        url : "api/sgpStudyGroupTalent/queryPage.do",
        path : "api/sgpStudyGroupTalent/queryPage",
        clazz : "PP01"
    },{
        name : "小组才艺-保存",
        url : "api/sgpStudyGroupTalent/save.do",
        path : "api/sgpStudyGroupTalent/save",
        clazz : "PP01"
    },{
        name : "经验-小组经验列表",
        url : "api/sgpStudyGroupExperience/queryPage.do",
        path : "api/sgpStudyGroupExperience/queryPage",
        clazz : "PP01"
    },{
        name : "新增小组经验",
        url : "api/sgpStudyGroupExperience/save.do",
        path : "api/sgpStudyGroupExperience/save",
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

var menus = [
    // 00基础服务
    {
        name : "课程作业-可管理作业列表查询-前后台共用",
        url : "api/wkHomework/queryManagePage.do",
        path : "api/wkHomework/queryManagePage",
        clazz : "PP00"
    },{
        name : "新增和修改作业保存",
        url : "api/wkHomework/save.do",
        path : "api/wkHomework/save",
        clazz : "PP00"
    },{
        name : "批量删除",
        url : "api/wkHomework/deleteById.do",
        path : "api/wkHomework/deleteById",
        clazz : "PP00"
    },{
        name : "详情获取",
        url : "api/wkHomework/queryById.do",
        path : "api/wkHomework/queryById",
        clazz : "PP00"
    },{
        name : "根据ids获取作业对象列表",
        url : "api/wkHomework/detail.do",
        path : "api/wkHomework/detail",
        clazz : "PP00"
    },{
        name : "批量发布、取消发布",
        url : "api/wkHomework/publish.do",
        path : "api/wkHomework/publish",
        clazz : "PP00"
    },{
        name : "用户课程作业列表-带状态",
        url : "api/wkUserHomework/userHomework.do",
        path : "api/wkUserHomework/userHomework",
        clazz : "PP01"
    },{
        name : "用户作业详细",
        url : "api/wkUserHomework/detail.do",
        path : "api/wkUserHomework/detail",
        clazz : "PP01"
    },{
        name : "作业反馈-新增和修改保存作业反馈",
        url : "api/wkUserHomework/save.do",
        path : "api/wkUserHomework/save",
        clazz : "PP01"
    },{
        name : "作业反馈-作业提交记录列表查询",
        url : "api/wkUserHomework/queryUserSubmit.do",
        path : "api/wkUserHomework/queryUserSubmit",
        clazz : "PP01"
    },{
        name : "后台所有用户提交的作业列表 --用于老师查义作业进行打分",
        url : "api/wkUserHomework/querySumbitPage.do",
        path : "api/wkUserHomework/querySumbitPage",
        clazz : "PP01"
    },{
        name : "作业提交",
        url : "api/wkUserHomework/submit.do",
        path : "api/wkUserHomework/submit",
        clazz : "PP01"
    },{
        name : "批阅评分/评星",
        url : "api/wkUserHomework/score.do",
        path : "api/wkUserHomework/score",
        clazz : "PP01"
    },{
        name : "新增/编辑作业附件",
        url : "api/wkHomeworkAttachment/save.do",
        path : "api/wkHomeworkAttachment/save",
        clazz : "PP02"
    },{
        name : "作业附件详细",
        url : "api/wkHomeworkAttachment/queryById.do",
        path : "api/wkHomeworkAttachment/queryById",
        clazz : "PP02"
    },{
        name : "作业附件详删除",
        url : "api/wkHomeworkAttachment/deleteById.do",
        path : "api/wkHomeworkAttachment/deleteById",
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

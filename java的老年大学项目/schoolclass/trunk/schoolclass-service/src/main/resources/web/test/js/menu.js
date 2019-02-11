var menus = [
    // 00基础服务
    {
        name : "新增班级课程	保存",
        url : "api/clzClazzCourse/save.do",
        path : "api/clzClazzCourse/save",
        clazz : "PP00"
    },{
        name : "班级课程列表查询-前后台共用",
        url : "api/clzClazzCourse/queryShowPage.do",
        path : "api/clzClazzCourse/queryShowPage",
        clazz : "PP00"
    },{
        name : "批量删除班级课程",
        url : "api/clzClazzCourse/deleteById.do",
        path : "api/clzClazzCourse/deleteById",
        clazz : "PP00"
    },{
        name : "班级学员列表-前后台共用",
        url : "api/clzStudentClazz/queryShowPage.do",
        path : "api/clzStudentClazz/queryShowPage",
        clazz : "PP01"
    },{
        name : "报名",
        url : "api/clzStudentClazz/signup.do",
        path : "api/clzStudentClazz/signup",
        clazz : "PP01"
    },{
        name : "判断用户是否参加了班级-前台",
        url : "api/clzStudentClazz/signuped.do",
        path : "api/clzStudentClazz/signuped",
        clazz : "PP01"
    },{
        name : "获取学员在班级的身份",
        url : "api/clzStudentClazz/GetUserAuth.do",
        path : "api/clzStudentClazz/GetUserAuth",
        clazz : "PP01"
    },{
        name : "批量导入学员",
        url : "api/clzStudentClazz/importStudent.do",
        path : "api/clzStudentClazz/importStudent",
        clazz : "PP01"
    },{
        name : "批量添加学员(不加课程)",
        url : "api/clzStudentClazz/batchAddStudent.do",
        path : "api/clzStudentClazz/batchAddStudent",
        clazz : "PP01"
    },{
        name : "学员班级列表（我的班级）",
        url : "api/clzStudentClazz/queryUserClazzPage.do",
        path : "api/clzStudentClazz/queryUserClazzPage",
        clazz : "PP01"
    },{
        name : "学员班级课程列表-带进度",
        url : "api/clzUserClazzCourse/queryUserClazzCoursePage.do",
        path : "api/clzUserClazzCourse/queryUserClazzCoursePage",
        clazz : "PP01"
    },{
        name : "班级测验列表",
        url : "api/clzClazzTest/testList.do",
        path : "api/clzClazzTest/testList",
        clazz : "PP02"
    },{
        name : "新增班级测验关系",
        url : "api/clzClazzTest/addTest.do",
        path : "api/clzClazzTest/addTest",
        clazz : "PP02"
    },{
        name : "删除班级测验关系",
        url : "api/clzClazzTest/delTest.do",
        path : "api/clzClazzTest/delTest",
        clazz : "PP02"
    },{
        name : "可管理班级列表查询",
        url : "api/clzClazz/queryPageManger.do",
        path : "api/clzClazz/queryPageManger",
        clazz : "PP03"
    },{
        name : "新增修改保存",
        url : "api/clzClazz/save.do",
        path : "api/clzClazz/save",
        clazz : "PP03"
    },{
        name : "批量删除",
        url : "api/clzClazz/delete.do",
        path : "api/clzClazz/delete",
        clazz : "PP03"
    },{
        name : "详情获取-前后台共用",
        url : "api/clzClazz/queryById.do",
        path : "api/clzClazz/queryById",
        clazz : "PP03"
    },{
        name : "批量发布、取消发布",
        url : "api/clzClazz/publish.do",
        path : "api/clzClazz/publish",
        clazz : "PP03"
    },{
        name : "主站下发到子站点班级列表查询",
        url : "api/clzClazz/sendLowerPage.do",
        path : "api/clzClazz/sendLowerPage",
        clazz : "PP03"
    },{
        name : "批量推荐和取消推荐",
        url : "api/clzClazz/recommend.do",
        path : "api/clzClazz/recommend",
        clazz : "PP03"
    },{
        name : "站点的可用班级列表-f",
        url : "api/clzClazz/queryPageUse.do",
        path : "api/clzClazz/queryPageUse",
        clazz : "PP03"
    },{
        name : "管理班级分类列表查询",
        url : "api/clzCategory/queryPage.do",
        path : "api/clzCategory/queryPage",
        clazz : "PP04"
    },{
        name : "管理班级分类新增修改保存",
        url : "api/clzCategory/save.do",
        path : "api/clzCategory/save",
        clazz : "PP04"
    },{
        name : "管理班级分类详情",
        url : "api/clzCategory/queryById.do",
        path : "api/clzCategory/queryById",
        clazz : "PP04"
    },{
        name : "管理班级分类批量删除",
        url : "api/clzCategory/delete.do",
        path : "api/clzCategory/delete",
        clazz : "PP04"
    },{
        name : "站点班级分类列表-f",
        url : "api/clzCategory/queryPageUse.do",
        path : "api/clzCategory/queryPageUse",
        clazz : "PP04"
    },{
        name : "班级分类批量显示隐藏",
        url : "api/clzSiteCategoryRel/show.do",
        path : "api/clzSiteCategoryRel/show",
        clazz : "PP04"
    },{
        name : "班级日程新增",
        url : "api/clzClazzSchedule/insert.do",
        path : "api/clzClazzSchedule/insert",
        clazz : "PP05"
    },{
        name : "班级日程修改",
        url : "api/clzClazzSchedule/updateById.do",
        path : "api/clzClazzSchedule/updateById",
        clazz : "PP05"
    },{
        name : "班级日程列表",
        url : "api/clzClazzSchedule/queryPage.do",
        path : "api/clzClazzSchedule/queryPage",
        clazz : "PP05"
    },{
        name : "班级日程详情",
        url : "api/clzClazzSchedule/queryById.do",
        path : "api/clzClazzSchedule/queryById",
        clazz : "PP05"
    },{
        name : "班级日程上课",
        url : "api/clzClazzSchedule/attendClass.do",
        path : "api/clzClazzSchedule/attendClass",
        clazz : "PP05"
    },{
        name : "班级日程当前日程",
        url : "api/clzClazzSchedule/queryNowSchedule.do",
        path : "api/clzClazzSchedule/queryNowSchedule",
        clazz : "PP05"
    },{
        name : "学员的日程列表",
        url : "api/clzClazzSchedule/queryListByStudent.do",
        path : "api/clzClazzSchedule/queryListByStudent",
        clazz : "PP05"
    },{
        name : "专家的日程列表",
        url : "api/clzClazzSchedule/queryListByTearcher.do",
        path : "api/clzClazzSchedule/queryListByTearcher",
        clazz : "PP05"
    },{
        name : "班级日程统计(统计已结束课程)",
        url : "api/clzClazzSchedule/scheduleCount.do",
        path : "api/clzClazzSchedule/scheduleCount",
        clazz : "PP05"
    },{
        // scheduleParRateCount
        name : "班级-出勤率统计",
        url : "api/clzClazzSign/scheduleParRateCount.do",
        path : "api/clzClazzSign/scheduleParRateCount",
        clazz : "PP05"
    },{
        // scheduleParRateCount
        name : "班级-出勤率统计(饼图)",
        url : "api/clzClazzSign/ClzParRateCount.do",
        path : "api/clzClazzSign/ClzParRateCount",
        clazz : "PP05"
    },{
        name : "学员签到列表",
        url : "api/clzClazzSign/queryPage.do",
        path : "api/clzClazzSign/queryPage",
        clazz : "PP05"
    },{
        name : "学员签到详情",
        url : "api/clzClazzSign/queryByCzScIdAndCustId.do",
        path : "api/clzClazzSign/queryByCzScIdAndCustId",
        clazz : "PP05"
    },{
        name : "学员上课签到",
        url : "api/clzClazzSign/signIn.do",
        path : "api/clzClazzSign/signIn",
        clazz : "PP05"
    },{
        name : "学员下课签到",
        url : "api/clzClazzSign/signOff.do",
        path : "api/clzClazzSign/signOff",
        clazz : "PP05"
    },{
        name : "班级-咨讯-新增",
        url : "api/clzClazzNews/save.do",
        path : "api/clzClazzNews/save",
        clazz : "PP05"
    },{
        name : "班级-咨讯-列表",
        url : "api/clzClazzNews/queryPage.do",
        path : "api/clzClazzNews/queryPage",
        clazz : "PP05"
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

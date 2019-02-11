var menus = [
    // 00基础服务
    {
        name : "课程分类-新增和修改",
        url : "api/crsCatalog/save.do",
        path : "api/crsCatalog/save",
        clazz : "PP00"
    },{
        name : "课程分类-批量删除",
        url : "api/crsCatalog/deleteById.do",
        path : "api/crsCatalog/deleteById",
        clazz : "PP00"
    },{
        name : "课程分类-详情",
        url : "api/crsCatalog/queryById.do",
        path : "api/crsCatalog/queryById",
        clazz : "PP00"
    },{
        name : "课程分类-可管理列表查询",
        url : "api/crsCatalog/queryManagePage.do",
        path : "api/crsCatalog/queryManagePage",
        clazz : "PP00"
    },{
        name : "课程分类-可用分类列表查询",
        url : "api/crsCatalog/queryShowPage.do",
        path : "api/crsCatalog/queryShowPage",
        clazz : "PP00"
    },{
        name : "课程-新增和修改",
        url : "api/crsCourse/save.do",
        path : "api/crsCourse/save",
        clazz : "PP01"
    },{
        name : "课程-批量删除",
        url : "api/crsCourse/deleteById.do",
        path : "api/crsCourse/deleteById",
        clazz : "PP01"
    },{
        name : "课程-批量发布/取消发布",
        url : "api/crsCourse/publish.do",
        path : "api/crsCourse/publish",
        clazz : "PP01"
    },{
        name : "课程-批量推荐/取消推荐",
        url : "api/crsCourse/tj.do",
        path : "api/crsCourse/tj",
        clazz : "PP01"
    },{
        name : "课程-提交审核",
        url : "api/crsCourse/submitCheck.do",
        path : "api/crsCourse/submitCheck",
        clazz : "PP01"
    },{
        name : "课程-批量修改审核状态",
        url : "api/crsCourse/check.do",
        path : "api/crsCourse/check",
        clazz : "PP01"
    },{
        name : "课程-详情",
        url : "api/crsCourse/queryById.do",
        path : "api/crsCourse/queryById",
        clazz : "PP01"
    },{
        name : "课程-关联辅导老师",
        url : "api/csrCourseTutorRel/addTutor.do",
        path : "api/csrCourseTutorRel/addTutor",
        clazz : "PP01"
    },{
        name : "课程-删除辅导老师",
        url : "api/csrCourseTutorRel/delTutor.do",
        path : "api/csrCourseTutorRel/delTutor",
        clazz : "PP01"
    },{
        name : "课程-可管理列表查询",
        url : "api/crsCourse/queryManagePage.do",
        path : "api/crsCourse/queryManagePage",
        clazz : "PP01"
    },{
        name : "课程-可用列表查询",
        url : "api/crsCourse/queryShowPage.do",
        path : "api/crsCourse/queryShowPage",
        clazz : "PP01"
    },{
        name : "课程-主站下发列表查询",
        url : "api/crsCourse/queryMainPage.do",
        path : "api/crsCourse/queryMainPage",
        clazz : "PP01"
    },{
        name : "课程-根据课程id参数课程列表",
        url : "api/crsCourse/detail.do",
        path : "api/crsCourse/detail",
        clazz : "PP01"
    },{
        name : "课程-批量选课和取消选课",
        url : "api/crsCustLearnCourse/addUserCourse.do",
        path : "api/crsCustLearnCourse/addUserCourse",
        clazz : "PP01"
    },{
        name : "课程-	用户的课程列表-带进度",
        url : "api/crsCustLearnCourse/queryUserCoursePage.do",
        path : "api/crsCustLearnCourse/queryUserCoursePage",
        clazz : "PP01"
    },{
        name : "课程-课程最近学习人员",
        url : "api/crsCustLearnCourse/queryUserPage.do",
        path : "api/crsCustLearnCourse/queryUserPage",
        clazz : "PP01"
    },{
        name : "课程章节-新增和修改",
        url : "api/crsChapter/save.do",
        path : "api/crsChapter/save",
        clazz : "PP02"
    },{
        name : "课程章节-批量删除",
        url : "api/crsChapter/deleteById.do",
        path : "api/crsChapter/deleteById",
        clazz : "PP02"
    },{
        name : "课程章节-详情",
        url : "api/crsChapter/queryById.do",
        path : "api/crsChapter/queryById",
        clazz : "PP02"
    },{
        name : "课程章节-列表",
        url : "api/crsChapter/chapterList.do",
        path : "api/crsChapter/chapterList",
        clazz : "PP02"
    },{
        name : "课程章节-树目录",
        url : "api/crsChapter/treeList.do",
        path : "api/crsChapter/treeList",
        clazz : "PP02"
    },{
        name : "课程章节-关联资源",
        url : "api/crsChapterResourceRel/addResource.do",
        path : "api/crsChapterResourceRel/addResource",
        clazz : "PP02"
    },{
        name : "课程章节-删除资源",
        url : "api/crsChapterResourceRel/delResource.do",
        path : "api/crsChapterResourceRel/delResource",
        clazz : "PP02"
    },{
        name : "课程章节资源列表",
        url : "api/crsChapterResourceRel/queryResources.do",
        path : "api/crsChapterResourceRel/queryResources",
        clazz : "PP02"
    },{
        name : "课程作业-列表",
        url : "api/crsCourseHomework/homeworkList.do",
        path : "api/crsCourseHomework/homeworkList",
        clazz : "PP03"
    },{
        name : "课程作业-关联作业",
        url : "api/crsCourseHomework/addHomework.do",
        path : "api/crsCourseHomework/addHomework",
        clazz : "PP03"
    },{
        name : "课程作业-删除作业",
        url : "api/crsCourseHomework/delHomework.do",
        path : "api/crsCourseHomework/delHomework",
        clazz : "PP03"
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

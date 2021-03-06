var menus = [
    // 00基础服务
    {
        name : "题库-可管理题库列表",
        url : "api/testingQuestionPool/queryPage.do",
        path : "api/testingQuestionPool/queryPage",
        clazz : "PP00"
    },{
        name : "题库-新增修改保存",
        url : "api/testingQuestionPool/save.do",
        path : "api/testingQuestionPool/save",
        clazz : "PP00"
    },{
        name : "题库-删除",
        url : "api/testingQuestionPool/deleteByIds.do",
        path : "api/testingQuestionPool/deleteByIds",
        clazz : "PP00"
    },{
        name : "题库-详情",
        url : "api/testingQuestionPool/queryById.do",
        path : "api/testingQuestionPool/queryById",
        clazz : "PP00"
    },{
        name : "题库-主站下发子站列表",
        url : "api/testingQuestionPool/sendLowerPage.do",
        path : "api/testingQuestionPool/sendLowerPage",
        clazz : "PP00"
    },{
        name : "题库章节列表",
        url : "api/testingQuestionSection/queryList.do",
        path : "api/testingQuestionSection/queryList",
        clazz : "PP00"
    },{
        name : "题库章节保存",
        url : "api/testingQuestionSection/save.do",
        path : "api/testingQuestionSection/save",
        clazz : "PP00"
    },{
        name : "题库章节详情",
        url : "api/testingQuestionSection/queryById.do",
        path : "api/testingQuestionSection/queryById",
        clazz : "PP00"
    },{
        name : "题库章节批量删除",
        url : "api/testingQuestionSection/delete.do",
        path : "api/testingQuestionSection/delete",
        clazz : "PP00"
    },{
        name : "题库题目列表",
        url : "api/testingQuestion/queryPageExt.do",
        path : "api/testingQuestion/queryPageExt",
        clazz : "PP00"
    },{
        name : "题库题目新增修改保存",
        url : "api/testingQuestion/save.do",
        path : "api/testingQuestion/save",
        clazz : "PP00"
    },{
        name : "题库题目详情获取",
        url : "api/testingQuestion/queryById.do",
        path : "api/testingQuestion/queryById",
        clazz : "PP00"
    },{
        name : "题库题目批量删除",
        url : "api/testingQuestion/delete.do",
        path : "api/testingQuestion/delete",
        clazz : "PP00"
    },{
        name : "商户基础题型获取",
        url : "api/testingItemTypes/queryList.do",
        path : "api/testingItemTypes/queryList",
        clazz : "PP01"
    },{
        name : "题库题型类别数量获取",
        url : "api/testingQuestion/queryItemTypes.do",
        path : "api/testingQuestion/queryItemTypes",
        clazz : "PP01"
    },{
        name : "组卷规则新增和修改保存",
        url : "api/testingPaperRule/save.do",
        path : "api/testingPaperRule/save",
        clazz : "PP01"
    },{
        name : "组卷规则列表",
        url : "api/testingPaperRule/queryManagePage.do",
        path : "api/testingPaperRule/queryManagePage",
        clazz : "PP01"
    },{
        name : "组卷规则信息获取",
        url : "api/testingPaperRule/queryById.do",
        path : "api/testingPaperRule/queryById",
        clazz : "PP01"
    },{
        name : "题型组卷规则新增和保存",
        url : "api/testingQuestionitemRule/save.do",
        path : "api/testingQuestionitemRule/save",
        clazz : "PP01"
    },{
        name : "题型组卷规则列表",
        url : "api/testingQuestionitemRule/queryManageList.do",
        path : "api/testingQuestionitemRule/queryManageList",
        clazz : "PP01"
    },{
        name : "题型组卷规则获取",
        url : "api/testingQuestionitemRule/queryById.do",
        path : "api/testingQuestionitemRule/queryById",
        clazz : "PP01"
    },{
        name : "组卷",
        url : "api/testingPaperRule/saveGenPaper.do",
        path : "api/testingPaperRule/saveGenPaper",
        clazz : "PP01"
    },{
        name : "测验可管理列表",
        url : "api/testingTest/queryPage.do",
        path : "api/testingTest/queryPage",
        clazz : "PP02"
    },{
        name : "测验新增修改保存",
        url : "api/testingTest/save.do",
        path : "api/testingTest/save",
        clazz : "PP02"
    },{
        name : "测验批量删除",
        url : "api/testingTest/delete.do",
        path : "api/testingTest/delete",
        clazz : "PP02"
    },{
        name : "测验详情获取",
        url : "api/testingTest/queryById.do",
        path : "api/testingTest/queryById",
        clazz : "PP02"
    },{
        name : "获取学员测试卷子",
        url : "api/testingStudentPaper/queryStudentPaper.do",
        path : "api/testingStudentPaper/queryStudentPaper",
        clazz : "PP03"
    },{
        name : "学员测验-答题",
        url : "api/testingStudentPaper/savePaperQuestion.do",
        path : "api/testingStudentPaper/savePaperQuestion",
        clazz : "PP03"
    },{
        name : "学员测验-交卷",
        url : "api/testingStudentPaper/saveStudentPaper.do",
        path : "api/testingStudentPaper/saveStudentPaper",
        clazz : "PP03"
    },{
        name : "学员测验成绩列表",
        url : "api/testingStudentTest/queryUserTestings.do",
        path : "api/testingStudentTest/queryUserTestings",
        clazz : "PP03"
    },{
        name : "学员所有测验成绩列表-带分页",
        url : "api/testingStudentTest/queryShowPage.do",
        path : "api/testingStudentTest/queryShowPage",
        clazz : "PP03"
    },{
        name : "研讯通问卷调查答卷",
        url : "api/testingAnswerPaperQuestion/answerPaper.do",
        path : "api/testingAnswerPaperQuestion/answerPaper",
        clazz : "PP04"
    },{
        name : "研讯通问卷调查-是否已答卷",
        url : "api/testingAnswerPaperQuestion/isAnswer.do",
        path : "api/testingAnswerPaperQuestion/isAnswer",
        clazz : "PP04"
    },{
        name : "研讯通问卷调查-分值统计",
        url : "api/testingAnswerPaperQuestion/dataCount.do",
        path : "api/testingAnswerPaperQuestion/dataCount",
        clazz : "PP04"
    },{
        name : "研讯通问卷调查-满意度调查",
        url : "api/testingAnswerPaperQuestion/ClzCompreEvalua.do",
        path : "api/testingAnswerPaperQuestion/ClzCompreEvalua",
        clazz : "PP04"
    },{
        name : "研讯通问卷调查-满意度调查（饼图）",
        url : "api/testingAnswerPaperQuestion/ClzComprePie.do",
        path : "api/testingAnswerPaperQuestion/ClzComprePie",
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

(function (window) {
    function returnapi(returnapi, serviceapi) {
        let i = 0;
        for (i in returnapi) {
            returnapi[i] = serviceapi + returnapi[i]
        }
        return returnapi
    }

    let file_service = 'http://old.ahstudy.cn/file-service/',//文件上传服务
        file = {
            "uploadVido": "upload/uploadVido.do",//视频上传
            "pic": "upload/pic",//图片上传
            "file": "upload/file",//小文件上传
            "custfile": "upload/custfile.do",//自定义文件上传
            "custfiledata": "upload/custfile.do",//获取文件信息参数
            "getFileInfo": "getFileInfo",//获取文件信息参数
            "kindedt": "/kindedt/upload",//编辑器上次图片
            "deleteFile": "deleteFile"//删除文件
        };
    returnapi(file, file_service);
    let activity_service = "http://old.ahstudy.cn/activity-service/",//活动
        activity = {
            "queryById": "api/actCategory/queryById.do",//分类详情
            "actCategorysave": "api/actCategory/save.do",//活动分类-保存
            "deleteById": "api/actCategory/deleteById.do",//活动分类-删除
            "queryPage": "api/actCategory/queryPage.do",//活动分类-列表
            "actmak": "api/actMarking/queryPage.do",//打分记录
            "actMarking": "api/actMarking/save.do",//打分
            "activitylist": "api/actActivity/queryPageByCriteria.do",//
            "actactivityworks": "api/actActivityWorks/save.do",//活动作品-新增和修改保存-前后台共用
            "sumbitaudit": "api/actActivityWorks/sumbitAudit.do",//活动作品-提交审核
            "asumbitAudit": "api/actResults/sumbitAudit.do",//活动成果-提交审核
            "actCategory": "api/actCategory/queryPage.do",//活动分类列表
            "actactivitySave": "api/actActivity/save.do",//活动-保存
            "apublish": "api/actActivity/publish.do",//活动-发布/取消发布
            "sendLowerPage": "api/actActivity/sendLowerPage.do",//主站下发子站列表
            "activityDel": "api/actActivity/delete.do",
            "activitySumbitAudit": "api/actActivity/sumbitAudit.do",//活动提交审核
            "activityAudit": "api/actActivity/audit.do",//活动审核
            "activityPublish": "api/actActivity/publish.do",//活动发布
            "actactivity": "api/actActivity/queryById.do",//活动-详情
            "actResultPage": "api/actResults/queryPage.do",//活动成果
            "actResultDelete": "api/actResults/delete.do",//活动成果删除
            "actResultSumbitAudit": "api/actResults/sumbitAudit.do",//提交审核
            "actResultAudit": "api/actResults/audit.do",//活动成果审核
            "actResultQueryById": "api/actResults/queryById.do",//活动成果详情获取
            "actResultsSave": "api/actResults/save.do",//活动成果-保存
        };
    returnapi(activity, activity_service);

    let show_service = 'http://old.ahstudy.cn/show-service/',//才艺服务
        show = {
            "abmAlbum": "api/abmAlbum/recommend.do",//相册-批量推荐
            "sumbitAudit": "api/abmAlbum/sumbitAudit.do",//相册-批量提交审核
            "daabmAlbum": "api/abmAlbum/delete.do",//相册-批量删除
            "albumlist": "api/abmAlbum/queryPage.do",//相册-可管理相册列表查询-前后台共用
            "sendLowerPage": "api/abmAlbum/sendLowerPage.do",//主站下发到子站点相册列表查询
            "albumCateQueryPage": "api/abmCategory/queryPage.do",//才艺分类可管理
            "albumCateDelete": "api/abmCategory/delete.do",//相册分类删除

        };
    returnapi(show, show_service);

    let audit_service = '',//审核服务
        audit = {
            "": "",//
        };
    returnapi(audit, audit_service);

    let base_service = 'http://old.ahstudy.cn/base-service/',//基础服务
        base = {
            "resetPassword": "api/cust/custInfo/resetPassword.do",//重置密码
            "custquery": "api/cust/custInfo/queryCustPage.do",//客户-列表
            "passwordLogin": "login/passwordLogin.do",//用户名密码登录
            "staffPtSitesList": "api/cust/staffPtSitesList.do",//查询员工平台站点列表
            "queryStaffPage": "api/cust/custInfo/queryStaffPage.do",//员工-列表
            "queryList": "api/ptsetSite/queryList.do",//站点列表
            "custrole": "api/custRole/queryPage.do",//角色列表
            "staffPtSitesListOne": "api/cust/staffPtSitesList.do",//查询员工平台站点列表
            "ptsetPlatform": "api/ptsetPlatform/queryList.do",//平台列表
            "setPlatform": "api/cust/staffPtSitesList.do",//查询员工平台站点列表
            "custInfo": "api/cust/custInfo/queryStaffSiteRole.do",//查询员工站点角色
            "cust": "api/cust/custInfo/saveStaff.do",//员工-保存
            "cfgFunction": "api/cfgFunction/queryMngFuncTree.do",//后台功能树
            "custRole": "api/custRole/save.do",//保存角色
            "savecustInfo": "api/cust/custInfo/saveStaffSiteRole.do",//员工-保存员工站点角色
            "setMainSite": "api/ptsetSite/setMainSite.do",//站点设主站点
            "enableSite": "api/ptsetSite/enableSite.do",//站点-启用
            "disableSite": "api/ptsetSite/disableSite.do",//站点禁用
            "ptsetSite": "api/ptsetSite/save.do",//站点保存
            "queryPage": "api/custRole/queryPage.do",
            "roleForm": "api/custRole/roleForm.do",//角色信息(包括功能id)
            "freezeUser": "api/cust/custInfo/freezeUser.do",//用户禁用
            "enableUser": "api/cust/custInfo/enableUser.do",//用户启用
            "deleteByIds": "api/custRole/deleteByIds.do",//角色-删除
            "setSite": "api/ptsetSite/queryById.do",//站点-详情
        };
    returnapi(base, base_service);

    let urlnews_service = 'http://old.ahstudy.cn/news-service/',//资讯服务
        news = {
            "save": "api/newsArticle/save.do",//新增和修改保存
            "delete": "api/newsArticle/delete.do",//批量删除
            "queryById": "api/newsArticle/queryById.do",//详情获取
            "subaudit": "api/newsArticle/subAudit.do",//提交审核
            "audit": "api/newsArticle/audit.do",//修改审核状态
            "publish": "api/newsArticle/publish.do",//咨讯-发布/取消发布
            "recommend": "api/newsArticle/recommend.do",//批量推荐和取消推荐
            "queryTopPage": "api/newsArticle/queryTopPage.do",//咨讯-置顶列表
            "top": "api/newsArticle/top.do",//批量置顶、取消置顶
            "queryPageByCatIds": "api/newsArticle/queryPageByCatIds.do",//咨讯-某个站点多个分类列表
            "queryPageByIds": "api/newsArticle/queryPageByIds.do",//咨讯列表-根据多个咨讯id
            "newsCategoryqueryPage": "api/newsCategory/queryPage.do",//管理员可管理的站点分类列表查询
            "newsCategoryqueryById": "api/newsCategory/queryById.do",//分类-详情获取
            "newsCategorysave": "api/newsCategory/save.do",//分类-新增和修改保存
            "newsCategorydeleteById": "api/newsCategory/deleteById.do",//分类-删除
            "newsCategoryqueryShowPage": "api/newsCategory/queryShowPage.do",//分类-可用分类树列表
            "queryPageOne": "api/newsArticle/queryPage.do",
            "queryPage": "api/newsArticle/queryPage.do",
            "lowerSendPage": "api/newsArticle/lowerSendPage.do",

        };
    returnapi(news, urlnews_service);

    let notice_service = 'http://old.ahstudy.cn/notice-service/',//通知服务
        notice = {
            "save": "api/newsArticle/save.do",//新增和修改保存
            "delete": "api/newsArticle/delete.do",//批量删除
            "queryById": "api/newsArticle/queryById.do",//详情获取
            "subaudit": "api/newsArticle/subAudit.do",//提交审核
            "audit": "api/newsArticle/audit.do",//修改审核状态
            "publish": "api/newsArticle/publish.do",//咨讯-发布/取消发布
            "recommend": "api/newsArticle/recommend.do",//批量推荐和取消推荐
            "queryTopPage": "api/newsArticle/queryTopPage.do",//咨讯-置顶列表
            "top": "api/newsArticle/top.do",//批量置顶、取消置顶
            "queryPageByCatIds": "api/newsArticle/queryPageByCatIds.do",//咨讯-某个站点多个分类列表
            "queryPageByIds": "api/newsArticle/queryPageByIds.do",//咨讯列表-根据多个咨讯id
            "newsCategoryqueryPage": "api/newsCategory/queryPage.do",//管理员可管理的站点分类列表查询
            "newsCategoryqueryById": "api/newsCategory/queryById.do",//分类-详情获取
            "newsCategorysave": "api/newsCategory/save.do",//分类-新增和修改保存
            "newsCategorydeleteById": "api/newsCategory/deleteById.do",//分类-删除
            "newsCategoryqueryShowPage": "api/newsCategory/queryShowPage.do",//分类-可用分类树列表
            "queryPageOne": "api/newsArticle/queryPage.do",
            "queryPage": "api/newsArticle/queryPage.do",
            "lowerSendPage": "api/newsArticle/lowerSendPage.do",
        };
    returnapi(notice, notice_service);

    let help_service = 'http://old.ahstudy.cn/help-service/',//帮助/知识点
        help = {
            "save": "api/newsArticle/save.do",//新增和修改保存
            "delete": "api/newsArticle/delete.do",//批量删除
            "queryById": "api/newsArticle/queryById.do",//详情获取
            "subaudit": "api/newsArticle/subAudit.do",//提交审核
            "audit": "api/newsArticle/audit.do",//修改审核状态
            "publish": "api/newsArticle/publish.do",//咨讯-发布/取消发布
            "recommend": "api/newsArticle/recommend.do",//批量推荐和取消推荐
            "queryTopPage": "api/newsArticle/queryTopPage.do",//咨讯-置顶列表
            "top": "api/newsArticle/top.do",//批量置顶、取消置顶
            "queryPageByCatIds": "api/newsArticle/queryPageByCatIds.do",//咨讯-某个站点多个分类列表
            "queryPageByIds": "api/newsArticle/queryPageByIds.do",//咨讯列表-根据多个咨讯id
            "newsCategoryqueryPage": "api/newsCategory/queryPage.do",//管理员可管理的站点分类列表查询
            "newsCategoryqueryById": "api/newsCategory/queryById.do",//分类-详情获取
            "newsCategorysave": "api/newsCategory/save.do",//分类-新增和修改保存
            "newsCategorydeleteById": "api/newsCategory/deleteById.do",//分类-删除
            "newsCategoryqueryShowPage": "api/newsCategory/queryShowPage.do",//分类-可用分类树列表
            "queryPageOne": "api/newsArticle/queryPage.do",
            "queryPage": "api/newsArticle/queryPage.do",
            "lowerSendPage": "api/newsArticle/lowerSendPage.do",
        };
    returnapi(help, help_service);

    let dynamics_service = 'http://old.ahstudy.cn/dynamics-service/',//动态服务
        dynamics = {
            "queryPage": "api/dynDynamics/queryPage.do",//对象动态列表查询
            "insert": "api/dynDynamics/insert.do",//新增保存
        };
    returnapi(dynamics, dynamics_service);

    let interact_service = 'http://old.ahstudy.cn/interact-service/',//互动服务
        interact = {
            "interactlist": "api/itaComment/queryPage.do",
            "delete": "api/itaComment/delete.do",//删除
        };
    returnapi(interact, interact_service);


    let studygroup_serice = 'http://old.ahstudy.cn/studygroup-service/',//学习小组服务
        studygroup = {
            "studygrouplist": "api/sgpStudyGroup/queryPage.do",//管理列表
            "studygroupDelete": "api/sgpStudyGroup/delete.do",//删除
            "studygroupSumbit": "api/sgpStudyGroup/sumbitAudit.do",//小组提交审核
            "studygroupSave": "api/sgpStudyGroup/save.do",//学习小组新增
            "studygroupqueryById": "api/sgpStudyGroup/queryById.do",//学习小组详情,
            "studygroupAudit": "api/sgpStudyGroup/audit.do",//学习小组shen
            "sgpCategoryPage": "api/sgpCategory/queryPage.do",//分类管理列表
            "studygrouplowerPage": "api/sgpStudyGroup/sendLowerPage.do",//主站下发列表
            "studygroupCateDelete": "api/sgpCategory/delete.do",//分类删除
            "studygroupCateSave": "api/sgpCategory/save.do",//活动分类保存
        };
    returnapi(studygroup, studygroup_serice);

    let course_service = 'http://old.ahstudy.cn/course-service/',//课程服务
        course = {
            "save": "api/crsCatalog/save.do",//课程分类-新增和修改
            "deleteById": "api/crsCatalog/deleteById.do",//课程分类-批量删除
            "queryById": "api/crsCatalog/queryById.do",//课程分类-详情
            "queryManagePage": "api/crsCatalog/queryManagePage.do",//课程分类-可管理列表查询
            "queryShowPage": "api/crsCatalog/queryShowPage.do",//课程分类-可用分类列表查询
            "csrsave": "api/crsCourse/save.do",//课程-新增和修改
            "csrdeleteById": "api/crsCourse/deleteById.do",//课程-批量删除
            "csrpublish": "api/crsCourse/publish.do",//课程-批量发布/取消发布
            "csrsubmitCheck": "api/crsCourse/submitCheck.do",//课程-提交审核
            "csrcheck": "api/crsCourse/check.do",//课程-批量修改审核状态
            "csrqueryById": "api/crsCourse/queryById.do",//课程-详情
            "csraddTutor": "api/csrCourseTutorRel/addTutor.do",//课程-关联辅导老师
            "csrdelTutor": "api/csrCourseTutorRel/delTutor.do",//课程-删除辅导老师
            "crcqueryManagePage": "api/crsCourse/queryManagePage.do",//课程-可管理列表查询
            "crcqueryShowPage": "api/crsCourse/queryShowPage.do",//课程-可用列表查询
            "crcqueryMainPage": "api/crsCourse/queryMainPage.do",//课程-主站下发列表查询课程-主站下发列表查询
            "crcdetail": "api/crsCourse/detail.do",//课程-根据课程id参数课程列表
            "crcaddUserCourse": "api/crsCustLearnCourse/addUserCourse.do",//课程-批量选课和取消选课
            "crcqueryMyCoursePage": "api/crsCustLearnCourse/queryMyCoursePage.do",//课程-我学习的课程列表
            "crcqueryUserPage": "api/crsCustLearnCourse/queryUserPage.do",//课程-课程最近学习人员
            "crcsave": "api/crsChapter/save.do",//课程章节-新增和修改
            "crcdeleteById": "api/crsChapter/deleteById.do",//课程章节-批量删除
            "crcqueryById": "api/crsChapter/queryById.do",//课程章节-详情
            "crcchapterList": "api/crsChapter/chapterList.do",//课程章节-列表
            "crctreeList": "api/crsChapter/treeList.do",//课程章节-树目录
            "crcaddResource": "api/crsChapterResourceRel/addResource.do",//课程章节-关联资源
            "crcdelResource": "api/crsChapterResourceRel/delResource.do",//课程章节-删除资源

        };
    returnapi(course, course_service);

    let homework_service = 'http://old.ahstudy.cn/homework-service/',//作业服务
        homework = {
            "wkHomework": "api/wkHomework/queryById.do",//作业详情
            "queryManagePage": "api/wkHomework/queryManagePage.do",//课程作业-可管理作业列表查询-前后台共用
            "save": "api/wkHomework/save.do",//新增和修改作业保存
            "deleteById": "api/wkHomework/deleteById.do",//批量删除
            "detail": "api/wkHomework/detail.do",//详情获取
            "publish": "api/wkHomework/publish.do",//批量发布、取消发布
            "uuserHomework": "api/wkUserHomework/userHomework.do",//用户课程作业列表-带状态
            "udetail": "api/wkUserHomework/detail.do",//用户作业详细
            "usave": "api/wkUserHomework/save.do",//做作业-新增和修改保存
            "uquerySumbitPage": "api/wkUserHomework/querySumbitPage.do",//作业反馈-作业提交记录列表查询
            "usubmit": "api/wkUserHomework/submit.do",//作业提交
            "uscore": "api/wkUserHomework/score.do",//批阅评分/评星
            "hsave": "api/wkHomeworkAttachment/save.do",//新增/编辑作业附件
            "hqueryById": "api/wkHomeworkAttachment/queryById.do",//作业附件详细
            "hdeleteById": "api/wkHomeworkAttachment/deleteById.do",//作业附件详删除
        };
    returnapi(homework, homework_service);

    let resource_service = 'http://old.ahstudy.cn/resource-service/',//资源服务
        resource = {
            "showresResource": "api/resResource/queryShowPage.do",//资源-可查看列表,下发的不能编辑的
            "csave": "api/resCategory/save.do",//新增和修改资源分类保存
            "cdeleteById": "api/resCategory/deleteById.do",//资源分类-批量删除
            "cqueryById": "api/resCategory/queryById.do",//资源分类-详情获取
            "cqueryManagePage": "api/resCategory/queryManagePage.do",//资源分类-可管理资源分类列表查询
            "cqueryShowPage": "api/resCategory/queryShowPage.do",//资源分类-可用分类列表查询
            "rsave": "api/resResource/save.do",//资源新增和修改保存
            "rdeleteById": "api/resResource/deleteById.do",//资源 -批量删除
            "rpublish": "api/resResource/publish.do",//资源-批量发布/取消发布
            "rcheck": "api/resResource/check.do",//资源-批量修改审核状态
            "rdetail": "api/resResource/detail.do",//资源-详情获取/根据资源ids参数资源列表
            "rqueryManagePage": "api/resResource/queryManagePage.do",//资源-可管理列表查询
            "rqueryMainPage": "api/resResource/queryMainPage.do",//资源-主站下发列表查询
            "fsave": "api/resFile/save.do",//资源文件-新增和修改
            "fdeleteById": "api/resFile/deleteById.do",//资源文件-批量删除
            "fdetail": "api/resFile/detail.do",//资源文件-详情
            "lqueryPage": "api/stdCustLearnRecord/queryPage.do",//学员学习记录-学员学习时间明细记录列表
            "llearnSave": "api/stdCustLearnRecord/learnSave.do",//提交记时
            "lsave": "api/stdCustLearnResource/save.do",//学员学习资源-新增
            "lqueryResources": "api/stdCustLearnResource/queryResources.do",//学员学习资源-学员多个资源id的学习情况列表
            "lqueryResourcePage": "api/stdCustLearnResource/queryResourcePage.do",//学员学习资源-学员资源列表
            "lqueryUserPage": "api/stdCustLearnResource/queryUserPage.do",//资源最近学习的人员
            "lqueryByResId": "api/stdStudyObjectStatistics/queryByResId.do",//资源学习统计-根据多个资源id获取统计列表
            "lqueryByUserId": "api/stdCustExt/queryByUserId.do",//多个用户id对应用户学习统计列表
            "queryMainPage": "api/resResource/queryMainPage.do",
            "queryShowPage": "api/resResource/queryShowPage.do",
            "resResource": "api/resResource/queryById.do",//资源-详细

        };
    returnapi(resource, resource_service);

    let cert_service = 'http://old.ahstudy.cn/cert-service/',//证书服务
        cert = {
            "tsave": "api/ctTemplate/save.do",//证书模板-新增和修改
            "tdeleteById": "api/ctTemplate/deleteById.do",//证书模板-批量删除
            "tqueryById": "api/ctTemplate/queryById.do",//证书模板-详情
            "tqueryManagePage": "api/ctTemplate/queryManagePage.do",//证书模板-列表查询
            "tmodifyStatus": "api/ctTemplate/modifyStatus.do",//证书模板-启用/取消启用
            "csave": "api/ctCert/save.do",//证书-新增和修改
            "cdeleteById": "api/ctCert/deleteById.do",//证书-批量删除
            "csubmitCheck": "api/ctCert/submitCheck.do",//证书-提交审核
            "ccheck": "api/ctCert/check.do",//证书-批量修改审核状态
            "cqueryById": "api/ctCert/queryById.do",//证书-详情
            "cqueryManagePage": "api/ctCert/queryManagePage.do",//证书-可管理列表查询
            "cqueryShowPage": "api/ctCert/queryShowPage.do",//证书-可用列表查询
            "cqueryMainPage": "api/ctCert/queryMainPage.do",//证书-主站下发列表查询
            "usave": "api/ctUserCert/save.do",//用户证书-新增用户证书
            "uqueryManagePage": "api/ctUserCert/queryManagePage.do",//用户证书-证书学员列表
            "uqueryUserPage": "api/ctUserCert/queryUserPage.do",//用户证书-学员证书列表查询
            "upublish": "api/ctUserCert/publish.do",//用户证书-批量发布/取消发布
            "queryManagePage": "api/ctCert/queryManagePage.do",


        };
    returnapi(cert, cert_service);

    let schoolclass_service = 'http://old.ahstudy.cn/schoolclass-service/',//教务管理接口服务
        schoolclass = {
            "clzCategorysave": "api/clzCategory/save.do",//班级分类-新增
            "clzquer": "api/clzCategory/queryById.do",//分类详情
            "deletegls": "api/clzCategory/delete.do",//班级分类-删除
            "deletesc": "api/clzClazz/delete.do",//删除班级
            "clzClazzpublish": "api/clzClazz/publish.do",//班级-批量发布/取消发布
            "clzCategory": "api/clzCategory/queryPage.do",//管理班级分类列表
            "clzClazz": "api/clzClazz/save.do",//班级-新增修改保存
            "savebj": "api/clzClazzCourse/save.do",//班级课程-新增/修改
            "bjqueryShowPage": "api/clzClazzCourse/queryShowPage.do",//班级课程列表查询
            "deleteById": "api/clzClazzCourse/deleteById.do",//班级课程-批量删除
            "queryShowPage": "api/clzStudentClazz/queryShowPage.do",//班级学员列表查询
            "signup": "api/clzStudentClazz/signup.do",//报名
            "signuped": "api/clzStudentClazz/signuped.do",//判断用户是否参加了班级
            "importStudent": "api/clzStudentClazz/importStudent.do",//批量导入学员
            "queryUserClazzPage": "api/clzStudentClazz/queryUserClazzPage.do",//学员班级列表（我的班级）
            "queryUserClazzCoursePage": "api/clzUserClazzCourse/queryUserClazzCoursePage.do",//学员班级课程列表-带进度
            "testList": "api/clzClazzTest/testList.do",//班级测验-列表
            "addTest": "api/clzClazzTest/addTest.do",//新增班级测验
            "delTest": "api/clzClazzTest/delTest.do",//删除班级测验
            "cqueryPageUse": "api/clzClazz/queryPageUse.do",//站点的可用班级列表-f
            "queryById": "api/clzClazz/queryById.do",//班级-详情获取
            "queryPageManger": "api/clzClazz/queryPageManger.do",

        };

    returnapi(schoolclass, schoolclass_service);

    let testing_service = "http://old.ahstudy.cn/testing-service/", //测验服务
        testing = {
            "saveGenPaper": "api/testingPaperRule/saveGenPaper.do",//组卷
            "testingtest": "api/testingTest/queryById.do",//测验详情
            "testingPaper": "api/testingPaperRule/queryById.do",//组卷规则详情
            "testdelete": "api/testingTest/delete.do",//测验-批量删除
            "deletetest": "api/testingQuestion/delete.do",//删除题目
            "testingqestion": "api/testingQuestion/queryById.do",//题目详情
            "testingPaperRule": "api/testingPaperRule/save.do",//组卷规则-新增/编辑
            "testingquestionitemRule": "api/testingQuestionitemRule/save.do",//组卷规则的题型出题规则-新增/编辑
            "testingItemTypes": "api/testingItemTypes/queryList.do",//题型列表
            "testingquestionpool": "api/testingQuestionPool/queryPage.do",//题库-可管理列表
            "queryitemtypes": "api/testingQuestion/queryItemTypes.do",//题库题型类别数量获取
            "querypageex": "api/testingQuestion/queryPageExt.do",//题库题目列表
            "testqu": "api/testingQuestionPool/queryPage.do",//题库-可管理题库列表
            "testingpool": "api/testingQuestionPool/save.do",//题库-新增修改保存
            "testsave": "api/testingQuestion/save.do",//题目-新增修改保存
            "testingquwr": "api/testingQuestionPool/queryPage.do",//题库-可管理题库列表
            "queryPage": "api/testingTest/queryPage.do",
            "queryManagePage": "api/testingPaperRule/queryManagePage.do",
            "section": "api/testingQuestionSection/queryList.do",//题库章节目录-目录树
            "testingTest": "api/testingTest/save.do",//测验-新增修改保存
            "queryPageExt": "api/testingQuestion/queryPageExt.do",
            "queryPageOne": "api/testingQuestionPool/queryPage.do",
            "save": "api/testingQuestion/save.do",
            "queryList": "api/testingQuestionSection/queryList.do",
            "sectionDelete": "api/testingQuestionSection/delete.do",//章节删除
            "sectionSave": "api/testingQuestionSection/save.do",//章节新增
        };
    returnapi(testing, testing_service);

    let setting_service = 'http://old.ahstudy.cn/setting-service/',//配置服务
        setting = {
            "setLinks": "api/setLinks/queryPage.do",//友情链接-管理列表
            "enable": "api/setLinks/enable.do",//链接-启用
            "disable": "api/setLinks/disable.do",//链接-禁用
            "queryById": "api/setLinks/queryById.do",//链接-详情
            "update": "api/setLinks/update.do",//友情链接-修改
            "deleteById": "api/setLinks/deleteById.do",//友情链接-删除
            "save": "api/setLinks/save.do",//友情链接-添加
            "setPromotion": "api/setPromotion/queryPage.do",//推广-管理列表
            "ssave": "api/setPromotion/save.do",//推广-添加
            "supdate": "api/setPromotion/update.do",//推广-修改
            "sdeleteById": "api/setPromotion/deleteById.do",//推广-删除
            "squeryById": "api/setPromotion/queryById.do",//推广-详情
            "senable": "api/setPromotion/enable.do",//推广-启用
            "sdisable": "api/setPromotion/disable.do",//推广-禁用
            "saveSorts": "api/setPromotion/saveSorts.do",//推广-保存排序
        };
    returnapi(setting, setting_service);

    let exp_service = "http://old.ahstudy.cn/exp-service/",//经验
        exp = {
            "save": "api/newsArticle/save.do",//新增和修改保存
            "delete": "api/newsArticle/delete.do",//批量删除
            "queryById": "api/newsArticle/queryById.do",//详情获取
            "subaudit": "api/newsArticle/subAudit.do",//提交审核
            "audit": "api/newsArticle/audit.do",//修改审核状态
            "publish": "api/newsArticle/publish.do",//咨讯-发布/取消发布
            "recommend": "api/newsArticle/recommend.do",//批量推荐和取消推荐
            "queryTopPage": "api/newsArticle/queryTopPage.do",//咨讯-置顶列表
            "top": "api/newsArticle/top.do",//批量置顶、取消置顶
            "queryPageByCatIds": "api/newsArticle/queryPageByCatIds.do",//咨讯-某个站点多个分类列表
            "queryPageByIds": "api/newsArticle/queryPageByIds.do",//咨讯列表-根据多个咨讯id
            "newsCategoryqueryPage": "api/newsCategory/queryPage.do",//管理员可管理的站点分类列表查询
            "newsCategoryqueryById": "api/newsCategory/queryById.do",//分类-详情获取
            "newsCategorysave": "api/newsCategory/save.do",//分类-新增和修改保存
            "newsCategorydeleteById": "api/newsCategory/deleteById.do",//分类-删除
            "newsCategoryqueryShowPage": "api/newsCategory/queryShowPage.do",//分类-可用分类树列表
            "queryPageOne": "api/newsArticle/queryPage.do",
            "queryPage": "api/newsArticle/queryPage.do",
            "lowerSendPage": "api/newsArticle/lowerSendPage.do",

        };
    returnapi(exp, exp_service);

    let orderform_service = "http://old.ahstudy.cn/orderform-service/",//订单
        orderform = {
            "orderformlist": "api/ordOrderform/queryManagePage.do",//订单-可管理列表
        };
    returnapi(orderform, orderform_service);

    let resultbill_service = "http://old.ahstudy.cn/resultbill-service/",//订单
        resultbill = {
            "bilPoints": "api/bilPoints/queryPage.do",//积分-积分列表
        };
    returnapi(resultbill, resultbill_service);
    let apidata = {
        "orderform": orderform,
        "help": help,
        "resultbill": resultbill,
        "setting": setting,
        "activity": activity,
        "show": show,
        "audit": audit,
        "base": base,
        "news": news,
        "dynamics": dynamics,
        "interact": interact,
        "studygroup": studygroup,
        "course": course,
        "homework": homework,
        "resource": resource,
        "cert": cert,
        "file": file,
        "schoolclass": schoolclass,
        "notice": notice,
        "testing": testing,
        "exp": exp,
        "card": "http://api.learnyeai.com:9011/certApi/cert/certoffline/manage/certlist?callback=successCallback",
        "postdata": {
            "header":
                {
                    "SESSION_TOKEN": "6348187417",
                    "UUID": "6348187417",
                    "CLIENT_OS": "O",
                },
            "payload":
                {
                    "title": "",
                    "page": "1",
                    "rows": "8"
                }
        },
        "initpostdata": {
            "header":
                {
                    "SESSION_TOKEN": "6348187417",
                    "UUID": "6348187417",
                    "CLIENT_OS": "O",
                },
            "payload":
                {
                    "title": "",
                    "page": "1",
                    "rows": "8"
                }
        }
    };
    window.apidata = apidata;
})(window);
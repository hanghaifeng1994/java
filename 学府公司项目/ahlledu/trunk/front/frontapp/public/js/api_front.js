(function (window) {
    function returnapi(returnapi, serviceapi) {
        let i = 0;
        for (i in returnapi) {
            returnapi[i] = serviceapi + returnapi[i]
        }
        return returnapi
    }

    let activity_service = 'http://115.159.99.212:9026/activity-service/',//活动服务
        activity = {
            "queryPageUse": "api/actActivity/queryPageUse.do"//活动-可用活动列表
        };
    let album_service = 'http://115.159.99.212:9024/album-service/',//相册服务
            album = {
            "queryPage": "api/abmCategory/queryPage.do",//管理员可管理的相册分类列表查询
            "save": "api/abmCategory/save.do",//分类-分类新增和修改保存
            "queryById": "api/abmCategory/queryById.do",//分类-详情获取
            "delete": "api/abmCategory/delete.do",//分类-批量删除
            "queryPageUse": "api/abmCategory/queryPageUse.do",//分类-可用分类树列表
            "aqueryPageUse": "api/abmAlbum/queryPageUse.do",//相册-站点可用相册列表查询
            "recommend": "api/abmAlbum/recommend.do",//相册-批量推荐/取消推荐
            "sumbitAudit": "api/abmAlbum/sumbitAudit.do",//相册-批量提交审核
            "adelete": "api/abmAlbum/delete.do",//相册-批量删除
            "asave": "api/abmAlbum/save.do",//相册-新增修改保存
            "aqueryById": "api/abmAlbum/queryById.do",//相册-详情查询
            "asumbitAudit": "api/abmAlbum/sumbitAudit.do",//相册-提交审核
            "aaudit": "api/abmAlbum/audit.do",//相册-修改审核状态
            "arecommend": "api/abmAlbum/recommend.do",//相册-批量推荐/取消推荐
            "amyQueryPage": "api/abmAlbum/myQueryPage.do",//相册-我的列表
            "aqueryByIds": "api/abmAlbum/queryByIds.do",//相册-根据多ids获取对象列表
            "pqueryPage": "api/abmPhoto/queryPage.do",//图片-我的图片列表
            "aqueryPage": "api/abmAlbum/queryPage.do",//图片-可管理相册列表查询
            "pdelete": "api/abmPhoto/delete.do",//图片-批量删除
            "pqueryById": "api/abmPhoto/queryById.do",//图片-详情
            "phsave": "api/abmPhoto/save.do",//图片-批量新增
        };

    let audit_service = '',//审核服务
        audit = {
            "": "",//
        };

    let base_service = '',//基础服务
        base = {
            "": "",//
        };

    let urlnews_service = 'http://115.159.99.212:9022/news-service/',//资讯服务
        news = {
            "queryPage": "api/newsArticle/queryPage.do",//我管理的站点资讯列表查询
            "save": "api/newsArticle/save.do",//新增和修改保存
            "delete": "api/newsArticle/delete.do",//批量删除
            "queryById": "api/newsArticle/queryById.do",//详情获取
            "subaudit": "api/newsArticle/subAudit.do",//提交审核
            "audit": "api/newsArticle/audit.do",//修改审核状态
            "publish": "api/newsArticle/publish.do",//咨讯-发布/取消发布
            "recommend": "api/newsArticle/recommend.do",//批量推荐和取消推荐
            "queryTopPage": "api/newsArticle/queryTopPage.do",//咨讯-置顶列表
            "top": "api/newsArticle/top.do",//批量置顶、取消置顶
            "lowerSendPage": "api/newsArticle/lowerSendPage.do",//管理员管理的主站下发到子站点资讯列表
            "queryPageByCatIds": "api/newsArticle/queryPageByCatIds.do",//咨讯-某个站点多个分类列表
            "queryPageByIds": "api/newsArticle/queryPageByIds.do",//咨讯列表-根据多个咨讯id
            "newsCategoryqueryPage": "api/newsCategory/queryPage.do",//管理员可管理的站点分类列表查询
            "newsCategoryqueryById": "api/newsCategory/queryById.do",//分类-详情获取
            "newsCategorysave": "api/newsCategory/save.do",//分类-新增和修改保存
            "newsCategorydeleteById": "api/newsCategory/deleteById.do",//分类-删除
            "newsCategoryqueryShowPage": "api/newsCategory/queryShowPage.do",//分类-可用分类树列表
        };

    let dynamics_service = 'http://115.159.99.212:9025/dynamics-service/',//动态服务
        dynamics = {
            "queryPage": "api/dynDynamics/queryPage.do",//对象动态列表查询
            "insert": "api/dynDynamics/insert.do",//新增保存
        };

    let interact_service = 'http://115.159.99.212:9023/interact-service/',//互动服务
        interact = {
            "queryPage": "api/itaInteractionTimes/queryPage.do",//互动次数-查询多个对象的互动统计信息列表
            "iqueryPage":"api/itaComment/queryPage.do",//指定站点的全部或者对象的评论列表查询（前后台公用）
            "myQueryPage":"api/itaComment/myQueryPage.do",//个人发表的评论列表查询
            "insert":"api/itaComment/insert.do",//评论-新增
            "updateById":"api/itaComment/updateById.do",//评论-修改
            "delete":"api/itaComment/delete.do",//评论-删除
            "linsert":"api/itaLiked/insert.do",//点赞-添加
            "isItaLike":"api/itaLiked/isItaLike.do",//查询某人的对象是否点赞
            "itqueryPage":"api/itaCollection/queryPage.do",//收藏-我的收藏列表查询
            "itinsert":"api/itaCollection/insert.do",//我的收藏-新增
            "icdelete":"api/itaCollection/delete.do",//收藏-批量删除
            "inqueryPage":"api/itaInteractionTimes/queryPage.do",//互动次数-查询多个对象的互动统计信息列表
            "shsave":"api/itaShare/save.do",//分享-添加
            "ivsave":"api/itaVote/save.do",//投票-保存
            "queryListByObjId":"api/itaVote/queryListByObjId.do",//查询用户是否参与了业务对象的投票
            "icqueryById":"api/itaCustExt/queryById.do",//用户-参与业务对象互动的多个用户统计列表
        };

    let studygroup_service = 'http://115.159.99.212:9027/studygroup-service/',//学习小组服务
        studygrou = {
            "queryPageUse": "api/sgpStudyGroup/queryPageUse.do",//
        };

    let course_service = 'http://115.159.99.212:8093/course-service/',//课程服务
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

    let homework_service = 'http://115.159.99.212:8092/homework-service/',//作业服务
        homework = {
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

    let resource_service = 'http://115.159.99.212:8091/resource-service/',//资源服务
        resource = {
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
        };

    let cert_service = 'http://115.159.99.212:8094/cert-service/',//证书服务
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
        };

    let schoolclass_service = 'http://115.159.99.212:8095/schoolclass-service/',//教务管理接口服务
        schoolclass = {
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
            "delTest": "api/clzClazzTest/delTest.do"//删除班级测验
        };
    let resultbill_service = 'http://115.159.99.212:9028/resultbill-service/',//成果账单服务接口服务
        resultbill = {
            "queryPageByUser": "api/bilCustExt/queryPageByUser.do",//账单用户-几个用户参数的账单列表查询
            "bjqueryShowPage": "api/clzClazzCourse/queryShowPage.do"
        };
    returnapi(resultbill, resultbill_service);
    returnapi(activity, activity_service);
    returnapi(album, album_service);
    returnapi(audit, audit_service);
    returnapi(base, base_service);
    returnapi(news, urlnews_service);
    returnapi(dynamics, dynamics_service);
    returnapi(interact, interact_service);
    returnapi(studygrou, studygroup_service);
    returnapi(course, course_service);
    returnapi(homework, homework_service);
    returnapi(resource, resource_service);
    returnapi(cert, cert_service);
    returnapi(schoolclass, schoolclass_service);

    let apidata = {
        "resultbill": resultbill,
        "activity": activity,
        "album": album,
        "audit": audit,
        "base": base,
        "news": news,
        "dynamics": dynamics,
        "interact": interact,
        "studygrou": studygrou,
        "course": course,
        "homework": homework,
        "resource": resource,
        "cert": cert,
        "postdata": {
            "header":
                {
                    "SESSION_TOKEN": "6348187417",
                    "UUID": "6348187417",
                    "CLIENT_OS": "O",
                    "__account_id":"222"
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
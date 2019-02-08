var activity_service = 'http://115.159.99.212:9026/activity-service/',//活动服务
    activity_servicelist = {
        "aqueryPage": activity_service + "api/actSiteActivityRel/queryPage.do",//活动-可管理的活动列表查询
        "aqueryPageByCriteria": activity_service + "api/actActivity/queryPageByCriteria.do",//活动-列表(按条件查询)
        "aactActivity": activity_service + "api/actActivity/save.do",//活动-新增和修改保存
        "bactActivity": activity_service + "api/actActivity/delete.do",//活动-批量删除
        "cactActivity": activity_service + "api/actActivity/queryById.do",//活动-详情获取-前后台共用
        "sumbitAudit": activity_service + "api/actActivity/sumbitAudit.do",//活动-提交审核
        "audit": activity_service + "api/actActivity/audit.do",//活动-审核
        "publish": activity_service + "api/actActivity/publish.do",//批量发布、取消发布
        "sendLowerPage": activity_service + "api/actSiteActivityRel/sendLowerPage.do",//活动-主站下发子站活动列表
        "queryPageUse": activity_service + "api/actSiteActivityRel/queryPageUse.do",//活动-站点可用活动列表
        "signUp": activity_service + "api/actActivityMemer/signUp.do",//活动-活动报名
        "personPage": activity_service + "api/actActivity/personPage.do",//活动-活动人员列表
        "queryById": activity_service + "api/actActivityWorks/queryById.do",//活动作品-详情
        "hddelete": activity_service + "api/actActivityWorks/delete.do",//活动作品-删除
        "myqueryPage": activity_service + "api/actActivityWorks/queryPage.do",//活动作品-我的列表
        "mysave": activity_service + "api/actActivityWorks/save.do",//活动作品-新增和修改保存-前后台共用
        "mysumbitAudit": activity_service + "api/actActivityWorks/sumbitAudit.do",//活动作品-提交审核
        "myaudit": activity_service + "api/actActivityWorks/audit.do",//活动作品-审核
        "zpqueryPage": activity_service + "api/actMarking/queryPage.do",//活动作品打分-打分记录列表
        "zpsave": activity_service + "api/actMarking/save.do",//api/actMarking/save.do
        "cgqueryPage": activity_service + "api/actResults/queryPage.do",//活动成果-活动列表查询-前后台公用
        "hdsave": activity_service + "api/actResults/save.do",//活动成果-新增和修改保存-前后台共用
        "mydelete": activity_service + "api/actResults/delete.do",//活动成果-批量删除
        "myhdqueryById": activity_service + "api/actResults/queryById.do",//活动成果-详情获取-前后台共用
        "hdsumbitAudit": activity_service + "api/actResults/sumbitAudit.do",//活动成果-提交审核
        "myhdaudit": activity_service + "api/actResults/audit.do",//活动成果-修改审核状态
    };
var album_service = '',//相册服务
    album_servicelist = {
        "": album_service + "",//
    };
var audit_service = '',//审核服务
    audit_servicelist = {
        "": audit_service + "",//
    };
var base_service = '',//基础服务
    base_servicelist = {
        "": base_service + "",//
    };
var urlnews_service = 'http://115.159.99.212:9022/news-service/',//资讯服务
    news= {
        "queryPage": urlnews_service + "api/newsArticle/queryPage.do",//我管理的站点资讯列表查询
        "save": urlnews_service + "api/newsArticle/save.do",//新增和修改保存
        "delete": urlnews_service + "api/newsArticle/delete.do",//批量删除
        "queryById": urlnews_service + "api/newsArticle/queryById.do",//详情获取
        "subAudit": urlnews_service + "api/newsArticle/subAudit.do",//提交审核
        "audit": urlnews_service + "api/newsArticle/audit.do",//修改审核状态
        "publish": urlnews_service + "api/newsArticle/publish.do",//咨讯-发布/取消发布
        "recommend": urlnews_service + "api/newsArticle/recommend.do",//批量推荐和取消推荐
        "queryTopPage": urlnews_service + "api/newsArticle/queryTopPage.do",//咨讯-置顶列表
        "top": urlnews_service + "api/newsArticle/top.do",//批量置顶、取消置顶
        "lowerSendPage": urlnews_service + "api/newsArticle/lowerSendPage.do",//管理员管理的主站下发到子站点资讯列表
        "queryPageByCatIds": urlnews_service + "api/newsArticle/queryPageByCatIds.do",//咨讯-某个站点多个分类列表
        "queryPageByIds": urlnews_service + "api/newsArticle/queryPageByIds.do",//咨讯列表-根据多个咨讯id
        "newsCategoryqueryPage": urlnews_service + "api/newsCategory/queryPage.do",//管理员可管理的站点分类列表查询
        "newsCategoryqueryById": urlnews_service + "api/newsCategory/queryById.do",//分类-详情获取
        "newsCategorysave": urlnews_service + "api/newsCategory/save.do",//分类-新增和修改保存
        "newsCategorydeleteById": urlnews_service + "api/newsCategory/deleteById.do",//分类-删除
        "newsCategoryqueryShowPage": urlnews_service + "api/newsCategory/queryShowPage.do",//分类-可用分类树列表
    };
var dynamics_service = 'http://115.159.99.212:9025/dynamics-service/',//动态服务
    dynamics_servicelist = {
        "queryPage": dynamics_service + "api/dynDynamics/queryPage.do",//对象动态列表查询
        "insert": dynamics_service + "api/dynDynamics/insert.do",//新增保存
    };
var interact_service = '',//互动服务
    interact_servicelist = {
        "": interact_service + "",//
    };
var studygroup_service = '',//学习小组服务
    studygroup_servicelist = {
        "": studygroup_service + "",//
    };
var course_service = 'http://115.159.99.212:8093/course-service/',//课程服务
    course_servicelist = {
        "save": course_service + "api/crsCatalog/save.do",//课程分类-新增和修改
        "deleteById": course_service + "api/crsCatalog/deleteById.do",//课程分类-批量删除
        "queryById": course_service + "api/crsCatalog/queryById.do",//课程分类-详情
        "queryManagePage": course_service + "api/crsCatalog/queryManagePage.do",//课程分类-可管理列表查询
        "queryShowPage": course_service + "api/crsCatalog/queryShowPage.do",//课程分类-可用分类列表查询
        "csrsave": course_service + "api/crsCourse/save.do",//课程-新增和修改
        "csrdeleteById": course_service + "api/crsCourse/deleteById.do",//课程-批量删除
        "csrpublish": course_service + "api/crsCourse/publish.do",//课程-批量发布/取消发布
        "csrsubmitCheck": course_service + "api/crsCourse/submitCheck.do",//课程-提交审核
        "csrcheck": course_service + "api/crsCourse/check.do",//课程-批量修改审核状态
        "csrqueryById": course_service + "api/crsCourse/queryById.do",//课程-详情
        "csraddTutor": course_service + "api/csrCourseTutorRel/addTutor.do",//课程-关联辅导老师
        "csrdelTutor": course_service + "api/csrCourseTutorRel/delTutor.do",//课程-删除辅导老师
        "crcqueryManagePage": course_service + "api/crsCourse/queryManagePage.do",//课程-可管理列表查询
        "crcqueryShowPage": course_service + "api/crsCourse/queryShowPage.do",//课程-可用列表查询
        "crcqueryMainPage": course_service + "api/crsCourse/queryMainPage.do",//课程-主站下发列表查询课程-主站下发列表查询
        "crcdetail": course_service + "api/crsCourse/detail.do",//课程-根据课程id参数课程列表
        "crcaddUserCourse": course_service + "api/crsCustLearnCourse/addUserCourse.do",//课程-批量选课和取消选课
        "crcqueryMyCoursePage": course_service + "api/crsCustLearnCourse/queryMyCoursePage.do",//课程-我学习的课程列表
        "crcqueryUserPage": course_service + "api/crsCustLearnCourse/queryUserPage.do",//课程-课程最近学习人员
        "crcsave": course_service + "api/crsChapter/save.do",//课程章节-新增和修改
        "crcdeleteById": course_service + "api/crsChapter/deleteById.do",//课程章节-批量删除
        "crcqueryById": course_service + "api/crsChapter/queryById.do",//课程章节-详情
        "crcchapterList": course_service + "api/crsChapter/chapterList.do",//课程章节-列表
        "crctreeList": course_service + "api/crsChapter/treeList.do",//课程章节-树目录
        "crcaddResource": course_service + "api/crsChapterResourceRel/addResource.do",//课程章节-关联资源
        "crcdelResource": course_service + "api/crsChapterResourceRel/delResource.do",//课程章节-删除资源
    };
var homework_service = 'http://115.159.99.212:8092/homework-service/',//作业服务
    homework_servicelist = {
        "queryManagePage": homework_service + "api/wkHomework/queryManagePage.do",//课程作业-可管理作业列表查询-前后台共用
        "save": homework_service + "api/wkHomework/save.do",//新增和修改作业保存
        "deleteById": homework_service + "api/wkHomework/deleteById.do",//批量删除
        "detail": homework_service + "api/wkHomework/detail.do",//详情获取
        "publish": homework_service + "api/wkHomework/publish.do",//批量发布、取消发布
        "uuserHomework": homework_service + "api/wkUserHomework/userHomework.do",//用户课程作业列表-带状态
        "udetail": homework_service + "api/wkUserHomework/detail.do",//用户作业详细
        "usave": homework_service + "api/wkUserHomework/save.do",//做作业-新增和修改保存
        "uquerySumbitPage": homework_service + "api/wkUserHomework/querySumbitPage.do",//作业反馈-作业提交记录列表查询
        "usubmit": homework_service + "api/wkUserHomework/submit.do",//作业提交
        "uscore": homework_service + "api/wkUserHomework/score.do",//批阅评分/评星
        "hsave": homework_service + "api/wkHomeworkAttachment/save.do",//新增/编辑作业附件
        "hqueryById": homework_service + "api/wkHomeworkAttachment/queryById.do",//作业附件详细
        "hdeleteById": homework_service + "api/wkHomeworkAttachment/deleteById.do",//作业附件详删除
    };
var resource_service = 'http://115.159.99.212:8091/resource-service/',//资源服务
    resource_servicelist = {
        "csave": resource_service + "api/resCategory/save.do",//新增和修改资源分类保存
        "cdeleteById": resource_service + "api/resCategory/deleteById.do",//资源分类-批量删除
        "cqueryById": resource_service + "api/resCategory/queryById.do",//资源分类-详情获取
        "cqueryManagePage": resource_service + "api/resCategory/queryManagePage.do",//资源分类-可管理资源分类列表查询
        "cqueryShowPage": resource_service + "api/resCategory/queryShowPage.do",//资源分类-可用分类列表查询
        "rsave": resource_service + "api/resResource/save.do",//资源新增和修改保存
        "rdeleteById": resource_service + "api/resResource/deleteById.do",//资源 -批量删除
        "rpublish": resource_service + "api/resResource/publish.do",//资源-批量发布/取消发布
        "rcheck": resource_service + "api/resResource/check.do",//资源-批量修改审核状态
        "rdetail": resource_service + "api/resResource/detail.do",//资源-详情获取/根据资源ids参数资源列表
        "rqueryManagePage": resource_service + "api/resResource/queryManagePage.do",//资源-可管理列表查询
        "rqueryMainPage": resource_service + "api/resResource/queryMainPage.do",//资源-主站下发列表查询
        "fsave": resource_service + "api/resFile/save.do",//资源文件-新增和修改
        "fdeleteById": resource_service + "api/resFile/deleteById.do",//资源文件-批量删除
        "fdetail": resource_service + "api/resFile/detail.do",//资源文件-详情
        "lqueryPage": resource_service + "api/stdCustLearnRecord/queryPage.do",//学员学习记录-学员学习时间明细记录列表
        "llearnSave": resource_service + "api/stdCustLearnRecord/learnSave.do",//提交记时
        "lsave": resource_service + "api/stdCustLearnResource/save.do",//学员学习资源-新增
        "lqueryResources": resource_service + "api/stdCustLearnResource/queryResources.do",//学员学习资源-学员多个资源id的学习情况列表
        "lqueryResourcePage": resource_service + "api/stdCustLearnResource/queryResourcePage.do",//学员学习资源-学员资源列表
        "lqueryUserPage": resource_service + "api/stdCustLearnResource/queryUserPage.do",//资源最近学习的人员
        "lqueryByResId": resource_service + "api/stdStudyObjectStatistics/queryByResId.do",//资源学习统计-根据多个资源id获取统计列表
        "lqueryByUserId": resource_service + "api/stdCustExt/queryByUserId.do",//多个用户id对应用户学习统计列表
    };
var cert_service = 'http://115.159.99.212:8094/cert-service/',//证书服务
    cert_servicelist = {
        "tsave": cert_service + "api/ctTemplate/save.do",//证书模板-新增和修改
        "tdeleteById": cert_service + "api/ctTemplate/deleteById.do",//证书模板-批量删除
        "tqueryById": cert_service + "api/ctTemplate/queryById.do",//证书模板-详情
        "tqueryManagePage": cert_service + "api/ctTemplate/queryManagePage.do",//证书模板-列表查询
        "tmodifyStatus": cert_service + "api/ctTemplate/modifyStatus.do",//证书模板-启用/取消启用
        "csave": cert_service + "api/ctCert/save.do",//证书-新增和修改
        "cdeleteById": cert_service + "api/ctCert/deleteById.do",//证书-批量删除
        "csubmitCheck": cert_service + "api/ctCert/submitCheck.do",//证书-提交审核
        "ccheck": cert_service + "api/ctCert/check.do",//证书-批量修改审核状态
        "cqueryById": cert_service + "api/ctCert/queryById.do",//证书-详情
        "cqueryManagePage": cert_service + "api/ctCert/queryManagePage.do",//证书-可管理列表查询
        "cqueryShowPage": cert_service + "api/ctCert/queryShowPage.do",//证书-可用列表查询
        "cqueryMainPage": cert_service + "api/ctCert/queryMainPage.do",//证书-主站下发列表查询
        "usave": cert_service + "api/ctUserCert/save.do",//用户证书-新增用户证书
        "uqueryManagePage": cert_service + "api/ctUserCert/queryManagePage.do",//用户证书-证书学员列表
        "uqueryUserPage": cert_service + "api/ctUserCert/queryUserPage.do",//用户证书-学员证书列表查询
        "upublish": cert_service + "api/ctUserCert/publish.do",//用户证书-批量发布/取消发布
    };

module.exports = {
    "news": news,
    "cert_servicelist": cert_servicelist,
    "activity_servicelist":activity_servicelist
};
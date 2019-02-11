package cn.com.weyeyun.commoncert.util;
/**
 * 同一种对象用同一个前缀，以便做数据更新时，缓存按照前缀批量更新，并且需要进行更新操作的 做一类前缀
 * @author ycguo
 *
 */
public class CacheKeyUtil {

	public static String cachePerfix = "core_";

	public static String categoryPrefix = cachePerfix + "categorys";

	public static String ArticlesByTwoCategoryPrefix = cachePerfix + "ArticlesByTwoCategory";

	public static String AllColumnsPrefix = cachePerfix + "AllColumns";

	public static String StudySitePrefix = cachePerfix + "StudySite";

	public static String ArticleConfigPrefix = cachePerfix + "articleConfig";

	public static String SigninConfigPrefix = cachePerfix + "signinConfig";

	public static String AdvertiseConfigPrefix = cachePerfix + "advertiseConfig";

	public static String ADVERTISEPREFIX = cachePerfix + "Advertise";

	public static String AllShowimgPre = cachePerfix + "Advertise";

	public static String AllPracticeunitPrefix = cachePerfix + "Practiceunit";

	public static String AllAboutmePrefix = cachePerfix + "Aboutme";

	// 有问有答（用于首页显示有问有答）
	public static String AllQuestionPrefix = cachePerfix + "Question";

	// 友情链接分类管理（用于首页显示友情链接分类）
	public static String AllFriendLinkTypePrefix = cachePerfix + "FriendLinkType";

	// 友情链接文字分类管理（用于首页显示友情链接文字分类）
	public static String AllLetterFriendlinkPrefix = cachePerfix + "LetterFriendlink";

	// 友情链接图片分类管理（用于首页显示友情链接图片分类）
	public static String AllImageFriendlinkPrefix = cachePerfix + "ImageFriendlink";

	// 展播图片项目管理
	public static String AllShowimgPrefix = cachePerfix + "Showimg";

	// 期号管理
	public static String AllPeriodPrefix = cachePerfix + "Period";

	// 期刊杂志管理
	public static String MagazinePrefix = cachePerfix + "Magazine";

	// 红腰带广告key前缀
	public static String WaistbandPrefix = cachePerfix + "Waistband";

	// 资料下载栏目key
	public static String FILETYPE_PREFIX = cachePerfix + "FileType";

	// 推荐课程key
	public static String COURSERECOMMEND_PREFIX = cachePerfix + "CourseRecommend";
	
	public static String PRODUCTCOMMEND_PREFIX = cachePerfix + "ProductRecommend";

	// 推荐教师key
	public static String TEACHERCOMMEND_PREFIX = cachePerfix + "TeacherRecommend";

	// 推荐课程key
	public static String FRIENDLINK_PREFIX = cachePerfix + "FriendLink";

	// 公告key
	public static String NOTICE_PREFIX = cachePerfix + "Notice";

	// 用户在学课程key
	public static String LEARNINGCOURSE_PREFIX = cachePerfix + "LearningCourse";

	// 用户最近在学课程key
	public static String LASTLEARNINGCOURSE_PREFIX = cachePerfix + "LastLearningCourse";

	// 用户选课key
	public static String USERSELECTCOURSERECORD_PREFIX = cachePerfix + "UserSelectCourseRecord";

	// 证书模板Key
	public static String CERTTEMPLATEPREFIX = cachePerfix + "CerttemplateKey";

	// 用户学习课程统计key
	public static String USERNAVCOURSECOUNT_PREFIX = cachePerfix + "UserNavCourseCount";
	/**
	 * 无锡新首页租户排行
	 */
	public static String wxeduTenantOrderMapPrefix = cachePerfix + "wxedutenantorder";

	/**
	 * 能力提升工程 首页区域排名
	 */
	public static String regionsVOOrderMapPrefix = cachePerfix + "regionsvoorder";

	// 首页缓存
	public static String INDEX = cachePerfix + "INDEX_";

	// 首页图片新闻
	public static String PICARTICLES = INDEX + "PICARTICLE";
	
    //短信验证码key
    public static String SMSCODE_PREFIX = cachePerfix + "smscode";

	/**
	 * 搜索新闻秩序缓存key，有过期机制
	 */
	public static String SEARCHE_ARTICLES = cachePerfix+ "SearchArticle";
	/**
	 * 通用key前缀
	 */
	public static String CommonPrefix = cachePerfix + "common";
	
	/**
	 * 梁溪首页课程
	 */
	public static String SEARCHE_COURSE = cachePerfix+ "SearchCourse";
	
	/**
	 * 远程文件服务器是否能使用
	 */
	public static String STATIC_URL_USED=cachePerfix+"staticurl";
	
	/**
	 * 梁溪首页课程
	 */
	public static String RERECOMEND_INDEX_PHASE = cachePerfix+ "RERECOMENDINDEXPHASE";
	
	/**
	 * 构建新闻资讯搜索数据缓存key
	 * @param orderBy
	 * @param order
	 * @param num
	 * @param catId
	 * @param tenantid
	 * @return
	 */
	public static String buildSearchArticleKey(String orderBy, String order, int num,
			long catId,Long tenantid) {
		return SEARCHE_ARTICLES + orderBy+ "_" +order + "_" + num + "_" +catId + "_" + tenantid;
	}
	
	/**
	 * 
	 * 构建证书模板cachekey
	 * 
	 * @since 2013-1-31
	 * @author fangyong
	 * @param parentId
	 * @return
	 */
	public static String buildCerttemplateKey(boolean status) {
		return CERTTEMPLATEPREFIX  + status;
	}

	/**
	 * 在学课表cache key
	 * 
	 * @param userId
	 * @return
	 */
	public static String buildUserLearningCourseCacheKey(long userId) {
		return LEARNINGCOURSE_PREFIX + userId;
	}

	/**
	 * 用户最近一次在学课程cache key
	 * 
	 * @param userId
	 * @return
	 */
	public static String buildUserLastLearningCourseCacheKey(long userId) {
		return LASTLEARNINGCOURSE_PREFIX + userId;
	}

	/**
	 * 
	 * 构造资料下载栏目key
	 * 
	 * @since 2011-11-9
	 * @author fangyong
	 * @param orderBy
	 * @param order
	 * @return
	 */
	public static String buildFileTypeKey(String orderBy, boolean order) {
		return FILETYPE_PREFIX + orderBy + "_" + order;
	}

	/**
	 * 学习网站城市key
	 * 
	 * @return
	 */
	public static String buildStudySiteCity() {
		return StudySitePrefix + "_city";
	}

	/**
	 * 红腰带广告key
	 * 
	 * @return
	 */
	public static String buildWaistband() {
		return WaistbandPrefix + "waistband";
	}

	/**
	 * 构造期号期刊key
	 * 
	 * @return
	 */
	public static String buildPeriodMagazine(String periodId) {
		return MagazinePrefix + periodId;
	}

	/**
	 * 构造一定类型年份期号期刊key
	 * 
	 * @return
	 */
	public static String buildPeriodMagazineType(int year, String periodId, int type) {
		return MagazinePrefix + periodId + "_" + year + "_" + type;
	}

	/**
	 * 构造一定数量期号期刊key
	 * 
	 * @return
	 */
	public static String buildPeriodMagazineTop(String periodId, String orderBy, String order, int num) {
		return MagazinePrefix + periodId + "_" + orderBy + "_" + order + "_" + num;
	}

	/**
	 * 构造所有期号key
	 * 
	 * @return
	 */
	public static String buildAllPeriod(int type, String orderBy, boolean isAsc) {
		return AllPeriodPrefix + type + "_" + orderBy + "_" + isAsc;
	}

	/**
	 * 构造展播图片项目管理key
	 * 
	 * @return
	 */
	public static String buildShowimgKey(String topic) {
		return AllShowimgPrefix + topic;
	}

	/**
	 * 构造首页显示友情链接图片分类管理key
	 * 
	 * @return
	 */
	public static String buildImageFriendlinkCatKey(String orderBy, String order, int num) {
		return AllImageFriendlinkPrefix + orderBy + "_" + order + "_" + num;
	}

	/**
	 * 构造首页显示友情链接文字分类管理key
	 * 
	 * @return
	 */
	public static String buildLetterFriendlinkCatKey(String catId, String orderBy, String order, int num) {
		return AllLetterFriendlinkPrefix + catId + "_" + orderBy + "_" + order + "_" + num;
	}

	/**
	 * 构造首页显示友情链接分类管理key
	 * 
	 * @return
	 */
	public static String buildFriendLinkTypeKey(String key) {
		return AllFriendLinkTypePrefix + "FriendLinkType+"+key;
	}

	/**
	 * 构造首页显示有问有答管理key
	 * 
	 * @return
	 */
	public static String buildQuestionCatKey(String orderBy, String order, int num) {
		return AllQuestionPrefix + orderBy + "_" + order + "_" + num;
	}

	/**
	 * 构造了解我们管理key
	 * 
	 * @return
	 */
	public static String buildAboutmeCatKey() {
		return AllAboutmePrefix + "Aboutme";
	}

	/**
	 * 构造某个城市下推荐的学习网站管理key
	 * 
	 * @return
	 */
	public static String buildCityStudySiteRecommndKey(String city) {
		return StudySitePrefix + "_recommnd_" + city;
	}

	/**
	 * 构造实践点管理key
	 * 
	 * @return
	 */
	public static String buildPracticeunitCatKey(String type) {
		return AllPracticeunitPrefix + type;
	}

	/**
	 * 构造公告管理,常见问题管理key
	 * 
	 * @return
	 */
	public static String buildArticleConfigCatKey(String orderBy, String order, int num, long type) {
		return ArticleConfigPrefix + orderBy + "_" + order + "_" + num + "_" + type;
	}

	public static String buildArticleConfigRecommendKey(String orderBy, String order, int num) {
		return ArticleConfigPrefix + orderBy + "_" + order + "_" + num + "_recommend";
	}

	/**
	 * 构造广告管理key
	 * 
	 * @return
	 */
	public static String buildAdvertiseConfigCatKey(int type) {
		return AdvertiseConfigPrefix + type;
	}

	/**
	 * 构造访问量key
	 * 
	 * @param key
	 * @return
	 */
	public static String buildVisitCountKey() {
		return cachePerfix + "visitCount";
	}

	/**
	 * 构建所有分类cachekey
	 * 
	 * @return
	 */
	public static String buildAllCategoryKey() {
		return categoryPrefix + "_";
	}

	/**
	 * 构建获得所有一级分类cachekey
	 * 
	 * @return
	 */
	public static String buildAllOneCategoryKey() {
		return categoryPrefix + "oneCategory";
	}

	/**
	 * 构建获得所有一级分类cachekey
	 * 
	 * @return
	 */
	public static String buildAllOneCategoryKeyByTenantid(String tenantId) {
		return categoryPrefix + "oneCategory" + tenantId;
	}

	public static String buildOneCategory(String key) {
		return categoryPrefix + "oneCategory_c_" + key;
	}
	
	/**
	 * 构建根据父级栏目Id查询子栏目分类cachekey
	 * 
	 * @return
	 */
	public static String buildCategoryByParentIdKey(String parentId, String tenantId) {
		return categoryPrefix + parentId + "_" + tenantId;
	}

	/**
	 * 构建根据二级分类取得指定数量的资讯
	 * 
	 * @param catID
	 * @param orderBy
	 * @param order
	 * @param num
	 * @param recommend
	 * @return
	 */
	public static String buildArticlesByTwoCategory(String code, int num) {
		return ArticlesByTwoCategoryPrefix + code + "_" + num;
	}

	/**
	 * 构建所有展播栏目cache key
	 * 
	 * @param orderBy
	 * @param isAsc
	 * @return
	 */
	public static String buildAllColumns(String orderBy, boolean isAsc) {
		return AllColumnsPrefix + orderBy + "_" + isAsc;
	}

	/**
	 * 构建所有学习网站
	 * 
	 * @return
	 */
	public static String buildAllRecommendStudySite() {
		return StudySitePrefix + "_AllRecommendStudySite";
	}

	/**
	 * 广告cache key
	 * 
	 * @return
	 */
	public static String buildAdvertiseKey(int num) {
		return ADVERTISEPREFIX  + num;
	}
	
	/**
	 * 广告前缀缓存key
	 * @param key
	 * @return
	 */
	public static String buildAdvertiseKey(String key) {
		return ADVERTISEPREFIX + key;
	}

	/**
	 * 构建推荐课程
	 * 
	 * @param orderBy
	 * @param order
	 * @param num
	 * @param type
	 * @return
	 */
	public static String buildCourseRecommendConfigCatKey(String orderBy, String order, int num, long type) {
		return COURSERECOMMEND_PREFIX + orderBy + "_" + order + "_" + num + "_" + type;
	}
	
	/**
	 * 构建商品
	 * 
	 * @param orderBy
	 * @param order
	 * @param num
	 * @param type
	 * @return
	 */
	public static String buildProductRecommendConfigCatKey(String orderBy, String order, int num, long type) {
		return PRODUCTCOMMEND_PREFIX + orderBy + "_" + order + "_" + num + "_" + type;
	}

	/**
	 * 推荐课程
	 * @param key
	 * @return
	 */
	public static String buildCourseRecommendKey(String key) {
		return COURSERECOMMEND_PREFIX + key;
	}
	
	public static String buildProductRecommendKey(String key) {
		return PRODUCTCOMMEND_PREFIX + key;
	}

	/**
	 * 构建推荐权威师资推荐
	 * 
	 * @param orderBy
	 * @param order
	 * @param num
	 * @param type
	 * @return
	 */
	public static String buildTeacherRecommendConfigCatKey(String orderBy, String order, int num) {
		return TEACHERCOMMEND_PREFIX + orderBy + "_" + order + "_" + num;
	}
	
	/**
	 * 所有推荐老师缓存key
	 * @return
	 */
	public static String buildTeacherRecommendAllKey() {
		return TEACHERCOMMEND_PREFIX + "_all" ;
	}

	/**
	 * 构建友情链接缓存key
	 * 
	 * @param orderBy
	 * @param order
	 * @param num
	 * @return
	 */
	public static String buildFriendLinkConfigCatKey(String orderBy, String order, int num) {
		return FRIENDLINK_PREFIX + orderBy + "_" + order + "_" + num;
	}

	/**
	 * 公告数据缓存key
	 * 
	 * @param num
	 * @return
	 */
	public static String buildNoticeCacheKey(int num) {
		return NOTICE_PREFIX + num;
	}

	/**
	 * 公告数据缓存key
	 * @param num
	 * @param tenantId
	 * @return
	 */
	public static String buildNoticeCacheKey(int num, Long tenantId) {
		return NOTICE_PREFIX + "_" + num+"_"+(tenantId==null?0:tenantId.longValue());
	}

	
	/**
	 * 用户选择课程cache key
	 * 
	 * @param userId
	 * @return
	 */
	public static String buildUserSeclectCourseCacheKey(long userId) {
		return USERSELECTCOURSERECORD_PREFIX  + userId;
	}

	public static String buildNavCourseCountCacheKey(String userId) {
		return USERNAVCOURSECOUNT_PREFIX + userId;
	}

	public static String getwxeduTenantOrderMapKey(String key) {
		return wxeduTenantOrderMapPrefix  + key;
	}

	public static String getregionsVOOrderMapKey(String key) {
		return regionsVOOrderMapPrefix + key;
	}
	
	/**
	 * 首页图片新闻key
	 * @param key
	 * @return
	 */
	public static String buildPicArticlesCacheKey(String key){
		return PICARTICLES  + key;
	}
	
	/**
	 * 首页推荐新闻资讯
	 * @param key
	 * @return
	 */
	public static String buildRecommendArticlesCacheKey(String key){
		return INDEX + "_rec_" + key;
	}
	/**
	 * 短信cache key
	 * @param token
	 * @return
	 */
    public static String buildSmscodeCacheKey(String token){
        return SMSCODE_PREFIX +token;
    }

    /**
	 * 构造通用key
	 * 
	 * @return
	 */
	public static String buildCommonKey(String key) {
		return CommonPrefix + key;
	}
    
    /**
     * 梁溪首页课程
     * @param token
     * @return
     */
    public static String buildIndexCourseCacheKey(Long tenantCode){
    	return SEARCHE_COURSE +tenantCode;
    }
    
    /**
     * 推荐首页项目
     * @param token
     * @return
     */
    public static String buildIndexPhaseCacheKey(Long tenantId){
    	return RERECOMEND_INDEX_PHASE +"_"+tenantId;
    }
}

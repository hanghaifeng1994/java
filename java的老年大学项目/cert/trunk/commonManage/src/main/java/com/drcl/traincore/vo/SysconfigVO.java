package com.drcl.traincore.vo;

public class SysconfigVO {

	
	@Override
	public String toString() {
		return "SysconfigVO [GMagickPath=" + GMagickPath
				+ ", ahcert_webapp_url=" + ahcert_webapp_url
				+ ", ahstudy_certification_url=" + ahstudy_certification_url
				+ ", ahstudy_ffmpeg=" + ahstudy_ffmpeg
				+ ", ahstudy_tryread_url=" + ahstudy_tryread_url
				+ ", ahstudy_upload_path_url=" + ahstudy_upload_path_url
				+ ", ahstudy_uploadpath=" + ahstudy_uploadpath
				+ ", ahstudy_uploadpath_tryread=" + ahstudy_uploadpath_tryread
				+ ", ahstudy_webapp_url=" + ahstudy_webapp_url
				+ ", ahstudy_webapp_url_inner=" + ahstudy_webapp_url_inner
				+ ", check_copycourse=" + check_copycourse
				+ ", check_create_ep_scorm=" + check_create_ep_scorm
				+ ", check_finished_tocert=" + check_finished_tocert
				+ ", check_gencert=" + check_gencert
				+ ", check_redefine_permission=" + check_redefine_permission
				+ ", check_repeatlearningcourse=" + check_repeatlearningcourse
				+ ", check_synstudy_tocert=" + check_synstudy_tocert
				+ ", check_synuser_tobbs=" + check_synuser_tobbs
				+ ", check_synuser_tocert=" + check_synuser_tocert
				+ ", check_synuser_tolms=" + check_synuser_tolms
				+ ", check_synuser_towebchat=" + check_synuser_towebchat
				+ ", clazz_tips_day=" + clazz_tips_day
				+ ", course_autoextend_period=" + course_autoextend_period
				+ ", course_coursescorm_addCourse="
				+ course_coursescorm_addCourse
				+ ", course_coursescorm_showCourse="
				+ course_coursescorm_showCourse
				+ ", course_coursescorm_webpath=" + course_coursescorm_webpath
				+ ", course_coursescorm_webpath_inner="
				+ course_coursescorm_webpath_inner
				+ ", course_coursescorm_wsdl=" + course_coursescorm_wsdl
				+ ", course_examcenter_exam=" + course_examcenter_exam
				+ ", course_examcenter_examination="
				+ course_examcenter_examination
				+ ", course_examcenter_paperrule="
				+ course_examcenter_paperrule
				+ ", course_examcenter_subjectbase="
				+ course_examcenter_subjectbase
				+ ", course_examcenter_webpath=" + course_examcenter_webpath
				+ ", course_examschedule_look=" + course_examschedule_look
				+ ", course_examschedule_manage=" + course_examschedule_manage
				+ ", course_examschedule_webpath="
				+ course_examschedule_webpath
				+ ", course_homework_addhomeworks="
				+ course_homework_addhomeworks
				+ ", course_homework_dohomeworks="
				+ course_homework_dohomeworks
				+ ", course_homework_readhomeworks="
				+ course_homework_readhomeworks + ", course_homework_webpath="
				+ course_homework_webpath + ", course_schedule_look="
				+ course_schedule_look + ", course_schedule_manage="
				+ course_schedule_manage + ", course_schedule_web_path="
				+ course_schedule_web_path + ", course_study_period="
				+ course_study_period + ", course_studycenter_addCourse="
				+ course_studycenter_addCourse
				+ ", course_studycenter_viewCourse="
				+ course_studycenter_viewCourse
				+ ", course_studycenter_webpath=" + course_studycenter_webpath
				+ ", course_studycenter_webpath_inner="
				+ course_studycenter_webpath_inner
				+ ", course_studycenter_wsdl=" + course_studycenter_wsdl
				+ ", develop_env=" + develop_env + ", epcourse_rootpath="
				+ epcourse_rootpath + ", jjkSecurityKey=" + jjkSecurityKey
				+ ", lp3_open=" + lp3_open + ", lp3_url=" + lp3_url
				+ ", merDomain=" + merDomain + ", orderform_period="
				+ orderform_period + ", pay_evn=" + pay_evn
				+ ", pay_istestmoney=" + pay_istestmoney + ", ssologin_cert="
				+ ssologin_cert + ", ssologin_url_inclient="
				+ ssologin_url_inclient + ", ssologin_url_inserver="
				+ ssologin_url_inserver + ", testSecurityKey="
				+ testSecurityKey + ", test_merDomain=" + test_merDomain
				+ ", test_upop_base_url=" + test_upop_base_url
				+ ", test_upop_query_url=" + test_upop_query_url
				+ ", upop_base_url=" + upop_base_url + ", upop_query_url="
				+ upop_query_url + ", xykSecurityKey=" + xykSecurityKey + "]";
	}

	private String ahstudy_webapp_url;     //主应用url
	
	private String ahstudy_webapp_url_inner;  //内网用的主应用url,如果服务器器可以访问外网那么可以和上面的主应用url保持一直
	
    private String ahstudy_uploadpath;    //各种文件上传目录
	
	private String ahstudy_uploadpath_tryread; //试读文件上传目录
	
	private String ahstudy_ffmpeg;     //转换为flv执行文件路径
	
	private String ahstudy_certification_url;  //成果认证地址
	
	private String ahstudy_upload_path_url;   //上传文件的http请求url
	
	private String ahstudy_tryread_url;   //上传试读文件的http请求url
	
	private String course_studycenter_webpath;  //课程平台的web主应用
	
	private String course_studycenter_webpath_inner;  //课程平台的web主应用
	
	private String course_studycenter_addCourse;  //
	
	private String course_studycenter_viewCourse;
	
	private String course_studycenter_wsdl;
	
	private String course_coursescorm_webpath;
	
	private String course_coursescorm_webpath_inner;
	
	private String course_coursescorm_addCourse;
	
	private String course_coursescorm_showCourse;
	
	private String course_coursescorm_wsdl;
	
	private String course_examcenter_webpath;
	
	private String course_examcenter_subjectbase;
	
	private String course_examcenter_paperrule;
	
	private String course_examcenter_exam;
	
	private String course_examcenter_examination;
	
	private String course_examschedule_webpath;
	
	private String course_examschedule_manage;
	
	private String course_examschedule_look;
	
	private String course_homework_webpath;
	
	private String course_homework_addhomeworks;
	
	private String course_homework_dohomeworks;
	
	private String course_homework_readhomeworks;
	
	private String course_schedule_web_path;
	
	private String course_schedule_manage;
	
	private String course_schedule_look;
	
	private String course_study_period;
	
	private String course_autoextend_period;
	
	private String clazz_tips_day;
	
	private String  test_merDomain;
	
	private String merDomain;
	
	private String test_upop_base_url;
	
	private String upop_base_url;
	
	private String test_upop_query_url;
	
	private String upop_query_url;
	
	private String jjkSecurityKey;
	
	private String xykSecurityKey;
	
	
	private String testSecurityKey;
	
	private String pay_evn;
	
	private String pay_istestmoney;
	
	private String ssologin_cert;
	
	private String ssologin_url_inserver;
	
	private String ssologin_url_inclient;
	
	
	private String ahcert_webapp_url;
	
	private String develop_env;
	
	private String check_synuser_tocert;
	
	private String check_synuser_towebchat;
	
	private String check_synstudy_tocert;
	
	private String check_synuser_tobbs;
	
	
	private String check_gencert;
	
	private String check_repeatlearningcourse;
	
	private String check_create_ep_scorm;
	
	private String check_finished_tocert;
	
	private String check_synuser_tolms;
	
	private String check_copycourse;
	
	
	private String check_redefine_permission;
	
	private String epcourse_rootpath;
	
	private String orderform_period;
	
	private String GMagickPath;
	
	private String lp3_open;
	
	private String lp3_url;
	
	public String getAhstudy_webapp_url() {
		return ahstudy_webapp_url;
	}

	public void setAhstudy_webapp_url(String ahstudyWebappUrl) {
		ahstudy_webapp_url = ahstudyWebappUrl;
	}

	public String getAhstudy_webapp_url_inner() {
		return ahstudy_webapp_url_inner;
	}

	public void setAhstudy_webapp_url_inner(String ahstudyWebappUrlInner) {
		ahstudy_webapp_url_inner = ahstudyWebappUrlInner;
	}



	public String getAhstudy_ffmpeg() {
		return ahstudy_ffmpeg;
	}

	public void setAhstudy_ffmpeg(String ahstudyFfmpeg) {
		ahstudy_ffmpeg = ahstudyFfmpeg;
	}

	public String getAhstudy_certification_url() {
		return ahstudy_certification_url;
	}

	public void setAhstudy_certification_url(String ahstudyCertificationUrl) {
		ahstudy_certification_url = ahstudyCertificationUrl;
	}

	public String getAhstudy_upload_path_url() {
		return ahstudy_upload_path_url;
	}

	public void setAhstudy_upload_path_url(String ahstudyUploadPathUrl) {
		ahstudy_upload_path_url = ahstudyUploadPathUrl;
	}

	public String getAhstudy_tryread_url() {
		return ahstudy_tryread_url;
	}

	public void setAhstudy_tryread_url(String ahstudyTryreadUrl) {
		ahstudy_tryread_url = ahstudyTryreadUrl;
	}


	public String getCourse_coursescorm_webpath() {
		return course_coursescorm_webpath;
	}

	public void setCourse_coursescorm_webpath(String courseCoursescormWebpath) {
		course_coursescorm_webpath = courseCoursescormWebpath;
	}

	public String getCourse_coursescorm_webpath_inner() {
		return course_coursescorm_webpath_inner;
	}

	public void setCourse_coursescorm_webpath_inner(
			String courseCoursescormWebpathInner) {
		course_coursescorm_webpath_inner = courseCoursescormWebpathInner;
	}

	public String getCourse_coursescorm_addCourse() {
		return course_coursescorm_addCourse;
	}

	public void setCourse_coursescorm_addCourse(String courseCoursescormAddCourse) {
		course_coursescorm_addCourse = courseCoursescormAddCourse;
	}

	public String getCourse_coursescorm_showCourse() {
		return course_coursescorm_showCourse;
	}

	public void setCourse_coursescorm_showCourse(String courseCoursescormShowCourse) {
		course_coursescorm_showCourse = courseCoursescormShowCourse;
	}

	public String getCourse_coursescorm_wsdl() {
		return course_coursescorm_wsdl;
	}

	public void setCourse_coursescorm_wsdl(String courseCoursescormWsdl) {
		course_coursescorm_wsdl = courseCoursescormWsdl;
	}

	public String getCourse_examcenter_webpath() {
		return course_examcenter_webpath;
	}

	public void setCourse_examcenter_webpath(String courseExamcenterWebpath) {
		course_examcenter_webpath = courseExamcenterWebpath;
	}

	public String getCourse_examcenter_subjectbase() {
		return course_examcenter_subjectbase;
	}

	public void setCourse_examcenter_subjectbase(String courseExamcenterSubjectbase) {
		course_examcenter_subjectbase = courseExamcenterSubjectbase;
	}

	public String getCourse_examcenter_paperrule() {
		return course_examcenter_paperrule;
	}

	public void setCourse_examcenter_paperrule(String courseExamcenterPaperrule) {
		course_examcenter_paperrule = courseExamcenterPaperrule;
	}

	public String getCourse_examcenter_exam() {
		return course_examcenter_exam;
	}

	public void setCourse_examcenter_exam(String courseExamcenterExam) {
		course_examcenter_exam = courseExamcenterExam;
	}

	public String getCourse_examcenter_examination() {
		return course_examcenter_examination;
	}

	public void setCourse_examcenter_examination(String courseExamcenterExamination) {
		course_examcenter_examination = courseExamcenterExamination;
	}

	public String getCourse_examschedule_webpath() {
		return course_examschedule_webpath;
	}

	public void setCourse_examschedule_webpath(String courseExamscheduleWebpath) {
		course_examschedule_webpath = courseExamscheduleWebpath;
	}

	public String getCourse_examschedule_manage() {
		return course_examschedule_manage;
	}

	public void setCourse_examschedule_manage(String courseExamscheduleManage) {
		course_examschedule_manage = courseExamscheduleManage;
	}

	public String getCourse_examschedule_look() {
		return course_examschedule_look;
	}

	public void setCourse_examschedule_look(String courseExamscheduleLook) {
		course_examschedule_look = courseExamscheduleLook;
	}

	public String getCourse_homework_webpath() {
		return course_homework_webpath;
	}

	public void setCourse_homework_webpath(String courseHomeworkWebpath) {
		course_homework_webpath = courseHomeworkWebpath;
	}

	public String getCourse_homework_addhomeworks() {
		return course_homework_addhomeworks;
	}

	public void setCourse_homework_addhomeworks(String courseHomeworkAddhomeworks) {
		course_homework_addhomeworks = courseHomeworkAddhomeworks;
	}

	public String getCourse_homework_dohomeworks() {
		return course_homework_dohomeworks;
	}

	public void setCourse_homework_dohomeworks(String courseHomeworkDohomeworks) {
		course_homework_dohomeworks = courseHomeworkDohomeworks;
	}

	public String getCourse_homework_readhomeworks() {
		return course_homework_readhomeworks;
	}

	public void setCourse_homework_readhomeworks(String courseHomeworkReadhomeworks) {
		course_homework_readhomeworks = courseHomeworkReadhomeworks;
	}

	public String getCourse_schedule_web_path() {
		return course_schedule_web_path;
	}

	public void setCourse_schedule_web_path(String courseScheduleWebPath) {
		course_schedule_web_path = courseScheduleWebPath;
	}

	public String getCourse_schedule_manage() {
		return course_schedule_manage;
	}

	public void setCourse_schedule_manage(String courseScheduleManage) {
		course_schedule_manage = courseScheduleManage;
	}

	public String getCourse_schedule_look() {
		return course_schedule_look;
	}

	public void setCourse_schedule_look(String courseScheduleLook) {
		course_schedule_look = courseScheduleLook;
	}

	public String getCourse_study_period() {
		return course_study_period;
	}

	public void setCourse_study_period(String courseStudyPeriod) {
		course_study_period = courseStudyPeriod;
	}

	public String getCourse_autoextend_period() {
		return course_autoextend_period;
	}

	public void setCourse_autoextend_period(String courseAutoextendPeriod) {
		course_autoextend_period = courseAutoextendPeriod;
	}

	public String getClazz_tips_day() {
		return clazz_tips_day;
	}

	public void setClazz_tips_day(String clazzTipsDay) {
		clazz_tips_day = clazzTipsDay;
	}

	public String getTest_merDomain() {
		return test_merDomain;
	}

	public void setTest_merDomain(String testMerDomain) {
		test_merDomain = testMerDomain;
	}

	public String getMerDomain() {
		return merDomain;
	}

	public void setMerDomain(String merDomain) {
		this.merDomain = merDomain;
	}

	public String getTest_upop_base_url() {
		return test_upop_base_url;
	}

	public void setTest_upop_base_url(String testUpopBaseUrl) {
		test_upop_base_url = testUpopBaseUrl;
	}

	public String getUpop_base_url() {
		return upop_base_url;
	}

	public void setUpop_base_url(String upopBaseUrl) {
		upop_base_url = upopBaseUrl;
	}

	public String getTest_upop_query_url() {
		return test_upop_query_url;
	}

	public void setTest_upop_query_url(String testUpopQueryUrl) {
		test_upop_query_url = testUpopQueryUrl;
	}

	public String getUpop_query_url() {
		return upop_query_url;
	}

	public void setUpop_query_url(String upopQueryUrl) {
		upop_query_url = upopQueryUrl;
	}

	public String getJjkSecurityKey() {
		return jjkSecurityKey;
	}

	public void setJjkSecurityKey(String jjkSecurityKey) {
		this.jjkSecurityKey = jjkSecurityKey;
	}

	public String getXykSecurityKey() {
		return xykSecurityKey;
	}

	public void setXykSecurityKey(String xykSecurityKey) {
		this.xykSecurityKey = xykSecurityKey;
	}

	public String getTestSecurityKey() {
		return testSecurityKey;
	}

	public void setTestSecurityKey(String testSecurityKey) {
		this.testSecurityKey = testSecurityKey;
	}

	public String getPay_evn() {
		return pay_evn;
	}

	public void setPay_evn(String payEvn) {
		pay_evn = payEvn;
	}

	public String getPay_istestmoney() {
		return pay_istestmoney;
	}

	public void setPay_istestmoney(String payIstestmoney) {
		pay_istestmoney = payIstestmoney;
	}

	public String getSsologin_cert() {
		return ssologin_cert;
	}

	public void setSsologin_cert(String ssologinCert) {
		ssologin_cert = ssologinCert;
	}

	public String getSsologin_url_inserver() {
		return ssologin_url_inserver;
	}

	public void setSsologin_url_inserver(String ssologinUrlInserver) {
		ssologin_url_inserver = ssologinUrlInserver;
	}

	public String getSsologin_url_inclient() {
		return ssologin_url_inclient;
	}

	public void setSsologin_url_inclient(String ssologinUrlInclient) {
		ssologin_url_inclient = ssologinUrlInclient;
	}

	public String getAhcert_webapp_url() {
		return ahcert_webapp_url;
	}

	public void setAhcert_webapp_url(String ahcertWebappUrl) {
		ahcert_webapp_url = ahcertWebappUrl;
	}

	public String getDevelop_env() {
		return develop_env;
	}

	public void setDevelop_env(String developEnv) {
		develop_env = developEnv;
	}

	public String getCheck_synuser_tocert() {
		return check_synuser_tocert;
	}

	public void setCheck_synuser_tocert(String checkSynuserTocert) {
		check_synuser_tocert = checkSynuserTocert;
	}

	public String getCheck_synuser_towebchat() {
		return check_synuser_towebchat;
	}

	public void setCheck_synuser_towebchat(String checkSynuserTowebchat) {
		check_synuser_towebchat = checkSynuserTowebchat;
	}

	public String getCheck_synstudy_tocert() {
		return check_synstudy_tocert;
	}

	public void setCheck_synstudy_tocert(String checkSynstudyTocert) {
		check_synstudy_tocert = checkSynstudyTocert;
	}

	public String getCheck_synuser_tobbs() {
		return check_synuser_tobbs;
	}

	public void setCheck_synuser_tobbs(String checkSynuserTobbs) {
		check_synuser_tobbs = checkSynuserTobbs;
	}

	public String getCheck_gencert() {
		return check_gencert;
	}

	public void setCheck_gencert(String checkGencert) {
		check_gencert = checkGencert;
	}

	public String getCheck_repeatlearningcourse() {
		return check_repeatlearningcourse;
	}

	public void setCheck_repeatlearningcourse(String checkRepeatlearningcourse) {
		check_repeatlearningcourse = checkRepeatlearningcourse;
	}

	public String getCheck_create_ep_scorm() {
		return check_create_ep_scorm;
	}

	public void setCheck_create_ep_scorm(String checkCreateEpScorm) {
		check_create_ep_scorm = checkCreateEpScorm;
	}

	public String getCheck_finished_tocert() {
		return check_finished_tocert;
	}

	public void setCheck_finished_tocert(String checkFinishedTocert) {
		check_finished_tocert = checkFinishedTocert;
	}

	public String getCheck_synuser_tolms() {
		return check_synuser_tolms;
	}

	public void setCheck_synuser_tolms(String checkSynuserTolms) {
		check_synuser_tolms = checkSynuserTolms;
	}

	public String getCheck_copycourse() {
		return check_copycourse;
	}

	public void setCheck_copycourse(String checkCopycourse) {
		check_copycourse = checkCopycourse;
	}

	public String getCheck_redefine_permission() {
		return check_redefine_permission;
	}

	public void setCheck_redefine_permission(String checkRedefinePermission) {
		check_redefine_permission = checkRedefinePermission;
	}

	public String getEpcourse_rootpath() {
		return epcourse_rootpath;
	}

	public void setEpcourse_rootpath(String epcourseRootpath) {
		epcourse_rootpath = epcourseRootpath;
	}

	public String getOrderform_period() {
		return orderform_period;
	}

	public void setOrderform_period(String orderformPeriod) {
		orderform_period = orderformPeriod;
	}

	public String getGMagickPath() {
		return GMagickPath;
	}

	public void setGMagickPath(String gMagickPath) {
		GMagickPath = gMagickPath;
	}

	public String getLp3_open() {
		return lp3_open;
	}

	public void setLp3_open(String lp3Open) {
		lp3_open = lp3Open;
	}

	public String getLp3_url() {
		return lp3_url;
	}

	public void setLp3_url(String lp3Url) {
		lp3_url = lp3Url;
	}

	public void setAhstudy_uploadpath(String ahstudy_uploadpath) {
		this.ahstudy_uploadpath = ahstudy_uploadpath;
	}

	public String getAhstudy_uploadpath() {
		return ahstudy_uploadpath;
	}

	public void setAhstudy_uploadpath_tryread(String ahstudy_uploadpath_tryread) {
		this.ahstudy_uploadpath_tryread = ahstudy_uploadpath_tryread;
	}

	public String getAhstudy_uploadpath_tryread() {
		return ahstudy_uploadpath_tryread;
	}

	public void setCourse_studycenter_webpath(String course_studycenter_webpath) {
		this.course_studycenter_webpath = course_studycenter_webpath;
	}

	public String getCourse_studycenter_webpath() {
		return course_studycenter_webpath;
	}

	public void setCourse_studycenter_webpath_inner(
			String course_studycenter_webpath_inner) {
		this.course_studycenter_webpath_inner = course_studycenter_webpath_inner;
	}

	public String getCourse_studycenter_webpath_inner() {
		return course_studycenter_webpath_inner;
	}

	public void setCourse_studycenter_addCourse(
			String course_studycenter_addCourse) {
		this.course_studycenter_addCourse = course_studycenter_addCourse;
	}

	public String getCourse_studycenter_addCourse() {
		return course_studycenter_addCourse;
	}

	public void setCourse_studycenter_viewCourse(
			String course_studycenter_viewCourse) {
		this.course_studycenter_viewCourse = course_studycenter_viewCourse;
	}

	public String getCourse_studycenter_viewCourse() {
		return course_studycenter_viewCourse;
	}

	public void setCourse_studycenter_wsdl(String course_studycenter_wsdl) {
		this.course_studycenter_wsdl = course_studycenter_wsdl;
	}

	public String getCourse_studycenter_wsdl() {
		return course_studycenter_wsdl;
	}

	
	
	
}

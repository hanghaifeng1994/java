package com.learnyeai.course.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.common.utils.WeyeCons;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.course.api.service.StdCustLearnResourceApiService;
import com.learnyeai.course.api.vo.StdCustLearnResourceVo;
import com.learnyeai.course.mapper.CrsCustLearnCourseMapper;
import com.learnyeai.course.model.CrsChapter;
import com.learnyeai.course.model.CrsChapterResourceRel;
import com.learnyeai.course.model.CrsCourse;
import com.learnyeai.course.model.CrsCourseHomework;
import com.learnyeai.course.model.CrsCourseTest;
import com.learnyeai.course.model.CrsCustLearnChapter;
import com.learnyeai.course.model.CrsCustLearnChapterRes;
import com.learnyeai.course.model.CrsCustLearnCourse;
import com.learnyeai.course.util.CourseUtil;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.CurrentUserInfoDao;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.mq.CourseMq;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.BeanUtils;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class CrsCustLearnCourseWyService extends WeyeBaseService<CrsCustLearnCourse> {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private CrsCustLearnCourseMapper crsCustLearnCourseMapper;

	@Resource
	private CrsCourseWyService crsCourseWyService;

	@Resource
	private CrsChapterWyService crsChapterWyService;

	@Resource
	private CrsCustLearnChapterWyService crsCustLearnChapterWyService;

	@Resource
	private CrsCustLearnChapterResWyService crsCustLearnChapterResWyService;

	@Resource
	private CrsChapterResourceRelWyService crsChapterResourceRelWyService;

	@Resource
	private StdCustLearnResourceApiService stdCustLearnResourceApiService;

	@Resource
	private CrsCourseTestWyService crsCourseTestWyService;

	@Resource
	private CrsCourseHomeworkWyService crsCourseHomeworkWyService;

	@Resource
	private CurrentUserInfoDao currentUserInfoDao;

	@Autowired
	private RabbitSender rabbitSender;

	@Override
	public BaseMapper<CrsCustLearnCourse> getMapper() {
		return crsCustLearnCourseMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Transactional
	public List<CrsCustLearnCourse> queryUserCoursesApi(String studyUserId, String csIds) {
		List<CrsCustLearnCourse> list = new ArrayList<CrsCustLearnCourse>();
		CrsCustLearnCourse clc = new CrsCustLearnCourse();
		clc.setLcsNormal("1");
		clc.setStudyUserId(studyUserId);
		for (String csId : csIds.split(",")) {
			CrsCourse course = crsCourseWyService.get(csId);
			if (course == null)
				continue;
			clc.setCsId(csId);
			CrsCustLearnCourse obj = super.queryOne(clc);
			if (obj == null)
				continue;
			obj.setCsName(course.getCsName());
			list.add(obj);
		}
		return list;
	}

	@Transactional
	public MyPage<CrsCustLearnCourse> queryMyCoursePage(CrsCustLearnCourse clc) {
		clc.setLcsNormal("1");
		clc.setStudyUserId(currentUserInfoDao.getId());
		MyPage<CrsCustLearnCourse> myPage = super.queryPage(clc, null);
		for (CrsCustLearnCourse obj : myPage.getList()) {
			CrsCourse course = crsCourseWyService.get(obj.getCsId());
			obj.setCsName(course.getCsName());
		}
		return myPage;
	}

	@Transactional
	public MyPage<CrsCustLearnCourse> queryUserCoursePage(CrsCustLearnCourse clc, String orderType,
			String coursedebug) {
		CrsCustLearnCourse learnCourse = new CrsCustLearnCourse();
		learnCourse.setLcsNormal("1");
		learnCourse.setStudyUserId(clc.getStudyUserId());
		learnCourse.setCsId(clc.getCsId());

		Map<String, Object> params = new HashMap<String, Object>();
		String sorts = "lcsFinished=1";
		if ("0".equals(orderType)) {// 进度排序
			sorts = "lcsFinished=1";
		} else if ("1".equals(orderType)) {// 学习时间排序 倒排
			sorts = "updateDate=0";
		} else if ("2".equals(orderType)) {// 选课时间排序 升序
			sorts = "createDate=1";
		} else if ("3".equals(orderType)) {// 选课时间排序 倒排
			sorts = "createDate=0";
		}
		params.put("sorts", sorts);
		MyPage<CrsCustLearnCourse> myPage = super.queryPage(learnCourse, params);
		if (StringUtils.isNotBlank(coursedebug) && "1".equals(coursedebug)) {// 需要课程信息 n+1
			for (CrsCustLearnCourse obj : myPage.getList()) {
				CrsCourse course = crsCourseWyService.get(obj.getCsId());
				obj.setCsName(course.getCsName());
			}
		}
		return myPage;
	}

	@Transactional
	public Map<String, Object> addUserCourse(CrsCustLearnCourse clc) {
		Map<String, Object> result = new HashMap();
		String[] uIds = clc.getStudyUserId().split(",");
		String[] cIds = clc.getCsId().split(",");
		for (String studyUserId : uIds) {
			for (String csId : cIds) {
				CrsCustLearnCourse param = new CrsCustLearnCourse();
				param.setStudyUserId(studyUserId);
				param.setCsId(csId);
				param = super.queryOne(param);
				if (param == null) {
					param = new CrsCustLearnCourse();
					param.setStudyUserId(studyUserId);
					param.setCsId(csId);
					param.setLcsStudyFinished("0");
					param.setLcsHomeworkeFinished("0");
					param.setLcsExameFinished("0");
					param.setLcsScoreFinished("0");
					param.setLcsFinished("0");
					param.setLcsNormal(clc.getLcsNormal());
					super.save(param);
					// 开始新增用户章节
					CrsChapter chapter = new CrsChapter();
					chapter.setCsId(csId);
					List<CrsChapter> chapters = crsChapterWyService.queryList(chapter, null);// 查询课程所有章节
					for (CrsChapter c : chapters) {
						CrsCustLearnChapter learnChapter = new CrsCustLearnChapter();
						learnChapter.setCsId(param.getCsId());
						learnChapter.setStudyUserId(param.getStudyUserId());
						learnChapter.setStudyFinished("0");
						learnChapter.setCptId(c.getCptId());
						crsCustLearnChapterWyService.save(learnChapter);// 新增用户学习章节

						CrsChapterResourceRel chapterResource = new CrsChapterResourceRel();
						chapterResource.setCptId(c.getCptId());
						List<CrsChapterResourceRel> chapterResources = crsChapterResourceRelWyService
								.queryList(chapterResource, null);// 查询章节下的所有资源
						for (CrsChapterResourceRel obj : chapterResources) {
							CrsCustLearnChapterRes res = new CrsCustLearnChapterRes();
							res.setLcptId(learnChapter.getLcptId());
							res.setStudyUserId(param.getStudyUserId());
							res.setResId(obj.getResId());
							crsCustLearnChapterResWyService.save(res);// 新增用户学习章节资源
						}
					}
				} else {
					if ("1".equals(clc.getLcsNormal())) {
						param.setLcsNormal(clc.getLcsNormal());
						super.save(param);
					}
				}
			}
		}
		result.put("status", "0");
		return result;
	}

	@Transactional
	public MyPage<CrsCustLearnCourse> queryUserPage(CrsCustLearnCourse clc) {
		if (clc != null && clc.getPage() != null && clc.getRows() != null) {
			PageHelper.startPage(clc.getPage(), clc.getRows());
		}
		clc.setLcsNormal("1");
		List<CrsCustLearnCourse> list = crsCustLearnCourseMapper.queryUserPage(clc);
		MyPage<CrsCustLearnCourse> page = new MyPage<CrsCustLearnCourse>(list);
		return page;
	}

	/**
	 * 处理消息队列
	 * 
	 * @param studyUserId
	 * @param resId
	 * @return
	 * @throws WeyeRabbitException
	 */
	@Transactional
	public Map<String, Object> saveQueueCustLearnCourse(String studyUserId, String resId, Date updateDate)
			throws Exception {
		logger.debug("开始处理用户学习资源消息userId={}|resId={}", studyUserId, resId);
		Map<String, Object> map = new HashMap<String, Object>();
		// 查出资源的所有课程
		CrsCustLearnChapterRes params = new CrsCustLearnChapterRes();
		params.setStudyUserId(studyUserId);
		params.setResId(resId);
		List<CrsCustLearnChapterRes> objs = crsCustLearnChapterResWyService.queryList(params, null);
		for (CrsCustLearnChapterRes obj : objs) {
			updateCustLearnCourse(obj.getStudyUserId(), obj.getCsId(), obj.getLcptId(), updateDate);
		}
		logger.debug("结束处理用户学习资源消息userId={}|resId={}", studyUserId, resId);
		map.put("status", 1);
		map.put("msg", "处理成功.");
		return map;
	}

	/**
	 * 更新用户课程
	 * 
	 * @param studyUserId
	 * @param csId
	 * @param cptId
	 * @param updateDate
	 * @return
	 * @throws Exception
	 */
	public boolean updateCustLearnCourse(String studyUserId, String csId, String cptId, Date updateDate)
			throws Exception {
		logger.debug("开始更新用户课程userId={}|csId={}", studyUserId, csId);
		// 查出资源的所有课程
		CrsCustLearnChapterRes params = new CrsCustLearnChapterRes();
		params.setStudyUserId(studyUserId);
		params.setCsId(csId);
		List<CrsCustLearnChapterRes> objs = crsCustLearnChapterResWyService.queryList(params, null);
		long studyTime = 0l;// 课程总学习时间
		for (CrsCustLearnChapterRes obj : objs) {
			logger.debug("调用用户资源接口  resId={}", obj.getResId());
			StdCustLearnResourceVo vo = stdCustLearnResourceApiService.queryUserResourceApi(studyUserId,
					obj.getResId());
			logger.debug("调用用户资源接口返回  vo=" + vo);
			if (vo == null)
				continue;
			studyTime += vo.getStudyTime();
		}
		logger.debug("统计用户课程学习时间 userId={}|csId={}|studyTime={}", studyUserId, csId, studyTime);
		CrsCustLearnCourse learnCourse = new CrsCustLearnCourse();
		learnCourse.setLcsNormal("1");
		learnCourse.setStudyUserId(studyUserId);
		learnCourse.setCsId(csId);
		learnCourse = super.queryOne(learnCourse);
		if (learnCourse != null) {
			CrsCourse course = crsCourseWyService.queryById(learnCourse.getCsId());
			learnCourse.setCurCptId(cptId);
			learnCourse.setLcsStudyTime(studyTime);
			learnCourse.setUpdateDate(updateDate);
			double lcsProcess = 0d;
			if ("1".equals(course.getCsStudyneed()) && course.getCsStudyTime() > 0l) {
				lcsProcess = studyTime * 100d / course.getCsStudyTime();
				if (lcsProcess > 100d)
					lcsProcess = 100d;
			}
			learnCourse.setLcsProcess(new BigDecimal(lcsProcess));
			if ("0".equals(learnCourse.getLcsStudyFinished())) {
				if ("1".equals(course.getCsStudyneed()) && learnCourse.getLcsStudyTime() > course.getCsStudyTime()) {
					learnCourse.setLcsStudyFinished("1");// 学习完成
					boolean finished = finished(learnCourse);
					if (finished) {
						learnCourse.setLcsFinished("1");
						logger.debug("用户课程学习完成，发送消息给教务服务.userId={}|csId={}", studyUserId, csId);
						CourseMq mq = new CourseMq(learnCourse.getStudyUserId(), learnCourse.getCsId(),
								learnCourse.getUpdateDate());
						RabbitMetaMessage msg = CourseUtil.toParseRabbitMetaMessage(mq);
						rabbitSender.send(msg);
					}
				}
			}
			crsCustLearnCourseMapper.updateByPrimaryKeySelective(learnCourse);
		}
		logger.debug("结束更新用户课程userId={}|csId={}", studyUserId, csId);
		return true;
	}

	/**
	 * 处理测验消息队列
	 * 
	 * @param studyUserId
	 * @param csId
	 * @param cptId
	 * @param resId
	 * @param updateDate
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Map<String, Object> saveTestingQueueCustLearnCourse(String studyUserId, String tsId, double score,
			Date updateDate) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		CrsCourseTest params = new CrsCourseTest();
		params.setTsId(tsId);
		List<CrsCourseTest> objs = crsCourseTestWyService.queryList(params, null);
		for (CrsCourseTest ct : objs) {
			CrsCustLearnCourse learnCourse = new CrsCustLearnCourse();
			learnCourse.setLcsNormal("1");
			learnCourse.setStudyUserId(studyUserId);
			learnCourse.setCsId(ct.getCsId());
			learnCourse = super.queryOne(learnCourse);
			if (learnCourse != null) {
				learnCourse.setLcsExamScore(new BigDecimal(score));
				learnCourse.setUpdateDate(updateDate);
				if ("0".equals(learnCourse.getLcsExameFinished())) {
					CrsCourse course = crsCourseWyService.queryById(learnCourse.getCsId());
					if ("1".equals(course.getCsExamneed())
							&& learnCourse.getLcsExamScore().doubleValue() >= course.getCsExamScore().doubleValue()) {
						learnCourse.setLcsExameFinished("1");// 测验完成
						boolean finished = finished(learnCourse);
						if (finished) {
							learnCourse.setLcsFinished("1");
							// 发送消息到消息队列，去统计课程总的学习时间
							CourseMq mq = new CourseMq(learnCourse.getStudyUserId(), learnCourse.getCsId(),
									learnCourse.getUpdateDate());
							RabbitMetaMessage msg = CourseUtil.toParseRabbitMetaMessage(mq);
							rabbitSender.send(msg);
							logger.debug("用户课程完成，发送消息给教务服务.");
						}
					}
				}
				crsCustLearnCourseMapper.updateByPrimaryKeySelective(learnCourse);
			}
		}
		map.put("status", 1);
		map.put("msg", "处理成功.");
		return map;
	}

	@Transactional
	public Map<String, Object> saveHomeworkQueueCustLearnCourse(String studyUserId, String hwId, double score,
			Date updateDate) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		CrsCourseHomework params = new CrsCourseHomework();
		params.setHwId(hwId);
		List<CrsCourseHomework> objs = crsCourseHomeworkWyService.queryList(params, null);
		for (CrsCourseHomework cw : objs) {
			CrsCustLearnCourse learnCourse = new CrsCustLearnCourse();
			learnCourse.setLcsNormal("1");
			learnCourse.setStudyUserId(studyUserId);
			learnCourse.setCsId(cw.getCsId());
			learnCourse = super.queryOne(learnCourse);
			if (learnCourse != null) {
				learnCourse.setLcsHomeworkScore(new BigDecimal(score));
				learnCourse.setUpdateDate(updateDate);
				if ("0".equals(learnCourse.getLcsHomeworkeFinished())) {
					CrsCourse course = crsCourseWyService.queryById(learnCourse.getCsId());
					if ("1".equals(course.getCsHomeworkneed()) && learnCourse.getLcsHomeworkScore()
							.doubleValue() >= course.getCsHomeworkScore().doubleValue()) {
						learnCourse.setLcsHomeworkeFinished("1");// 作业完成
						boolean finished = finished(learnCourse);
						if (finished) {
							learnCourse.setLcsFinished("1");
							// 发送消息到消息队列，去统计课程总的学习时间
							CourseMq mq = new CourseMq(learnCourse.getStudyUserId(), learnCourse.getCsId(),
									learnCourse.getUpdateDate());
							RabbitMetaMessage msg = CourseUtil.toParseRabbitMetaMessage(mq);
							rabbitSender.send(msg);
							logger.debug("用户课程完成，发送消息给教务服务.");
						}
					}
				}
				crsCustLearnCourseMapper.updateByPrimaryKeySelective(learnCourse);
			}
		}
		map.put("status", 1);
		map.put("msg", "处理成功.");
		return map;
	}

	public boolean finished(CrsCustLearnCourse learnCourse) {
		CrsCourse course = crsCourseWyService.queryById(learnCourse.getCsId());
		if ("1".equals(course.getCsStudyneed()) && learnCourse.getLcsStudyTime() < course.getCsStudyTime()) {
			return false;
		}
		if ("1".equals(course.getCsHomeworkneed())
				&& learnCourse.getLcsHomeworkScore().doubleValue() < course.getCsHomeworkScore().doubleValue()) {
			return false;
		}
		if ("1".equals(course.getCsExamneed())
				&& learnCourse.getLcsExamScore().doubleValue() < course.getCsExamScore().doubleValue()) {
			return false;
		}
		if ("1".equals(course.getCsScoreneed())
				&& learnCourse.getLcsScore().doubleValue() < course.getCsScore().doubleValue()) {
			return false;
		}
		return true;
	}

	/**
	 * 提供给其它服务调用的，新增用户课程
	 * 
	 * @param userIds
	 * @param csIds
	 * @return
	 */
	@Transactional
	public boolean saveUserCourseApi(String userIds, String csIds, String siteId, String normal) {
		logger.info("开始保存用户课程userIds={}|csIds={}|siteId={}", userIds, csIds, siteId);
		List<CrsCustLearnCourse> result = new ArrayList<CrsCustLearnCourse>();
		String[] uIds = userIds.split(",");
		String[] cIds = csIds.split(",");
		for (String studyUserId : uIds) {
			List<String> resIds = new ArrayList<String>();
			for (String csId : cIds) {
				CrsCustLearnCourse param = new CrsCustLearnCourse();
				param.setStudyUserId(studyUserId);
				param.setCsId(csId);
				param = super.queryOne(param);
				if (param == null) {
					param = new CrsCustLearnCourse();
					param.setStudyUserId(studyUserId);
					param.setCsId(csId);
					param.setLcsStudyFinished("0");
					param.setLcsHomeworkeFinished("0");
					param.setLcsExameFinished("0");
					param.setLcsScoreFinished("0");
					param.setLcsFinished("0");
					param.setLcsNormal(normal);
					param.setSiteId(siteId);
					super.save(param);
					// 开始新增用户章节
					CrsChapter chapter = new CrsChapter();
					chapter.setCsId(csId);
					List<CrsChapter> chapters = crsChapterWyService.queryList(chapter, null);// 查询课程所有章节
					for (CrsChapter c : chapters) {
						CrsCustLearnChapter learnChapter = new CrsCustLearnChapter();
						learnChapter.setCsId(param.getCsId());
						learnChapter.setStudyUserId(param.getStudyUserId());
						learnChapter.setStudyFinished("0");
						learnChapter.setCptId(c.getCptId());
						learnChapter.setSiteId(siteId);
						crsCustLearnChapterWyService.save(learnChapter);// 新增用户学习章节

						CrsChapterResourceRel chapterResource = new CrsChapterResourceRel();
						chapterResource.setCptId(c.getCptId());
						List<CrsChapterResourceRel> chapterResources = crsChapterResourceRelWyService
								.queryList(chapterResource, null);// 查询章节下的所有资源
						for (CrsChapterResourceRel obj : chapterResources) {
							CrsCustLearnChapterRes res = new CrsCustLearnChapterRes();
							res.setLcptId(learnChapter.getLcptId());
							res.setStudyUserId(studyUserId);
							res.setResId(obj.getResId());
							res.setCsId(csId);
							crsCustLearnChapterResWyService.save(res);// 新增用户学习章节资源
							resIds.add(obj.getResId());
						}
					}
				} else {
					if ("1".equals(normal)) {
						param.setLcsNormal(normal);
						super.save(param);
					}
				}
				result.add(param);
			}
			if (resIds != null && resIds.size() > 0) {
				logger.info("开始调用保存用户资源接口userId={}|resIds={}|siteId={}", studyUserId, resIds, siteId);
				boolean success = stdCustLearnResourceApiService.saveUserResourceApi(studyUserId,
						String.join(",", resIds), siteId, 1);
				if (!success)
					throw new RuntimeException("同步到用户资源失败!");
				logger.info("结束调用保存用户资源接口userId={}|resIds={}|siteId={}|success={}", studyUserId, resIds, siteId,
						success);

			}
		}
		return true;
	}

	/**
	 * 未登陆保存数据的，接口专用
	 * 
	 * @param t
	 * @return
	 */
	public int saveLearnCourse(CrsCustLearnCourse t) {
		int ret = 0;
		Object id = getId(t);
		if (id == null || id.toString().length() == 0) {
			// 生成主键
			id = genId();
			BeanUtils.setProperty(t, getIdProp(), id, true);
			String mchtId = WeyeThreadContextUtils.getMerchantId();
			if (StringUtils.isNotBlank(mchtId))
				BeanUtils.setProperty(t, WeyeCons.BEAN_NAME_MCHT_ID, mchtId, false);
			// 商户方案
			String mchtSchmId = WeyeThreadContextUtils.getMerchantSchemeId();
			if (StringUtils.isNotBlank(mchtSchmId))
				BeanUtils.setProperty(t, WeyeCons.BEAN_NAME_MCHT_SCHM_ID, mchtSchmId, false);
			// 站点，后管中，当前站点id必须为空
			String siteId = WeyeThreadContextUtils.getSiteId();
			if (StringUtils.isNotBlank(siteId))
				BeanUtils.setProperty(t, WeyeCons.BEAN_NAME_SITE_ID, siteId, false);
			ret = getMapper().insert(t);
		} else {
			ret = getMapper().updateByPrimaryKeySelective(t);
		}
		return ret;
	}

	@Override
	protected Weekend<CrsCustLearnCourse> genSqlExample(CrsCustLearnCourse t, Map params) {
		Weekend<CrsCustLearnCourse> w = super.genSqlExample(t, params);
		WeekendCriteria<CrsCustLearnCourse, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getLcsNormal())) {
			c.andEqualTo(CrsCustLearnCourse::getLcsNormal, t.getLcsNormal());
		}
		if (StringUtils.isNotBlank(t.getStudyUserId())) {
			c.andEqualTo(CrsCustLearnCourse::getStudyUserId, t.getStudyUserId());
		}
		if (StringUtils.isNotBlank(t.getCsId())) {
			if (t.getCsId().contains(",")) {
				c.andIn(CrsCustLearnCourse::getCsId, Arrays.asList(t.getCsId().split(",")));
			} else {
				c.andEqualTo(CrsCustLearnCourse::getCsId, t.getCsId());
			}
		}
		w.and(c);
		return w;
	}
}

package com.learnyeai.course.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.course.mapper.CrsCourseMapper;
import com.learnyeai.course.model.CrsCatalog;
import com.learnyeai.course.model.CrsCatalogCourseRel;
import com.learnyeai.course.model.CrsCourse;
import com.learnyeai.course.model.CrsSiteCourseRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.tools.common.StringUtils;

/**
 *
 * @author twang
 */
@Service
public class CrsCourseWyService extends WeyeBaseService<CrsCourse> {

	@Resource
	private CrsCourseMapper crsCourseMapper;

	@Resource
	private CrsSiteCourseRelWyService crsSiteCourseRelWyService;

	@Resource
	private CrsCatalogCourseRelWyService crsCatalogCourseRelWyService;
	
	@Resource
	private CrsCatalogWyService crsCatalogWyService;

	@Override
	public BaseMapper<CrsCourse> getMapper() {
		return crsCourseMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	/**
	 * status0操作成功 1操作失败 2:资源分类id不能为空
	 * 
	 * @param cs
	 * @return
	 */
	@Transactional
	public Map<String, Object> saveOrUpdate(CrsCourse cs) {
		Map<String, Object> map = new HashMap();
		boolean isNew = false;
		boolean isModifyCat = false;// 是否修改课程分类
		if (StringUtils.isBlank(cs.getCsId())) {
			cs.setCreateDate(new Date());
			cs.setCsPubStatus("0");
			cs.setCsStatus("0");
			cs.setCsTjStatus("0");
			isNew = true;
			if (StringUtils.isBlank(cs.getCsSerialNo())) {
				cs.setCsSerialNo(genSerialNo());
			}
		}
		if (StringUtils.isNotBlank(cs.getCsCatstr())) {
			isModifyCat = true;
		}
		if (cs.getCsStudyTime() != null) {// 数据库保存到秒
			cs.setCsStudyTime(cs.getCsStudyTime() * 60);
		}

		super.save(cs);

		/**
		 * 保存到缓存中去
		 */
		cs = crsCourseMapper.selectByPrimaryKey(cs.getCsId());
		RedisUtil redis = RedisUtilFactory.getUtil("course_courseDetail", CrsCourse.class);
		redis.set(cs.getCsId(), cs);

		if (isModifyCat) {
			List<CrsCatalogCourseRel> list = new ArrayList<CrsCatalogCourseRel>();
			CrsCatalogCourseRel ccr = new CrsCatalogCourseRel();
			ccr.setCsId(cs.getCsId());
			list = crsCatalogCourseRelWyService.queryList4Simple(ccr);
			for (CrsCatalogCourseRel rel : list) {
				crsCatalogCourseRelWyService.delete(rel);
			}
			CrsCatalogCourseRel addObj = null;
			for (String catId : cs.getCsCatstr().split(",")) {
				addObj = new CrsCatalogCourseRel();
				addObj.setCatId(catId);
				addObj.setCsId(cs.getCsId());
				crsCatalogCourseRelWyService.save(addObj);
			}
		}
		// 保存关系表
		if (isNew) {
			for (PtsetSiteVo site : SiteUtils.getPubSites(cs.getSiteId())) {
				CrsSiteCourseRel crsSiteCourseRel = new CrsSiteCourseRel();
				crsSiteCourseRel.setCsId(cs.getCsId());
				crsSiteCourseRel.setCsCrtSiteId(cs.getSiteId());
				crsSiteCourseRel.setSiteId(site.getSiteId());
				crsSiteCourseRel.setCsAsName(cs.getCsName());
				crsSiteCourseRel.setCsPubStatus("0");
				crsSiteCourseRel.setCsManageStatus("0");
				crsSiteCourseRel.setCsTjStatus("0");
				if (site.getSiteId().equals(cs.getSiteId())) {
					crsSiteCourseRel.setCsManageStatus("1");
				}
				crsSiteCourseRelWyService.save(crsSiteCourseRel);
			}
		}
		map.put("status", 0);
		map.put("msg", "保存成功!");
		map.put("id", cs.getCsId());
		return map;

	}

	@Transactional
	public Map<String, Object> deleteCourses(CrsCourse cs) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String csId : cs.getCsId().split(",")) {
			CrsCourse delOne = new CrsCourse();
			delOne.setCsId(csId);
			delOne.setDelFlag("1");
			int c = crsCourseMapper.updateByPrimaryKeySelective(delOne);
			if (c > 0)
				num++;
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> publish(CrsCourse cs) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String csId : cs.getCsId().split(",")) {
			CrsCourse course = super.queryById(csId);
			if (course == null)
				continue;
			if (course.getSiteId().equals(cs.getSiteId())) {// 自己站点的课程本表也要发布
				course.setCsPubDate(new Date());
				course.setCsPubStatus(cs.getCsPubStatus());
				super.save(course);
			}
			CrsSiteCourseRel crsSiteCourseRel = new CrsSiteCourseRel();
			crsSiteCourseRel.setCsId(csId);
			crsSiteCourseRel.setSiteId(cs.getSiteId());
			crsSiteCourseRel = crsSiteCourseRelWyService.queryOne(crsSiteCourseRel);
			if (crsSiteCourseRel != null) {
				crsSiteCourseRel.setCsPubStatus(cs.getCsPubStatus());
				crsSiteCourseRel.setCsPubDate(new Date());
				crsSiteCourseRelWyService.save(crsSiteCourseRel);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> tj(CrsCourse cs) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String csId : cs.getCsId().split(",")) {
			CrsCourse course = super.queryById(csId);
			if (course == null)
				continue;
			if (course.getSiteId().equals(cs.getSiteId())) {// 自己站点的课程本表也要推荐
				course.setCsTjDate(new Date());
				course.setCsTjStatus(cs.getCsTjStatus());
				super.save(course);
			}
			CrsSiteCourseRel crsSiteCourseRel = new CrsSiteCourseRel();
			crsSiteCourseRel.setCsId(csId);
			crsSiteCourseRel.setSiteId(cs.getSiteId());
			crsSiteCourseRel = crsSiteCourseRelWyService.queryOne(crsSiteCourseRel);
			if (crsSiteCourseRel != null) {
				crsSiteCourseRel.setCsTjStatus(cs.getCsTjStatus());
				crsSiteCourseRel.setCsTjDate(new Date());
				crsSiteCourseRelWyService.save(crsSiteCourseRel);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> check(CrsCourse cs) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String csId : cs.getCsId().split(",")) {
			CrsCourse obj = super.queryById(csId);
			if (obj != null) {
				obj.setCsStatus(cs.getCsStatus());
				super.save(obj);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> submitCheck(CrsCourse cs) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String csId : cs.getCsId().split(",")) {
			CrsCourse obj = super.queryById(csId);
			if (obj != null) {
				obj.setCsStatus("1");
				super.save(obj);
				System.out.println("发送审核消息队列。。。");
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> author(CrsCourse cs) {
		Map<String, Object> result = new HashMap();
		result.put("status", "0");
		return result;
	}

	public Object detail(String csIds) {
		List<CrsCourse> list = Lists.newArrayList();
		for (String csId : csIds.split(",")) {
			CrsCourse crsCourse = super.queryById(csId);
			if (crsCourse == null)
				continue;
			list.add(crsCourse);
		}
		return list;
	}

	public Object courseDetail(String csId, String chapter) {
		CrsCourse crsCourse = super.queryById(csId);
		if (StringUtils.isNotBlank(chapter) && "1".equals(chapter)) {
			System.out.println("去查询章节信息");
			System.out.println("*******************************************************************");
		}
		String csCatnamestr = "";
		if(StringUtils.isNotBlank(crsCourse.getCsCatstr())) {
			for (String catId : crsCourse.getCsCatstr().split(",")) {
				if (StringUtils.isBlank(catId))
					continue;
				CrsCatalog category = crsCatalogWyService.queryById(catId);
				if (category != null) {
					csCatnamestr += "," + category.getCatName();
				}
			}
		}
		if(StringUtils.isNotBlank(csCatnamestr)) {
			csCatnamestr = csCatnamestr.substring(1);
		}
		crsCourse.setCsCatnamestr(csCatnamestr);
		return crsCourse;
	}

	@Transactional
	public MyPage<CrsCourse> queryManagePage(CrsCourse cs) {
		if (cs != null && cs.getPage() != null && cs.getRows() != null) {
			PageHelper.startPage(cs.getPage(), cs.getRows());
		}
		List<CrsCourse> list = crsCourseMapper.queryManagePage(cs);
		MyPage<CrsCourse> page = new MyPage<CrsCourse>(list);
		return page;
	}

	@Transactional
	public MyPage<CrsCourse> queryShowPage(CrsCourse cs) {
		if (StringUtils.isNotBlank(cs.getCsCatstr())) {
			if (cs != null && cs.getPage() != null && cs.getRows() != null) {
				PageHelper.startPage(cs.getPage(), cs.getRows());
			}
			List<CrsCourse> list = crsCourseMapper.queryShowPage(cs);
			MyPage<CrsCourse> page = new MyPage<CrsCourse>(list);
			return page;
		} else {// n+1查询
			MyPage<CrsCourse> page = new MyPage<CrsCourse>();
			List<CrsCourse> list = new ArrayList<CrsCourse>();
			CrsSiteCourseRel rel = new CrsSiteCourseRel();
			rel.setCsPubStatus("1");
			rel.setCsAsName(cs.getCsName());
			rel.setCsTjStatus(cs.getCsTjStatus());
			rel.setSiteIds(cs.getSiteIds());
			rel.setPage(cs.getPage());
			rel.setRows(cs.getRows());
			Map<String, Object> params = new HashMap<String, Object>();

			String sorts = "csTjStatus=0&csTjDate=0&csPubDate=0";
			if (cs.getOrderType() == 0) {
				sorts = "csTjStatus=0&csTjDate=10&csPubDate=0";
			} else if (cs.getOrderType() == 1) {
				sorts = "csPubDate=0";
			} else if (cs.getOrderType() == 2) {
				sorts = "csPubDate=1";
			}
			params.put("sorts", sorts);
			MyPage<CrsSiteCourseRel> siteCoursePage = crsSiteCourseRelWyService.queryPage(rel, params);
			for (CrsSiteCourseRel siteCourse : siteCoursePage.getList()) {
				CrsCourse course = super.queryById(siteCourse.getCsId());
				if(course==null) continue;
				course.setCsName(siteCourse.getCsAsName());
				course.setCsPubDate(siteCourse.getCsPubDate());
				course.setCsPubStatus(siteCourse.getCsPubStatus());
				course.setCsTjStatus(siteCourse.getCsTjStatus());
				course.setCsTjDate(siteCourse.getCsTjDate());
				list.add(course);
			}
			page.setList(list);
			page.setPageNo(siteCoursePage.getPageNo());
			page.setPageSize(siteCoursePage.getPageSize());
			page.setTotal(siteCoursePage.getTotal());
			return page;
		}

	}

	@Transactional
	public MyPage<CrsCourse> queryMainPage(CrsCourse cs) {
		if (cs != null && cs.getPage() != null && cs.getRows() != null) {
			PageHelper.startPage(cs.getPage(), cs.getRows());
		}
		List<CrsCourse> list = crsCourseMapper.queryMainPage(cs);
		MyPage<CrsCourse> page = new MyPage<CrsCourse>(list);
		return page;

	}

	private synchronized String genSerialNo() {
		String serialNo = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss" + new Random().nextInt(1000000));
		return serialNo;
	}

	public List<CrsCourse> queryCoursesApi(String csIds) {
		List<CrsCourse> list = new ArrayList<CrsCourse>();
		for (String csId : csIds.split(",")) {
			CrsCourse course = getMapper().selectByPrimaryKey(csId);
			if (course == null)
				continue;
			list.add(course);
		}
		return list;
	}

	/**
	 * 通过课程id查询课程明细，包括删除的，走缓存
	 * @param csId
	 * @return
	 */
	@Cacheable(cacheNames = "course_courseDetail", key = "#csId")
	public CrsCourse get(String csId) {
		CrsCourse course = getMapper().selectByPrimaryKey(csId);
		return course;
	}
}

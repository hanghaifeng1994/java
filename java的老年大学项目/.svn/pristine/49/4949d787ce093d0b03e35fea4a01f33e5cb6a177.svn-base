package com.learnyeai.schoolclass.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.api.service.CrsCourseApiService;
import com.learnyeai.schoolclass.api.service.CtUserCertApiService;
import com.learnyeai.schoolclass.api.vo.CrsCourseVo;
import com.learnyeai.schoolclass.api.vo.CtUserCertVo;
import com.learnyeai.schoolclass.mapper.ClzClazzCourseMapper;
import com.learnyeai.schoolclass.model.ClzClazzCourse;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class ClzClazzCourseWyService extends WeyeBaseService<ClzClazzCourse> {

	@Resource
	private ClzClazzCourseMapper clzClazzCourseMapper;

	@Resource
	private CrsCourseApiService crsCourseApiService;

	@Resource
	private CtUserCertApiService ctUserCertApiService;

	@Override
	public BaseMapper<ClzClazzCourse> getMapper() {
		return clzClazzCourseMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	@Transactional
	public Map<String, Object> saveOrUpdate(ClzClazzCourse cc) {
		Map<String, Object> map = new HashMap();
		if (StringUtils.isBlank(cc.getCcId())) {
			cc.setDelFlag("0");
			CrsCourseVo course = crsCourseApiService.queryById(cc.getCsId());
			if (course == null) {
				map.put("status", 1);
				map.put("msg", "保存失败，课程不存在!");
				return map;
			}
			if (cc.getCsAmount() == null) {
				cc.setCsAmount(course.getCsPrice());
			}
			if (cc.getCsStudylength() == null) {
				cc.setCsStudylength(course.getCsStudylength());
			}
			cc.setSiteId(course.getSiteId());
		}
		super.save(cc);
		map.put("status", 0);
		map.put("msg", "保存成功!");
		map.put("id", cc.getCcId());
		return map;

	}

	@Transactional
	public Map<String, Object> delClazzCourses(ClzClazzCourse cc) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String ccId : cc.getCcId().split(",")) {
			ClzClazzCourse t = new ClzClazzCourse();
			t.setCcId(ccId);
			t.setDelFlag("1");
			int c = clzClazzCourseMapper.updateByPrimaryKeySelective(t);
			if (c > 0)
				num++;
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public MyPage<ClzClazzCourse> queryShowPage(ClzClazzCourse cc) {
		if (cc != null && cc.getPage() != null && cc.getRows() != null) {
			PageHelper.startPage(cc.getPage(), cc.getRows());
		}
		MyPage<ClzClazzCourse> page = super.queryPage(cc, null);
		// 通过接口查找所有课程详细
		for (ClzClazzCourse clazzCourse : page.getList()) {
			CrsCourseVo course = crsCourseApiService.queryCourseApi(clazzCourse.getCsId());
			if (course != null) {
				clazzCourse.setCsName(course.getCsName());
			}

		}
		return page;
	}

	@Override
	protected Weekend<ClzClazzCourse> genSqlExample(ClzClazzCourse t, Map params) {
		Weekend<ClzClazzCourse> w = super.genSqlExample(t, params);
		WeekendCriteria<ClzClazzCourse, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCsId())) {
			if (t.getCsId().contains(",")) {
				c.andIn(ClzClazzCourse::getCsId, Arrays.asList(t.getCsId().split(",")));
			} else {
				c.andEqualTo(ClzClazzCourse::getCsId, t.getCsId());
			}
		}
		if (StringUtils.isNotBlank(t.getCzId())) {
			c.andEqualTo(ClzClazzCourse::getCzId, t.getCzId());
		}
		if (t.getCsType() != null) {
			c.andEqualTo(ClzClazzCourse::getCsType, t.getCsType());
		}
		w.and(c);
		return w;
	}

}

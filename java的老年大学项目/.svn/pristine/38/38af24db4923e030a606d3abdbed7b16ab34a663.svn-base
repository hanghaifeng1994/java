package com.learnyeai.course.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.mapper.CrsCustLearnChapterResMapper;
import com.learnyeai.course.model.CrsCustLearnChapterRes;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class CrsCustLearnChapterResWyService extends WeyeBaseService<CrsCustLearnChapterRes> {

	@Resource
	private CrsCustLearnChapterResMapper crsCustLearnChapterResMapper;

	@Override
	public BaseMapper<CrsCustLearnChapterRes> getMapper() {
		return crsCustLearnChapterResMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Override
	protected Weekend<CrsCustLearnChapterRes> genSqlExample(CrsCustLearnChapterRes t, Map params) {
		Weekend<CrsCustLearnChapterRes> w = super.genSqlExample(t, params);
		WeekendCriteria<CrsCustLearnChapterRes, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getLcptId())) {
			c.andEqualTo(CrsCustLearnChapterRes::getLcptId, t.getLcptId());
		}
		if (StringUtils.isNotBlank(t.getResId())) {
			c.andEqualTo(CrsCustLearnChapterRes::getResId, t.getResId());
		}
		if (StringUtils.isNotBlank(t.getStudyUserId())) {
			c.andEqualTo(CrsCustLearnChapterRes::getStudyUserId, t.getStudyUserId());
		}
		if (StringUtils.isNotBlank(t.getCsId())) {
			c.andEqualTo(CrsCustLearnChapterRes::getCsId, t.getCsId());
		}
		w.and(c);
		return w;
	}
}

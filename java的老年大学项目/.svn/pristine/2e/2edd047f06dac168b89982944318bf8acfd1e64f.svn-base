package com.learnyeai.course.service;

import com.learnyeai.course.model.CrsCustLearnChapter;
import com.learnyeai.course.model.CrsCustLearnChapter;
import com.learnyeai.course.mapper.CrsCustLearnChapterMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import java.util.Map;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class CrsCustLearnChapterWyService extends WeyeBaseService<CrsCustLearnChapter> {

	@Resource
	private CrsCustLearnChapterMapper crsCustLearnChapterMapper;

	@Override
	public BaseMapper<CrsCustLearnChapter> getMapper() {
		return crsCustLearnChapterMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Override
	protected Weekend<CrsCustLearnChapter> genSqlExample(CrsCustLearnChapter t, Map params) {
		Weekend<CrsCustLearnChapter> w = super.genSqlExample(t, params);
		WeekendCriteria<CrsCustLearnChapter, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getLcptId())) {
			c.andEqualTo(CrsCustLearnChapter::getLcptId, t.getLcptId());
		}
		if (StringUtils.isNotBlank(t.getStudyUserId())) {
			c.andEqualTo(CrsCustLearnChapter::getStudyUserId, t.getStudyUserId());
		}
		if (StringUtils.isNotBlank(t.getCptId())) {
			c.andEqualTo(CrsCustLearnChapter::getCptId, t.getCptId());
		}
		w.and(c);
		return w;
	}
}

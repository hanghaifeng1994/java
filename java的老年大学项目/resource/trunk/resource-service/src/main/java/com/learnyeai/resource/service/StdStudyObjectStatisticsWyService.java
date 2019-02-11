package com.learnyeai.resource.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.resource.mapper.StdStudyObjectStatisticsMapper;
import com.learnyeai.resource.model.StdStudyObjectStatistics;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author yl
 */
@Service
public class StdStudyObjectStatisticsWyService extends WeyeBaseService<StdStudyObjectStatistics> {

	@Resource
	private StdStudyObjectStatisticsMapper stdStudyObjectStatisticsMapper;

	@Override
	public BaseMapper<StdStudyObjectStatistics> getMapper() {
		return stdStudyObjectStatisticsMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	public List<StdStudyObjectStatistics> queryByResId(StdStudyObjectStatistics params) {
		List<StdStudyObjectStatistics> result = Lists.newArrayList();
		for (String objId : params.getObjId().split(",")) {
			StdStudyObjectStatistics obj = new StdStudyObjectStatistics();
			obj.setObjId(objId);
			obj.setType(params.getType());
			obj = super.queryOne(obj);
			if (obj != null)
				result.add(obj);
		}
		return result;
	}

	@Override
	protected Weekend<StdStudyObjectStatistics> genSqlExample(StdStudyObjectStatistics t, Map params) {
		Weekend<StdStudyObjectStatistics> w = super.genSqlExample(t, params);
		WeekendCriteria<StdStudyObjectStatistics, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getType())) {
			c.andEqualTo(StdStudyObjectStatistics::getType, t.getType());
		}
		if (StringUtils.isNotBlank(t.getObjId())) {
			c.andEqualTo(StdStudyObjectStatistics::getObjId, t.getObjId());
		}
		w.and(c);
		return w;
	}
}

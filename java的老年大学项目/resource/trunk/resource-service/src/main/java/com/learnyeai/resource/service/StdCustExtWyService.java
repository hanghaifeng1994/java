package com.learnyeai.resource.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.resource.mapper.StdCustExtMapper;
import com.learnyeai.resource.model.StdCustExt;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class StdCustExtWyService extends WeyeBaseService<StdCustExt> {

	@Resource
	private StdCustExtMapper stdCustExtMapper;

	@Override
	public BaseMapper<StdCustExt> getMapper() {
		return stdCustExtMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}
	
	public List<StdCustExt> queryByUserId(StdCustExt params) {
		List<StdCustExt> result = Lists.newArrayList();
		for (String objId : params.getCustId().split(",")) {
			StdCustExt obj = new StdCustExt();
			obj.setCustId(objId);
			obj = super.queryOne(obj);
			if (obj != null)
				result.add(obj);
		}
		return result;
	}

	@Override
	protected Weekend<StdCustExt> genSqlExample(StdCustExt t, Map params) {
		Weekend<StdCustExt> w = super.genSqlExample(t, params);
		WeekendCriteria<StdCustExt, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCustId())) {
			c.andEqualTo(StdCustExt::getCustId, t.getCustId());
		}
		w.and(c);
		return w;
	}
}

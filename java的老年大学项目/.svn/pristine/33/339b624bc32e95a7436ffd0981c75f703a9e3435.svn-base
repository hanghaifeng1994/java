package com.learnyeai.orderform.service;

import com.learnyeai.orderform.model.OrdOrderformDetail;
import com.learnyeai.orderform.model.OrdOrderformDetail;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import com.learnyeai.orderform.mapper.OrdOrderformDetailMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class OrdOrderformDetailWyService extends WeyeBaseService<OrdOrderformDetail> {

	@Resource
	private OrdOrderformDetailMapper ordOrderformDetailMapper;

	@Override
	public BaseMapper<OrdOrderformDetail> getMapper() {
		return ordOrderformDetailMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Override
	protected Weekend<OrdOrderformDetail> genSqlExample(OrdOrderformDetail t, Map params) {
		Weekend<OrdOrderformDetail> w = super.genSqlExample(t, params);
		WeekendCriteria<OrdOrderformDetail, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getOrderId())) {
			c.andEqualTo(OrdOrderformDetail::getOrderId, t.getOrderId());
		}
		if (StringUtils.isNotBlank(t.getOrdDetailId())) {
			c.andEqualTo(OrdOrderformDetail::getOrdDetailId, t.getOrdDetailId());
		}
		w.and(c);
		return w;
	}
}

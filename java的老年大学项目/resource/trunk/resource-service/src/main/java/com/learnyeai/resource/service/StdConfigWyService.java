package com.learnyeai.resource.service;

import com.learnyeai.resource.model.StdConfig;
import com.learnyeai.resource.mapper.StdConfigMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class StdConfigWyService extends WeyeBaseService<StdConfig> {

	@Resource
	private StdConfigMapper stdConfigMapper;

	@Override
	public BaseMapper<StdConfig> getMapper() {
		return stdConfigMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	public StdConfig queryByItem(String cgItem) {
		StdConfig param = new StdConfig();
		param.setCgItem(cgItem);
		StdConfig obj = super.queryOne(param);
		if(obj==null) {
			obj = new StdConfig();
			obj.setId(super.genId());
			obj.setCgItem(cgItem);
			obj.setCgValue("20180808080808000");
			stdConfigMapper.insertSelective(obj);
		}
		return obj;
	}
}

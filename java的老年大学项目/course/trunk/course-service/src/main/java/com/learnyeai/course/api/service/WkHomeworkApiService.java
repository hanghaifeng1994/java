package com.learnyeai.course.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.course.api.client.WkHomeworkClient;
import com.learnyeai.course.api.vo.WkHomeworkVo;
import com.learnyeai.learnai.support.BaseClientService;

/**
 *
 * @author twang
 */
@Service
public class WkHomeworkApiService extends BaseClientService<WkHomeworkVo> {
	@Autowired
	private WkHomeworkClient wkHomeworkClient;

	@Override
	public BaseFeignClient<WkHomeworkVo> getFeignClient() {
		return wkHomeworkClient;
	}

	@Override
	public Object getId(Map params) {
		String idKey = "hwId";
		if (params.containsKey(idKey)) {
			return params.get(idKey);
		}
		return null;
	}

	@Cacheable(cacheNames = "homework_homeworkDetail", key = "#hwId")
	public WkHomeworkVo queryHomeworkApi(String hwId) {
		return wkHomeworkClient.queryHomeworkApi(hwId);
	}
}

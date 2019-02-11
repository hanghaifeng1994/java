package com.learnyeai.course.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.course.api.client.TestingTestClient;
import com.learnyeai.course.api.vo.TestingTestVo;
import com.learnyeai.learnai.support.BaseClientService;

/**
 *
 * @author twang
 */
@Service
public class TestingTestApiService extends BaseClientService<TestingTestVo> {
	@Autowired
	private TestingTestClient testingTestClient;

	@Override
	public BaseFeignClient<TestingTestVo> getFeignClient() {
		return testingTestClient;
	}

	@Override
	public Object getId(Map params) {
		String idKey = "tsId";
		if (params.containsKey(idKey)) {
			return params.get(idKey);
		}
		return null;
	}

	@Cacheable(cacheNames = "testing_testDetail", key = "#tsId")
	public TestingTestVo queryTestApi(String tsId) {
		return testingTestClient.queryTestApi(tsId);
	}
}

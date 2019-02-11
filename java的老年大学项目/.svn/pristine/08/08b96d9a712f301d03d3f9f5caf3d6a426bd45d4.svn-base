package com.learnyeai.testing.service;

import com.learnyeai.testing.model.TestingItemTypes;
import com.learnyeai.testing.mapper.TestingItemTypesMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class TestingItemTypesWyService extends WeyeBaseService<TestingItemTypes> {

	@Resource
	private TestingItemTypesMapper testingItemTypesMapper;

	@Override
	public BaseMapper<TestingItemTypes> getMapper() {
		return testingItemTypesMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Cacheable(cacheNames = "testing_itemTypes", key = "#itemTypeId")
	public TestingItemTypes get(String itemTypeId) {
		return super.queryById(itemTypeId);
	}
}

package com.learnyeai.resource.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.resource.mapper.StdCustLearnResourceMapper;
import com.learnyeai.resource.model.ResResource;
import com.learnyeai.resource.model.StdCustLearnResource;

/**
 *
 * @author twang
 */
@Service
public class StdCustLearnResourceCatchService extends WeyeBaseService<StdCustLearnResource> {

	@Resource
	private StdCustLearnResourceMapper stdCustLearnResourceMapper;
	
	@Override
	public BaseMapper<StdCustLearnResource> getMapper() {
		return stdCustLearnResourceMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Cacheable(cacheNames = "resource_resourceLearn", key = "#key")
	public StdCustLearnResource queryUserResource(String key) {
		String[] keys = key.split("_");
		if (keys.length < 2)
			return null;
		StdCustLearnResource learnResource = new StdCustLearnResource();
		learnResource.setStudyUserId(keys[0]);
		learnResource.setResId(keys[1]);
		learnResource = super.queryOne(learnResource);
		if(learnResource==null) return null;
		return learnResource;
	}

	@CachePut(cacheNames = "resource_resourceLearn", key = "#key")
	public StdCustLearnResource saveUserResource(String key, StdCustLearnResource learnResource) {
		return learnResource;
	}

	@CacheEvict(cacheNames = "resource_resourceLearn", key = "#key")
	public void removeUserResource(String key) {
	}
}

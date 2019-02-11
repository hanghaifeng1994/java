package com.learnyeai.course.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.course.api.client.StdCustLearnResourceClient;
import com.learnyeai.course.api.vo.ResResourceVo;
import com.learnyeai.course.api.vo.StdCustLearnResourceVo;
import com.learnyeai.learnai.support.BaseClientService;

/**
 *
 * @author twang
 */
@Service
public class StdCustLearnResourceApiService extends BaseClientService<StdCustLearnResourceVo> {
	@Autowired
	private StdCustLearnResourceClient stdCustLearnResourceClient;

	@Override
	public BaseFeignClient<StdCustLearnResourceVo> getFeignClient() {
		return stdCustLearnResourceClient;
	}

	@Override
	public Object getId(Map params) {
		String idKey = "lresId";
		if (params.containsKey(idKey)) {
			return params.get(idKey);
		}
		return null;
	}

	public boolean saveUserResourceApi(String userIds, String resIds, String siteId, int source) {
		return stdCustLearnResourceClient.saveUserResourceApi(userIds, resIds, siteId, source);
	}

	public List<StdCustLearnResourceVo> queryUserResourcesApi(String userId, String resIds) {
		return stdCustLearnResourceClient.queryUserResourcesApi(userId, resIds);
	}
	
	@Cacheable(cacheNames="resource_resourceLearn",key = "#userId+'_'+#resId")
	public StdCustLearnResourceVo queryUserResourceApi(String userId, String resId) {
		return stdCustLearnResourceClient.queryUserResourceApi(userId, resId);
	}
	
	@Cacheable(cacheNames="resource_resourceDetail",key = "#resId")
	public ResResourceVo queryResourceApi(String resId) {
		return stdCustLearnResourceClient.queryResourceApi(resId);
	}
}

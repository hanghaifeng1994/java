package com.learnyeai.schoolclass.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import com.learnyeai.schoolclass.api.client.CrsCourseClient;
import com.learnyeai.schoolclass.api.vo.CrsCourseVo;

/**
 *
 * @author twang
 */
@Service
public class CrsCourseApiService extends BaseClientService<CrsCourseVo> {
	@Autowired
	private CrsCourseClient crsCourseClient;

	@Override
	public BaseFeignClient<CrsCourseVo> getFeignClient() {
		return crsCourseClient;
	}

	@Override
	public Object getId(Map params) {
		String idKey = "csId";
		if (params.containsKey(idKey)) {
			return params.get(idKey);
		}
		return null;
	}

	public List<CrsCourseVo> queryCoursesApi(String csIds) {
		return crsCourseClient.queryCoursesApi(csIds);
	}

	@Cacheable(cacheNames = "course_courseDetail", key = "#csId")
	public CrsCourseVo queryCourseApi(String csId) {
		return crsCourseClient.queryCourseApi(csId);
	}
}

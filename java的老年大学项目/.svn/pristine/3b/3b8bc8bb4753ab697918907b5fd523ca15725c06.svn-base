package com.learnyeai.schoolclass.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import com.learnyeai.schoolclass.api.client.CrsCustLearnCourseClient;
import com.learnyeai.schoolclass.api.vo.CrsCustLearnCourseVo;

/**
 *
 * @author twang
 */
@Service
public class CrsCustLearnCourseApiService extends BaseClientService<CrsCustLearnCourseVo> {
	@Autowired
	private CrsCustLearnCourseClient crsCustLearnCourseClient;

	@Override
	public BaseFeignClient<CrsCustLearnCourseVo> getFeignClient() {
		return crsCustLearnCourseClient;
	}

	@Override
	public Object getId(Map params) {
		String idKey = "lcsId";
		if (params.containsKey(idKey)) {
			return params.get(idKey);
		}
		return null;
	}

	public List<CrsCustLearnCourseVo> queryUserCoursesApi(String studyUserId, String csIds) {
		return crsCustLearnCourseClient.queryUserCoursesApi(studyUserId, csIds);
	}

	public boolean saveUserCourseApi(String userIds, String csIds, String siteId) {
		return crsCustLearnCourseClient.saveUserCourseApi(userIds, csIds, siteId);
	}
}

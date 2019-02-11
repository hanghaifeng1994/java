package com.learnyeai.homework.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.homework.model.WkHomework;
import com.learnyeai.homework.service.WkHomeworkWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + WkHomeworkAction.BASE_URL)
public class WkHomeworkAction extends ApiBaseController<WkHomework> {
	public static final String BASE_URL = "/WkHomework/";

	@Autowired
	private WkHomeworkWyService wkHomeworkWyService;

	@Override
	protected BaseService<WkHomework> getBaseService() {
		return wkHomeworkWyService;
	}

	@Override
	public String getBaseUrl() {
		return BASE_URL;
	}

	@RequestMapping(value = "/queryHomeworkApi", method = RequestMethod.GET)
	public WkHomework queryHomeworkApi(String hwId) {
		return wkHomeworkWyService.get(hwId);
	}
}

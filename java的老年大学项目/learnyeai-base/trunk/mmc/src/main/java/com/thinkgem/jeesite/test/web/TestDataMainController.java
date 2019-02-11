/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.web.BaseExtController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.test.entity.TestDataMain;
import com.thinkgem.jeesite.test.service.TestDataMainService;

/**
 * 主子表生成Controller
 * @author ThinkGem
 * @version 2016-09-19
 */
@Controller
@RequestMapping(value = "${adminPath}/test/testDataMain")
public class TestDataMainController extends BaseExtController {

	@Autowired
	private TestDataMainService testDataMainService;
	
	@ModelAttribute
	public TestDataMain get(@RequestParam(required=false) String id) {
		TestDataMain entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testDataMainService.get(id);
		}
		if (entity == null){
			entity = new TestDataMain();
		}
		return entity;
	}

    @Override
    protected String getBasePermission() {
        return "test:testDataMain";
    }

	@RequestMapping(value = {"list", ""})
	public String list(TestDataMain testDataMain, HttpServletRequest request, HttpServletResponse response, Model model) {
		checkPermission("view");
		Page<TestDataMain> page = testDataMainService.findPage(new Page<TestDataMain>(request, response), testDataMain); 
		model.addAttribute("page", page);
		return "jeesite/test/testDataMainList";
	}

	@RequestMapping(value = "form")
	public String form(TestDataMain testDataMain, Model model) {
		checkPermission("view");
		model.addAttribute("testDataMain", testDataMain);
		return "jeesite/test/testDataMainForm";
	}

	@RequestMapping(value = "save")
	public String save(TestDataMain testDataMain, Model model, RedirectAttributes redirectAttributes) {
		checkPermission("edit");
		if (!beanValidator(model, testDataMain)){
			return form(testDataMain, model);
		}
		testDataMainService.save(testDataMain);
		addMessage(redirectAttributes, "保存主子表成功");
		return "redirect:"+Global.getAdminPath()+"/test/testDataMain/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(TestDataMain testDataMain, RedirectAttributes redirectAttributes) {
		checkPermission("edit");
		testDataMainService.delete(testDataMain);
		addMessage(redirectAttributes, "删除主子表成功");
		return "redirect:"+Global.getAdminPath()+"/test/testDataMain/?repage";
	}

}
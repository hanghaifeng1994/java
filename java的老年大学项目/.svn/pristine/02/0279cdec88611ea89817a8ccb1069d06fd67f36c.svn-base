/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.test.entity.TestTreeZpz;
import com.thinkgem.jeesite.modules.test.service.TestTreeZpzService;

/**
 * 测试树生成zpzController
 * @author 张配忠
 * @version 2016-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/test/testTreeZpz")
public class TestTreeZpzController extends BaseController {

	@Autowired
	private TestTreeZpzService testTreeZpzService;
	
	@ModelAttribute
	public TestTreeZpz get(@RequestParam(required=false) String id) {
		TestTreeZpz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testTreeZpzService.get(id);
		}
		if (entity == null){
			entity = new TestTreeZpz();
		}
		return entity;
	}
	
	@RequiresPermissions("test:testTreeZpz:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestTreeZpz testTreeZpz, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<TestTreeZpz> list = testTreeZpzService.findList(testTreeZpz); 
		model.addAttribute("list", list);
		return "modules/test/testTreeZpzList";
	}

	@RequiresPermissions("test:testTreeZpz:view")
	@RequestMapping(value = "form")
	public String form(TestTreeZpz testTreeZpz, Model model) {
		if (testTreeZpz.getParent()!=null && StringUtils.isNotBlank(testTreeZpz.getParent().getId())){
			testTreeZpz.setParent(testTreeZpzService.get(testTreeZpz.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(testTreeZpz.getId())){
				TestTreeZpz testTreeZpzChild = new TestTreeZpz();
				testTreeZpzChild.setParent(new TestTreeZpz(testTreeZpz.getParent().getId()));
				List<TestTreeZpz> list = testTreeZpzService.findList(testTreeZpz); 
				if (list.size() > 0){
					testTreeZpz.setSort(list.get(list.size()-1).getSort());
					if (testTreeZpz.getSort() != null){
						testTreeZpz.setSort(testTreeZpz.getSort() + 30);
					}
				}
			}
		}
		if (testTreeZpz.getSort() == null){
			testTreeZpz.setSort(30);
		}
		model.addAttribute("testTreeZpz", testTreeZpz);
		return "modules/test/testTreeZpzForm";
	}

	@RequiresPermissions("test:testTreeZpz:edit")
	@RequestMapping(value = "save")
	public String save(TestTreeZpz testTreeZpz, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testTreeZpz)){
			return form(testTreeZpz, model);
		}
		testTreeZpzService.save(testTreeZpz);
		addMessage(redirectAttributes, "保存文章分类成功");
		return "redirect:"+Global.getAdminPath()+"/test/testTreeZpz/?repage";
	}
	
	@RequiresPermissions("test:testTreeZpz:edit")
	@RequestMapping(value = "delete")
	public String delete(TestTreeZpz testTreeZpz, RedirectAttributes redirectAttributes) {
		testTreeZpzService.delete(testTreeZpz);
		addMessage(redirectAttributes, "删除文章分类成功");
		return "redirect:"+Global.getAdminPath()+"/test/testTreeZpz/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<TestTreeZpz> list = testTreeZpzService.findList(new TestTreeZpz());
		for (int i=0; i<list.size(); i++){
			TestTreeZpz e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}
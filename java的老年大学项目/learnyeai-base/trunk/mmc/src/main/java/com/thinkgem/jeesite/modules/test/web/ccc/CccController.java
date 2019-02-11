/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.web.ccc;

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
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.test.entity.ccc.Ccc;
import com.thinkgem.jeesite.modules.test.service.ccc.CccService;

/**
 * cccController
 * @author ccc
 * @version 2016-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/test/ccc/ccc")
public class CccController extends BaseController {

	@Autowired
	private CccService cccService;
	
	@ModelAttribute
	public Ccc get(@RequestParam(required=false) String id) {
		Ccc entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cccService.get(id);
		}
		if (entity == null){
			entity = new Ccc();
		}
		return entity;
	}
	
	@RequiresPermissions("test:ccc:ccc:view")
	@RequestMapping(value = {"list", ""})
	public String list(Ccc ccc, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ccc> page = cccService.findPage(new Page<Ccc>(request, response), ccc); 
		model.addAttribute("page", page);
		return "modules/test/ccc/cccList";
	}

	@RequiresPermissions("test:ccc:ccc:view")
	@RequestMapping(value = "form")
	public String form(Ccc ccc, Model model) {
		model.addAttribute("ccc", ccc);
		return "modules/test/ccc/cccForm";
	}

	@RequiresPermissions("test:ccc:ccc:edit")
	@RequestMapping(value = "save")
	public String save(Ccc ccc, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ccc)){
			return form(ccc, model);
		}
		cccService.save(ccc);
		addMessage(redirectAttributes, "保存ccc成功");
		return "redirect:"+Global.getAdminPath()+"/test/ccc/ccc/?repage";
	}
	
	@RequiresPermissions("test:ccc:ccc:edit")
	@RequestMapping(value = "delete")
	public String delete(Ccc ccc, RedirectAttributes redirectAttributes) {
		cccService.delete(ccc);
		addMessage(redirectAttributes, "删除ccc成功");
		return "redirect:"+Global.getAdminPath()+"/test/ccc/ccc/?repage";
	}

}
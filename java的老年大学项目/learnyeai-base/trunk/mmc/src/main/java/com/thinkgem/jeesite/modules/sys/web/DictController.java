/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.weye.core.message.send.MessageSendService;
import cn.com.weye.core.model.SysDict;
import cn.com.weye.core.service.SysDictService;
import cn.com.weye.core.utils.ConfigEnum;
import cn.com.weye.core.utils.SysDictUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import cn.com.weye.core.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 字典Controller
 * @author ThinkGem
 * @version 2014-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/dict")
public class DictController extends BaseController {

	@Resource
	private SysDictService sysDictService;

//	@Autowired
//	private MessageSendService sendService;

	@ModelAttribute
	public SysDict get(@RequestParam(required=false) String id) {
		if (org.apache.commons.lang3.StringUtils.isNotBlank(id)){
			return sysDictService.queryById(id);
		}else{
			return new SysDict();
		}
	}

	@RequiresPermissions("sys:dict:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysDict dict, HttpServletRequest request, HttpServletResponse response, Model model) {
		cn.com.weye.core.consts.ConsTools.getConsMap();
		List<String> typeList = sysDictService.findTypeList();
		model.addAttribute("typeList", typeList);
		Page<SysDict> page = sysDictService.find(new Page<SysDict>(request, response), dict);
		model.addAttribute("page", page);
		model.addAttribute("dict", dict);
		return "modules/sys/dictList";
	}

	@RequiresPermissions("sys:dict:view")
	@RequestMapping(value = "form")
	public String form(SysDict dict, Model model) {
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}

	@RequiresPermissions("sys:dict:view")
	@RequestMapping(value = "formAdd")
	public String formAdd(SysDict dict, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		//解决字典表里添加键值的时候描述中文乱码问题
//    	Object descObj = request.getParameter("descriptin");
//    	if(descObj!=null && descObj.toString().length()>0){
//    		String descStr_ISO = descObj.toString();
////    		String descStr_UTF8 = new String(descStr_ISO.getBytes("ISO-8859-1"),"UTF-8");
//    		dict.setDescription(descStr_ISO);
//    	}
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}

	@RequiresPermissions("sys:dict:edit")
	@RequestMapping(value = "save")//@Valid
	public String save(SysDict dict, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:"+Global.getAdminPath()+"/sys/dict/list?repage&type="+dict.getType();
		}
		sysDictService.save(dict);
		addMessage(redirectAttributes, "保存字典'" + dict.getLabel() + "'成功");

//		sendService.sendQueue("DICT_CHANGE", "DICT_CHANGE:" + dict.getType());

		return "redirect:"+Global.getAdminPath()+"/sys/dict/list?repage&type="+dict.getType();
	}

	@RequiresPermissions("sys:dict:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:"+Global.getAdminPath()+"/sys/dict/list?repage";
		}
		sysDictService.delete(id);
		addMessage(redirectAttributes, "删除字典成功");
		return "redirect:"+Global.getAdminPath()+"/sys/dict/list?repage";
	}

	/**
	 * 服务配置列表
	 * @param dict
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:dict:view")
	@RequestMapping(value = {"toServerList"})
	public String toServerList(SysDict dict, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysDict> page = sysDictService.findServerList(new Page<SysDict>(request, response), dict);
		model.addAttribute("page", page);
		model.addAttribute("dict", dict);
		return "modules/sys/serverList";
	}

	@RequiresPermissions("sys:dict:view")
	@RequestMapping(value = "toServerForm")
	public String toServerAdd(SysDict dict, Model model) {
		dict.setType("SYS_PARAM");
		model.addAttribute("dict", dict);
		return "modules/sys/serverForm";
	}

	@RequestMapping("serverConfigRepeatCheck")
	@ResponseBody
	public boolean serverConfigRepeatCheck(String value) {
		return null == SysDictUtils.getDictValue(value, ConfigEnum.DICT_SYS_PARAMS, null);
	}

	@RequestMapping("dictRepeatCheck")
	@ResponseBody
	public boolean dictRepeatCheck(String newType, String newValue) {
		return null == SysDictUtils.getDictLabel(newValue, newType, null);
	}

	/**
	 * 添加服务配置
	 * @param dict
	 * @param request
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:dict:edit")
	@RequestMapping(value = "serverSave")//@Valid
	public String serverSave(SysDict dict, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:"+Global.getAdminPath()+"/sys/dict/toServerList?repage&type="+dict.getType();
		}
		if (!beanValidator(model, dict)){
			return form(dict, model);
		}
		sysDictService.save(dict);

		addMessage(redirectAttributes, "保存服务配置'" + dict.getLabel() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/sys/dict/toServerList?repage&type="+dict.getType();
	}

	/**
	 * 删除服务配置
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:dict:edit")
	@RequestMapping(value = "deleteServer")
	public String deleteServer(String id, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:"+Global.getAdminPath()+"/sys/dict/toServerList?repage";
		}
		sysDictService.delete(id);
		addMessage(redirectAttributes, "删除服务配置成功");
		return "redirect:"+Global.getAdminPath()+"/sys/dict/toServerList?repage";
	}
}

/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.com.weye.modules.attach.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.weye.modules.attach.service.AttachmentService;
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
import cn.com.weye.modules.attach.entity.Attachment;

/**
 * 附件操作Controller
 * @author 张配忠
 * @version 2016-09-21
 */
@Controller
@RequestMapping(value = "${adminPath}/attach/attachment")
public class AttachmentController extends BaseExtController {

	@Autowired
	private AttachmentService attachmentService;
	
	@ModelAttribute
	public Attachment get(@RequestParam(required=false) String id) {
		Attachment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = attachmentService.get(id);
		}
		if (entity == null){
			entity = new Attachment();
		}
		return entity;
	}

    @Override
    protected String getBasePermission() {
        return "attach:attachment";
    }

	@RequestMapping(value = {"list", ""})
	public String list(Attachment attachment, HttpServletRequest request, HttpServletResponse response, Model model) {
		checkPermission("view");
		Page<Attachment> page = attachmentService.findPage(new Page<Attachment>(request, response), attachment); 
		model.addAttribute("page", page);
		return "modules/attach/attachmentList";
	}

	@RequestMapping(value = "form")
	public String form(Attachment attachment, Model model) {
		checkPermission("view");
		model.addAttribute("attachment", attachment);
		return "modules/attach/attachmentForm";
	}

	@RequestMapping(value = "save")
	public String save(Attachment attachment, Model model, RedirectAttributes redirectAttributes) {
		checkPermission("edit");
		if (!beanValidator(model, attachment)){
			return form(attachment, model);
		}
		attachmentService.save(attachment);
		addMessage(redirectAttributes, "保存附件成功");
		return "redirect:"+Global.getAdminPath()+"/attach/attachment/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Attachment attachment, RedirectAttributes redirectAttributes) {
		checkPermission("edit");
		attachmentService.delete(attachment);
		addMessage(redirectAttributes, "删除附件成功");
		return "redirect:"+Global.getAdminPath()+"/attach/attachment/?repage";
	}

}
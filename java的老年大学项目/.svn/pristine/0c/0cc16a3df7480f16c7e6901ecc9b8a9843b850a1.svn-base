package com.drcl.traincore.web.manage;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import cn.common.lib.springside.web.CrudActionSupport;

import com.drcl.traincore.dto.CertDTO;

/**
 * 
 * 友情链接后台Action
 * 
 * @author sli
 * @author zzhe
 * @version 1.0
 * @since 2015-1-12
 * 
 * @author hbqian checked by hbqian at 2050812 整理代码
 */
// 定义URL映射对应/assist/manage/friendlink.action
@Namespace("/cert/manage")
// 定义名为reload的result重定向到friendlink.action, 其他result则按照convention默认.
@Results({ @Result(name = CrudActionSupport.RELOAD, location = "cert.action", type = "redirect") })
public class CertAction extends BaseCrudAction<CertDTO> {
	private static final long serialVersionUID = 8683878162525847972L;
	@Override
	public String input() throws Exception {
		return INPUT;
	}

	@Override
	public String list() throws Exception {
		return SUCCESS;
	}

	@Override
	protected void prepareModel() throws Exception {
	}

	public String termplate() {
		return "termplate";
	}

	@Override
	public String save() throws Exception {
		this.addActionMessage("保存成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		return RELOAD;
	}

	@Override
	public CertDTO getModel() {
		return null;
	}
}

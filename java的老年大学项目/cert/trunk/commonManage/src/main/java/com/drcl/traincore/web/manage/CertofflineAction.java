package com.drcl.traincore.web.manage;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import cn.common.lib.springside.web.CrudActionSupport;

import com.drcl.traincore.dto.CertDTO;

/**
 * 线下证书管理
 * 
 * @author twang
 * 
 */
@Namespace("/cert/manage")
@Results({ @Result(name = CrudActionSupport.RELOAD, location = "certoffline.action", type = "redirect") })
public class CertofflineAction extends BaseCrudAction<CertDTO> {
	private static final long serialVersionUID = -4557257320854510857L;

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
		return RELOAD;
	}

	@Override
	public CertDTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

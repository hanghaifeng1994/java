package com.drcl.traincore.web.manage;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import cn.common.lib.springside.web.CrudActionSupport;

import com.drcl.traincore.dto.UserCertOfflineDTO;

/**
 * 用户线下证书action
 * 
 * @author chenbo
 * 
 */
@Namespace("/cert/manage")
@Results({ @Result(name = CrudActionSupport.RELOAD, location = "usercertoffline.action", type = "redirect") })
public class UsercertofflineAction extends BaseCrudAction<UserCertOfflineDTO> {

	@Override
	public String input() throws Exception {
		return INPUT;
	}

	@Override
	protected void prepareModel() throws Exception {
	}

	@Override
	public String save() throws Exception {
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		return RELOAD;
	}

	// 保存批量删除的Id
	public void setIds(Long[] ids) {
	}

	/*
	 * 发布证书
	 */
	public String publish() {
		return RELOAD;
	}

	public String printed() throws Exception {
		return list();
	}

	public String unprinted() throws Exception {
		return list();
	}

	public String unpublish() {
		return RELOAD;
	}

	@Override
	public String list() throws Exception {
		return SUCCESS;
	}

	@Override
	public UserCertOfflineDTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

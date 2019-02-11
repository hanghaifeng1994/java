package com.drcl.traincore.web.manage;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import cn.common.lib.springside.web.CrudActionSupport;

import com.drcl.traincore.dto.CertTemplateDTO;

/**
 * 
 * 证书模板管理
 * 
 * @author fangyong
 * @version 1.0
 * @since 2012-9-3
 * 
 * @author hbqian checked by hbqian at 2050812 整理代码
 */
@Namespace("/cert/manage")
@Results({ @Result(name = CrudActionSupport.RELOAD, location = "certtemplate.action", type = "redirect") })
public class CerttemplateAction extends BaseCrudAction<CertTemplateDTO> {
	private static final long serialVersionUID = -3470173971812733351L;

	/**
	 * 进入保存页面
	 * 
	 * @since 2012-3-21
	 * @see cn.common.lib.springside.web.CrudActionSupport#input()
	 */
	@Override
	public String input() throws Exception {
		return INPUT;
	}

	/**
	 * 查询
	 * 
	 * @since 2012-3-21
	 * @see cn.common.lib.springside.web.CrudActionSupport#list()
	 */
	@Override
	public String list() throws Exception {
		// 设置默认排序方式
		return SUCCESS;
	}

	@Override
	protected void prepareModel() throws Exception {
	}

	/**
	 * 保存
	 * 
	 * @since 2012-3-21
	 * @see cn.common.lib.springside.web.CrudActionSupport#save()
	 */
	@Override
	public String save() throws Exception {
		return RELOAD;
	}

	/**
	 * 删除
	 * 
	 * @since 2012-6-15
	 * @see cn.common.lib.springside.web.CrudActionSupport#delete()
	 */
	@Override
	public String delete() throws Exception {
		return RELOAD;
	}

	/**
	 * 
	 * 批量取消启用
	 * 
	 * @since 2013-1-30
	 * @author fangyong
	 * @param idsList
	 * @return
	 */
	public String cancleUse() {
		return RELOAD;
	}

	/**
	 * 
	 * 批量启用
	 * 
	 * @since 2013-1-30
	 * @author fangyong
	 * @param idsList
	 * @return
	 */
	public String batchUse() {
		return RELOAD;
	}

	/**
	 * 证书单个预览和打印
	 * 
	 * @since 2013-2-1
	 * @see cn.common.lib.springside.web.CrudActionSupport#input()
	 */
	@SuppressWarnings("unchecked")
	public String singleViewPrint() throws Exception {
		return null;
	}

	@Override
	public CertTemplateDTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

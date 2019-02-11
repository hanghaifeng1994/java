package com.drcl.traincore.web.manage;

import org.apache.struts2.convention.annotation.Namespace;

/**
 * 后台管理首页
 * 
 * @author qianhb
 * 
 * @author hbqian checked by hbqian at 2050812 整理代码
 */
@Namespace("/admin")
public class IndexAction extends BaseManageAction<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3403229976576017316L;

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}

}

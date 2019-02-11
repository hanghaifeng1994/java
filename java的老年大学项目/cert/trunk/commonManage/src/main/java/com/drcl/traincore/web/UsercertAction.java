package com.drcl.traincore.web;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 后台管理首页
 * 
 * @author qianhb
 * 
 * @author hbqian checked by hbqian at 2050812 整理代码
 */
@Namespace("/")
public class UsercertAction extends ActionSupport {
	private static final long serialVersionUID = -3403229976576017316L;
	private Long id;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

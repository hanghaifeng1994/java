/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.com.weye.modules.attach.entity;

import cn.com.weye.core.utils.ConfigUtils;
import org.hibernate.validator.constraints.Length;

import cn.com.weye.core.persistence.DataExtEntity;

/**
 * 附件操作Entity
 * @author 张配忠
 * @version 2016-09-21
 */
public class Attachment extends DataExtEntity<Attachment> {
	
	private static final long serialVersionUID = 1L;
	private String atName;		// 附件原名
	private String atSuffix;		// 文件后缀
	private String atType;		// 附件类型
	private String atTime;		// 上传时间
	private String atStatus;		// 状态
	
	public Attachment() {
		super();
	}

	public Attachment(String id){
		super(id);
	}
	@Override
	public String getTableName()
	{
		return ConfigUtils.getValue("schema.interPlat") + ".attachment";
	}


	@Length(min=1, max=128, message="附件原名长度必须介于 1 和 128 之间")
	public String getAtName() {
		return atName;
	}

	public void setAtName(String atName) {
		this.atName = atName;
	}
	
	@Length(min=0, max=20, message="文件后缀长度必须介于 0 和 20 之间")
	public String getAtSuffix() {
		return atSuffix;
	}

	public void setAtSuffix(String atSuffix) {
		this.atSuffix = atSuffix;
	}
	
	@Length(min=0, max=1, message="附件类型长度必须介于 0 和 1 之间")
	public String getAtType() {
		return atType;
	}

	public void setAtType(String atType) {
		this.atType = atType;
	}
	
	@Length(min=0, max=20, message="上传时间长度必须介于 0 和 20 之间")
	public String getAtTime() {
		return atTime;
	}

	public void setAtTime(String atTime) {
		this.atTime = atTime;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getAtStatus() {
		return atStatus;
	}

	public void setAtStatus(String atStatus) {
		this.atStatus = atStatus;
	}
	
}
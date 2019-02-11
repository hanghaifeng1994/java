/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.com.weye.modules.attach.dao;

import cn.com.weye.core.persistence.CrudExtDao;
import cn.com.weye.modules.attach.entity.Attachment;
import cn.com.weye.core.persistence.annotation.MyBatisDao;

/**
 * 附件操作DAO接口
 * @author 张配忠
 * @version 2016-09-21
 */
@MyBatisDao
public interface AttachmentDao extends CrudExtDao<Attachment> {
	
}
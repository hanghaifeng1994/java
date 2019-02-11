/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.com.weye.modules.attach.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.CrudExtService;
import cn.com.weye.modules.attach.entity.Attachment;
import cn.com.weye.modules.attach.dao.AttachmentDao;

/**
 * 附件操作Service
 * @author 张配忠
 * @version 2016-09-21
 */
@Service
@Transactional(readOnly = true)
public class AttachmentService extends CrudExtService<AttachmentDao, Attachment> {

	public Attachment get(String id) {
		return super.get(id);
	}
	
	public List<Attachment> findList(Attachment attachment) {
		return super.findList(attachment);
	}
	
	public Page<Attachment> findPage(Page<Attachment> page, Attachment attachment) {
		return super.findPage(page, attachment);
	}
	
	@Transactional(readOnly = false)
	public void save(Attachment attachment) {
		super.save(attachment);
	}
	
	@Transactional(readOnly = false)
	public void delete(Attachment attachment) {
		super.delete(attachment);
	}

	/**
	 * 查询多个附件，附件id之间用逗号分割
	 * @param ids
	 * @return
     */
	public List<Attachment> findByIds(String ids){
		List<Attachment> list = new ArrayList<Attachment>();
		if(null == ids || ids.isEmpty())
			return list;
		String aa[] = ids.split(",");
		Attachment o = null;
		for(int i=0; i<aa.length; i++){
			o = dao.get(aa[i]);
			if(null != o)
				list.add(o);
		}

		return list;
	}
	/**
	 * 查询多个附件，附件id之间用逗号分割
	 * 返回附件名称
	 * @param ids
	 * @return
	 */
	public String findNameByIds(String ids){
		if(null == ids || ids.isEmpty())
			return "";
		String aa[] = ids.split(",");
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0; i<aa.length; i++){
			Attachment o = dao.get(aa[i]);
			if(null != o)
				stringBuffer.append(o.getAtName()+",");
		}
		if(stringBuffer.length()>1)
			stringBuffer.deleteCharAt(stringBuffer.length()-1);
		return stringBuffer.toString();
	}
	
}
/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service.ccc;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.weye.core.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.ccc.Ccc;
import com.thinkgem.jeesite.modules.test.dao.ccc.CccDao;

/**
 * cccService
 * @author ccc
 * @version 2016-09-13
 */
@Service
@Transactional(readOnly = true)
public class CccService extends CrudService<CccDao, Ccc> {

	public Ccc get(String id) {
		return super.get(id);
	}
	
	public List<Ccc> findList(Ccc ccc) {
		return super.findList(ccc);
	}
	
	public Page<Ccc> findPage(Page<Ccc> page, Ccc ccc) {
		return super.findPage(page, ccc);
	}
	
	@Transactional(readOnly = false)
	public void save(Ccc ccc) {
		super.save(ccc);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ccc ccc) {
		super.delete(ccc);
	}
	
}
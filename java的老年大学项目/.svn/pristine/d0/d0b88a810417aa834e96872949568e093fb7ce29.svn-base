package com.learnyeai.course.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.mapper.CrsCatalogMapper;
import com.learnyeai.course.model.CrsCatalog;
import com.learnyeai.course.model.CrsSiteCatalogRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.tools.common.StringUtils;

/**
 *
 * @author twang
 */
@Service
public class CrsCatalogWyService extends WeyeBaseService<CrsCatalog> {

	@Resource
	private CrsCatalogMapper crsCatalogMapper;

	@Autowired
	private CrsSiteCatalogRelWyService crsSiteCatalogRelWyService;

	@Override
	public BaseMapper<CrsCatalog> getMapper() {
		return crsCatalogMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	/**
	 * status0操作成功 1操作失败
	 * 
	 * @param cc
	 * @return
	 */
	@Transactional
	public Map<String, Object> saveOrUpdate(CrsCatalog cc) {
		Map<String, Object> map = new HashMap();
		String parentId = cc.getParentId();
		String parentIds;
		String showStatus = cc.getShowStatus();
		int catLevel = 1;
		boolean isNew = false;
		if (StringUtils.isNotBlank(parentId)) {
			CrsCatalog parent = super.queryById(parentId);
			parentIds = (parent.getParentIds() == null ? "" : parent.getParentIds()) + parentId + ",";
			catLevel = parent.getCatLevel() + 1;
			cc.setParentIds(parentIds);
			cc.setCatLevel(catLevel);
		}

		if (StringUtils.isBlank(cc.getCatId())) {
			isNew = true;
			if (StringUtils.isBlank(parentId)) {
				cc.setCatLevel(1);
			}
			if (cc.getCatSort() == null) {
				long catNum = crsCatalogMapper.countByParent(cc.getSiteId(), parentId);
				cc.setCatSort(catNum + 1);
			}
		}

		if(isNew) {
			super.save(cc);
			// 保存下发子站关系
			for (PtsetSiteVo site : SiteUtils.getPubSites(cc.getSiteId())) {
				CrsSiteCatalogRel siteCatalog = new CrsSiteCatalogRel();
				siteCatalog.setCatId(cc.getCatId());
				siteCatalog.setCatCrtSiteId(cc.getSiteId());
				siteCatalog.setSiteId(site.getSiteId());
				siteCatalog.setShowStatus("0");
				if(StringUtils.isNotBlank(showStatus)) {
					siteCatalog.setShowStatus(showStatus);
				}else {
					siteCatalog.setShowStatus("1");
				}
				siteCatalog.setCatSort(cc.getCatSort());
				crsSiteCatalogRelWyService.save(siteCatalog);
			}
		}else {
			// 保存关系表
			CrsSiteCatalogRel crsSiteCatalogRel = new CrsSiteCatalogRel();
			crsSiteCatalogRel.setCatId(cc.getCatId());
			crsSiteCatalogRel.setSiteId(cc.getSiteId());
			crsSiteCatalogRel = crsSiteCatalogRelWyService.queryOne(crsSiteCatalogRel);
			if (crsSiteCatalogRel == null) {
				crsSiteCatalogRel = new CrsSiteCatalogRel();
				crsSiteCatalogRel.setCatId(cc.getCatId());
				crsSiteCatalogRel.setCatCrtSiteId(cc.getSiteId());
				crsSiteCatalogRel.setSiteId(cc.getSiteId());
				crsSiteCatalogRel.setCatSort(0l);
				crsSiteCatalogRel.setShowStatus("1");
			}
			if(StringUtils.isNotBlank(showStatus)) {
				crsSiteCatalogRel.setShowStatus(cc.getShowStatus());
			}
			if (crsSiteCatalogRel.getCatSort() != null) {
				crsSiteCatalogRel.setCatSort(cc.getCatSort());
			}
			crsSiteCatalogRelWyService.save(crsSiteCatalogRel);
			
			super.save(cc);
		}
		map.put("status", 0);
		map.put("id", cc.getCatId());
		return map;

	}

	@Transactional
	public Map<String, Object> deleteCat(CrsCatalog cc) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String catId : cc.getCatId().split(",")) {
			CrsCatalog delOne = new CrsCatalog();
			delOne.setCatId(catId);
			delOne.setDelFlag("1");
			int c = crsCatalogMapper.updateByPrimaryKeySelective(delOne);
			if (c > 0) num++;
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public MyPage<CrsCatalog> queryManagePage(CrsCatalog cc) {
		if (cc != null && cc.getPage() != null && cc.getRows() != null) {
			PageHelper.startPage(cc.getPage(), cc.getRows());
		}
		MyPage<CrsCatalog> page = new MyPage<CrsCatalog>(crsCatalogMapper.queryManagePage(cc));
		return page;
	}

	@Transactional
	public MyPage<CrsCatalog> queryShowPage(CrsCatalog cc) {
		if (cc != null && cc.getPage() != null && cc.getRows() != null) {
			PageHelper.startPage(cc.getPage(), cc.getRows());
		}
		MyPage<CrsCatalog> page = new MyPage<CrsCatalog>(crsCatalogMapper.queryShowPage(cc));
		for(CrsCatalog cat : page.getList()) {
			CrsCatalog p = new CrsCatalog();
			p.setParentId(cat.getCatId());
			List<CrsCatalog> childs = crsCatalogMapper.queryShowPage(p);
			for(CrsCatalog c : childs) {
				p = new CrsCatalog();
				p.setParentId(c.getCatId());
				List<CrsCatalog> childs02 = crsCatalogMapper.queryShowPage(p);
				c.setChilds(childs02);
			}
			cat.setChilds(childs);
		}
		return page;

	}
}

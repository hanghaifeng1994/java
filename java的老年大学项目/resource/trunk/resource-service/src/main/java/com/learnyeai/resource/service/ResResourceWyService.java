package com.learnyeai.resource.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.resource.mapper.ResResourceMapper;
import com.learnyeai.resource.model.ResCategory;
import com.learnyeai.resource.model.ResCategoryResourceRel;
import com.learnyeai.resource.model.ResFile;
import com.learnyeai.resource.model.ResResource;
import com.learnyeai.resource.model.ResSiteResourceRel;
import com.learnyeai.tools.common.StringUtils;

/**
 *
 * @author twang
 */
@Service
public class ResResourceWyService extends WeyeBaseService<ResResource> {

	@Resource
	private ResResourceMapper resResourceMapper;

	@Autowired
	private ResSiteResourceRelWyService resSiteResourceRelWyService;

	@Autowired
	private ResCategoryResourceRelWyService resCategoryResourceRelWyService;

	@Autowired
	private ResFileWyService resFileWyService;

	@Autowired
	private ResCategoryWyService resCategoryWyService;

	@Override
	public BaseMapper<ResResource> getMapper() {
		return resResourceMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	/**
	 * status0操作成功 1操作失败 2:资源分类id不能为空
	 * 
	 * @param rr
	 * @return
	 */
	@Transactional
	public Map<String, Object> saveOrUpdate(ResResource rr) {
		Map<String, Object> map = new HashMap();
		boolean isNew = false;
		boolean isModifyCat = false;// 是否修改分类
		if (StringUtils.isBlank(rr.getResId())) {
			rr.setCreateDate(new Date());
			rr.setResPubStatus("0");
			rr.setResStatus("0");
			isNew = true;
		}
		if (StringUtils.isNotBlank(rr.getResCatstr())) {
			isModifyCat = true;
		}
		super.save(rr);

		if (isModifyCat) {
			List<ResCategoryResourceRel> list = new ArrayList<ResCategoryResourceRel>();
			ResCategoryResourceRel crr = new ResCategoryResourceRel();
			crr.setResId(rr.getResId());
			list = resCategoryResourceRelWyService.queryList4Simple(crr);
			for (ResCategoryResourceRel rel : list) {
				resCategoryResourceRelWyService.delete(rel);
			}
			ResCategoryResourceRel addObj = null;
			for (String catId : rr.getResCatstr().split(",")) {
				addObj = new ResCategoryResourceRel();
				addObj.setCatId(catId);
				addObj.setResId(rr.getResId());
				resCategoryResourceRelWyService.save(addObj);
			}
		}
		// 保存关系表
		if (isNew) {
			for (PtsetSiteVo site : SiteUtils.getPubSites(rr.getSiteId())) {
				ResSiteResourceRel resSiteResourceRel = new ResSiteResourceRel();
				resSiteResourceRel.setResId(rr.getResId());
				resSiteResourceRel.setResCrtSiteId(rr.getSiteId());
				resSiteResourceRel.setSiteId(site.getSiteId());
				resSiteResourceRel.setResAsName(rr.getResName());
				resSiteResourceRel.setResPubStatus("0");
				resSiteResourceRel.setResManageStatus("0");
				if (site.getSiteId().equals(rr.getSiteId())) {
					resSiteResourceRel.setResManageStatus("1");
				}
				resSiteResourceRelWyService.save(resSiteResourceRel);
			}
		}
		map.put("status", 0);
		map.put("msg", "保存成功!");
		map.put("id", rr.getResId());
		return map;

	}

	@Transactional
	public Map<String, Object> deleteRes(ResResource rr) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String resId : rr.getResId().split(",")) {
			ResResource delOne = new ResResource();
			delOne.setResId(resId);
			delOne.setDelFlag("1");
			int c = resResourceMapper.updateByPrimaryKeySelective(delOne);
			if (c > 0)
				num++;
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> publish(ResResource rr) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String resId : rr.getResId().split(",")) {
			ResResource resource = super.queryById(resId);
			if (resource == null)
				continue;
			if (resource.getSiteId().equals(rr.getSiteId())) {
				resource.setResPubDate(new Date());
				resource.setResPubStatus(rr.getResPubStatus());
				super.save(resource);
			}
			ResSiteResourceRel resSiteResourceRel = new ResSiteResourceRel();
			resSiteResourceRel.setResId(resId);
			resSiteResourceRel.setSiteId(rr.getSiteId());
			resSiteResourceRel = resSiteResourceRelWyService.queryOne(resSiteResourceRel);
			if (resSiteResourceRel != null) {
				resSiteResourceRel.setResPubStatus(rr.getResPubStatus());
				resSiteResourceRel.setResPubDate(new Date());
				resSiteResourceRelWyService.save(resSiteResourceRel);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> check(ResResource rr) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String resId : rr.getResId().split(",")) {
			ResResource obj = super.queryById(resId);
			if (obj != null) {
				obj.setResStatus(rr.getResStatus());
				super.save(obj);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> author(ResResource rr) {
		Map<String, Object> result = new HashMap();
		result.put("status", "0");
		return result;
	}

	public Object detail(String resIds) {
		List<ResResource> list = Lists.newArrayList();
		for (String resId : resIds.split(",")) {
			ResResource resResource = super.queryById(resId);
			if (resResource == null)
				continue;
			ResFile rf = new ResFile();
			rf.setResId(resResource.getResId());
			rf.setDelFlag("0");
			List<ResFile> rfs = resFileWyService.queryList(rf, null);
			resResource.setResFiles(rfs);
			list.add(resResource);
		}
		return list;
	}

	public Object queryById(String resId) {
		ResResource resResource = super.queryById(resId);
		ResFile rf = new ResFile();
		rf.setResId(resResource.getResId());
		rf.setDelFlag("0");
		List<ResFile> rfs = resFileWyService.queryList(rf, null);
		resResource.setResFiles(rfs);
		String resCatnamestr = "";
		if (StringUtils.isNotBlank(resResource.getResCatstr())) {
			for (String catId : resResource.getResCatstr().split(",")) {
				if (StringUtils.isBlank(catId))
					continue;
				ResCategory category = resCategoryWyService.queryById(catId);
				if (category != null) {
					resCatnamestr += "," + category.getCatName();
				}
			}
		}
		if (StringUtils.isNotBlank(resCatnamestr)) {
			resCatnamestr = resCatnamestr.substring(1);
		}
		resResource.setResCatnamestr(resCatnamestr);
		return resResource;
	}

	@Transactional
	public MyPage<ResResource> queryManagePage(ResResource rr) {
		if (rr != null && rr.getPage() != null && rr.getRows() != null) {
			PageHelper.startPage(rr.getPage(), rr.getRows());
		}
		List<ResResource> list = resResourceMapper.queryManagePage(rr);
		for (ResResource resResource : list) {
			ResFile rf = new ResFile();
			rf.setResId(resResource.getResId());
			rf.setDelFlag("0");
			List<ResFile> rfs = resFileWyService.queryList(rf, null);
			resResource.setResFiles(rfs);
		}
		MyPage<ResResource> page = new MyPage<ResResource>(list);
		return page;
	}

	@Transactional
	public MyPage<ResResource> queryShowPage(ResResource rr) {
		if (rr != null && rr.getPage() != null && rr.getRows() != null) {
			PageHelper.startPage(rr.getPage(), rr.getRows());
		}
		List<ResResource> list = resResourceMapper.queryShowPage(rr);
		for (ResResource resResource : list) {
			ResFile rf = new ResFile();
			rf.setResId(resResource.getResId());
			rf.setDelFlag("0");
			List<ResFile> rfs = resFileWyService.queryList(rf, null);
			resResource.setResFiles(rfs);
		}
		MyPage<ResResource> page = new MyPage<ResResource>(list);
		return page;
	}

	@Transactional
	public MyPage<ResResource> queryMainPage(ResResource rr) {
		if (rr != null && rr.getPage() != null && rr.getRows() != null) {
			PageHelper.startPage(rr.getPage(), rr.getRows(), "r.RES_PUB_DATE desc");
		}
		List<ResResource> list = resResourceMapper.queryMainPage(rr);
		for (ResResource resResource : list) {
			ResFile rf = new ResFile();
			rf.setResId(resResource.getResId());
			rf.setDelFlag("0");
			List<ResFile> rfs = resFileWyService.queryList(rf, null);
			resResource.setResFiles(rfs);
		}
		MyPage<ResResource> page = new MyPage<ResResource>(list);
		return page;

	}

	/**
	 * 可以查询到已删除的
	 * 
	 * @param id
	 * @return
	 */
	public ResResource get(String id) {
		return resResourceMapper.selectByPrimaryKey(id);
	}
}

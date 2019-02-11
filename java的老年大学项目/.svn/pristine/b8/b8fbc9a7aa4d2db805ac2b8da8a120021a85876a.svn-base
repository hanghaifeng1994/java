package com.learnyeai.course.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.api.service.StdCustLearnResourceApiService;
import com.learnyeai.course.api.vo.ResResourceVo;
import com.learnyeai.course.mapper.CrsChapterResourceRelMapper;
import com.learnyeai.course.model.CrsChapterResourceRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class CrsChapterResourceRelWyService extends WeyeBaseService<CrsChapterResourceRel> {

	@Resource
	private CrsChapterResourceRelMapper crsChapterResourceRelMapper;
	@Resource
	private StdCustLearnResourceApiService stdCustLearnResourceApiService;

	@Override
	public BaseMapper<CrsChapterResourceRel> getMapper() {
		return crsChapterResourceRelMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	public List<CrsChapterResourceRel> queryResources(CrsChapterResourceRel chapterResource) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "cptId=1");
		List<CrsChapterResourceRel> list = super.queryList(chapterResource, params);
		for (CrsChapterResourceRel cr : list) {
			ResResourceVo res = stdCustLearnResourceApiService.queryResourceApi(cr.getResId());
			if (res != null) {
				cr.setResName(res.getResName());
				cr.setFileTimeLen(res.getFileTimeLen());
			}
		}
		return list;
	}

	@Transactional
	public Map<String, Object> addResource(CrsChapterResourceRel param) {
		Map<String, Object> map = new HashMap();
		int num = 0;
		for (String resId : param.getResId().split(",")) {
			CrsChapterResourceRel obj = new CrsChapterResourceRel();
			obj.setCptId(param.getCptId());
			obj.setResId(resId);
			obj = super.queryOne(obj);
			if (obj == null) {
				obj = new CrsChapterResourceRel();
				obj.setCptId(param.getCptId());
				obj.setResId(resId);
				obj.setResType(param.getResType());
				obj.setFileType(param.getFileType());
				super.save(obj);
			}
			num++;
		}
		map.put("status", 0);
		map.put("num", num);
		return map;
	}

	@Transactional
	public Map<String, Object> delResource(CrsChapterResourceRel param) {
		Map<String, Object> map = new HashMap();
		int num = 0;
		for (String resId : param.getResId().split(",")) {
			CrsChapterResourceRel obj = new CrsChapterResourceRel();
			obj.setCptId(param.getCptId());
			obj.setResId(resId);
			obj = super.queryOne(obj);
			if (obj != null) {
				super.delete(obj);
			}
			num++;
		}
		map.put("status", 0);
		map.put("num", num);
		return map;
	}

	@Override
	protected Weekend<CrsChapterResourceRel> genSqlExample(CrsChapterResourceRel t, Map params) {
		Weekend<CrsChapterResourceRel> w = super.genSqlExample(t, params);
		WeekendCriteria<CrsChapterResourceRel, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCptId())) {
			if (t.getCptId().contains(",")) {
				c.andIn(CrsChapterResourceRel::getCptId, Arrays.asList(t.getCptId().split(",")));
			} else {
				c.andEqualTo(CrsChapterResourceRel::getCptId, t.getCptId());
			}
		}
		if (StringUtils.isNotBlank(t.getResId())) {
			c.andEqualTo(CrsChapterResourceRel::getResId, t.getResId());
		}
		w.and(c);
		return w;
	}

}

package com.learnyeai.course.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.mapper.CrsChapterMapper;
import com.learnyeai.course.model.CrsChapter;
import com.learnyeai.course.model.CrsCourse;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class CrsChapterWyService extends WeyeBaseService<CrsChapter> {

	@Resource
	private CrsChapterMapper crsChapterMapper;
	
	@Resource
	private  CrsCourseWyService crsCourseWyService;

	@Override
	public BaseMapper<CrsChapter> getMapper() {
		return crsChapterMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	@Transactional
	public Map<String, Object> saveOrUpdate(CrsChapter chapter) {
		Map<String, Object> map = new HashMap();
		String parentId = chapter.getParentId();
		String parentIds;
		if (StringUtils.isBlank(chapter.getCptId())) {
			if (StringUtils.isBlank(chapter.getCsId())) {
				map.put("status", 2);
				map.put("msg", "保存失败，课程id不能为空!");
				return map;
			}
			CrsCourse course = crsCourseWyService.queryById(chapter.getCsId());
			chapter.setSiteId(course.getSiteId());
			chapter.setMchtId(course.getMchtId());
			chapter.setMchtSchmId(course.getMchtSchmId());
			long cpNum = 0;
			chapter.setDelFlag("0");
			if (StringUtils.isNotBlank(parentId)) {
				cpNum = crsChapterMapper.countByParent(chapter.getCsId(), parentId);
			} else {
				cpNum = crsChapterMapper.countOneTree(chapter.getCsId());
			}
			chapter.setCptSort(cpNum + 1);
		}
		if (StringUtils.isNotBlank(parentId)) {
			CrsChapter parent = super.queryById(parentId);
			parentIds = (parent.getParentIds() == null ? "" : parent.getParentIds()) + parentId + ",";
			chapter.setParentIds(parentIds);
		}
		if(chapter.getCptMaxStudyTime()!=null) {
			chapter.setCptMaxStudyTime(chapter.getCptMaxStudyTime()*60);
		}
		super.save(chapter);
		map.put("status", 0);
		map.put("msg", "保存成功!");
		map.put("id", chapter.getCptId());
		return map;
	}

	@Transactional
	public Map<String, Object> delChapter(CrsChapter chapter) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String cptId : chapter.getCptId().split(",")) {
			CrsChapter delOne = new CrsChapter();
			delOne.setCptId(cptId);
			delOne.setDelFlag("1");
			int c = crsChapterMapper.updateByPrimaryKeySelective(delOne);
			if (c > 0)
				num++;
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public List<CrsChapter> chapterList(CrsChapter chapter) {
		List<CrsChapter> list = crsChapterMapper.queryByParent(chapter.getCsId(), chapter.getParentId());
		return list;
	}

	@Transactional
	public List<CrsChapter> treeList(CrsChapter chapter) {
		List<CrsChapter> list = queryByParent(chapter.getCsId(), chapter.getParentId());
		return list;
	}

	private List<CrsChapter> queryByParent(String csId, String parentId) {
		List<CrsChapter> list = crsChapterMapper.queryByParent(csId, parentId);
		for (CrsChapter obj : list) {
			List<CrsChapter> childs = queryByParent(csId, obj.getCptId());
			obj.setChilds(childs);
		}
		return list;
	}
	
	@Override
	protected Weekend<CrsChapter> genSqlExample(CrsChapter t, Map params) {
		Weekend<CrsChapter> w = super.genSqlExample(t, params);
		WeekendCriteria<CrsChapter, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCptId())) {
			c.andEqualTo(CrsChapter::getCptId, t.getCptId());
		}
		if (StringUtils.isNotBlank(t.getCsId())) {
			c.andEqualTo(CrsChapter::getCsId, t.getCsId());
		}
		w.and(c);
		return w;
	}

}

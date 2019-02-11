package com.learnyeai.course.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.mapper.CsrCourseTutorRelMapper;
import com.learnyeai.course.model.CsrCourseTutorRel;
import com.learnyeai.learnai.support.BaseMapper;

/**
 *
 * @author twang
 */
@Service
public class CsrCourseTutorRelWyService extends WeyeBaseService<CsrCourseTutorRel> {

	@Resource
	private CsrCourseTutorRelMapper csrCourseTutorRelMapper;

	@Override
	public BaseMapper<CsrCourseTutorRel> getMapper() {
		return csrCourseTutorRelMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Transactional
	public Map<String, Object> addTutor(CsrCourseTutorRel ct) {
		Map<String, Object> map = new HashMap();
		int num = 0;
		for (String tutorId : ct.getTutorId().split(",")) {
			CsrCourseTutorRel param = new CsrCourseTutorRel();
			param.setTutorId(tutorId);
			param.setCsId(ct.getCsId());
			param = super.queryOne(param);
			if (param == null) {
				param = new CsrCourseTutorRel();
				param.setCsId(ct.getCsId());
				param.setTutorId(tutorId);
				super.save(param);
			}
			num++;
		}

		map.put("status", 0);
		map.put("num", num);
		map.put("msg", "保存成功!");
		return map;
	}

	@Transactional
	public Map<String, Object> delTutor(CsrCourseTutorRel ct) {
		Map<String, Object> map = new HashMap();
		int num = 0;
		for (String tutorId : ct.getTutorId().split(",")) {
			CsrCourseTutorRel param = new CsrCourseTutorRel();
			param.setTutorId(tutorId);
			param.setCsId(ct.getCsId());
			param = super.queryOne(param);
			if (param != null) {
				super.delete(param);
			}
			num++;
		}

		map.put("status", 0);
		map.put("num", num);
		map.put("msg", "删除成功!");
		return map;
	}
}

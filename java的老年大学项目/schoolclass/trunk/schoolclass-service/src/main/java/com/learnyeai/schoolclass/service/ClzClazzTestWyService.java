package com.learnyeai.schoolclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.schoolclass.api.service.TestingTestApiService;
import com.learnyeai.schoolclass.api.vo.TestingTestVo;
import com.learnyeai.schoolclass.mapper.ClzClazzTestMapper;
import com.learnyeai.schoolclass.model.ClzClazzTest;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class ClzClazzTestWyService extends WeyeBaseService<ClzClazzTest> {

	@Resource
	private ClzClazzTestMapper clzClazzTestMapper;

	@Resource
	private TestingTestApiService testingTestApiService;

	@Override
	public BaseMapper<ClzClazzTest> getMapper() {
		return clzClazzTestMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Transactional
	public Map<String, Object> addTest(ClzClazzTest clazzTest) {
		Map<String, Object> map = new HashMap();
		int num = 0;
		for (String tsId : clazzTest.getTsId().split(",")) {
			ClzClazzTest t = new ClzClazzTest();
			t.setCzId(clazzTest.getCzId());
			t.setTsId(tsId);
			ClzClazzTest obj = super.queryOne(t);
			if (obj == null) {
				super.save(t);
				num++;
			}
		}
		map.put("status", 0);
		map.put("num", num);
		map.put("msg", "保存成功!");
		return map;
	}

	@Transactional
	public Map<String, Object> delTest(ClzClazzTest clazzTest) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String tsId : clazzTest.getTsId().split(",")) {
			ClzClazzTest t = new ClzClazzTest();
			t.setCzId(clazzTest.getCzId());
			t.setTsId(tsId);
			t = super.queryOne(t);
			if (t != null) {
				super.delete(t);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public List<ClzClazzTest> testList(ClzClazzTest t) {
		List<ClzClazzTest> list = super.queryList(t, null);
		for (ClzClazzTest ch : list) {
			TestingTestVo test = testingTestApiService.queryTestApi(ch.getTsId());
			ch.setName(test.getName());
		}
		return list;
	}

	@Override
	protected Weekend<ClzClazzTest> genSqlExample(ClzClazzTest t, Map params) {
		Weekend<ClzClazzTest> w = super.genSqlExample(t, params);
		WeekendCriteria<ClzClazzTest, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCzId())) {
			c.andEqualTo(ClzClazzTest::getCzId, t.getCzId());
		}
		if (StringUtils.isNotBlank(t.getTsId())) {
			c.andEqualTo(ClzClazzTest::getTsId, t.getTsId());
		}
		w.and(c);
		return w;
	}
}

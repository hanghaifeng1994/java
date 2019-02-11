package com.learnyeai.course.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.api.service.TestingTestApiService;
import com.learnyeai.course.api.vo.TestingTestVo;
import com.learnyeai.course.mapper.CrsCourseTestMapper;
import com.learnyeai.course.model.CrsCourseTest;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class CrsCourseTestWyService extends WeyeBaseService<CrsCourseTest> {

    @Resource
    private CrsCourseTestMapper crsCourseTestMapper;
    
    @Resource
    private TestingTestApiService testingTestApiService;

    @Override
    public BaseMapper<CrsCourseTest> getMapper() {
        return crsCourseTestMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    
    @Transactional
	public Map<String, Object> addTest(CrsCourseTest courseTest) {
		Map<String, Object> map = new HashMap();
		int num = 0;
		for (String tsId : courseTest.getTsId().split(",")) {
			CrsCourseTest t = new CrsCourseTest();
			t.setCsId(courseTest.getCsId());
			t.setTsId(tsId);
			CrsCourseTest obj = super.queryOne(t);
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
	public Map<String, Object> delTest(CrsCourseTest courseTest) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String tsId : courseTest.getTsId().split(",")) {
			CrsCourseTest t = new CrsCourseTest();
			t.setCsId(courseTest.getCsId());
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
	public List<CrsCourseTest> testList(CrsCourseTest t) {
		List<CrsCourseTest> list = super.queryList(t, null);
		for (CrsCourseTest ch : list) {
			TestingTestVo test = testingTestApiService.queryTestApi(ch.getTsId());
			ch.setName(test.getName());
		}
		return list;
	}
    
    @Override
	protected Weekend<CrsCourseTest> genSqlExample(CrsCourseTest t, Map params) {
		Weekend<CrsCourseTest> w = super.genSqlExample(t, params);
		WeekendCriteria<CrsCourseTest, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getTsId())) {
			c.andEqualTo(CrsCourseTest::getTsId, t.getTsId());
		}
		if (StringUtils.isNotBlank(t.getCsId())) {
			c.andEqualTo(CrsCourseTest::getCsId, t.getCsId());
		}
		w.and(c);
		return w;
	}
}

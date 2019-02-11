package com.learnyeai.testing.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.learnyeai.tools.common.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.mapper.TestingTestMapper;
import com.learnyeai.testing.model.TestingTest;
import com.learnyeai.tools.common.MapUtil;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class TestingTestWyService extends WeyeBaseService<TestingTest> {

	@Resource
	private TestingTestMapper testingTestMapper;
	@Resource
	private BaseInfoDao baseInfoDao;
	@Resource
	private  TestingPaperRuleWyService testingPaperRuleWyService;

	@Override
	public BaseMapper<TestingTest> getMapper() {
		return testingTestMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}
	protected Weekend<TestingTest> genSqlExample(TestingTest t, Map params) {
		Weekend<TestingTest> weekend = super.genSqlExample(t, params);
		WeekendCriteria<TestingTest, Object> c = weekend.createCriteriaAddOn();
		if(StringUtils.isNotBlank(t.getName())){
			c.andLike(TestingTest::getName,"%"+t.getName()+"%");
		}
		if(StringUtils.isNotBlank(t.getTsId())){
			c.andEqualTo(TestingTest::getTsId,t.getTsId());
		}
		weekend.and(c);
		return weekend;
	}
	
	@Cacheable(cacheNames = "testing_testDetail", key = "#tsId")
	public TestingTest get(String tsId) {
		return testingTestMapper.selectByPrimaryKey(tsId);
	}

	/**
	 * 测验新增
	 * @param ctx
	 * @return
	 */
	public Map<String,Object> saveData(IBusinessContext ctx){
		TestingTest t=super.convert2Bean(ctx.getParamMap());
		String siteId=t.getSiteId();
		//根据站点查询出平台id
		PtsetSiteVo pt=baseInfoDao.querySite(siteId);
		t.setPlatformId(pt.getPtId());
		super.save(t);
		return MapUtil.newMap("id",t.getTsId());
	}
	@Transactional
	public Map<String,Object> deleteData(IBusinessContext ctx){
		TestingTest t=super.convert2Bean(ctx.getParamMap());
		String[] testIds=(t.getTsId()).split(",");
		Map<String,Object> map=new HashMap<>();
		int num=0;
		for (String testId:testIds){
			num+=super.deleteById(testId);
		}
		map.put("num",num);
		return map;
	}
	
}

package com.learnyeai.testing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.testing.mapper.TestingQuestionitemRuleMapper;
import com.learnyeai.testing.model.TestingItemTypes;
import com.learnyeai.testing.model.TestingQuestionitemRule;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class TestingQuestionitemRuleWyService extends WeyeBaseService<TestingQuestionitemRule> {

	@Resource
	private TestingQuestionitemRuleMapper testingQuestionitemRuleMapper;

	@Resource
	private TestingItemTypesWyService testingItemTypesWyService;

	@Override
	public BaseMapper<TestingQuestionitemRule> getMapper() {
		return testingQuestionitemRuleMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	/**
	 * status0操作成功 1操作失败 2:资源分类id不能为空
	 * 
	 * @param param
	 * @return
	 */
	@Transactional
	public Map<String, Object> saveOrUpdate(TestingQuestionitemRule param) {
		Map<String, Object> map = new HashMap();
		super.save(param);
		map.put("status", 0);
		map.put("msg", "保存成功!");
		map.put("id", param.getQuestionitemRuleId());
		return map;

	}

	@Transactional
	public List<TestingQuestionitemRule> queryManageList(TestingQuestionitemRule obj) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "orderNum=1");
		List<TestingQuestionitemRule> list = super.queryList(obj, params);
		for (TestingQuestionitemRule rule : list) {
			TestingItemTypes itemType = testingItemTypesWyService.get(rule.getItemTypeId());
			rule.setItemType(itemType.getItemType());
			rule.setName(itemType.getName());
		}
		return list;
	}

	@Override
	protected Weekend<TestingQuestionitemRule> genSqlExample(TestingQuestionitemRule t, Map params) {
		Weekend<TestingQuestionitemRule> w = super.genSqlExample(t, params);
		WeekendCriteria<TestingQuestionitemRule, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getPaperRuleId())) {
			c.andEqualTo(TestingQuestionitemRule::getPaperRuleId, t.getPaperRuleId());
		}
		if (StringUtils.isNotBlank(t.getQuestionitemRuleId())) {
			c.andEqualTo(TestingQuestionitemRule::getQuestionitemRuleId, t.getQuestionitemRuleId());
		}
		if (StringUtils.isNotBlank(t.getItemTypeId())) {
			c.andEqualTo(TestingQuestionitemRule::getItemTypeId, t.getItemTypeId());
		}
		w.and(c);
		return w;
	}
}

package com.learnyeai.testing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.learnyeai.learnai.key.KeyFactory;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.testing.model.*;
import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.common.JsonUtils;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.testing.mapper.TestingQuestionMapper;

import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class TestingQuestionWyService extends WeyeBaseService<TestingQuestion> {

	@Resource
	private TestingQuestionMapper testingQuestionMapper;

	@Autowired
	private TestingQuestionOptionWyService testingQuestionOptionWyService;
	@Autowired
	private TestingItemTypesWyService testingItemTypesWyService;
	@Autowired
	private TestingQuestionPoolWyService testingQuestionPoolWyService;
	@Autowired
	private TestingQuestionSectionWyService testingQuestionSectionWyService;

	@Override
	public BaseMapper<TestingQuestion> getMapper() {
		return testingQuestionMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	/**
	 * 按题库和题型查询所有试题，组卷时使用
	 * 
	 * @param qpId
	 * @param itemTypeId
	 * @return
	 */
	public List<TestingQuestion> queryByQpIdAndType(String qpId, String itemTypeId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "createDate=1");
		TestingQuestion t = new TestingQuestion();
		t.setQpId(qpId);
		t.setItemTypeId(itemTypeId);
		t.setItemPubStatus("1");
		t.setDelFlag("0");
		return super.queryList(t, params);
	}

	/**
	 * 通过主键查询
	 * 
	 * @param questionId
	 * @return
	 */
	@Cacheable(cacheNames = "testing_question", key = "#questionId")
	public TestingQuestion get(String questionId) {
		TestingQuestion question = testingQuestionMapper.selectByPrimaryKey(questionId);
		Map<String, Object> optionOrderParam = new HashMap<String, Object>();
		optionOrderParam.put("sorts", "orderNum=1");
		TestingQuestionOption questionOption = new TestingQuestionOption();
		questionOption.setQuestionId(question.getQuestionId());
		List<TestingQuestionOption> questionOptions = testingQuestionOptionWyService.queryList(questionOption,
				optionOrderParam);
		question.setQuestionOptions(questionOptions);
		return question;
	}

	@Override
	protected Weekend<TestingQuestion> genSqlExample(TestingQuestion t, Map params) {
		Weekend<TestingQuestion> w = super.genSqlExample(t, params);
		WeekendCriteria<TestingQuestion, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getQpId())) {
			String[] getQpIds=(t.getQpId()).split(",");
			c.andIn(TestingQuestion::getQpId, Arrays.asList(getQpIds));
		}
		if (StringUtils.isNotBlank(t.getSectionId())) {
			String[] sctionIds=(t.getSectionId()).split(",");
			c.andIn(TestingQuestion::getSectionId, Arrays.asList(sctionIds));
		}
		if (StringUtils.isNotBlank(t.getOnlyCode())) {
			c.andEqualTo(TestingQuestion::getOnlyCode, t.getOnlyCode());
		}
		if (StringUtils.isNotBlank(t.getOneSectionId())) {
			c.andEqualTo(TestingQuestion::getOneSectionId, t.getOneSectionId());
		}
		if (StringUtils.isNotBlank(t.getTwoSectionId())) {
			c.andEqualTo(TestingQuestion::getTwoSectionId, t.getTwoSectionId());
		}
		if (StringUtils.isNotBlank(t.getThreeSectionId())) {
			c.andEqualTo(TestingQuestion::getThreeSectionId, t.getThreeSectionId());
		}
		if (StringUtils.isNotBlank(t.getNewversion())) {
			c.andEqualTo(TestingQuestion::getNewversion, t.getNewversion());
		}
		if (StringUtils.isNotBlank(t.getItemTypeId())) {
			c.andEqualTo(TestingQuestion::getItemTypeId, t.getItemTypeId());
		}
		if (StringUtils.isNotBlank(t.getItemPubStatus())) {
			c.andEqualTo(TestingQuestion::getItemPubStatus, t.getItemPubStatus());
		}
		if (StringUtils.isNotBlank(t.getDelFlag())) {
			c.andEqualTo(TestingQuestion::getDelFlag, t.getDelFlag());
		}
		w.and(c);
		return w;
	}

	/**
	 * 根据题目查询详情
	 * @param ctx
	 * @return
	 */
	public TestingQuestion queryByIdExt(IBusinessContext ctx){
		TestingQuestion t=	super.convert2Bean(ctx.getParamMap());
		t =super.queryById(t.getQuestionId());
		String qpId=t.getQpId();
		String secId =t.getSectionId();
		TestingQuestionSection section=testingQuestionSectionWyService.queryById(secId);
		if(section!=null){
			String secionName=section.getName();
			t.setSectionName(secionName);
		}
		String itemTypeId=t.getItemTypeId();
		if(StringUtils.isNotBlank(itemTypeId)){
			TestingItemTypes type=testingItemTypesWyService.queryById(itemTypeId);
			if(type!=null){
				t.setTypeName(type.getName());
				t.setItemType(type.getItemType());
			}
		}
		if(StringUtils.isNotBlank(qpId)){
			TestingQuestionPool pool=testingQuestionPoolWyService.queryById(qpId);
			if(pool!=null){
				t.setPoolName(pool.getName());
			}
		}
		//根据题目id查询出这个题目下挂所有选项
		TestingQuestionOption option=new TestingQuestionOption();
		option.setQuestionId(t.getQuestionId());
		Map<String,Object> map=new HashMap();
		map.put("orderBy","1");
		List<TestingQuestionOption> list=testingQuestionOptionWyService.queryList(option,map);
		t.setQuestionOptions(list);
		return t;
	}

	/**
	 * 查询题目列表 带答案
	 * @param ctx
	 * @return
	 */
	public MyPage<TestingQuestion> queryPageExt(IBusinessContext ctx){
		TestingQuestion t=super.convert2Bean(ctx.getParamMap());
		MyPage<TestingQuestion> page =super.queryPage(t,ctx.getParamMap());
		List<TestingQuestion> list=page.getList();
		TestingQuestionOption option=new TestingQuestionOption();
		for(TestingQuestion tq:list){
			String questionId=tq.getQuestionId();
            option.setQuestionId(questionId);
			List<TestingQuestionOption> options= testingQuestionOptionWyService.queryList(option,new HashMap());
			tq.setQuestionOptions(options);
			String itemTypeId=tq.getItemTypeId();
			if(StringUtils.isNotBlank(itemTypeId)){
				TestingItemTypes type=testingItemTypesWyService.queryById(itemTypeId);
				if(type!=null){
					tq.setTypeName(type.getName());
				}
			}
		}
		return page;
	}

	/**
	 * 题目新增修改保存
	 * @param ctx
	 * @return
	 */
	@Transactional
	public Map<String,Object> saveData(IBusinessContext ctx){
		TestingQuestion tq=super.convert2Bean(ctx.getParamMap());
		//先新增题目
        String questionId=tq.getQuestionId();
        if(StringUtils.isNotBlank(questionId)){
            TestingQuestion question=super.queryById(questionId);
            tq.setOnlyCode(question.getOnlyCode());
            //将所有过去版本NEWVERSION的数据设为false
            testingQuestionMapper.updateByOnlyCode(tq);
            int version=question.getVersion();
            version++;
            tq.setVersion(version);
            tq.setQuestionId("");
            tq.setNewversion("1");
            tq.setItemPubStatus("1");
            super.save(tq);
        }else{
            //生成onlycode
            String onlyCode=KeyFactory.getKeyGenerator("onlyCode" + "onlyCode").genNextKey();
            tq.setOnlyCode(onlyCode);
            tq.setVersion(1);
            tq.setNewversion("1");
            tq.setItemPubStatus("1");
            super.save(tq);
        }
		List<TestingQuestionOption> options=tq.getQuestionOptions();
		for (TestingQuestionOption option:options){
			option.setQuestionId(tq.getQuestionId());
			testingQuestionOptionWyService.save(option);
		}
		return MapUtil.newMap("id",tq.getQuestionId());
	}

	/**
	 * 先删除题目再删除题目下面的选项
	 * @param ctx
	 * @return
	 */
	@Transactional
	public Map<String,Object> deleteData(IBusinessContext ctx){
		TestingQuestion question= super.convert2Bean(ctx.getParamMap());
		String[] ids=(question.getQuestionId()).split(",");
		int num=0;
		for (String id:ids){
			//先删除题目
			num+=super.deleteById(id);
			//通过题目id删除选项
			testingQuestionOptionWyService.deleteByQtId(id);
		}

		return MapUtil.newMap("num",num);
	}
	
	public List<Map<String,Object>> queryItemTypes(String qpId){
		List<Map<String,Object>> list = testingQuestionMapper.queryItemTypes(qpId);
		return list;
	}
}

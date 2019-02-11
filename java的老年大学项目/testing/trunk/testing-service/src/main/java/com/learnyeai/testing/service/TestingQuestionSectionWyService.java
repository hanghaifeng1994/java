package com.learnyeai.testing.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingQuestion;
import com.learnyeai.testing.model.TestingQuestionPool;
import com.learnyeai.testing.model.TestingQuestionSection;
import com.learnyeai.testing.mapper.TestingQuestionSectionMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author twang
 */
@Service
public class TestingQuestionSectionWyService extends WeyeBaseService<TestingQuestionSection> {

    @Resource
    private TestingQuestionSectionMapper testingQuestionSectionMapper;
    @Resource
    private TestingQuestionWyService testingQuestionWyService;
    @Resource
    private TestingQuestionPoolWyService testingQuestionPoolWyService;

    @Override
    public BaseMapper<TestingQuestionSection> getMapper() {
        return testingQuestionSectionMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<TestingQuestionSection> genSqlExample(TestingQuestionSection t, Map params) {
        Weekend<TestingQuestionSection> weekend = super.genSqlExample(t,params);
        WeekendCriteria<TestingQuestionSection, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getParentId())){
            c.andEqualTo(TestingQuestionSection::getParentId,t.getParentId());
        }
        if(StringUtils.isNotBlank(t.getSectionId())){
            c.andEqualTo(TestingQuestionSection::getSectionId,t.getSectionId());
        }
        if(StringUtils.isNotBlank(t.getQpId())){
            c.andEqualTo(TestingQuestionSection::getQpId,t.getQpId());
        }
        weekend.and(c);
        return weekend;
    }

    /**
     * 章节目录树
     * @param ctx
     * @return
     */
    public List<TestingQuestionSection> queryListData(IBusinessContext ctx){
        TestingQuestionSection t= super.convert2Bean(ctx.getParamMap());
        TestingQuestionSection s=new TestingQuestionSection();
        if(StringUtils.isNotBlank(t.getSectionId())){
            s.setParentId(t.getSectionId());
        }
        if(StringUtils.isNotBlank(t.getQpId())){
            s.setQpId(t.getQpId());
        }
        List<TestingQuestionSection>  list= super.queryList(s,ctx.getParamMap());
        TestingQuestionPool pool=new TestingQuestionPool();
        TestingQuestionSection section=new TestingQuestionSection();
        for (TestingQuestionSection test:list){
            String qpId=test.getQpId();
            TestingQuestionPool tp=  testingQuestionPoolWyService.queryById(qpId);
            if(tp!=null && tp.getName()!="" && tp.getName()!=null){
                test.setPoolName(tp.getName());
            }
            section.setParentId(test.getSectionId());
            List<TestingQuestionSection> sections=super.queryList(section,new HashMap());
            if(sections.size()>0){
                test.setHaveChild("1");
            }else{
                test.setHaveChild("0");
            }
        }
        return list;
    }
    //新增
    public Map<String,Object> saveData(IBusinessContext ctx){
        TestingQuestionSection t= super.convert2Bean(ctx.getParamMap());
        //先判断是新增还是修改
        if(StringUtils.isBlank(t.getSectionId())){
            if(StringUtils.isBlank(t.getParentId())){
                t.setParentId("0");
                t.setParentIds("0,");
                t.setLevel(1);
            }else{
                //查询父id详情
                if("0".equals(t.getParentId())){
                    t.setLevel(1);
                }else{
                    TestingQuestionSection parentSection=  super.queryById(t.getParentId());
                    Integer level=parentSection.getLevel();
                    t.setLevel(level+1);
                }
            }
        }
        super.save(t);
        return MapUtil.newMap("id",t.getSectionId());
    }

    /**
     * 批量删除
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> deleteData(IBusinessContext ctx){
        TestingQuestionSection t=  super.convert2Bean(ctx.getParamMap());
        String[] ids=(t.getSectionId()).split(",");
        Map<String,Object> map=new HashMap<>();
        int num =0;
       String msg="";
        for (String id:ids){
          //判断这个章节下面有没有题目有的话不能删除
            TestingQuestion questions=new TestingQuestion();
            questions.setSectionId(id);
            List<TestingQuestion> list= testingQuestionWyService.queryList(questions,new HashMap());
            if(list.size()>0){
                TestingQuestionSection section=  super.queryById(id);
                msg=msg+section.getName()+",";
            }else{
                num+= super.deleteById(id);
            }

        }
        if(msg.length()>0){
            msg=msg+"存在题目，请先删除题目再删除该章节！";
        }
        map.put("num",num);
        map.put("msg",msg);
        return map;
    }


}

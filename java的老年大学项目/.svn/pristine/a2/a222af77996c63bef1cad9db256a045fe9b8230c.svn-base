package com.learnyeai.testing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.api.client.ClzClazzTestClient;
import com.learnyeai.testing.api.vo.ClzClazzTestVo;
import com.learnyeai.testing.model.*;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.testing.api.vo.OptionVo;
import com.learnyeai.testing.api.vo.QuestionVo;
import com.learnyeai.testing.mapper.TestingAnswerPaperQuestionMapper;
import com.learnyeai.testing.model.TestingAnswerPaperQuestion;

import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class TestingAnswerPaperQuestionWyService extends WeyeBaseService<TestingAnswerPaperQuestion> {

	@Resource
	private TestingAnswerPaperQuestionMapper testingAnswerPaperQuestionMapper;
	@Resource
	private TestingQuestionWyService testingQuestionWyService;
	@Resource
	private TestingQuestionOptionWyService testingQuestionOptionWyService;
	@Resource
	private TestingStudentPaperWyService testingStudentPaperWyService;
	@Resource
	private TestingPaperRuleWyService testingPaperRuleWyService;
	@Resource
	private ClzClazzTestClient clzClazzTestClient;
	@Resource
	private TestingPaperWyService testingPaperWyService;
	@Resource
	private TestingPaperQuestionWyService testingPaperQuestionWyService;
	@Resource
    private TestingTestWyService testingTestWyService;

	@Override
	public BaseMapper<TestingAnswerPaperQuestion> getMapper() {
		return testingAnswerPaperQuestionMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	/**
	 * 通过试卷id和题型查询试卷试题详细
	 * 
	 * @param
	 * @param itemTypeId
	 * @return
	 */
	public List<QuestionVo> queryByPaperIdAndItemTypeId(String awId, String itemTypeId) {
		List<QuestionVo> questions = new ArrayList<QuestionVo>();
		TestingAnswerPaperQuestion paperQuestion = new TestingAnswerPaperQuestion();
		paperQuestion.setAwId(awId);
		paperQuestion.setItemTypeId(itemTypeId);
		Map<String, Object> questionOrderParam = new HashMap<String, Object>();
		questionOrderParam.put("sorts", "orderNum=1");
		List<TestingAnswerPaperQuestion> paperQuestions = super.queryList(paperQuestion, questionOrderParam);
		QuestionVo questionVo = null;
		for (TestingAnswerPaperQuestion obj : paperQuestions) {
			TestingQuestion question = testingQuestionWyService.get(obj.getQuestionId());
			questionVo = new QuestionVo(obj.getQuestionId(), question.getStemContent(), question.getAnswerDesc(),
					obj.getScore(), obj.getOrderNum(), itemTypeId);
			questionVo.setItemIds(obj.getAnswerIdValue());
			List<OptionVo> options = new ArrayList<OptionVo>();
			if (StringUtils.isNotBlank(obj.getItemIds())) {// 题目答案
				OptionVo optionVo = null;
				int orderNum = 1;
				for (String itemId : obj.getItemIds().split(",")) {
					TestingQuestionOption questionOption = testingQuestionOptionWyService.get(itemId);
					String checked = "0";
					if (StringUtils.isNotBlank(obj.getAnswerIdValue())
							&& Arrays.asList(obj.getAnswerIdValue().split(",")).contains(itemId))
						checked = "1";
					optionVo = new OptionVo(itemId, questionOption.getOptionContent(), orderNum++, checked);
					options.add(optionVo);
				}
			}
			questionVo.setOptions(options);
			questions.add(questionVo);
		}
		return questions;
	}

	public double computeScore(String awId) {
		Double score = testingAnswerPaperQuestionMapper.computeScore(awId);
		return score == null ? 0d : score;
	}

	public boolean isAnswered(String questionId, String answerIdValue) {
		TestingQuestion question = testingQuestionWyService.get(questionId);
		List<TestingQuestionOption> questionOptions = question.getQuestionOptions();
		List<String> itemIds = new ArrayList<String>(Arrays.asList(answerIdValue.split(",")));
		for (TestingQuestionOption questionOption : questionOptions) {
			if ("1".equals(questionOption.getAnswer())) {
				if (!itemIds.contains(questionOption.getItemId()))
					return false;
				itemIds.remove(questionOption.getItemId());
			}
		}
		if (!itemIds.isEmpty())
			return false;
		return true;
	}

	@Override
	protected Weekend<TestingAnswerPaperQuestion> genSqlExample(TestingAnswerPaperQuestion t, Map params) {
		Weekend<TestingAnswerPaperQuestion> w = super.genSqlExample(t, params);
		WeekendCriteria<TestingAnswerPaperQuestion, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getAwId())) {
			c.andEqualTo(TestingAnswerPaperQuestion::getAwId, t.getAwId());
		}
		if (StringUtils.isNotBlank(t.getItemTypeId())) {
			c.andEqualTo(TestingAnswerPaperQuestion::getItemTypeId, t.getItemTypeId());
		}
		if (StringUtils.isNotBlank(t.getQuestionId())) {
            String[] strArr=(t.getQuestionId()).split(",");
			c.andIn(TestingAnswerPaperQuestion::getQuestionId, Arrays.asList(strArr));
		}
		if (StringUtils.isNotBlank(t.getOkStatus())) {
			c.andEqualTo(TestingAnswerPaperQuestion::getOkStatus, t.getOkStatus());
		}
		w.and(c);
		return w;
	}

	/**
	 * 研讯通小程序答题
	 * @param ctx
	 * @return
	 */
	@Transactional
	public Map<String,Object> answerPaper(IBusinessContext ctx){
		TestingAnswerPaperQuestion questions=super.convert2Bean(ctx.getParamMap());
		Map<String,Object> map=new HashMap<>();
        Map<String,Object> params=ctx.getParamMap();
        String czId=MapUtil.singleNodeText(ctx.getParamMap(),"objId");
        String tsId=MapUtil.singleNodeText(ctx.getParamMap(),"tsId");
        map.put("czId",czId);
        map.put("tsId",tsId);
		List<TestingAnswerPaperQuestion> answers=questions.getAnswers();
		for (TestingAnswerPaperQuestion question:answers){
            question.setObjId(czId);
            question.setTsId(tsId);
			super.save(question);
		}
		//新增答题人数
        int t=clzClazzTestClient.addTsNum(map);
		return MapUtil.newMap("msg","答题成功！");
	}

	/**
	 * 获取分值的统计数据
	 * @param ctx
	 * @return
	 */
	public DataResult ClzComprePie(IBusinessContext ctx){
		TestingAnswerPaperQuestion question=super.convert2Bean(ctx.getParamMap());
        DataResult dataResult=new DataResult();
		String[] tsIds=(MapUtil.singleNodeText(ctx.getParamMap(),"tsIds")).split(",");
        List<StarDataCount>  result=new ArrayList<>();
		for(String tsId :tsIds){
            //查询测验名称
            TestingTest te= testingTestWyService.queryById(tsId);
            String objId=question.getObjId();
            //根据测验id去查询组卷规则
            TestingPaperRule rule=new TestingPaperRule();
            rule.setTsId(question.getTsId());
            rule.setIsNewversion("1");
            List<TestingPaperRule> rules=testingPaperRuleWyService.queryList(rule,ctx.getParamMap());
            if(rules!=null && rules.size()>0){
                TestingPaperRule r=rules.get(0);
                //通过组卷规则查询查询试卷
                TestingPaper paper=new TestingPaper();
                paper.setPaperRuleId(r.getPaperRuleId());
                List<TestingPaper> papers= testingPaperWyService.queryList(paper,new HashMap());
                if(papers!=null && papers.size()>0){
                    TestingPaper testingPaper=papers.get(0);
                    //通过试卷查询试卷所有题目的id
                    TestingPaperQuestion question1=new TestingPaperQuestion();
                    question1.setPaperId(testingPaper.getPaperId());
                    List<TestingPaperQuestion> questions=testingPaperQuestionWyService.queryList(question1,ctx.getParamMap());
                    String questionId="";
                    for(TestingPaperQuestion q:questions){
                        questionId+=q.getQuestionId()+",";
                    }
                    TestingQuestion tq=new TestingQuestion();
                    tq.setQuestionId(questionId);
                    tq.setTypeName("pf");
                    List<TestingQuestion> questionss= testingQuestionWyService.queryList(tq,new HashMap());
                    TestingAnswerPaperQuestion paperQuestion=new TestingAnswerPaperQuestion();
                    StarDataCount count=new StarDataCount();
                    paperQuestion.setTsId(tsId);
                    paperQuestion.setObjId(objId);
                        List<CommonStar> stars=testingAnswerPaperQuestionMapper.starCount(paperQuestion);
                        count.setCommonStars(stars);
                    //查询平均分值
                    Double avgscore= testingAnswerPaperQuestionMapper.getAvgScore(paperQuestion);
                    count.setAvgScore(BigDecimal.valueOf(avgscore));
                    //通过id查询测验名称名称
                    if(te !=null){
                        count.setName(te.getName());
                    }else{
                        dataResult.setMsg("请输入正确的测验!");
                        return dataResult;
                    }
                    result.add(count);
                }else{
                    dataResult.setMsg("该测试下没有试卷!");
                    return dataResult;
                }

            }else{
                dataResult.setMsg("该测试下没有组卷规则!");
                return dataResult;
            }
        }
        dataResult.setStarDataCounts(result);
        return dataResult;
	}

	/**
	 * 班级的综合评价
	 * @param ctx
	 * @return
	 */
	public List<StarDataCount> ClzCompreEvalua(IBusinessContext ctx){
		String tsIds=MapUtil.singleNodeText(ctx.getParamMap(),"tsIds");
		String[] tsIdArr=tsIds.split(",");
		String czId =MapUtil.singleNodeText(ctx.getParamMap(),"czId");
		List<StarDataCount> result=new ArrayList<>();
		Map<String,Object> params=new HashMap<>();
		params.put("czId",czId);
		for (String tsId:tsIdArr){
			StarDataCount count=new StarDataCount();
			params.put("tsId",tsId);
			//通过tsId找到测试名称
			TestingTest test=testingTestWyService.queryById(tsId);
			if(test!=null){
				String name=test.getName();
				count.setName(name);
			}
			//再根据测试id以及班级id查询出整个平均满意度
		   Double score=	testingAnswerPaperQuestionMapper.getTsAvgScore(params);
			count.setAvgScore(BigDecimal.valueOf(score));
			result.add(count);
		}
		return result;
	}
	/**
	 * 是否已经参加答卷了 0否1是
	 * @param ctx
	 * @return
	 */
	public List<TestingAnswerPaperQuestion> isAnswer(IBusinessContext ctx){
		TestingAnswerPaperQuestion question =super.convert2Bean(ctx.getParamMap());
		String custId=MapUtil.singleNodeText(ctx.getParamMap(),"custId");
		String[] tsIds=(MapUtil.singleNodeText(ctx.getParamMap(),"tsIds")).split(",");
		List<TestingAnswerPaperQuestion> result=new ArrayList<>();
		TestingStudentPaper paper=new TestingStudentPaper();
		for(String tstId:tsIds){
			Map<String,Object> map=new HashMap<>();
			paper.setTsId(tstId);
			paper.setStudentUserId(custId);
			//该用户是否生成了卷子
			List<TestingStudentPaper> papers=testingStudentPaperWyService.queryList(paper,ctx.getParamMap());
			TestingAnswerPaperQuestion test =new TestingAnswerPaperQuestion();
			test.setCustId(custId);
			test.setTsId(tstId);
			if(papers!=null && papers.size()>0){
				out:for(TestingStudentPaper p:papers){
						String answerId=p.getAwId();
						test.setAwId(answerId);
						List<TestingAnswerPaperQuestion> a=super.queryList(test,new HashMap());
						if(a!=null&&a.size()>0){
							test.setStatus("1");
							break out;
						}else{
							test.setStatus("0");
						}
					}
			}else{
				test.setStatus("0");
			}
			test.setAwId(null);
			result.add(test);
		}
		return result;
	}

	public int queryCzTestNum(String czId){
        return  testingAnswerPaperQuestionMapper.queryCzTestNum(czId);
    }



    /**
     * 获取分值的统计数据
     * @param ctx
     * @return
     */
    public DataResult dataCount(IBusinessContext ctx){
        TestingAnswerPaperQuestion question=super.convert2Bean(ctx.getParamMap());
        DataResult dataResult=new DataResult();
        String tsId=MapUtil.singleNodeText(ctx.getParamMap(),"tsIds");
        List<StarDataCount>  result=new ArrayList<>();
            //查询测验名称
            TestingTest te= testingTestWyService.queryById(tsId);
            String objId=question.getObjId();
            //根据测验id去查询组卷规则
            TestingPaperRule rule=new TestingPaperRule();
            rule.setTsId(question.getTsId());
            rule.setIsNewversion("1");
            List<TestingPaperRule> rules=testingPaperRuleWyService.queryList(rule,ctx.getParamMap());
            if(rules!=null && rules.size()>0){
                TestingPaperRule r=rules.get(0);
                //通过组卷规则查询查询试卷
                TestingPaper paper=new TestingPaper();
                paper.setPaperRuleId(r.getPaperRuleId());
                List<TestingPaper> papers= testingPaperWyService.queryList(paper,new HashMap());
                if(papers!=null && papers.size()>0){
                    TestingPaper testingPaper=papers.get(0);
                    //通过试卷查询试卷所有题目的id
                    TestingPaperQuestion question1=new TestingPaperQuestion();
                    question1.setPaperId(testingPaper.getPaperId());
                    List<TestingPaperQuestion> questions=testingPaperQuestionWyService.queryList(question1,ctx.getParamMap());
                    String questionId="";
                    for(TestingPaperQuestion q:questions){
                        questionId=q.getQuestionId();
                        TestingQuestion tq=new TestingQuestion();
                        tq.setQuestionId(questionId);
                        tq.setTypeName("pf");
                        List<TestingQuestion> questionss= testingQuestionWyService.queryList(tq,new HashMap());
                        TestingAnswerPaperQuestion paperQuestion=new TestingAnswerPaperQuestion();
                        StarDataCount count=new StarDataCount();
                        paperQuestion.setTsId(tsId);
                        paperQuestion.setObjId(objId);
//                        for (TestingQuestion test:questionss){
//                            String quesId=test.getQuestionId();
                            paperQuestion.setQuestionId(questionId);
//                            //获取统计分值的数组
                            List<CommonStar> stars=testingAnswerPaperQuestionMapper.starCount(paperQuestion);
                            count.setCommonStars(stars);
//                        }
                        //查询平均分值
                        Double avgscore= testingAnswerPaperQuestionMapper.getAvgScore(paperQuestion);
                        count.setAvgScore(BigDecimal.valueOf(avgscore));
                        //通过id查询题目名称
                        TestingQuestionOption option=new TestingQuestionOption();
                        option.setQuestionId(questionId);
                       List<TestingQuestionOption> options=  testingQuestionOptionWyService.queryList(option,new HashMap());
                        if(options!=null&&options.size()>0){
                            count.setName((options.get(0)).getOptionContent());
                        } else{
                            dataResult.setMsg("请输入正确的测验!");
                            return dataResult;
                        }
                        result.add(count);
                    }
                }else{
                    dataResult.setMsg("该测试下没有试卷!");
                    return dataResult;
                }

            }else{
                dataResult.setMsg("该测试下没有组卷规则!");
                return dataResult;
            }
        dataResult.setStarDataCounts(result);
        return dataResult;
    }
}

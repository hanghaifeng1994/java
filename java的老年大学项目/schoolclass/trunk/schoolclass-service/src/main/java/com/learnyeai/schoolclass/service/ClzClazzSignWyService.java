package com.learnyeai.schoolclass.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.api.client.TestingTestClient;
import com.learnyeai.schoolclass.model.*;
import com.learnyeai.schoolclass.mapper.ClzClazzSignMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author twang
 */
@Service
public class ClzClazzSignWyService extends WeyeBaseService<ClzClazzSign> {

    @Resource
    private ClzClazzSignMapper clzClazzSignMapper;
    @Resource
    private ClzClazzScheduleWyService clzClazzScheduleWyService;
    @Resource
    private ClzStudentClazzWyService clzStudentClazzWyService;
    @Resource
    private ClzClazzNewsWyService clzClazzNewsWyService;
    @Resource
    private TestingTestClient testingTestClient;

    @Override
    public BaseMapper<ClzClazzSign> getMapper() {
        return clzClazzSignMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<ClzClazzSign> genSqlExample(ClzClazzSign t, Map params) {
        Weekend<ClzClazzSign> w= super.genSqlExample(t,params);
        WeekendCriteria<ClzClazzSign,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCustId())){
            c.andEqualTo(ClzClazzSign::getCustId,t.getCustId());
        }
        if(StringUtils.isNotBlank(t.getCzScId())){
            String[] czScIds=(t.getCzScId()).split(",");
            c.andIn(ClzClazzSign::getCzScId,Arrays.asList(czScIds));
        }
        if(StringUtils.isNotBlank(t.getStatus())){
            c.andEqualTo(ClzClazzSign::getStatus,t.getStatus());
        }
        w.and(c);
        return w;
    }


    public MyPage<ClzClazzSign> queryPageExt(IBusinessContext ctx){
        ClzClazzSign ccs=super.convert2Bean(ctx.getParamMap());
        MyPage page=super.queryPage(ccs,ctx.getParamMap());
        List<ClzClazzSign> list=page.getList();
        for (ClzClazzSign sign:list){
            ClzClazzSchedule schedule= clzClazzScheduleWyService.queryById(sign.getCzScId());
            if(schedule!=null){
                Date startDate=schedule.getStartDate();
                Date endDate=schedule.getEndDate();
                String parsetime=  (DateFormatUtils.format(startDate, "yyyy-MM-dd HH:mm:ss")).substring(11,16)+"-"+(DateFormatUtils.format(endDate, "yyyy-MM-dd HH:mm:ss")).substring(11,16);
               sign.setScheduleName(schedule.getScName());
               sign.setTearchers(schedule.getScTearcher());
               sign.setParseDate(parsetime);
            }
        }
        page.setList(list);
        return page;
    }

    public ClzParRateCount scheduleParRateCount(IBusinessContext ctx){
        String czId= MapUtil.singleNodeText(ctx.getParamMap(),"czId");
        ClzParRateCount count=new ClzParRateCount();
        //查询班级人数
       List<ClzStudentClazz> students= clzStudentClazzWyService.queryList(null,ctx.getParamMap());
       int totalMenber=students.size();
        count.setTotalMember(totalMenber);
       //查询总出勤人次，签到表中每一条记录为一次出勤
        List<ClzClazzSchedule> schedule=clzClazzScheduleWyService.queryList(null,ctx.getParamMap());
       //班级日程数量
        int schNum= schedule.size();
        String scId="";
        for (ClzClazzSchedule s:schedule){
            scId+=s.getCzScId()+",";
        }
        ClzClazzSign sign=new ClzClazzSign();
        sign.setCzScId(scId);
        List<ClzClazzSign> signs= super.queryList(sign,new HashMap());
        int totalPar =signs.size();
        count.setTotalPar(totalPar);
        //查询平均出勤率
        DecimalFormat df=new DecimalFormat("0.000");
        String avgParRate;
        if(schNum==0||totalMenber==0){
            count.setMsg("此班级没有日程，或者暂时无人参加");
        }else{
            avgParRate =df.format((float)totalPar/(schNum*totalMenber));
            count.setAvgParRate(avgParRate);
        }
        //查询评价数
        int commentNumber= testingTestClient.queryCzTestNum(czId);
        count.setCommentNumber(commentNumber);
        return count;
    }

    /**
     * 饼状图
     * @return
     */
    public Object ClzParRateCount(IBusinessContext ctx){
        ClzClazzSign sign= super.convert2Bean(ctx.getParamMap());
        //获取班级总人数
        List<ClzStudentClazz> students= clzStudentClazzWyService.queryList(null,ctx.getParamMap());
        int totalMenber=students.size();
        if(totalMenber==0){
            return MapUtil.newMap("msg","此班级还没有人报名");
        }
        sign.setNum(totalMenber);
       List<Map<String,Object>> result= clzClazzSignMapper.getPersent(sign);
       //level 分别FI SE TR FO
       String index="";
       for (Map<String,Object> map:result){
            String level=MapUtil.singleNodeText(map,"level");
            if(StringUtils.isNotBlank(level)){
                index+=level+",";
            }
       }
       //判断各个等级是否存在set中
        if(index.indexOf("FI")==-1){
           Map<String,Object> FI=new HashMap<>();
            FI.put("level","FI");
            FI.put("num","0");
            FI.put("persent","小于60%");
           result.add(FI);
        } if(index.indexOf("SE")==-1){
            Map<String,Object> SE=new HashMap<>();
            SE.put("level","SE");
            SE.put("num","0");
            SE.put("persent","60%·79%");
            result.add(SE);
        } if(index.indexOf("TR")==-1){
            Map<String,Object> TR=new HashMap<>();
            TR.put("level","TR");
            TR.put("num","0");
            TR.put("persent","80%·90%");
            result.add(TR);
        } if(index.indexOf("FO")==-1){
            Map<String,Object> FO=new HashMap<>();
            FO.put("level","FO");
            FO.put("num","0");
            FO.put("persent","大于90%");
            result.add(FO);
        }
        Map<String,Object> re=new HashMap<>();
        re.put("msg","查询成功");
        re.put("result",result);
        return  re;
    }
}

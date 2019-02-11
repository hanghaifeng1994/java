package com.learnyeai.schoolclass.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.model.*;
import com.learnyeai.schoolclass.mapper.ClzClazzScheduleMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.DateHelper;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import freemarker.template.utility.DateUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author twang
 */
@Service
public class ClzClazzScheduleWyService extends WeyeBaseService<ClzClazzSchedule> {

    @Resource
    private ClzClazzScheduleMapper clzClazzScheduleMapper;
    @Resource
    private ClzClazzWyService clzClazzWyService;
    @Resource
    private ClzStudentClazzWyService clzStudentClazzWyService;
    @Resource
    private ClzClazzSignWyService clzClazzSignWyService;

    @Override
    public BaseMapper<ClzClazzSchedule> getMapper() {
        return clzClazzScheduleMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<ClzClazzSchedule> genSqlExample(ClzClazzSchedule t, Map params) {
        Weekend<ClzClazzSchedule> w = super.genSqlExample(t, params);
        WeekendCriteria<ClzClazzSchedule,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCzId())){
            c.andEqualTo(ClzClazzSchedule::getCzId,t.getCzId());
        }
        //是否开始
        String isEnd=MapUtil.singleNodeText(params,"isEnd");
        if(StringUtils.isNotBlank(isEnd)){
            if("0".equals(isEnd)){
                c.andLessThan(ClzClazzSchedule::getStartDate,new Date());
            }else if("1".equals(isEnd)){
                c.andGreaterThan(ClzClazzSchedule::getStartDate,new Date());
                c.andLessThanOrEqualTo(ClzClazzSchedule::getEndDate,new Date());
            }else if("2".equals(isEnd)){
                c.andGreaterThan(ClzClazzSchedule::getEndDate,new Date());
            }
        }
        w.and(c);
        return w;
    }

    /**
     * 活动日程列表
     * @param ctx
     * @return
     */
    public List<ClzClazzScheduleExt> queryPageExt(IBusinessContext ctx){
        ClzClazzSchedule ccs= super.convert2Bean(ctx.getParamMap());
        List<ClzClazzSchedule> list=super.queryList(ccs,ctx.getParamMap());
        return dataFormat(list);
    }

    /**
     * 学员的活动列表
     * @param ctx
     * @return
     */
    public List<ClzClazzScheduleExt> queryPageByStudent(IBusinessContext ctx){
        ClzClazzSchedule ccs= super.convert2Bean(ctx.getParamMap());
        String studentId= MapUtil.singleNodeText(ctx.getParamMap(),"studentId");
        ClzStudentClazz clzsc=new ClzStudentClazz();
        clzsc.setCustId(studentId);
        List<ClzStudentClazz> clzscs=clzStudentClazzWyService.queryList(clzsc,new HashMap());
        String czIds="";
        for(ClzStudentClazz clazz:clzscs){
            String czId=clazz.getCzId();
            czIds+=czId+",";
        }
        Weekend<ClzClazzSchedule> w = super.genSqlExample(ccs, ctx.getParamMap());
        WeekendCriteria<ClzClazzSchedule,Object> c=w.weekendCriteria();
        ccs.setCzId(czIds);
        List<ClzClazzSchedule> list =new ArrayList<>();
        if(StringUtils.isNotBlank(ccs.getCzId())){
            String[] czIdArr=(ccs.getCzId()).split(",");
            c.andIn(ClzClazzSchedule::getCzId,Arrays.asList(czIdArr));
            //是否开始
            String isEnd=MapUtil.singleNodeText(ctx.getParamMap(),"isEnd");
            if(StringUtils.isNotBlank(isEnd)){
                if("0".equals(isEnd)){
                    c.andLessThan(ClzClazzSchedule::getStartDate,new Date());
                }else if("1".equals(isEnd)){
                    c.andGreaterThan(ClzClazzSchedule::getStartDate,new Date());
                    c.andLessThanOrEqualTo(ClzClazzSchedule::getEndDate,new Date());
                }else if("2".equals(isEnd)){
                    c.andGreaterThan(ClzClazzSchedule::getEndDate,new Date());
                }
            }
            if(clzscs!=null && clzscs.size()>0){
                List<String> l=new ArrayList<>();
                for(ClzStudentClazz cs:clzscs){
                    l.add(cs.getCzId());
                }
                c.andIn(ClzClazzSchedule::getCzId,l);
            }
            w.and(c);
             list =clzClazzScheduleMapper.selectByExample(w);
        }
        return dataFormat(list);
    }

    /**
     * 获取当前日程
     * @param ctx
     * @return
     */
    public ClzClazzSchedule queryNowSchedule(IBusinessContext ctx){
        ClzClazzSchedule schedule=super.convert2Bean(ctx.getParamMap());
        Weekend<ClzClazzSchedule> w = super.genSqlExample(schedule, ctx.getParamMap());
        WeekendCriteria<ClzClazzSchedule,Object> c=w.weekendCriteria();
        WeekendCriteria<ClzClazzSchedule,Object> b=w.weekendCriteria();
        if(StringUtils.isNotBlank(schedule.getCzId())){
            c.andEqualTo(ClzClazzSchedule::getCzId,schedule.getCzId());
        }
        Date date1=DateHelper.parseDate(parseDate("next"));
        Date date2=DateHelper.parseDate(parseDate("last"));
        c.andGreaterThan(ClzClazzSchedule::getStartDate,date2);
        c.andGreaterThanOrEqualTo(ClzClazzSchedule::getStartDate,new Date());
        c.andLessThanOrEqualTo(ClzClazzSchedule::getEndDate,new Date());
        c.andLessThan(ClzClazzSchedule::getEndDate,date1);
        b.andLessThanOrEqualTo(ClzClazzSchedule::getStartDate,new Date());
        b.andGreaterThanOrEqualTo(ClzClazzSchedule::getEndDate,new Date());
        w.and(c);
        w.or(b);
        w.setOrderByClause("start_date asc");
        List<ClzClazzSchedule> schedules=clzClazzScheduleMapper.selectByExample(w);
        if(schedules!=null&&schedules.size()>0){
            return schedules.get(0);
        }else{
            return new ClzClazzSchedule();
        }
    }
    public MyPage<ClzClazzSchedule> scheduleCount(IBusinessContext ctx){
        ClzClazzSchedule schedule= super.convert2Bean(ctx.getParamMap());
        MyPage page=super.queryPage(schedule,ctx.getParamMap());
        List<ClzClazzSchedule> list=page.getList();
        ClzClazzSign sign=new ClzClazzSign();
        for (ClzClazzSchedule s:list){
            sign.setCzScId(s.getCzScId());
            List<ClzClazzSign> signs=clzClazzSignWyService.queryList(sign,new HashMap());
            int czRealNum=signs.size();
            s.setCzRealNum(czRealNum);
            ClzClazz clazz=clzClazzWyService.queryById(s.getCzId());
            if(clazz!=null){
                s.setCzNum(clazz.getCzJoinupNum());
            }else{
                s.setCzNum(Long.valueOf(0));
            }

        }
        List<ClzClazzScheduleExt> listExt=dataFormat(list);
        page.setList(listExt);
        return page;
    }

    //格式化数据
    public List<ClzClazzScheduleExt> dataFormat(List<ClzClazzSchedule> list){
        List<ClzClazzScheduleExt> result=new ArrayList<>();
        Set<Object> set=new HashSet<>();
        for(ClzClazzSchedule cs:list){
            Date startDate =cs.getStartDate();
            Date endDate=cs.getEndDate();

            String sDate= "";
            if(startDate!=null){
                  sDate=  DateFormatUtils.format(startDate, "yyyy年MM月dd日");
            }
            String parsetime="";
            if(endDate==null&&startDate!=null){
                parsetime=  (DateFormatUtils.format(startDate, "yyyy-MM-dd HH:mm:ss")).substring(11,16)+"-";
            }else if(startDate==null&&endDate!=null){
                parsetime= "-"+(DateFormatUtils.format(endDate, "yyyy-MM-dd HH:mm:ss")).substring(11,16);
            }else if(startDate!=null&&endDate!=null){
                parsetime=  (DateFormatUtils.format(startDate, "yyyy-MM-dd HH:mm:ss")).substring(11,16)+"-"+(DateFormatUtils.format(endDate, "yyyy-MM-dd HH:mm:ss")).substring(11,16);
            }
            //向result中添加数据
            ClzClazzScheduleExt ext=new ClzClazzScheduleExt();
            ScheduleInfo info =new ScheduleInfo();
            if(set.size()==0){
                set.add(sDate);
                ext.setDate(sDate);
                List<ScheduleInfo> infos=ext.getInfo();
                info.setCzId(cs.getCzId());
                info.setCzScId(cs.getCzScId());
                info.setScTearcher(cs.getScTearcher());
                info.setScContent(cs.getScContent());
                info.setScName(cs.getScName());
                info.setScStatus(cs.getScStatus());
                info.setTimeParse(parsetime);
                info.setStartDate(cs.getStartDate());
                info.setEndDate(cs.getEndDate());
                info.setScRealStartDate(cs.getScRealStartDate());
                info.setScRealEndDate(cs.getScRealEndDate());
                info.setCzNum(cs.getCzNum());
                info.setCzRealNum(cs.getCzRealNum());
                if(infos==null){
                    infos=new ArrayList<>();
                }
                infos.add(info);
                ext.setInfo(infos);
                result.add(ext);
            }else{
                //先判断sDate在set中是否存在
                boolean flag= set.contains(sDate);
                if(flag){
                    //存在的情况下遍历result
                    for(ClzClazzScheduleExt ext2:result){
                        String date=ext2.getDate();
                        if(sDate.equals(date)){
                            List<ScheduleInfo> infos=ext2.getInfo();
                            info.setCzId(cs.getCzId());
                            info.setCzScId(cs.getCzScId());
                            info.setScTearcher(cs.getScTearcher());
                            info.setScContent(cs.getScContent());
                            info.setScName(cs.getScName());
                            info.setScStatus(cs.getScStatus());
                            info.setTimeParse(parsetime);
                            info.setStartDate(cs.getStartDate());
                            info.setEndDate(cs.getEndDate());
                            info.setScRealStartDate(cs.getScRealStartDate());
                            info.setScRealEndDate(cs.getScRealEndDate());
                            info.setCzNum(cs.getCzNum());
                            info.setCzRealNum(cs.getCzRealNum());
                            infos.add(info);
                            ext2.setInfo(infos);
                        }
                    }
                }else{
                    set.add(sDate);
                    ext.setDate(sDate);
                    List<ScheduleInfo> infos=ext.getInfo();
                    info.setCzId(cs.getCzId());
                    info.setCzScId(cs.getCzScId());
                    info.setScTearcher(cs.getScTearcher());
                    info.setScContent(cs.getScContent());
                    info.setScName(cs.getScName());
                    info.setTimeParse(parsetime);
                    info.setStartDate(cs.getStartDate());
                    info.setEndDate(cs.getEndDate());
                    info.setScStatus(cs.getScStatus());
                    info.setScRealStartDate(cs.getScRealStartDate());
                    info.setScRealEndDate(cs.getScRealEndDate());
                    info.setCzNum(cs.getCzNum());
                    info.setCzRealNum(cs.getCzRealNum());
                    if(infos==null){
                        infos=new ArrayList<>();
                    }
                    infos.add(info);
                    ext.setInfo(infos);
                    result.add(ext);
                }
            }

            set.add(sDate);
        }
        return result;
    }

    public String     parseDate(String type){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if("next".equals(type)){
            calendar.add(Calendar.DAY_OF_MONTH, +1);
        }else{
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        date = calendar.getTime();
        String date2=sdf.format(date);
        return date2;
    }
}

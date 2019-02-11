package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.model.ClzClazzSchedule;
import com.learnyeai.schoolclass.model.ClzClazzScheduleExt;
import com.learnyeai.schoolclass.model.ClzClazzSign;
import com.learnyeai.schoolclass.model.ScheduleInfo;
import com.learnyeai.schoolclass.service.ClzClazzScheduleWyService;
import com.learnyeai.schoolclass.service.ClzClazzSignWyService;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author twang
 */
@Component
public class ClzClazzSignController extends BaseController<ClzClazzSign> {

    @Autowired
    private ClzClazzSignWyService clzClazzSignWyService;
    @Autowired
    private ClzClazzScheduleWyService clzClazzScheduleWyService;

    @Override
    protected BaseService<ClzClazzSign> getService() {
        return clzClazzSignWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        ClzClazzSign cs=clzClazzSignWyService.convert2Bean(ctx.getParamMap());
        if("queryByCzScIdAndCustId".equals(method)){
           List<ClzClazzSign> list= clzClazzSignWyService.queryList(cs,ctx.getParamMap());

           return dataFormat(list);
        }
        if("ClzParRateCount".equals(method)){
           return clzClazzSignWyService.ClzParRateCount(ctx);
        }
        if("signIn".equals(method)){
           List<ClzClazzSign> signs= super.queryList(ctx);
           if(signs!=null && signs.size()>0){
               return MapUtil.newMap("msg","不能重复签到");
           }
            cs.setStatus("1");
            cs.setCzSignStartDate(new Date());
            clzClazzSignWyService.save(cs);
            return MapUtil.newMap("id",cs.getCzSignId());
        }
        if("signOff".equals(method)){
            cs.setStatus("2");
            cs.setCzSignEndDate(new Date());
            clzClazzSignWyService.save(cs);
            return MapUtil.newMap("id",cs.getCzSignId());
        }
        if("queryPage".equals(method)){
          MyPage<ClzClazzSign> page= clzClazzSignWyService.queryPageExt(ctx);
          return super.rtnPageList4Report(page);
        }
        if("scheduleParRateCount".equals(method)){
           return clzClazzSignWyService.scheduleParRateCount(ctx);
        }
        return super.execute(ctx);
    }


    //格式化数据
    public List<ClzClazzScheduleExt> dataFormat(List<ClzClazzSign> list){
        List<ClzClazzScheduleExt> result=new ArrayList<>();
        Set<Object> set=new HashSet<>();
        for(ClzClazzSign cs:list){
            Date startDate =cs.getCzSignStartDate();
            Date endDate=cs.getCzSignEndDate();
            String sDate="";
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
                info.setCzScId(cs.getCzScId());
                ClzClazzSchedule clz= clzClazzScheduleWyService.queryById(cs.getCzScId());
                if(clz!=null){
                    info.setScName(clz.getScName());
                    info.setScTearcher(clz.getScTearcher());
                }
                if(infos==null){
                    infos=new ArrayList<>();
                }
                info.setScRealStartDate(cs.getCzSignStartDate());
                info.setScRealEndDate(cs.getCzSignEndDate());
                info.setTimeParse(parsetime);
                info.setCzSignId(cs.getCzSignId());
                info.setStatus(cs.getStatus());
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
                            info.setCzScId(cs.getCzScId());
                            ClzClazzSchedule clz= clzClazzScheduleWyService.queryById(cs.getCzScId());
                            if(clz!=null){
                                info.setScName(clz.getScName());
                                info.setScTearcher(clz.getScTearcher());
                            }
                            info.setScRealStartDate(cs.getCzSignStartDate());
                            info.setScRealEndDate(cs.getCzSignEndDate());
                            info.setTimeParse(parsetime);
                            info.setStatus(cs.getStatus());
                            info.setCzSignId(cs.getCzSignId());
                            infos.add(info);
                            ext2.setInfo(infos);
                        }
                    }
                }else{
                    set.add(sDate);
                    ext.setDate(sDate);
                    List<ScheduleInfo> infos=ext.getInfo();
                    info.setCzScId(cs.getCzScId());
                    ClzClazzSchedule clz= clzClazzScheduleWyService.queryById(cs.getCzScId());
                    if(clz!=null){
                        info.setScName(clz.getScName());
                        info.setScTearcher(clz.getScTearcher());
                    }
                    info.setScRealStartDate(cs.getCzSignStartDate());
                    info.setScRealEndDate(cs.getCzSignEndDate());
                    info.setStatus(cs.getStatus());
                    info.setTimeParse(parsetime);
                    info.setCzSignId(cs.getCzSignId());
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

    public String     parseDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        date = calendar.getTime();
        String date2=sdf.format(date);
        return date2;
    }
}

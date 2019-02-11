package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.model.ClzClazzSchedule;
import com.learnyeai.schoolclass.model.ClzClazzScheduleExt;
import com.learnyeai.schoolclass.service.ClzClazzScheduleWyService;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author twang
 */
@Component
public class ClzClazzScheduleController extends BaseController<ClzClazzSchedule> {

    @Autowired
    private ClzClazzScheduleWyService clzClazzScheduleWyService;

    @Override
    protected BaseService<ClzClazzSchedule> getService() {
        return clzClazzScheduleWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        if("queryPage".equals(method)){
          List<ClzClazzScheduleExt> list=   clzClazzScheduleWyService.queryPageExt(ctx);
          return list;
        }
        if("queryListByTearcher".equals(method)){
            List<ClzClazzScheduleExt> list=   clzClazzScheduleWyService.queryPageExt(ctx);
            return list;
        }
        if("queryListByStudent".equals(method)){
            List<ClzClazzScheduleExt> list=   clzClazzScheduleWyService.queryPageByStudent(ctx);
            return list;
        }
        if("insert".equals(method)){
            ClzClazzSchedule schedule= clzClazzScheduleWyService.convert2Bean(ctx.getParamMap());
            schedule.setScStatus("0");
            clzClazzScheduleWyService.save(schedule);
            return MapUtil.newMap("id",schedule.getCzScId());
        }
        if("attendClass".equals(method)){
            ClzClazzSchedule schedule= clzClazzScheduleWyService.convert2Bean(ctx.getParamMap());
            if("scStatus".equals("1")){
                schedule.setScRealStartDate(new Date());
            }else if("scStatus".equals("2")){
                schedule.setScRealEndDate(new Date());
            }
             clzClazzScheduleWyService.save(schedule);
            return null;
        }
        if("queryNowSchedule".equals(method)){
            return clzClazzScheduleWyService.queryNowSchedule(ctx);
        }
        if("scheduleCount".equals(method)){
            MyPage page= clzClazzScheduleWyService.scheduleCount(ctx);
            return rtnPageList4Report(page);
        }
        return super.execute(ctx);
    }
}

package com.learnyeai.studygroup.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.studygroup.model.SgpStudyGroupExperience;
import com.learnyeai.studygroup.service.SgpStudyGroupExperienceWyService;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learnyeai.learnai.support.MyPage;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 *
 * @author yl
 */
@Component
public class SgpStudyGroupExperienceController extends BaseController<SgpStudyGroupExperience> {

    @Autowired
    private SgpStudyGroupExperienceWyService sgpStudyGroupExperienceWyService;

    @Override
    protected BaseService<SgpStudyGroupExperience> getService() {
        return sgpStudyGroupExperienceWyService;
    }


    @Override
    public Object execute(IBusinessContext ctx){
        String method = CtxHeadUtil.getControllerMethod();
        SgpStudyGroupExperience ssge = sgpStudyGroupExperienceWyService.convert2Bean(ctx.getParamMap());
        if("queryPage".equals(method)){
            MyPage<SgpStudyGroupExperience> page = sgpStudyGroupExperienceWyService.queryPage(ssge,new HashMap());
            List<SgpStudyGroupExperience> list = page.getList();
            String epcId = "";
            for(SgpStudyGroupExperience s:list){
                epcId += s.getEpcId()+",";
            }
            return MapUtil.newMap("epcId",epcId);
        }
        if("save".equals(method)){
            sgpStudyGroupExperienceWyService.saveData(ctx);
            return null;
        }
        if("delete".equals(method)){
           return sgpStudyGroupExperienceWyService.deleteByExpId(ctx);
        }
        return super.execute(ctx);
    }
}

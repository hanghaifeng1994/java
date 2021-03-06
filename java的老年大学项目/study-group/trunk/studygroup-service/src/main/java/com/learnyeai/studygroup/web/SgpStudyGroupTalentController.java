package com.learnyeai.studygroup.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.studygroup.model.SgpStudyGroupTalent;
import com.learnyeai.studygroup.service.SgpStudyGroupTalentWyService;
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
public class SgpStudyGroupTalentController extends BaseController<SgpStudyGroupTalent> {

    @Autowired
    private SgpStudyGroupTalentWyService sgpStudyGroupTalentWyService;

    @Override
    protected BaseService<SgpStudyGroupTalent> getService() {
        return sgpStudyGroupTalentWyService;
    }



    @Override
    public Object execute(IBusinessContext ctx){
        SgpStudyGroupTalent ssgt = sgpStudyGroupTalentWyService.convert2Bean(ctx.getParamMap());
        String method = CtxHeadUtil.getControllerMethod();
        Map<String,Object> map = new HashMap<>();
        if("queryPage".equals(method)){
            MyPage<SgpStudyGroupTalent> page = sgpStudyGroupTalentWyService.queryPage(ssgt,new HashMap());
            List<SgpStudyGroupTalent> list = page.getList();
            String tltId = "";
            for(SgpStudyGroupTalent s:list){
                tltId += s.getTltId() + ",";
            }
            return MapUtil.newMap("tltId",tltId);

        }
        if("save".equals(method)){
            sgpStudyGroupTalentWyService.saveData(ctx);
            return null;
        }
        if("delete".equals(method)){
            return  sgpStudyGroupTalentWyService.deleteByTalentAndSgpId(ctx);
        }
        return super.execute(ctx);
    }

}

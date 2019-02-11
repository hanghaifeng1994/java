package com.learnyeai.setting.web;

import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.setting.model.SetPromotion;
import com.learnyeai.setting.service.SetPromotionWyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author zhangpz
 */
@Component
public class SetPromotionController extends BaseController<SetPromotion> {

    @Autowired
    private SetPromotionWyService setPromotionWyService;

    @Override
    protected BaseService<SetPromotion> getService() {
        return setPromotionWyService;
    }

    @Override
    protected Object doDispached(IBusinessContext context, String method) {

        Object rst = null;
        if(method.equals("enable"))
            this.enable(context);
        else if(method.equals("disable"))
            this.disable(context);
        else if(method.equals("queryByIds")){
            rst = this.queryByIds(context);
        }else if(method.equals("saveSorts"))
            this.saveSorts(context);
        else if(method.equals("querySitePromotions"))
            rst = this.querySitePromotions(context);
        return rst;
    }

    /**
     * 启用
     * @param ctx
     */
    public void enable(IBusinessContext ctx){
        String ids = ctx.getParam("ids");
        String[] idArr = ids.split(",");
        setPromotionWyService.enable(idArr, true);
    }

    /**
     * 禁用
     * @param ctx
     */
    public void disable(IBusinessContext ctx){
        String ids = ctx.getParam("ids");
        String[] idArr = ids.split(",");
        setPromotionWyService.enable(idArr, false);
    }

    public List querySitePromotions(IBusinessContext ctx) {

        String siteId = WeyeThreadContextUtils.getSiteId();
        if(siteId == null){
            siteId = ctx.getParam("siteId");
        }
        if(StringUtils.isBlank(siteId)){
            throw new ArithmeticException();
        }
        String serviceType = ctx.getParam("serviceType");
        return setPromotionWyService.querySitePromotions(siteId, serviceType);
    }

    // 保存排序
    public void saveSorts(IBusinessContext ctx){
        String ids = ctx.getParam("ids");
        String sorts = ctx.getParam("sorts");
        String idArr[] = ids.split(",");
        String sortArr[] = sorts.split(",");
        if(idArr.length != sortArr.length){
            throw AresRuntimeException.build(null).iniCauseMsg("参数ids与sorts个数不一致");
        }
        for (int i=0; i<idArr.length; i++){
            SetPromotion o = new SetPromotion();
            if(StringUtils.isBlank(idArr[i]))
                continue;
            long sort = Long.valueOf(sortArr[i]);
            o.setId(idArr[i]);
            o.setSort(sort);
            setPromotionWyService.save(o);
        }
    }
}

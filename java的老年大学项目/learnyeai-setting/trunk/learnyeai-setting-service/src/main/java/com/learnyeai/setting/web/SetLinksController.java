package com.learnyeai.setting.web;

import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.setting.model.SetLinks;
import com.learnyeai.setting.service.SetLinksWyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author zhangpz
 */
@Component
public class SetLinksController extends BaseController<SetLinks> {

    @Autowired
    private SetLinksWyService setLinksWyService;

    @Override
    protected BaseService<SetLinks> getService() {
        return setLinksWyService;
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
        else if(method.equals("querySiteLinks"))
            rst = this.querySiteLinks(context);
        return rst;
    }

    /**
     * 启用
     * @param ctx
     */
    public void enable(IBusinessContext ctx){
        String ids = ctx.getParam("ids");
        String[] idArr = ids.split(",");
        setLinksWyService.enable(idArr, true);
    }

    /**
     * 禁用
     * @param ctx
     */
    public void disable(IBusinessContext ctx){
        String ids = ctx.getParam("ids");
        String[] idArr = ids.split(",");
        setLinksWyService.enable(idArr, false);
    }

    public List querySiteLinks(IBusinessContext ctx) {
        String siteId = null;
        siteId = WeyeThreadContextUtils.getSiteId();
        if(null == siteId){
            ctx.getParam("siteId");
        }
        if(StringUtils.isBlank(siteId)){
            throw new ArithmeticException();
        }
        return setLinksWyService.querySiteLinks(siteId);
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
            SetLinks o = new SetLinks();
            if(StringUtils.isBlank(idArr[i]))
                continue;
            long sort = Long.valueOf(sortArr[i]);
            o.setId(idArr[i]);
            o.setSort(sort);
            setLinksWyService.save(o);
        }
    }

}

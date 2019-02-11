package com.learnyeai.learnai.support;

import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.context.CtxReportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/4/21.
 */
public abstract class BaseController<T extends BaseEntity> implements IController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        // 获取方法
        String method = CtxHeadUtil.getControllerMethod();
        if(null == method)
            throw new RuntimeException();

        Object result = null;

        if(method.equals("save") || method.equals("insert") || method.equals("update"))
            result = this.save(ctx);
        else if(method.equals("deleteById"))
            this.deleteById(ctx);
        else if(method.equals("queryById"))
            result = this.queryById(ctx);
        else if(method.equals("queryList"))
            result = this.queryList(ctx);
        else if(method.equals("queryPage"))
            result = this.queryPage(ctx);
        else if(method.equals("queryByIds"))
            result = this.queryByIds(ctx);
        else if(method.equals("deleteByIds"))
            this.deleteByids(ctx);
        else
            result = this.doDispached(ctx, method);
        return result;

    }

    protected Object doDispached(IBusinessContext context, String method){
        return null;
    }
    protected abstract BaseService<T> getService();

    public Object queryById(IBusinessContext ctx){
        Object id = getService().getId(ctx.getParamMap());
        if(null == id)
            return null;
        return getService().queryById(id);
    }

    public List queryPage(IBusinessContext ctx) {

        // 获取分页参数
        MyPage page = getService().queryPage(null, ctx.getParamMap());
        return rtnPageList4Report(page);
    }

    public List queryList(IBusinessContext ctx) {
        return getService().queryList(null, ctx.getParamMap());
    }

    public Object save(IBusinessContext ctx) {
        T t = getService().convert2Bean(ctx.getParamMap());
        getService().save(t);
        CtxHeadUtil.setReportDataDealType("1");
        return getService().getId(t);
    }

    public void deleteById(IBusinessContext ctx) {
        Object id = getService().getId(ctx.getParamMap());
        if(null == id)
            return;

        getService().deleteById(id);
    }
    public List<T> queryByIds(IBusinessContext ctx){
        String ids = ctx.getParam("ids");
        String[] idArr = ids.split(",");
        List<T> list = new ArrayList<T>();
        for(String id : idArr){
            list.add(getService().queryById(id));
        }
        return list;
    }
    public void deleteByids(IBusinessContext ctx){
        String ids = ctx.getParam("ids");
        String[] idArr = ids.split(",");
        for(String id : idArr) {
            getService().deleteById(id);
        }
    }

   /**
            * 分页请求的报文，添加totalCount
     * @param page
     * @return
             */
    public static List rtnPageList4Report(MyPage page){
        if(page.getTotal() > -1){
//            ThreadContext.put(CtxHeadUtil.REPORT_TOTAL_COUNT, page.getTotal());
//            ThreadContext.put(CtxHeadUtil.REPORT_TOTAL_COUNT, page);
            Map extData = CtxReportUtil.getListExtResultMap();
            extData.put(AppR.RTN_TOTAL, page.getTotal());
            extData.put(AppR.RTN_PAGE_NO, page.getPageNo());
            extData.put(AppR.RTN_PAGE_SIZE, page.getPageSize());
        }
        return page.getList();
    }
}

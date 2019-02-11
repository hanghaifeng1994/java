package com.learnyeai.base.web;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 客户
 * @author zhangpz
 */
@Component
public class StaffController extends BaseController<CustInfo> {
    @Autowired
    private CustInfoWyService custInfoService;

    @Override
    protected BaseService<CustInfo> getService() {
        return custInfoService;
    }

    @Override
    protected Object doDispached(IBusinessContext context, String method) {
        Object rst = null;
        rst = super.doDispached(context, method);


        return rst;
    }

    public List queryStaffPage(IBusinessContext ctx) {
        // 添加客户类型
        ctx.setParam(CustInfoVo.CF.custType, BaseCons.CUST_INFO_TYPE.YG.getVal());
        return super.queryPage(ctx);
    }

    /**
     *
     * @param ctx
     */
    public void saveStaff(IBusinessContext ctx) {
        // 添加客户类型
        ctx.setParam(CustInfoVo.CF.custType, BaseCons.CUST_INFO_TYPE.YG.getVal());
        super.save(ctx);
    }

}
